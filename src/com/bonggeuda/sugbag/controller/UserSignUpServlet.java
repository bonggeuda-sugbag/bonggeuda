package com.bonggeuda.sugbag.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.service.LoginService;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/usersignup/insert")
public class UserSignUpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/views/common/register.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("email");
		String memberPwd = request.getParameter("password");
		String nickname = request.getParameter("phone");
		String phone = request.getParameter("nickName");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setUserId(memberId);
		requestMember.setUserPwd(memberPwd);
		requestMember.setNickName(nickname);
		requestMember.setUserPhone(phone);
		
		System.out.println("memberController requestMember : " + requestMember);
		
		LoginService loginService = new LoginService();
		
		int result = 0;/* loginService.registMember(requestMember); */
		
		System.out.println("memberController result : " + result);
		
		String page = "";
		
		if(result > 0) {
			
			page = "/WEB-INF/views/guest/moreNotice/narasuccess.jsp";
			request.setAttribute("successCode", "insertMember");
			
		} else {
			page = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("failedCode", "failInsertUser");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	
	}

}
