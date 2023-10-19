package com.ch.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ch.restaurant.dto.RestaurantDto;

public class RestaurantDao {
	public static final int SUCCESS = 1;
	private final int FAIL = 0;
	private DataSource ds;
	public RestaurantDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
		// 1. 맛집목록(startRow부터 endRow)
		public ArrayList<RestaurantDto> listRestaurant(int startRow, int endRow){
			ArrayList<RestaurantDto> rdtos = new ArrayList<RestaurantDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM" + 
					"                        (SELECT * FROM RESTAURANT ORDER BY RNAME) A)" + 
					"        WHERE RN BETWEEN ? AND ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					 int rno = rs.getInt("rno");
					 String rname = rs.getString("rname");
					 String cno = rs.getString("cno");
					 String raddress = rs.getString("raddress");
					 String rtel = rs.getString("rtel");
					 String rholiday = rs.getString("rholiday");
					 String rhours = rs.getString("rhours");
					 String rparking = rs.getString("rparking");
					 rdtos.add(new RestaurantDto(rno, rname, cno, raddress, rtel, rholiday, rhours, rparking));
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
			return rdtos;
		}
		// 2. fid로 dto가져오기(맛집등록시 session에 넣기 위함)
		public RestaurantDto getRestaurantUp(int rno) {
			RestaurantDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM RESTAURANT WHERE RNO=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rno);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					 String rname = rs.getString("rname");
					 String cno = rs.getString("cno");
					 String raddress = rs.getString("raddress");
					 String rtel = rs.getString("rtel");
					 String rholiday = rs.getString("rholiday");
					 String rhours = rs.getString("rhours");
					 String rparking = rs.getString("rparking");
					 dto = new RestaurantDto(rno, rname, cno, raddress, rtel, rholiday, rhours, rparking);
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
			return dto;
		}
		// 3. 맛집갯수
		public int getRestaurantTotCnt() {
			int totCnt = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql ="SELECT COUNT(*) CNT FROM RESTAURANT";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs.next();
				totCnt = rs.getInt("cnt");
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
			return totCnt;
		}
		// 4. 맛집 정보 수정
		public int modifyRestaurant(int rno, String rname, String cno, String raddress, String rholiday, String rparking) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE RESTAURANT SET RNAME =?," + 
					"                        CNO = ?," + 
					"                        RADDRESS = ?," + 
					"                        RHOLIDAY = ?," + 
					"                        RPARKING = ?" + 
					"                    WHERE RNO =?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cno);
				pstmt.setString(2, raddress);
				pstmt.setString(3, rholiday);
				pstmt.setString(4, rparking);
				pstmt.setInt(5, rno);
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS ? "맛집정보수정 성공":"맛집번호(rno)오류");
			} catch (SQLException e) {
				System.out.println(e.getMessage() + " : 맛집정보수정 실패");
			} finally {
				try {
					if(pstmt!= null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return result;
		}
		// 5. 맛집리뷰 정보 삭제
		public int deleteRestaurant(String rname) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM RESTAURANT_INFO WHERE RNO=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, rname);
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS ? "맛집삭제 성공":"맛집(rname)오류");
			} catch (SQLException e) {
				System.out.println(e.getMessage() + " : 맛집 삭제 실패");
			} finally {
				try {
					if(pstmt!= null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return result;
		}
				
	}

