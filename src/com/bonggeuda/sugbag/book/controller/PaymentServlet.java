package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.service.BookService;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/book/payment")
public class PaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//key value 확인
		Map<String,String[]> requestMap = request.getParameterMap();
		Set<String> keySet = requestMap.keySet();
		Iterator<String> keyIter = keySet.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			String[] value = requestMap.get(key);
			
			System.out.println("key : " + key);
			for(int i = 0; i < value.length; i++) {
				System.out.println("value[" + i + "] : " +value[i]);
			}
		}
		
		//예약자번호
		MemberDTO member = (MemberDTO)request.getSession().getAttribute("member");
		int userNo = member.getUserNo();
		
		//예약정보
		BookDTO bookInfo = new BookDTO();
		bookInfo.setUserNo(userNo);
		bookInfo.setBookUserName(request.getParameter("bookName"));
		bookInfo.setBookPersonnel(Integer.parseInt(request.getParameter("personnel")));
		bookInfo.setBookCheckDate(request.getParameter("checkInDate"));
		bookInfo.setBookCheckoutDate(request.getParameter("checkOutDate"));
		bookInfo.setBookCheckIn(request.getParameter("checkInTime"));
		bookInfo.setUserPhone(request.getParameter("phone"));
		bookInfo.setRoomNo(Integer.parseInt(request.getParameter("roomNo")));
		bookInfo.setRequest(request.getParameter("request"));
		//예약정보INSERT
		BookService bsvc = new BookService();
		int result = bsvc.insertBookInfo(bookInfo);
		if(result > 0) {
			System.out.println("예약INSERT성공");
		} else {
			System.out.println("예약INSERT실패");
		}
		//결제정보
		String c = request.getParameter("paymentType"); //결제수단
		String d = request.getParameter("finalPrice"); //결제금액
		String k = request.getParameter("point");  //포인트
		
		

	}

}
