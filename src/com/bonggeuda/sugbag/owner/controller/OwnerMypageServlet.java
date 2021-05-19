package com.bonggeuda.sugbag.owner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonnggeuda.sugbag.owner.dto.OwnerInfoDTO;

/**
 * Servlet implementation class OwnerMypage
 */
@WebServlet("/owner/mypage")
public class OwnerMypageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OwnerInfoDTO onwnerInfo = new OwnerInfoDTO();
		
		
		
		String path = "/WEB-INF/views/owner/mypage/mypage.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);

	}

}
