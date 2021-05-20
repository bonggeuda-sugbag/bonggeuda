package com.bonggeuda.sugbag.accomo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.accomo.model.dto.AccomoDTO;

/**
 * Servlet implementation class RegistrationAccomo2
 */
@WebServlet("/registration2")
public class RegistrationAccomo2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("2222" + request.getParameter("accomo1"));

//		String accomoName = request.getParameter("accomoName");
//		String ceoName = request.getParameter("ceoName");
//		String accomoType = request.getParameter("accomoType");
//		String registNo = request.getParameter("registNo");
//		String address = request.getParameter("address");
//		String adrDetail = request.getParameter("adrDetail");
//		String email = request.getParameter("email");
//		String homepage = request.getParameter("homepage");
		
		/*등록2단계*/
		//숙소이미지받아오기
		String[] arrayFacility = request.getParameterValues("arrayFacility");
		String facility = "";
		String accomoPath = request.getParameter("accomoPath");
		String near = request.getParameter("near");
		String rule = request.getParameter("rule");
		String parking = request.getParameter("parking");
		
		for(int i=0; i < arrayFacility.length; i++) {
			
			facility += arrayFacility[i];
			
			if(i < arrayFacility.length - 1) {
				facility += ", ";
			}
		}
		
		System.out.println(facility);
		System.out.println(accomoPath);
		System.out.println(near);
		System.out.println(rule);
		System.out.println(parking);
		
//		AccomoDTO accomoDTO = (AccomoDTO)(Object)request.getParameter("accomo1");
//
//		accomoDTO.setFacility(facility);
//		accomoDTO.setAccomoPath(accomoPath);
//		accomoDTO.setNear(near);
//		accomoDTO.setRule(rule);
//		accomoDTO.setParking(parking);
		
		String path="";

		path = "/WEB-INF/views/owner/registration/registration3.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}

}
