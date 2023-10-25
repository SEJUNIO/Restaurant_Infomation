package com.ch.restaurant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.ch.restaurant.dto.NoticeDto;

public class NoticeDao {
		public static final int FAIL = 0;
		public static final int SUCCESS = 1;
		private DataSource ds;
		// 싱글톤
		private static NoticeDao instance = new NoticeDao();
		public static NoticeDao getInstance() {
			return instance;
		}
		private NoticeDao() {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			} catch (NamingException e) {
				System.out.println(e.getMessage());
	}
}		
		//(1) 글목록(startRow~endRow)
		public ArrayList<NoticeDto> listNotice(int startRow, int endRow){
			ArrayList<NoticeDto> ndtos = new ArrayList<NoticeDto>();
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT * FROM" + 
					"  (SELECT ROWNUM RN, N.* FROM (SELECT N.* FROM NOTICE N, ADMIN A" + 
					"                              WHERE N.AID=A.AID" + 
					"                              ORDER BY NGROUP DESC, NSTEP) N)" + 
					"  WHERE RN BETWEEN ? AND ?";
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						 int nid = rs.getInt("nid");
						 String aid = rs.getString("aid");
						 String ntitle = rs.getString("ntitle");
						 String ncontent = rs.getString("ncontent");
						 int nhit = rs.getInt("nhit");
						 int ngroup = rs.getInt("ngroup");
						 int nstep = rs.getInt("nstep");
						 int nindent = rs.getInt("nindent");
						 String nip = rs.getString("nip");
						 Date nrdate = rs.getDate("nrdate");
						 ndtos.add(new NoticeDto(nid, aid, ntitle, ncontent, nhit, ngroup, nstep, nindent, nip, nrdate));
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage() + "리스트 예외");
				} finally {
					try {
						if(rs    != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(conn  != null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} 
				}
				return ndtos;
			}
		// (2) 글갯수
		public int getNoticeTotCnt() {
			int totCnt = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT COUNT(*) CNT FROM NOTICE";
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					rs.next();
					totCnt = rs.getInt(1);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(rs    != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(conn  != null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} 
				}
				return totCnt;
			}
			// (3). 글쓰기
		public int writeNotice(NoticeDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO NOTICE(NID, AID, NTITLE, NCONTENT, NHIT, NGROUP, NSTEP, NINDENT, NIP)" + 
					"    VALUES (NOTICE_SEQ.NEXTVAL, ?, ?, ?, ?, NOTICE_SEQ.CURRVAL, ?, ?, ?)";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getAid());
				pstmt.setString(2, dto.getNtitle());
				pstmt.setString(3, dto.getNcontent());
				pstmt.setInt(4, dto.getNhit());
				pstmt.setInt(5, dto.getNstep());
				pstmt.setInt(6, dto.getNindent());
				pstmt.setString(7, dto.getNip());
				pstmt.executeUpdate();
				result = SUCCESS;
				System.out.println("원글쓰기 성공");
			} catch (SQLException e) {
				System.out.println(e.getMessage() + "원글쓰기 실패");
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} 
			}
			return result;
		}
		// (4). hit 1회 올리기
		public void hitUp(int nid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE NOTICE SET NHIT = NHIT + 1 WHERE NID=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, nid);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage() + " 조회수 up 실패");
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
			}
		}		
	}
		//(5). 글번호(bid)로 글전체 내용(BoardDto)가져오기
		public NoticeDto getNoticeNotHitUP(int nid) {
			NoticeDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT N.*FROM NOTICE N, ADMIN A WHERE N.AID=A.AID AND NID=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, nid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					 String aid = rs.getString("aid");
					 String ntitle = rs.getString("ntitle");
					 String ncontent = rs.getString("ncontent");
					 int nhit = rs.getInt("nhit");
					 int ngroup = rs.getInt("ngroup");
					 int nstep = rs.getInt("nstep");
					 int nindent = rs.getInt("nindent");
					 String nip = rs.getString("nip");
					 Date nrdate = rs.getDate("nrdate");
					 dto = new NoticeDto(nid, aid, ntitle, ncontent, nhit, ngroup, nstep, nindent, nip, nrdate);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs    != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} 
			}
			return dto;			
		}
		//(6) 글 수정하기(nid, ntitle, ncontent, nip)수정
		public int modifyNotice(NoticeDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE NOTICE SET NTITLE = ?," + 
					"                    NCONTENT = ?," + 
					"					 NIP = ?" + 
					"            WHERE NID = ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getNtitle());
				pstmt.setString(2, dto.getNcontent());
				pstmt.setString(3, dto.getNip());
				pstmt.setInt(4, dto.getNid());
				result = pstmt.executeUpdate();
				System.out.println(result == SUCCESS ? "글수정 성공":"글번호(nid)오류");
			} catch (SQLException e) {
				System.out.println(e.getMessage() + "글 수정 실패----");
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} 
			}
			return result;	
		}
		public int deleteNotice(int nid) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM NOTICE WHERE NID=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, nid);
				result = pstmt.executeUpdate();
				System.out.println(result == SUCCESS ? "글삭제 성공":"글번호(nid) 오류");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} 
			}
			return result;
		}
	}
	


