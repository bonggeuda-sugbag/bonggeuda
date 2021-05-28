package com.bonggeuda.sugbag.owner.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bonggeuda.sugbag.common.paging.PageNation;
import com.bonggeuda.sugbag.model.dto.OwnerInfoDTO;
import com.bonggeuda.sugbag.model.dto.PageInfoDTO;
import com.bonggeuda.sugbag.model.dto.QnADTO;
import com.bonggeuda.sugbag.owner.notice.service.QuestionService;

/**
 * Servlet implementation class Question
 */
@WebServlet("/owner/question/list")
public class QuestionList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인 값
		HttpSession session = request.getSession();
		int ownerNo = (Integer)session.getAttribute("ownerNo"); 
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		/* 전체 게시물 수가 필요 */
		/* 데이터베이스에서 먼저 전체 게시물 수를 조회 */
		QuestionService questionService = new QuestionService();
		
		int totalCount = questionService.selectTotalCount(ownerNo);
		
		System.out.println("totalCount 체크 : " + totalCount);

		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;
		
		/* 한 번에 보여질 페이징 버튼의 수*/
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		PageInfoDTO pageInfo = PageNation.getPageInfo(pageNo, totalCount, limit, buttonAmount);

		System.out.println(pageInfo);

		/*결과값 반환*/
		List<QnADTO> selectQuestion = questionService.selectQuestion(pageInfo,ownerNo);
		
		System.out.println("전체문의조회 : " + selectQuestion);

		request.setAttribute("selectQuestion", selectQuestion); //jsp에 값 반환
		
		/*1:1 문의로 이동*/
		String path="";
		path = "/WEB-INF/views/owner/notice/questionList.jsp";			
		request.setAttribute("selectQuestion", selectQuestion);
		request.setAttribute("pageInfo", pageInfo);
		
		request.getRequestDispatcher(path).forward(request, response);	
	}

}
