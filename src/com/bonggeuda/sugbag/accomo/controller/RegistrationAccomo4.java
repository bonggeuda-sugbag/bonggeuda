package com.bonggeuda.sugbag.accomo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationAccomo4
 */
@WebServlet("/registration4")
public class RegistrationAccomo4 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String roomName = request.getParameter("roomName");
		String roomMax = request.getParameter("roomMax");
		//객실사진받아오기
		String roonIntro = request.getParameter("roonIntro");
		String roomFee = request.getParameter("roomFee");
		String peakFee = request.getParameter("peakFee");
	
		System.out.println(roomName);
		System.out.println(roomMax);
		System.out.println(roonIntro);
		System.out.println(roomFee);
		System.out.println(peakFee);
		
		String path="";

		path = "/WEB-INF/views/owner/main/main.jsp";
		//request.setAttribute("accomoList", accomoList);

		request.getRequestDispatcher(path).forward(request, response);
	}

}
