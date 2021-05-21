package com.bonggeuda.sugbag.owner.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.BookingContentDTO;
import com.bonggeuda.sugbag.owner.book.service.BookListSelectService;

/**
 * Servlet implementation class OwnerBookingPastList
 */
@WebServlet("/owner/bookingPastList")
public class OwnerBookingPastList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 	int ownerNo = 1;
	 	
		/* 2. 예약 넘버를 저장해서 setAttribute로 넘겨주자. */
		
		List<BookDTO> bookList = new ArrayList<>();
		
		BookListSelectService bookService = new BookListSelectService();
		
		bookList = bookService.bookPastListSelect(ownerNo);
		
		
		
		request.setAttribute("bookList", bookList);
		

		String path = "";
		path = "/WEB-INF/views/owner/bookingList/bookingPast.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 1. BookNO 가져오기 */
		int bookNo = Integer.parseInt(request.getParameter("bookNo")); 
		
		BookingContentDTO bookContentDTO = new BookingContentDTO();
		
		BookListSelectService bookService = new BookListSelectService();

		
		bookContentDTO = bookService.selectBookContent(bookNo);
		

		request.setAttribute("bookContentDTO", bookContentDTO );
		String path = "";
		path = "/WEB-INF/views/owner/bookingList/bookingPastContent.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
