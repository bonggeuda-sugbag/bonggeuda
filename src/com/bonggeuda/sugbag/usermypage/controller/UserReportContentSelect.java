package com.bonggeuda.sugbag.usermypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.ReportDTO;
import com.bonggeuda.sugbag.service.UserMypageService;

/**
 * Servlet implementation class UserReportContentSelect
 */
@WebServlet("/userreportcontent/select")
public class UserReportContentSelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = 1;
		int reportedNo = Integer.parseInt(request.getParameter("reportedNo"));
		System.out.println(reportedNo);
		
		UserMypageService mypageService = new UserMypageService();
		
		ReportDTO userReportContent = mypageService.selectReportContent(userNo, reportedNo);
		
		String path = "/WEB-INF/views/guest/mypage/warningContents.jsp";
		request.setAttribute("userReportContent", userReportContent);
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

}
