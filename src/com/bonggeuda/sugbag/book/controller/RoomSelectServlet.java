package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;

/**
 * Servlet implementation class RoomSelectServlet
 */
@WebServlet("/accomoSelect/room")
public class RoomSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getParameter("accomoInfo"));


		request.getRequestDispatcher("/WEB-INF/views/guest/accomoInfo/book.jsp").forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("두번쨰 서블릿 포스트 호출");
		
		
	}

}
