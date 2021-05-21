package com.bonggeuda.sugbag.owner.regist.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.model.dto.SelectEnNoDTO;
import com.bonggeuda.sugbag.owner.regist.service.AccomoService;

/**
 * Servlet implementation class RegistrationAccomo3
 */
@WebServlet("/registration3")
public class RegistrationAccomo3 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*등록3단계*/
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut"); 
		java.sql.Date peakStart = java.sql.Date.valueOf(request.getParameter("peakStart")); 
		java.sql.Date peakEnd = java.sql.Date.valueOf(request.getParameter("peakEnd")); 
		
		/*다시 DTO에 한번에 담아줌*/
		AccomoDTO accomoDTO = new AccomoDTO();
		
		/*값을 전달하기 위한 비지니스 로직 호출*/
		AccomoService accomoService = new AccomoService();
		
		/*결과값 반환*/
		int selectEnNo = accomoService.selectEnNo();
		
		accomoDTO.setAccomoName(request.getParameter("accomoName"));
		accomoDTO.setCeoName(request.getParameter("ceoName"));
		accomoDTO.setAccomoType(request.getParameter("accomoType"));
		accomoDTO.setRegistNo(request.getParameter("registNo"));
		accomoDTO.setAddress(request.getParameter("address"));
		accomoDTO.setAdrDetail(request.getParameter("adrDetail"));
		accomoDTO.setEmail(request.getParameter("email"));
		accomoDTO.setHomepage(request.getParameter("homepage"));
		accomoDTO.setFacility(request.getParameter("facility"));
		accomoDTO.setAccomoPath(request.getParameter("accomoPath"));
		accomoDTO.setNear(request.getParameter("near"));
		accomoDTO.setRule(request.getParameter("rule"));
		accomoDTO.setParking(request.getParameter("parking"));
		accomoDTO.setCheckIn(checkIn);
		accomoDTO.setCheckOut(checkOut);
		accomoDTO.setPeakStart(peakStart);
		accomoDTO.setPeakEnd(peakEnd);
		accomoDTO.setOwnerNo(selectEnNo);
		accomoDTO.setEnAccomoNo(selectEnNo + 1); //현재 등록된 번호보다 1 증가한 값을 담아줌
		
		/*1,2,3단계 값 모두 받았는지 확인*/
		System.out.println(request.getParameter("accomoName"));
		System.out.println(request.getParameter("ceoName"));
		System.out.println(request.getParameter("accomoType"));
		System.out.println(request.getParameter("registNo"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("adrDetail"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("homepage"));
		System.out.println(request.getParameter("facility"));
		System.out.println(request.getParameter("accomoPath"));
		System.out.println(request.getParameter("near"));
		System.out.println(request.getParameter("rule"));
		System.out.println(request.getParameter("parking"));
		System.out.println(checkIn);
		System.out.println(checkOut);
		System.out.println(peakStart);
		System.out.println(peakEnd);
				
		int insertAccomo = accomoService.InsertAccomoServlet(accomoDTO); //값을 int형으로 반환받아야 함
		
		String path="";

		path = "/WEB-INF/views/owner/registration/registration4.jsp";

		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
