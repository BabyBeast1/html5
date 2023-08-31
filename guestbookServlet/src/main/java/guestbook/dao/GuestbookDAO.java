package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GuestbookDAO() {
		try{
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		public void write(GuestbookDTO guestbookDTO) {
			String sql = "insert into guestbook values(seq_guestbook.nextval, ?, ?, ?, ?, ?, sysdate)";
			
			getConnection(); //접속
			try {
				pstmt = conn.prepareStatement(sql); //생성
				
				//?에 데이터 대입
				pstmt.setString(1, guestbookDTO.getName());
				pstmt.setString(2, guestbookDTO.getEmail());
				pstmt.setString(3, guestbookDTO.getWebsite());
				pstmt.setString(4, guestbookDTO.getTitle());
				pstmt.setString(5, guestbookDTO.getContent());
				
				pstmt.executeUpdate(); //실행
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
					try {
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			
		}
		
		/*
		 * public List<GuestbookDTO> select() { List<GuestbookDTO> list= new
		 * ArrayList<GuestbookDTO>(); //부모 = 자식 (다형성)
		 * 
		 * 
		 * String sql =
		 * "select seq, name, email, website, title, content, logtime from guestbook";
		 * // 날짜 - yyyy.mm.dd 변환
		 * 
		 * getConnection(); //접속
		 * 
		 * try { pstmt = conn.prepareStatement(sql);
		 * 
		 * rs = pstmt.executeQuery();//실행 -ResultSet 리턴
		 * 
		 * while(rs.next()) { GuestbookDTO guestbookDTO = new GuestbookDTO();
		 * guestbookDTO.setSeq(rs.getInt("seq"));
		 * guestbookDTO.setName(rs.getString("name"));
		 * guestbookDTO.setEmail(rs.getString("email"));
		 * guestbookDTO.setWebsite(rs.getString("website"));
		 * guestbookDTO.setTitle(rs.getString("title"));
		 * guestbookDTO.setContent(rs.getString("content"));
		 * guestbookDTO.setLogtime(rs.getDate("logtime"));
		 * 
		 * 
		 * 
		 * 
		 * list.add(guestbookDTO); } //while
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); list = null; }finally { try {
		 * if(rs != null) rs.close(); if(pstmt != null) pstmt.close(); if(conn != null)
		 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		 * 
		 * return list; }
		 */
/*
		public void write(GuestbookDTO guestbookDTO) {
//			String sql = "insert into guestbook values(seq_guestbook.nextval, ?, ?, ?, ?, ?, sysdate)";
			String sql = "insert into guestbook(seq, name, email, homepage, subject, content) values(seq_guestbook.nextval, ?, ?, ?, ?, ?)";
			
		
		try {
			pstmt = conn.prepareStatement(sql); // 생성
			
			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getWebsite());
			pstmt.setString(4, guestbookDTO.getTitle());
			pstmt.setString(5, guestbookDTO.getContent());
			
		
			 pstmt.executeUpdate(); // 실행 - 개수 리턴
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		}
		*/
		public List<GuestbookDTO> getAllList(int startNum, int endNum) {
			List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
			String sql = "select * from"
					   + "(select rownum rn, tt.* from"
					   + "(select * from guestbook order by seq desc)tt"
					   + ") where rn>=? and rn<=?";
			getConnection();
			
			
			try {
				pstmt = conn.prepareStatement(sql); // prepareStatement - sql문장을 전담으로 처리해주는 가이드

				//?에 데이터 대입
				pstmt.setInt(1, startNum);
				pstmt.setInt(2, endNum);
				
				rs = pstmt.executeQuery(); 			// 실행 - ResultSet 리턴  사이즈가 없기때문에 현재값이 없을때까지 계속 반복해야함
				
				while(rs.next()) {
					GuestbookDTO guestbookDTO = new GuestbookDTO();
					guestbookDTO.setSeq(rs.getInt("seq"));
					guestbookDTO.setName(rs.getString("name"));
					guestbookDTO.setEmail(rs.getString("email"));
					guestbookDTO.setWebsite(rs.getString("website"));
					guestbookDTO.setTitle(rs.getString("title"));
					guestbookDTO.setContent(rs.getString("content"));
					guestbookDTO.setLogtime(rs.getDate("logtime"));
					
					list.add(guestbookDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				list = null;
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;

	}

		public int getTotalA() {
			int totalA = 0;
			String sql = "select count(*) from guestbook";
			getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				rs.next();
				totalA = rs.getInt(1);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			return totalA;
		}

	
}


