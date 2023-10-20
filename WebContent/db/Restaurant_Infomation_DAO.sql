-- MemberDao에 들어갈 쿼리
-- (1) 회원mid 중복체크
SELECT * FROM MEMBER WHERE mID='aaa';
--SELECT COUNT(*) FROM MEMBER WHERE mID='aaa';
-- (2) 회원가입
INSERT INTO MEMBER (mID, mPW, mNAME, mEMAIL, mTEL, mBIRTH, mADDRESS)
    VALUES ('bbb','1','홍길동','hong@hong.com','010-1234-1234','1998/12/12','서대문');   
-- (3) 로그인
SELECT * FROM MEMBER WHERE mID='aaa' and mPW='111';
-- (4) mid로 dto가져오기 (로그인 성공시 session에 setAttribute하기 위함)
SELECT * FROM MEMBER WHERE mID='aaa';
-- (5) 회원정보수정 (특정mid의 정보 수정)
UPDATE MEMBER SET mPw = '1',
                    mName = '박지현',
                    mEmail = 'abc@naver.com',
                    mTEL = '010-1212-1212',
                    mBirth = '1999/11/03',
                    mAddress = '강원도 강릉'
        WHERE mId='aaa';     
-- (6) 회원리스트(top-N구문)
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MEMBER ORDER BY mBIRTH DESC) A)
  WHERE RN BETWEEN 4 AND 6;
-- (7) 회원수
SELECT COUNT(*) CNT FROM MEMBER;
-- (8) 회원탈퇴
COMMIT;
DELETE FROM MEMBER WHERE mID='go';
ROLLBACK;
COMMIT;

-- AdminDao에 들어갈 쿼리
-- (1) admin 로그인
SELECT * FROM ADMIN WHERE aID='abc' AND APW='111';
-- (2) 로그인 후 세션에 넣을 용도 : admin aid로 dto 가져오기
SELECT * FROM ADMIN WHERE AID='abc';

-- BoardDao에 들어갈 쿼리
-- (1-1) WRITER 타이틀에 사용자가 썼으면 사용자이름, 관리자가 썼으면 관리자라고 출력
SELECT BID, (SELECT MNAME FROM MEMBER WHERE BOARD.MID=MID)||
  (SELECT '-관리자-' FROM ADMIN WHERE BOARD.AID=AID) WRITER, BTITLE, BCONTENT, BHIT, BRDATE 
  FROM BOARD ORDER BY BRDATE DESC;
