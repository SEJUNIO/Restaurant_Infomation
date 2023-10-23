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
import com.ch.restaurant.dto.Restaurant_InfoDto;


public class RestaurantInfoDao {
	public static final int SUCCESS = 1;
	private final int FAIL = 0;
	private DataSource ds;
	private static RestaurantInfoDao Instance = new RestaurantInfoDao();
	public static RestaurantInfoDao getInstance() {
		return Instance;
	}
	public RestaurantInfoDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1. 글목록(startRow 부터 endRow 까지)
	public ArrayList<Restaurant_InfoDto> listRestInfo(int startRow, int endRow){
		ArrayList<Restaurant_InfoDto> dtos = new ArrayList<Restaurant_InfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
				"  (SELECT ROWNUM RN, A.* FROM (SELECT F.* FROM RESTAURANT_INFO F, MEMBER M" + 
				"        WHERE F.MID=M.MID" + 
				"            ORDER BY FGROUP DESC, FSTEP)" + 
				"                WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int fid = rs.getInt("fid");
				 String mid = rs.getString("mid");
				 int rno = rs.getInt("rno");
				 String ftitle = rs.getString("ftitle");
				 String fcontent = rs.getString("fcontent");
				 String ffilename = rs.getString("ffilename");
				 Date frdate = rs.getDate("fdate");
				 int fhit = rs.getInt("fhit");
				 int fgroup = rs.getInt("fgroup");
				 int fstep = rs.getInt("fstep");
				 int findent = rs.getInt("findent");
				 String fip = rs.getString("fip");
				 dtos.add(new Restaurant_InfoDto(fid, mid, rno, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip));
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
	// 2. 글갯수
	public int getRestaurantTotCnt() {
		int totCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM RESTAURANT_INFO";
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
	// 3. 원글쓰기 (사용자로부터 입력받은 bname, btitle, bcontent, bip)
	public int writeRestaurant_Inform(Restaurant_InfoDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO RESTAURANT_INFO "
					+ "(FID, MID, FTITLE, FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP)" + 
						"VALUES (RESTAURANT_INFO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, RESTAURANT_INFO_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setInt(5, dto.getFhit());
			pstmt.setString(6, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println("원글 쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : 원글쓰기 실패 ; " + dto);
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
	// 4. bid로 조회수 1 올리기
	public void hitUp(int fid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE RESTAURANT_INFO SET FHIT = FHIT + 1 WHERE FID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
			System.out.println(fid + "번 글 조회수 1up");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : 조회수 업 실패");
		} finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 5. fid로 dto가져오기
	public Restaurant_InfoDto getRestaurantNotHitUp(int fid) {
		Restaurant_InfoDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM RESTAURANT_INFO WHERE FID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 String mid = rs.getString("mid");
				 int rno = rs.getInt("rno");
				 String ftitle = rs.getString("ftitle");
				 String fcontent = rs.getString("fcontent");
				 String ffilename = rs.getString("ffilename");
				 Date frdate = rs.getDate("frdate");
				 int fhit = rs.getInt("fhit");
				 int fgroup = rs.getInt("fgroup");
				 int fstep = rs.getInt("fstep");
				 int findent = rs.getInt("findent");
				 String fip = rs.getString("fip");
				dto = new Restaurant_InfoDto(fid, mid, rno, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip);
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
	// 6. 글수정 (특정 fid의 ftitle, fcontent, ffilename, fip 수정)
	public int modifyBoard(int fid, String ftitle, String fcontent, String ffilename, String fip) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE " +
				"		RESTAURANT_INFO SET FTITLE = ?," + 
				"           FCONTENT = ?," + 
				"           fFILENAME = ?," + 
				"           FIP = ?" + 
				"            WHERE FID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ftitle);
			pstmt.setString(2, fcontent);
			pstmt.setString(3, ffilename);
			pstmt.setString(4, fip);
			pstmt.setInt(5, fid);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글수정 성공":"글번호(bid) 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : 글 수정 실패 ");
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
	// 7. 글삭제 (특정 bid 삭제)
	public int deleteRestaurantInform(int fid) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM RESTAURANT_INFO WHERE FID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글삭제 성공":"글번호(fid) 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : 글 삭제 실패 ");
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
	// 8. 답변글 저장 전단계(엑셀 ⓐ단계)
	private void preReplyStepRestaurant(int fgroup, int fstep) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE RESTAURANT_INFO SET BSTEP = BSTEP+1 WHERE BGROUP=? AND BSTEP > ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 fstep 재조정 됨");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : preReplyStepRestaurant 오류 ");
		} finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 9. 답변글 쓰기
	public int replyRestaurant(Restaurant_InfoDto dto) {
	int result = FAIL;
	preReplyStepRestaurant(dto.getFgroup(), dto.getFstep()); // 답변글 저장 전단계
	Connection        conn  = null;
	PreparedStatement pstmt = null;
	String sql = "INSERT INTO RESTAURANT_INFO (FID, MID, RNO, FTITLE, FCONTENT," +
			 									" FHIT, FGROUP, FSTEP, FINDENT, FIP)" + 
					"VALUES (RESTAURANT_INFO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	try {
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getMid());
		pstmt.setInt(2, dto.getRno());
		pstmt.setString(3, dto.getFtitle());
		pstmt.setString(4, dto.getFcontent());
		pstmt.setInt(5, dto.getFhit());
		pstmt.setInt(6, dto.getFgroup()+1);
		pstmt.setInt(7, dto.getFstep());
		pstmt.setInt(8, dto.getFindent()+1);
		pstmt.setString(9, dto.getFip());
		result = pstmt.executeUpdate();
		System.out.println("답변글 쓰기 성공");
	} catch (SQLException e) {
		System.out.println(e.getMessage() + " : 답변글쓰기 실패 ");
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
	// (10) 회원탈퇴시 탈퇴하는 회원(mid)이 쓴 글 모두 삭제하기
		public int preWithdrawalRestaurantStep(String mid) {
			int cntRestaurantReview = 0;
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM RESTAURANT_INFO WHERE MID=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				cntRestaurantReview = pstmt.executeUpdate();
				System.out.println(cntRestaurantReview+"개글 삭제 성공(회원탈퇴전)");
			} catch (SQLException e) {
				System.out.println(e.getMessage() + "탈퇴 전 글 삭제 실패 ");
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} 
			}
			return cntRestaurantReview;
		}
		// (11). 맛집리뷰 정보 삭제
		public int deleteRestaurantReview(String rname) {
			int result = FAIL;
				Connection conn = null;
				PreparedStatement pstmt = null;
				String sql = "DELETE FROM RESTAURANT_INFO WHERE RNO=?";
					try {
						conn = ds.getConnection();
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, rname);
						result = pstmt.executeUpdate();
						System.out.println(result==SUCCESS ? "맛집리뷰삭제 성공":"맛집리뷰(ftitle)오류");
					} catch (SQLException e) {
						System.out.println(e.getMessage() + " : 맛집리뷰 삭제 실패");
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

