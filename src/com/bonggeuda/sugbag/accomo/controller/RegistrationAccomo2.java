package com.bonggeuda.sugbag.accomo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationAccomo2
 */
@WebServlet("/registration2")
public class RegistrationAccomo2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//숙소이미지받아오기
		String[] facility = request.getParameterValues("facility");
		String accomoPath = request.getParameter("accomoPath");
		String near = request.getParameter("near");
		String rule = request.getParameter("rule");
		String parking = request.getParameter("parking");
		
		for(int i=0; i<facility.length; i++) {
			
			System.out.println(facility[i]);
		}
		System.out.println(accomoPath);
		System.out.println(near);
		System.out.println(rule);
		System.out.println(parking);
		
		String path="";

		path = "/WEB-INF/views/owner/registration/registration3.jsp";
		//request.setAttribute("accomoList", accomoList);

		request.getRequestDispatcher(path).forward(request, response);
	}

}
