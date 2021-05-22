package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/book/payment")
public class PaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("bookName"); //예약자이름
		String b = request.getParameter("phone"); //예약자전화번호
		String c = request.getParameter("paymentType"); //결제수단
		String d = request.getParameter("finalPrice"); //결제금액
		String e = request.getParameter("roomNo"); //결제금액
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		
	}

}
