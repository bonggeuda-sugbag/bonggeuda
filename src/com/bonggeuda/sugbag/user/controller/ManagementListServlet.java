package com.bonggeuda.sugbag.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.common.paging.PageNation;
import com.bonggeuda.sugbag.model.dto.PageInfoDTO;
import com.bonggeuda.sugbag.user.dto.UserInfoDTO;
import com.bonggeuda.sugbag.user.service.UserInfoService;

/**
 * 사용자 관리 리스트 불러오는 서블릿
 * Servlet implementation class UserSelectListServlet
 */
@WebServlet("/user/list")
public class ManagementListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		UserInfoService userInfoServie = new UserInfoService();
		int totalCount = userInfoServie.selectTotalCount();
		
//		System.out.println("totalCount 체크 : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;
		/* 한 번에 보여질 페이징 버튼의 수*/
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		PageInfoDTO pageInfo = PageNation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
//		System.out.println(pageInfo);
		
		/* 조회 해온다. */
		List<UserInfoDTO> userList = userInfoServie.selectBoardList(pageInfo);
		
		System.out.println("userList : " + userList);
		
		String path = "";
		if(userList != null) {
			path = "/WEB-INF/views/admin/user/userInfo.jsp";
			request.setAttribute("userList", userList);
			request.setAttribute("pageInfo", pageInfo);
		} 
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
