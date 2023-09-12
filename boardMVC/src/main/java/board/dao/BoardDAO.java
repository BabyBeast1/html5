package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.dto.BoardDTO;

public class BoardDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader); //생성
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExistId(String id){
		boolean exist = false;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.isExistId", id);
		if(boardDTO != null) exist = true; 
		sqlSession.close();
		return exist;
	}
	
	public void boardWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite", map);
		sqlSession.commit();
		sqlSession.close();
	}
	public List<BoardDTO> getBoardList(int startNum, int endNum){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<BoardDTO> list = sqlSession.selectList("boardSQL.getBoardList", map);
		sqlSession.close();
		return list;
	}
	
	public int getTotalA(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}
	
	public BoardDTO getBoard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
		sqlSession.close();
		return boardDTO;
	}
	
	
}











