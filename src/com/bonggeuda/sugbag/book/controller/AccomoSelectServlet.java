package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.service.BookService;

/**
 * Servlet implementation class AccomoSelectServlet
 */
@WebServlet("/accomoSelect/list")
public class AccomoSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿요청확인");
		String AccomoType = request.getParameter("value");
		
		String type="";
		
		switch(AccomoType) {
		    case "'hotel'" : type = "호텔"; break;
		    case "'pension'" : type = "펜션"; break;
		    case "'guestHouse'" : type = "게스트하우스"; break;
		}
		BookService booksvc = new BookService();
		List<AccomoInfoDTO> accomoList= booksvc.selectAccomoList(type);
		
		String path="";
		if(accomoList != null) {
			path = "/WEB-INF/views/guest/accomoInfo/list.jsp";
			request.setAttribute("accomoList", accomoList);
		} else {
			System.out.println("실패!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
