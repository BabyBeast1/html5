package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.dto.MemberDTO;

public class MemberDAO {	
private SqlSessionFactory sqlSessionFactory;
	
	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader); //생성
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public MemberDTO login(String id, String pwd) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.login",map);
		sqlSession.close();
		return memberDTO;
	}
	
	
	
}

