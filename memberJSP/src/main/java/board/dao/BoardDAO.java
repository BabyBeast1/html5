package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;

public class BoardDAO {

	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private DataSource ds;
	
	public BoardDAO() {
		try{
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");  //Tomcat 일 경우에만 java:comp/env 가 붙음 
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public void boardWrite(Map<String, String> map) {
		String sql = "insert into board(seq, id, name, email, subject, content, ref) "
	+ " values(seq_board.nextval, ?, ?, ?, ?, ?,seq_board.currval)";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, map.get("id"));
			pstmt.setString(2, map.get("name"));
			pstmt.setString(3, map.get("email"));
			pstmt.setString(4, map.get("subject"));
			pstmt.setString(5, map.get("content"));
			
			pstmt.executeUpdate(); //실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<BoardDTO> getBoardList(int startNum, int endNum){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select * from"
				   + "(select rownum rn, tt.* from"
				   + "(select * from board order by seq desc)tt "
				   + ")where rn >=? and rn<=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setRef(rs.getInt("ref"));				
				boardDTO.setLev(rs.getInt("lev"));				
				boardDTO.setStep(rs.getInt("step"));				
				boardDTO.setPseq(rs.getInt("pseq"));				
				boardDTO.setReply(rs.getInt("reply"));				
				boardDTO.setHit(rs.getInt("hit"));				
				boardDTO.setLogtime(rs.getDate("logtime"));				
				
				list.add(boardDTO);
			}//while
			
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











