package com.bonggeuda.sugbag.usermypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.service.UserMypageService;

/**
 * Servlet implementation class UserNickNameSelect
 */
@WebServlet("/usernickname/select")
public class UserNickNameSelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inputNickName = request.getParameter("intputNickname");
		System.out.println(inputNickName);
		
		UserMypageService mypageService = new UserMypageService();
		
		int userNickname = mypageService.selectUserNickName(inputNickName);
		
		System.out.println(userNickname);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(userNickname);
		
		out.flush();
		out.close();
		
//		
//		String path = "/WEB-INF/views/guest/mypage/myInformation.jsp";
//		request.setAttribute("userNickname", userNickname);
//		
//		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
