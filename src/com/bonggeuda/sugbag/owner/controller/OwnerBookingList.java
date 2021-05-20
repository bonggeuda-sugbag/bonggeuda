package com.bonggeuda.sugbag.owner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonnggeuda.sugbag.owner.service.BookListSelectService;

/**
 * Servlet implementation class OwnerBookingList
 */
@WebServlet("/owner/bookingList")
public class OwnerBookingList extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		 	int ownerNo = 1;
			/* 먼저 . 조회할 owner_no 을 가지고 BOOK_LIST DTO 에 담아서 값 전해주자. */
			BookDTO bookDTO = new BookDTO();
			
			List<BookDTO> bookList = new ArrayList<>();
			
			BookListSelectService bookService = new BookListSelectService();
			
			bookList = bookService.bookListSelect(ownerNo);
			
			
			
		
			request.setAttribute("bookList", bookList);
			
			String path = "";
			path = "/WEB-INF/views/owner/bookingList/bookingList.jsp";
			request.getAttribute(path);
			request.getRequestDispatcher(path).forward(request, response);
		
	}

	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 	int ownerNo = 1;
		/* 먼저 . 조회할 owner_no 을 가지고 BOOK_LIST DTO 에 담아서 값 전해주자. */
		BookDTO bookDTO = new BookDTO();
		
		List<BookDTO> bookList = new ArrayList<>();
		
		BookListSelectService bookService = new BookListSelectService();
		
		bookList = bookService.bookListSelect(ownerNo);
		
		
		
	
		request.setAttribute("bookList", bookList);
		
		String path = "";
		path = "/WEB-INF/views/owner/bookingList/bookingContent.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
