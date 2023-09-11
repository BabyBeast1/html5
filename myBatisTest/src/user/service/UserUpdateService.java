package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {
	
	
	
	@Override
	public void execute() {
		
		System.out.println();
		
		Scanner scan =new Scanner(System.in);
		System.out.println("수정할 아이디 입력 : ");
		String id = scan.next();
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("아이디가 존재하지 않습니다.");
		}else {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		
		}// else
		
		System.out.println();
		System.out.println("수정할 이름 입력 : ");
		String name = scan.next();
		System.out.println("수정할 비밀번호 입력 : ");
		String pwd = scan.next();
		
		
		userDTO.setName(name);
		userDTO.setPwd(pwd);
		
		//DB
		userDAO.update(userDTO);
		System.out.println("데이터를 수정하였습니다.");
	}

}
