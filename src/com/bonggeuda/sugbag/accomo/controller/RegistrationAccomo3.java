package com.bonggeuda.sugbag.accomo.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.accomo.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.accomo.model.service.AccomoService;

/**
 * Servlet implementation class RegistrationAccomo3
 */
@WebServlet("/registration3")
public class RegistrationAccomo3 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccomoDTO accomoDTO = new AccomoDTO();
		accomoDTO = (AccomoDTO) request.getAttribute("accomoDTO");
		
//		/*등록1단계*/
//		String accomoName = (String) request.getAttribute("accomoName");
//		String ceoName = (String) request.getAttribute("ceoName");
//		String accomoType = (String) request.getAttribute("accomoType");
//		String registNo = (String) request.getAttribute("registNo");
//		String address = (String) request.getAttribute("address");
//		String adrDetail = (String) request.getAttribute("adrDetail");
//		String email = (String) request.getAttribute("email");
//		String homepage = (String) request.getAttribute("homepage");
//		
//		/*등록2단계*/
//		//숙소이미지받아오기
//		String[] arrayFacility = request.getParameterValues("arrayFacility");
//		String facility = "";
//		String accomoPath = request.getParameter("accomoPath");
//		String near = request.getParameter("near");
//		String rule = request.getParameter("rule");
//		String parking = request.getParameter("parking");

		/*등록3단계*/
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut"); 
		java.sql.Date peakStart = java.sql.Date.valueOf(request.getParameter("peakStart")); 
		java.sql.Date peakEnd = java.sql.Date.valueOf(request.getParameter("peakEnd")); 
		
//		/*값 전달 확인용*/
//		System.out.println("accomoName");
//		System.out.println(ceoName);
//		System.out.println(accomoType);
//		System.out.println(registNo);
//		System.out.println(address);
//		System.out.println(adrDetail);
//		System.out.println(email);
//		System.out.println(homepage);
//		System.out.println(facility);
//		System.out.println(accomoPath);
//		System.out.println(near);
//		System.out.println(rule);
//		System.out.println(parking);
//		System.out.println(checkIn);
//		System.out.println(checkOut);
//		System.out.println(peakStart);
//		System.out.println(peakEnd);
		
		accomoDTO.setCheckIn(checkIn);
		accomoDTO.setCheckOut(checkOut);
		accomoDTO.setPeakStart(peakStart);
		accomoDTO.setPeakEnd(peakEnd);
		
		/*값을 전달하기 위한 비지니스 로직 호출*/
		AccomoService accomoService = new AccomoService();
		
		/*결과값 반환*/
		int insertAccomo = accomoService.InsertAccomoServlet(accomoDTO); //값을 int형으로 반환받아야 함
		
		String path="";

		path = "/WEB-INF/views/owner/registration/registration4.jsp";
		//request.setAttribute("accomoList", accomoList);

		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
