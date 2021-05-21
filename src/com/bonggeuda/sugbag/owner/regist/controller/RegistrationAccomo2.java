package com.bonggeuda.sugbag.owner.regist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoDTO;

/**
 * Servlet implementation class RegistrationAccomo2
 */
@WebServlet("/registration2")
public class RegistrationAccomo2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*1단계에서 값 넘어오는지 확인*/
//		System.out.println(request.getParameter("accomoName"));
//		System.out.println(request.getParameter("ceoName"));
//		System.out.println(request.getParameter("accomoType"));
//		System.out.println(request.getParameter("registNo"));
//		System.out.println(request.getParameter("address"));
//		System.out.println(request.getParameter("adrDetail"));
//		System.out.println(request.getParameter("email"));
//		System.out.println(request.getParameter("homepage"));
		
		/*2단계 입력받기*/
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
		
		/*다시 DTO에 한번에 담아줌*/
		AccomoDTO accomoDTO = new AccomoDTO();
		
		accomoDTO.setAccomoName(request.getParameter("accomoName"));
		accomoDTO.setCeoName(request.getParameter("ceoName"));
		accomoDTO.setAccomoType(request.getParameter("accomoType"));
		accomoDTO.setRegistNo(request.getParameter("registNo"));
		accomoDTO.setAddress(request.getParameter("address"));
		accomoDTO.setAdrDetail(request.getParameter("adrDetail"));
		accomoDTO.setEmail(request.getParameter("email"));
		accomoDTO.setHomepage(request.getParameter("homepage"));
		accomoDTO.setFacility(facility);
		accomoDTO.setAccomoPath(accomoPath);
		accomoDTO.setNear(near);
		accomoDTO.setRule(rule);
		accomoDTO.setParking(parking);
		
		/*숙소등록3번 jsp로 값 넘기기*/
		request.setAttribute("accomoDTO", accomoDTO);
		
		String path="";

		path = "/WEB-INF/views/owner/registration/registration3.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}

}
