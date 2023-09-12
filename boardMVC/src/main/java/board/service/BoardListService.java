package board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.dto.BoardPaging;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));

		//1페이지당 5개씩 설정
		int endNum = pg *5; 
		int startNum = endNum -4;
		//DB
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> list = boardDAO.getBoardList(startNum, endNum);

		//페이징 처리
		
		int totalA = boardDAO.getTotalA();  // 총글수

		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);

		boardPaging.makePagingHTML();

		//세션
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");

		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		request.setAttribute("boardPaging", boardPaging);
		
		return "/board/boardList.jsp";
	}

}
