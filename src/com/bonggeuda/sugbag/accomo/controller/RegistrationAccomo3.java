package com.bonggeuda.sugbag.accomo.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationAccomo3
 */
@WebServlet("/registration3")
public class RegistrationAccomo3 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut"); 
		String peakStart = request.getParameter("peakStart"); 
		String peakEnd = request.getParameter("peakEnd"); 
		
		System.out.println(checkIn);
		System.out.println(checkOut);
		System.out.println(peakStart);
		System.out.println(peakEnd);
		
		String path="";

		path = "/WEB-INF/views/owner/registration/registration4.jsp";
		//request.setAttribute("accomoList", accomoList);

		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