-- (2) 글갯수
SELECT COUNT(*) CNT FROM BOARD;
-- (3) 글쓰기(원글쓰기)
INSERT INTO BOARD(BID, MID, AID, BTITLE, BCONTENT, BPW, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (10, 'aaa', 'abc', '추가제목', '추가본문', '1', 0, 0, 0, '192.168.1.1'); 
-- (4) hit 1회 올리기
UPDATE BOARD SET BHIT = BHIT + 1 WHERE BID=1;
-- (5) 글번호(bid)로 글전체 내용(BoardDto)가져오기
SELECT B.*
  FROM BOARD B, MEMBER M WHERE B.MID=M.MID AND BID=1;
-- (6) 글 수정하기(bid, btitle, bcontent, bip)수정
UPDATE BOARD SET BTITLE = '바뀐제목',
                    BCONTENT = '바뀐본문',
                    BIP = '192.168.151.10',
                    BRDATE = SYSDATE
            WHERE BID = 2;
-- (7) 글 삭제하기
-- 글 삭제시 해당 글 하나 삭제하기(삭제하려는 글의 mid필요, 3번글 삭제)
    DELETE FROM BOARD WHERE bID=3;
-- (10) 회원탈퇴시 탈퇴하는 회원(mid)이 쓴글 모두 삭제하기
DELETE FROM BOARD WHERE MID='son';
ROLLBACK;

-- RESTAURANT_InfoDao에 들어갈 쿼리
-- (1) 글목록(startRow~endRow)
SELECT F.* FROM RESTAURANT_INFO F, MEMBER M
  WHERE F.MID=M.MID 
  ORDER BY FGROUP DESC, FSTEP; -- 출력 기준
SELECT * FROM
  (SELECT ROWNUM RN, A.* FROM (SELECT F.* FROM RESTAURANT_INFO F, MEMBER M
        WHERE F.MID=M.MID 
            ORDER BY FGROUP DESC, FSTEP) 
                WHERE RN BETWEEN 1 AND 7; -- dao에 쓸 query
-- (2) 글갯수
SELECT COUNT(*) FROM RESTAURANT_INFO;
-- (3) 글쓰기(원글쓰기)
INSERT INTO RESTAURANT_INFO (FID, MID, FTITLE, FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP)
  VALUES (RESTAURANT_INFO_SEQ.NEXTVAL, 'son', '토트넘','난 공격수', 'a.docx', 1, RESTAURANT_INFO_SEQ.CURRVAL, 0,0, '192.168.0.31');
-- (4) hit 1회 올리기
UPDATE RESTAURANT_INFO SET FHIT = FHIT + 1 WHERE FID=1;
-- (5) 글번호(fid)로 글전체 내용(RESTAURANT_INFODto) 가져오기
SELECT * FROM RESTAURANT_INFO WHERE FID=1;
-- (6) 글 수정하기(fid, ftitle, fcontent, ffilename, frdate(SYSDATE), fip 수정)
UPDATE RESTAURANT_INFO SET FTITLE = '바뀐제목',
                    FCONTENT = '바뀐본문',
                    fFILENAME = 'son.jpg',
                    FIP = '192.168.151.10'
            WHERE FID = 2;
-- (7) 글 삭제하기
COMMIT;
-- 글 삭제시 해당 글 하나 삭제하기 (삭제하려는 글의 FID필요. 3번글 삭제)
DELETE FROM RESTAURANT_INFO WHERE FID=3;
ROLLBACK;
-- 글 삭제시 답변글까지 삭제하는 로직(지우려는 3번글의 삭제하려는 글의 FGROUP=1, FSTEP=1, FINDENT=1 필요)
SELECT * FROM RESTAURANT_INFO ORDER BY FGROUP DESC, FSTEP;
DELETE FROM RESTAURANT_INFO WHERE FGROUP = 1 AND (FSTEP>=1 AND 
    FSTEP<(SELECT NVL(MIN(FSTEP),9999) 
          FROM RESTAURANT_INFO WHERE FGROUP=1 AND FSTEP>1 AND FINDENT<=1));
UPDATE RESTAURANT_INFO SET fSTEP = fSTEP-2 WHERE fGROUP=1 AND fSTEP>2;-- 생략 가능(2은 위의 DELETE문 수행결과) : fSTEP 재조정
COMMIT;
-- (8) 답변글 쓰기 전 단계(원글의 fgroup과 같고, 원글의 fstep보다 크면 fstep을 하나 증가하기)
UPDATE RESTAURANT_INFO SET FSTEP = FSTEP + 1 WHERE FGROUP=5 AND FSTEP>0;
-- (9) 답변글 쓰기
INSERT INTO RESTAURANT_INFO (FID, MID, RNO, FTITLE, FCONTENT, FHIT, FGROUP, FSTEP, FINDENT, FIP)
  VALUES (1-1, 'aaa', 1, '본문1', '내용1', '1', 0, 0, 0, '192.168.0.1'); 
COMMIT;
-- (10) 회원탈퇴시 탈퇴하는 회원(mid)이 쓴 글 모두 삭제하기
DELETE FROM RESTAURANT_INFO WHERE MID='son';
ROLLBACK;
-- (11).맛집후기 삭제
DELETE FROM RESTAURANT_INFO WHERE RNO=1; -- 후기 지우기 (이거먼저 지우고 식당 지우기)

-- RESTAURANT 에 들어갈 Dao 쿼리
-- (1) 맛집 리스트
SELECT * FROM (SELECT ROWNUM RN, A.* FROM 
                        (SELECT * FROM RESTAURANT ORDER BY rname) A)
        WHERE RN BETWEEN 1 AND 9;
-- (2) rno로 dto가져오기(맛집등록시 session에 넣기 위함)
SELECT * FROM RESTAURANT WHERE RNO='1';
-- (3) 맛집갯수
SELECT COUNT(*) CNT FROM RESTAURANT;
-- (4) 맛집 정보 수정
UPDATE RESTAURANT SET RNAME ='치폴로',
                        CNO = 'DESERT',
                        RADDRESS = '서울 동대문구',
                        RHOLIDAY = '금요일',
                        RPARKING = '없음'
                    WHERE RNO ='1';
-- (5) 맛집 정보 삭제
DELETE FROM RESTAURANT WHERE RNAME = '치폴로'; -- 식당 지우기
ROLLBACK;

-- RESTAURANT-CATEGORY 에 들어갈 Dao 쿼리
-- (1) 카테고리 코드 리스트
SELECT * FROM RESTAURANT_CATEGORY ORDER BY CNO DESC;
-- (2) 카테고리 갯수
SELECT COUNT(*) CNT FROM RESTAURANT_CATEGORY;
commit;