package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.DBTestDTO;

public class DBTestDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public DBTestDAO() {
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
		
		public int insert(DBTestDTO dBTestDTO) {
			int su = 0;
			String sql = "insert into DBTEST values(?,?,?,sysdate)";
			getConnection(); //접속
			
			try {
				pstmt = conn.prepareStatement(sql); //생성
				
				//?에 데이터 대입
				pstmt.setString(1, dBTestDTO.getName());
				pstmt.setString(2, dBTestDTO.getAge());
				pstmt.setString(3, dBTestDTO.getHeight());
				
				su = pstmt.executeUpdate(); //실행
				
				
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
			
			return su;
		}
		
		public List<DBTestDTO> select() {
			List<DBTestDTO> list= new ArrayList<DBTestDTO>(); //부모 = 자식 (다형성)
			
			
			String sql = "select name, age, height, to_char(logtime, 'yyyy.mm.dd') as logtime from dbtest"; // 날짜 - yyyy.mm.dd 변환
			
			
			getConnection(); //접속
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();//실행 -ResultSet 리턴
				
				while(rs.next()) {
					DBTestDTO dBTestDTO = new DBTestDTO();
					dBTestDTO.setName(rs.getString("name"));
					dBTestDTO.setAge(rs.getString("age"));
					dBTestDTO.setHeight(rs.getString("height"));
					dBTestDTO.setLogtime(rs.getString("logtime"));
					
					
					list.add(dBTestDTO);
				} //while
				
			} catch (SQLException e) {
				e.printStackTrace();
				list = null;
			}finally {
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
	
}


