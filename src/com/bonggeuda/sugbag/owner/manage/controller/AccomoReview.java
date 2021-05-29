package com.bonggeuda.sugbag.owner.manage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccomoReview
 */
@WebServlet("/owner/accomoReview")
public class AccomoReview extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int accomoNo = Integer.parseInt(request.getParameter("accomoNo"));
		
		String path="";

		path = "/WEB-INF/views/guest/accomoInfo/review.jsp ";
		
		request.getRequestDispatcher(path).forward(request, response);
		

	}

}
