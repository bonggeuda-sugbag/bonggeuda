package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccomoSelectServlet
 */
@WebServlet("/accomoSelect/list")
public class AccomoSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("accomoSelect서블릿 요청완료");
		
		String AccomoType = request.getParameter("value");
		System.out.println(AccomoType);
		
		String type="";
		
		switch(AccomoType) {
		    case "hotel" : type = "호텔"; break;
		    case "pension" : type = "펜션"; break;
		    case "guestHouse" : type = "게스트하우스"; break;
		}
		
		
		
	}

}
