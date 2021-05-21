package com.bonggeuda.sugbag.owner.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.owner.book.service.BookListSelectService;

/**
 * Servlet implementation class OwnerBookReject
 */
@WebServlet("/owner/bookReject")
public class OwnerBookReject extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookListSelectService bookRejectService = new BookListSelectService();
		int bookNo = Integer.parseInt(request.getParameter("bookNo")); 
		String rejecetReason = request.getParameter("rejectReson");/* 거절 사유 */
		System.out.println("거절 사유" + rejecetReason);
		System.out.println("거절할 예약 번호 " +bookNo); // 예약 거절로 업데이트
		
		int bookReject = 0;
		bookReject = bookRejectService.bookRejectUpdate(bookNo); 
		

		if(bookReject > 0) {
			int bookRejectHistory = 0;
			bookRejectHistory = bookRejectService.bookRejectHistoryInsert(bookNo,rejecetReason);
		
			String path = "";
			path = "bookingList";
			request.getAttribute(path);
			request.getRequestDispatcher(path).forward(request, response);
		
		}
		
		
		
		
	}
	
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
