package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("****************");
		System.out.println("1. 이름 검색 : ");
		System.out.println("2. 아이디 검색 : ");
		System.out.println("****************");
		System.out.println(" 번호 : ");
		int num = scan.nextInt();
		
		
		System.out.println();
		String columnName = null;
		String value = null;
		if(num == 1) {
			System.out.println("검색 할 이름 입력 : ");
			value = scan.next();
			columnName = "name";
			
		}else if(num == 2) {
			System.out.println("검색 할 아이디 입력 : ");
			value = scan.next();
			columnName = "id";
		}
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("columnName", columnName);
		map.put("value", value);
		
		//DB
		UserDAO userDAO = new UserDAO();
		List<UserDTO> list = userDAO.search(map);
		
		//응답
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			
		}//for
	}

}
















