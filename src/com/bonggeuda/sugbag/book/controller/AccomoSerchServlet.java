package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.AccomoSearchDTO;
import com.bonggeuda.sugbag.service.BookService;

/**
 * Servlet implementation class AccomoSerchServlet
 */
@WebServlet("/accomoSelect/search")
public class AccomoSerchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//숙소타입
		String type = request.getParameter("type");
		//검색할 편의시설
		String[] checkList = request.getParameterValues("checkList[]");
		//사진카테고리
		int category = 3;
		//인원수
		String personnal = request.getParameter("personnal");
		
		AccomoSearchDTO search = new AccomoSearchDTO();
		search.setType(request.getParameter("type"));
		search.setFacility(request.getParameterValues("checkList[]"));
		search.setCategory(3);
		if(request.getParameter("personnal").length() > 0) {
			search.setPersonnal(Integer.parseInt(request.getParameter("personnal")));
		}
		//조건에 일치하는 숙소리스트 검색
		BookService booksvc = new BookService();
		List<AccomoInfoDTO> accomoList = booksvc.selectAccomoFacility(search);
	
		
       
		
	}
}
