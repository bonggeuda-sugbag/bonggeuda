package com.bonggeuda.sugbag.usermypage.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.service.UserMypageService;

/**
 * Servlet implementation class UserWithdrawUpdate
 */
@WebServlet("/userwithdraw/update")
public class UserWithdrawUpdate extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = 1;
		
		request.setCharacterEncoding("UTF-8");
		
		UserMypageService mypageService = new UserMypageService();
		MemberDTO userWithdraw = new MemberDTO();
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		userWithdraw.setWithDrawDate(date);
		userWithdraw.setUserNo(userNo);
		
		int result = mypageService.userWithdraw(userWithdraw);
		
		System.out.println(result);
		
		if(result > 0) {
			
			request.getSession().invalidate();
			
			response.sendRedirect(request.getContextPath());
			
		}
	}

}
