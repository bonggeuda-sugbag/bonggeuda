package com.bonggeuda.sugbag.accomo.controller;

import java.io.IOException;
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

		request.getAttribute("accomoName");
		System.out.println(request.getAttribute("accomoName"));

		Object accomoInfo = request.getAttribute("accomoDTO");
		
		AccomoDTO accomoDTO = new AccomoDTO();
		
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

//		accomoDTO.setFacility(facility);
//		accomoDTO.setAccomoPath(accomoPath);
//		accomoDTO.setNear(near);
//		accomoDTO.setRule(rule);
//		accomoDTO.setParking(parking);
		

		
		String path="";

		path = "/WEB-INF/views/owner/registration/registration3.jsp";
		//request.setAttribute("accomoList", accomoList);

		request.getRequestDispatcher(path).forward(request, response);
	}

}
