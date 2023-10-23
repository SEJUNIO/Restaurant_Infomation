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

import com.ch.restaurant.dto.BoardDto;

public class BoardDao {
		public static final int FAIL = 0;
		public static final int SUCCESS = 1;
		private DataSource ds;
		// 싱글톤
		private static BoardDao instance = new BoardDao();
		public static BoardDao getInstance() {
			return instance;
		}
		private BoardDao() {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			} catch (NamingException e) {
				System.out.println(e.getMessage());
	}
}		
		// 1. 글목록(startRow부터 endRow)
		public ArrayList<BoardDto> listRestaurantBoard(int startRow, int endRow){
			ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT * FROM" + 
					"  (SELECT ROWNUM RN, B.* FROM (SELECT B.* FROM BOARD B, MEMBER M" + 
					"  WHERE B.MID=M.MID" + 
					"  ORDER BY BGROUP DESC, BSTEP) B)" + 
					"  WHERE RN BETWEEN ? AND ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					 int bid = rs.getInt("bid");
					 String mid = rs.getString("mid");
					 String aid = rs.getString("aid");
					 String btitle = rs.getString("btitle");
					 String bcontent = rs.getString("bcontent");
					 int bhit = rs.getInt("bhit");
					 String bpw = rs.getString("bpw");
					 int bgroup = rs.getInt("bgroup");
					 int bstep = rs.getInt("bstep");
					 int bindent = rs.getInt("bindent");
					 String bip = rs.getString("bip");
					 Date brdate = rs.getDate("brdate");
					 dtos.add(new BoardDto(bid, mid, aid, btitle, bcontent, bhit, bpw, bgroup, bstep, bindent, bip, brdate));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs   != null) rs.close();
					if(pstmt!= null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return dtos;
		}
		//(1) WRITER 타이틀에 사용자가 썼으면 사용자이름, 관리자가 썼으면 관리자라고 출력
		public ArrayList<BoardDto> writerBoard(){
			ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT BID, (SELECT MNAME FROM MEMBER WHERE BOARD.MID=MID)||" + 
						"  (SELECT '관리자' FROM ADMIN WHERE BOARD.AID=AID) WRITER, BTITLE, BCONTENT, BHIT, BRDATE" + 
						"  FROM BOARD ORDER BY BRDATE DESC";
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						 int bid = rs.getInt("bid");
						 String mid = rs.getString("mid");
						 String aid = rs.getString("aid");
						 String btitle = rs.getString("btitle");
						 String bcontent = rs.getString("bcontent");
						 int bhit = rs.getInt("bhit");
						 String bpw = rs.getString("bpw");
						 int bgroup = rs.getInt("bgroup");
						 int bstep = rs.getInt("bstep");
						 int bindent = rs.getInt("bindent");
						 String bip = rs.getString("bip");
						 Date brdate = rs.getDate("brdate");
						 dtos.add(new BoardDto(bid, mid, aid, btitle, bcontent, bhit, bpw, bgroup, bstep, bindent, bip, brdate));
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
				return dtos;
			}
		// (2) 글갯수
		public int getBoardTotCnt() {
			int totCnt = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT COUNT(*) CNT FROM BOARD";
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
		public int writeBoard(BoardDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO BOARD(BID, MID, AID, BTITLE, BCONTENT, BPW, BGROUP, BSTEP, BINDENT, BIP)" + 
					"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getBid());
				pstmt.setString(2, dto.getMid());
				pstmt.setString(3, dto.getAid());
				pstmt.setString(4, dto.getBtitle());
				pstmt.setString(5, dto.getBcontent());
				pstmt.setString(6, dto.getBpw());
				pstmt.setInt(7, dto.getBgroup());
				pstmt.setInt(8, dto.getBstep());
				pstmt.setInt(9, dto.getBindent());
				pstmt.setString(10, dto.getBip());
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
		public void hitUp(int bid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE BOARD SET BHIT = BHIT + 1 WHERE BID=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bid);
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
		public BoardDto getBoardNotHitUP(int bid) {
			BoardDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT B.*" + 
					"  FROM BOARD B, MEMBER M WHERE B.MID=M.MID AND BID=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					 String mid = rs.getString("mid");
					 String aid = rs.getString("aid");
					 String btitle = rs.getString("btitle");
					 String bcontent = rs.getString("bcontent");
					 int bhit = rs.getInt("bhit");
					 String bpw = rs.getString("bpw");
					 int bgroup = rs.getInt("bgroup");
					 int bstep = rs.getInt("bstep");
					 int bindent = rs.getInt("bindent");
					 String bip = rs.getString("bip");
					 Date brdate = rs.getDate("rdate");
					 dto = new BoardDto(bid, mid, aid, btitle, bcontent, bhit, bpw, bgroup, bstep, bindent, bip, brdate);
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
		//(6) 글 수정하기(bid, btitle, bcontent, bip)수정
		public int modifyBoard(BoardDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE BOARD SET BTITLE = ?," + 
					"                    BCONTENT = ?," + 
					"                    BIP = ?," + 
					"                    BRDATE = ?" + 
					"            WHERE BID = ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getBtitle());
				pstmt.setString(2, dto.getBcontent());
				pstmt.setString(3, dto.getBip());
				pstmt.setDate(4, dto.getBrdate());
				pstmt.setInt(5, dto.getBid());
				result = pstmt.executeUpdate();
				System.out.println(result == SUCCESS ? "글수정 성공":"글번호(bid)오류");
			} catch (SQLException e) {
				System.out.println(e.getMessage() + "글 수정 실패");
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
		public int deleteBoard(int fid) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM BOARD WHERE bID=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fid);
				result = pstmt.executeUpdate();
				System.out.println(result == SUCCESS ? "글삭제 성공":"글번호(bid) 오류");
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
	


