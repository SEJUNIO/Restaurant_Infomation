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

import com.ch.restaurant.dto.Restaurant_CategoryDto;

	public class RestaurantCategoryDao {
		public static final int FAIL = 0;
		public static final int SUCCESS = 1;
		private DataSource ds;
		// 싱글톤
		private static RestaurantCategoryDao instance = new RestaurantCategoryDao();
		public static RestaurantCategoryDao getInstance() {
			return instance;
		}
		private RestaurantCategoryDao() {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			} catch (NamingException e) {
				System.out.println(e.getMessage());
			}
		}
	// 1. 레스토랑 카테고리 목록
		public ArrayList<Restaurant_CategoryDto> listCategory(){
			ArrayList<Restaurant_CategoryDto> cLists = new ArrayList<Restaurant_CategoryDto>();
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT * FROM RESTAURANT_CATEGORY ORDER BY CNO DESC";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String cno   = rs.getString("cno");
					String cfood  = rs.getString("cfood");
					cLists.add(new Restaurant_CategoryDto(cno, cfood));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs   !=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return cLists;
	}
	// 2. 글갯수
		public int getRestaurantCateTotCnt() {
			int totCnt = 0;
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT COUNT(*) CNT FROM RESTAURANT_CATEGORY";
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
}
