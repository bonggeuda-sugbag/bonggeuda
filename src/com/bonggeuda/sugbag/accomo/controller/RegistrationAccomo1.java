package com.bonggeuda.sugbag.accomo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationAccomo
 */
@WebServlet("/registration1")
public class RegistrationAccomo1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accomoName = request.getParameter("accomoName");
		String ceoName = request.getParameter("ceoName");
		String accomoType = request.getParameter("accomoType");
		String registNo = request.getParameter("registNo");
		String address = request.getParameter("address");
		String adrDetail = request.getParameter("adrDetail");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		
		System.out.println("accomoName : " + accomoName);
		System.out.println("ceoName : " + ceoName);
		System.out.println("accomoType : " + accomoType);
		System.out.println("registNo : " + registNo);
		System.out.println("address : " + address);
		System.out.println("adrDetail : " + adrDetail);
		System.out.println("email : " + email);
		System.out.println("homepage : " + homepage);
		
		String path="";

		path = "/WEB-INF/views/owner/registration/registration2.jsp";
		//request.setAttribute("accomoList", accomoList);

		request.getRequestDispatcher(path).forward(request, response);
	}

}
