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
import com.bonggeuda.sugbag.owner.book.service.BookListSelectService;

/**
 * Servlet implementation class OwnerBookingList
 */
@WebServlet("/owner/bookingList")
public class OwnerBookingList extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		 	int ownerNo = 1;
		 	int bookNo = 0;
			/* 2. 예약 넘버를 저장해서 setAttribute로 넘겨주자. */
			
			List<BookDTO> bookList = new ArrayList<>();
			
			BookListSelectService bookService = new BookListSelectService();
			
			bookList = bookService.bookListSelect(ownerNo);
			
			
			
			System.out.println(bookList);
			request.setAttribute("bookList", bookList);
			
			request.setAttribute("BookNO", bookList.get(1));
			// 북 넘버만 조회해서 int 로 받은 다음에 set arrti로 보내자!
			
			String path = "";
			path = "/WEB-INF/views/owner/bookingList/bookingList.jsp";
			request.getAttribute(path);
			request.getRequestDispatcher(path).forward(request, response);
		
	}

	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 1. BookNO 가져오기 */

		request.getAttribute("bookList");
		
		BookListSelectService bookService = new BookListSelectService();

//		bookNO = bookService.selectBookNo()
		
		

		
		String path = "";
		path = "/WEB-INF/views/owner/bookingList/bookingContent.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
