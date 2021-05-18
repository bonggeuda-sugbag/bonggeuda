package com.bonggeuda.sugbag.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.PointDTO;
import com.bonggeuda.sugbag.service.MypageService;

/**
 * Servlet implementation class PointSelectServlet
 */
@WebServlet("/point/select")
public class PointSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("서블릿요청 !");
		
		int userNo = 1;
		
		MypageService mypageService = new MypageService();
		
		PointDTO pointDTO = mypageService.pointSelect(userNo);
		
		String path = "";
		if(pointDTO != null) {
			path = "/WEB-INF/views/guest/mypage/point.jsp";
			request.setAttribute("point", pointDTO);
		}
		
		int point = pointDTO.getPoint();
		
		System.out.println(point);
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
