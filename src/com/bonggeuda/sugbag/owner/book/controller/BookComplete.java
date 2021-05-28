package com.bonggeuda.sugbag.owner.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.owner.book.service.BookListSelectService;

/**
 * Servlet implementation class BookComplete
 */
@WebServlet("/owner/bookComplete")
public class BookComplete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * 예약 확정후 결제 이력 인서트 및 예약 이력 인서트
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		/* 1. book history에 인서트*/
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		
		BookListSelectService bookService = new BookListSelectService();
		
		//bookNo = bookService.insertBookHistory(bookNo);
		// 예약 승인/거절 시 북 히스토리에 업데이트 댐
		
		/* 2.sales history 인서트 */
		int accomoNo = Integer.parseInt(request.getParameter("accomoNo"));
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		int paymentFee = Integer.parseInt(request.getParameter("paymentFee"));
		int paymentNo = Integer.parseInt(request.getParameter("paymentNo"));
		
		int result = bookService.insertSalesHistory(accomoNo,roomNo,paymentFee,paymentNo);
		
		/* */
		
		/* 3. 지난 예약목록 리스트로 이동 */
		if(result > 0) {
			
			String path="";
			path = "/WEB-INF/views/owner/bookingList/bookingPast.jsp";
			request.getRequestDispatcher(path).forward(request, response);	
		}else {
			String path="";
			path = "/WEB-INF/views/owner/mypage/mypage.jsp";
			request.getRequestDispatcher(path).forward(request, response);	
		}
	}

}
