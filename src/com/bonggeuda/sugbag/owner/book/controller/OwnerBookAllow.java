package com.bonggeuda.sugbag.owner.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.owner.book.service.BookListSelectService;


/**
 * Servlet implementation class OwnerBookAllow
 */
@WebServlet("/owner/bookAllow")
public class OwnerBookAllow extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookNo = Integer.parseInt(request.getParameter("bookNo")); 
		System.out.println("승인할 예약 번호 " +bookNo);
		int bookAllow = 0;
		
		BookListSelectService bookAllowService = new BookListSelectService();

		bookAllow = bookAllowService.bookAllowUpdate(bookNo);
		
		
		if(bookAllow > 0) {
			System.out.println("예약 승인 됐습니다");
			
			String path = "";
			path = "/WEB-INF/views/owner/bookingList/allowSuccessPage.jsp";
			request.getAttribute(path);
			request.getRequestDispatcher(path).forward(request, response);
		}else {
			System.out.println("예약 승인이 되지 않습니다... ");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
