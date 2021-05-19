package com.bonggeuda.sugbag.owner.controller;

import java.io.IOException;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonnggeuda.sugbag.owner.dto.OwnerInfoDTO;
import com.bonnggeuda.sugbag.owner.service.OwnerMypagService;

/**
 * Servlet implementation class OwnerMypage
 */
@WebServlet("/owner/mypage")
public class OwnerMypageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ownerNo = 2;
		// 로그인 됐다 친 업주 정보
		OwnerMypagService ownerMypageService = new OwnerMypagService();
		
		OwnerInfoDTO selectOwner = ownerMypageService.selectOwnerInfo(ownerNo);
		
		
		System.out.println("컨트롤러 " + selectOwner);
		/* 비지니스 로직 실행 결과에 따른 로직*/
		String path = "";
		if(selectOwner != null) {

			request.setAttribute("selectOwner",selectOwner);
			path = "/WEB-INF/views/owner/mypage/mypage.jsp";
		}
		
		
		
		
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
//		String path = "/WEB-INF/views/owner/mypage/mypage.jsp";
//		
//		request.getRequestDispatcher(path).forward(request, response);

	}

}
