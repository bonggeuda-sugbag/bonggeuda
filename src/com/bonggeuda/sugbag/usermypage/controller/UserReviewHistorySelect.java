package com.bonggeuda.sugbag.usermypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.ReviewDTO;
import com.bonggeuda.sugbag.service.UserMypageService;

/**
 * Servlet implementation class UserReviewHistorySelect
 */
@WebServlet("/userreviewhistory/select")
public class UserReviewHistorySelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = ((MemberDTO)request.getSession().getAttribute("member")).getUserNo();
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		
		UserMypageService mypageService = new UserMypageService();
		
		ReviewDTO reviewHistory = mypageService.selectReviewHistory(userNo, bookNo);
		
		String path = "/WEB-INF/views/guest/mypage/usagehistory.jsp";
		request.setAttribute("reviewHistory", reviewHistory);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
