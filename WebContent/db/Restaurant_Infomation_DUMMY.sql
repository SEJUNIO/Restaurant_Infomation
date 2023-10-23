-- MEMBER DUMMY DATA
INSERT INTO MEMBER (mid, mpw, mname, memail, mtel, mbirth, maddress)
    VALUES ('aaa', '111', '박지후', 'aaa@a.com', '010-1111-1111', '1992/06/22', '서울 마포구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('gayun','1','김가연','gayun@naver.com','010-2222-2222','1972/09/09','광주 서구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('gico','1','지코','gico@naver.com','010-3333-3333','1992/09/14','서울 영등포구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('go','1','고소영','go@naver.com','010-4444-4444','1972/10/06','서울 동대문구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('son','1','손흥민','son@naver.com','010-5555-5555','1992/07/08','강원도 평창군');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('han','1','한지민','han@naver.com','010-6666-6666','1982/11/05','서울 강남구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('kim','1','김지민','kim@naver.com','010-7777-7777','1981/11/05','서울 서초구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('park','1','박진형','jin@naver.com','010-8888-8888','1983/11/05','서울 구로구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('sol','1','박솔우','sol@naver.com','010-9999-9999','1984/11/05','서울 송파구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('sole','1','박솔웅','sol@naver.com','010-9999-9999','1984/11/05','서울 송파구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('p1','1','박지우','sol@naver.com','010-9999-9999','1984/11/05','서울 송파구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('p2','1','박지운','sol@naver.com','010-9999-9999','1984/11/05','서울 송파구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('p3','1','박시오','sol@naver.com','010-9999-9999','1984/11/05','서울 송파구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('p4','1','박시운','sol@naver.com','010-9999-9999','1984/11/05','서울 송파구');
INSERT INTO MEMBER (mID, mPw, mName, mEmail, mtel, mBirth, mAddress)
    VALUES ('p5','1','박시유','sol@naver.com','010-9999-9999','1984/11/05','서울 송파구');
-- ADMIN DUMMY DATA
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('abc', '111', '박세준');

-- BOARD DUMMY DATA
INSERT INTO BOARD (BID, MID, AID, BTITLE, BCONTENT, BHIT, BPW, BGROUP, BSTEP, bINDENT, BIP)
    VALUES (1, 'aaa', null, '제목1', '냉무1', '111', '111', '111', 0, 0, '192.168.5.4');
INSERT INTO BOARD (BID, MID, AID, BTITLE, BCONTENT, BHIT, BPW, BGROUP, BSTEP, bINDENT, BIP)
    VALUES (2, 'go', null, '제목1', '냉무1', '111', '111', '111', 0, 0, '192.168.5.4');
INSERT INTO BOARD (BID, MID, AID, BTITLE, BCONTENT, BHIT, BPW, BGROUP, BSTEP, bINDENT, BIP)
    VALUES (3, 'son', null, '제목2', '냉무2', '111', '111', '111', 0, 0, '192.168.6.8');
INSERT INTO BOARD (BID, MID, AID, BTITLE, BCONTENT, BHIT, BPW, BGROUP, BSTEP, bINDENT, BIP)
    VALUES (4, 'park', null, '제목3', '냉무3', '111', '111', '111', 0, 0, '192.168.7.8');
INSERT INTO BOARD (BID, MID, AID, BTITLE, BCONTENT, BHIT, BPW, BGROUP, BSTEP, bINDENT, BIP)
    VALUES (5, null, 'abc', '제목1', '냉무1', '111', '111', '111', 0, 0, '192.168.7.9');
INSERT INTO BOARD (BID, MID, AID, BTITLE, BCONTENT, BHIT, BPW, BGROUP, BSTEP, bINDENT, BIP)
    VALUES (6, null, 'abc', '제목2', '냉무2', '111', '111', '111', 0, 0, '192.168.5.9'); 
INSERT INTO BOARD (BID, MID, AID, BTITLE, BCONTENT, BHIT, BPW, BGROUP, BSTEP, bINDENT, BIP)
    VALUES (7, null, 'abc', '제목3', '냉무3', '111', '111', '111', 0, 0, '192.168.6.9'); 
INSERT INTO BOARD (BID, MID, AID, BTITLE, BCONTENT, BHIT, BPW, BGROUP, BSTEP, bINDENT, BIP)
    VALUES (8, null, 'abc', '제목4', '냉무4', '111', '111', '111', 0, 0, '192.168.9.9'); 
    
-- RESTAURANT_INFO DUMMY DATA 
INSERT INTO RESTAURANT_INFO (FID, MID, RNO, FTITLE, FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (RESTAURANT_INFO_SEQ.NEXTVAL, 'aaa', 1, '본문1', '내용1', 'go.jpg', '1', RESTAURANT_INFO_SEQ.CURRVAL, 0, 0, '192.168.0.1');
INSERT INTO RESTAURANT_INFO (FID, MID, RNO, FTITLE, FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (RESTAURANT_INFO_SEQ.NEXTVAL, 'aaa', 1, '본문2', '내용2', 'go.jpg', '1', RESTAURANT_INFO_SEQ.CURRVAL, 0, 0, '192.168.1.1');
INSERT INTO RESTAURANT_INFO (FID, MID, RNO, FTITLE, FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (RESTAURANT_INFO_SEQ.NEXTVAL, 'aaa', 1, '본문3', '내용3', 'go.jpg', '1', RESTAURANT_INFO_SEQ.CURRVAL, 0, 0, '192.168.2.1');
INSERT INTO RESTAURANT_INFO (FID, MID, RNO, FTITLE, FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (RESTAURANT_INFO_SEQ.NEXTVAL, 'aaa', 1, '본문4', '내용4', 'go.jpg', '1', RESTAURANT_INFO_SEQ.CURRVAL, 0, 0, '192.168.3.1');
INSERT INTO RESTAURANT_INFO (FID, MID, RNO, FTITLE, FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (RESTAURANT_INFO_SEQ.NEXTVAL, 'aaa', 1, '본문5', '내용5', 'go.jpg', '1', RESTAURANT_INFO_SEQ.CURRVAL, 0, 0, '192.168.4.1');



-- RESTAURANT DUMMY DATA
INSERT INTO RESTAURANT (RNO, RNAME, CNO, RADDRESS, RTEL, RHOLIDAY, RHOURS, RPARKING)
    VALUES (1, '치즈플로', 'WESTERNFOOD', '서울 강남구', '02-822-1029', '금요일', '월-금 09:00~19:00', '발렛');
INSERT INTO RESTAURANT (RNO, RNAME, CNO, RADDRESS, RTEL, RHOLIDAY, RHOURS, RPARKING)
    VALUES (2, '오월의종', 'BAKERY', '서울 이태원', '02-749-9481', '월요일,일요일', '월-금 09:00~19:00', '없음');
INSERT INTO RESTAURANT (RNO, RNAME, CNO, RADDRESS, RTEL, RHOLIDAY, RHOURS, RPARKING)
    VALUES (3, '탄산바', 'DESERT', '서울 이태원', '02-794-4486', '없음', '월-금 09:00~19:00', '없음');
INSERT INTO RESTAURANT (RNO, RNAME, CNO, RADDRESS, RTEL, RHOLIDAY, RHOURS, RPARKING)
    VALUES (4, '데이로우', 'DESERT', '서울 이태원', '02-790-1767', '월요일', '월-금 09:00~19:00', '발렛');
INSERT INTO RESTAURANT (RNO, RNAME, CNO, RADDRESS, RTEL, RHOLIDAY, RHOURS, RPARKING)
    VALUES (5, '제니엘 디저트바', 'DESERT', '서울 이태원', '02-822-1029', '금요일', '월-금 09:00~19:00', '발렛');
INSERT INTO RESTAURANT (RNO, RNAME, CNO, RADDRESS, RTEL, RHOLIDAY, RHOURS, RPARKING)
    VALUES (6, '부자피자', 'KOREANFOOD', '서울 이태원', '02-822-1029', '없음', '월-금 09:00~19:00', '없음');
INSERT INTO RESTAURANT (RNO, RNAME, CNO, RADDRESS, RTEL, RHOLIDAY, RHOURS, RPARKING)
    VALUES (7, '빠르크', 'KOREANFOOD', '서울 이태원', '02-792-2022', '없음', '월-금 09:00~19:00', '발렛');
INSERT INTO RESTAURANT (RNO, RNAME, CNO, RADDRESS, RTEL, RHOLIDAY, RHOURS, RPARKING)
    VALUES (8, '루트에브리데이', 'WESTERNFOOD', '서울 강남구', '	02-797-9505', '월요일', '월-금 09:00~19:00', '없음');
INSERT INTO RESTAURANT (RNO, RNAME, CNO, RADDRESS, RTEL, RHOLIDAY, RHOURS, RPARKING)
    VALUES (9, 'YYY', 'WESTERNFOOD', '서울 이태원', '070-4213-2061', '없음', '월-금 09:00~19:00', '발렛');
    
-- RESTAURANT_CATEGORY DUMMY DATA
INSERT INTO RESTAURANT_CATEGORY (CNO, CFOOD) VALUES ('WESTERNFOOD', '양식');
INSERT INTO RESTAURANT_CATEGORY (CNO, CFOOD) VALUES ('CHINESEFOOD', '중식');
INSERT INTO RESTAURANT_CATEGORY (CNO, CFOOD) VALUES ('JAPANESEFOOD', '일식');
INSERT INTO RESTAURANT_CATEGORY (CNO, CFOOD) VALUES ('KOREANFOOD', '한식');
INSERT INTO RESTAURANT_CATEGORY (CNO, CFOOD) VALUES ('SNACKFOOD', '분식');
INSERT INTO RESTAURANT_CATEGORY (CNO, CFOOD) VALUES ('DESERT', '디저트');
INSERT INTO RESTAURANT_CATEGORY (CNO, CFOOD) VALUES ('BAKERY', '빵집');
INSERT INTO RESTAURANT_CATEGORY (CNO, CFOOD) VALUES ('CAFE', '카페');
INSERT INTO RESTAURANT_CATEGORY (CNO, CFOOD) VALUES ('ITALIANFOOD', '이탈리안');

COMMIT;











