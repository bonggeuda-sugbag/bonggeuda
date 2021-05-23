package com.bonggeuda.sugbag.owner.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.owner.mypage.service.OwnerMypagService;

/**
 * Servlet implementation class OwnerWithdraw
 */
@WebServlet("/owner/ownerWithdraw")
public class OwnerWithdraw extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	
	
	/**
	 * 탈퇴 후 로그인 페이지로 이동
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 오너 인포 페이지 업데이트 및 로그인 페이지로 이동
		int ownerNo = Integer.parseInt(request.getParameter("ownerNo"));
		// 오너넘 가저오기
		
		
		int ownerWithdrawUpdate = 0;
		
		OwnerMypagService ownerMypageService = new OwnerMypagService();
		ownerWithdrawUpdate = ownerMypageService.ownerWithdrawUpdateService(ownerNo);
		
		
		
		
		String path = "";
		path = "/WEB-INF/views/owner/login/login.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}

}
