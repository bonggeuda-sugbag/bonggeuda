package com.bonnggeuda.sugbag.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonnggeuda.sugbag.user.dto.UserInfoDTO;
import com.bonnggeuda.sugbag.user.service.UserInfoService;

@WebServlet("/user/detail")
public class UserSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserInfoService userInfoService = new UserInfoService();
		
		UserInfoDTO userInfo = userInfoService.selectDetail(request.getParameter("userNo"));
		
		System.out.println(userInfo);
		
		String path = "";
		
		if(userInfo != null) {
			path = "/WEB-INF/views/admin/user/userInfoDetail.jsp";
			request.setAttribute("userInfo", userInfo);
		} 
		

		request.getRequestDispatcher(path).forward(request, response);
	}

}
