package com.bonggeuda.sugbag.usermypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.ReportDTO;
import com.bonggeuda.sugbag.service.UserMypageService;

/**
 * Servlet implementation class UserReportListSelect
 */
@WebServlet("/userreportlist/select")
public class UserReportListSelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = 1;
		
		UserMypageService mypageService = new UserMypageService();
		
		List<ReportDTO> userreportList = new ArrayList<>();
		userreportList = mypageService.selectReportList(userNo);
		

		
		String path = "/WEB-INF/views/guest/mypage/warningList.jsp";
		request.setAttribute("userreportList", userreportList);
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

}
