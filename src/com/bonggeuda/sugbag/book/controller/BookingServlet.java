package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.RoomDTO;
import com.bonggeuda.sugbag.service.BookService;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/book/booking")
public class BookingServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//회원번호
		MemberDTO member = (MemberDTO)request.getSession().getAttribute("member");
		int userNo = member.getUserNo();
		
		//기존 숙소정보
		AccomoInfoDTO accomoInfo = new AccomoInfoDTO();
		accomoInfo.setAccomoNo(Integer.parseInt(request.getParameter("accomoNo")));
		accomoInfo.setAccomoName(request.getParameter("accomoName"));
		accomoInfo.setCheckIn(request.getParameter("AccomoCheckIn"));
		
		//기존 객실정보
		RoomDTO roomInfo = new RoomDTO();
		roomInfo.setRoomNo(Integer.parseInt(request.getParameter("roomNo")));
		roomInfo.setRoomName(request.getParameter("roomName"));
		roomInfo.setRoomFee(Integer.parseInt(request.getParameter("price")));
		roomInfo.setPeakFee(Integer.parseInt(request.getParameter("peakFee")));
		roomInfo.setRoomMax(Integer.parseInt(request.getParameter("roomMax")));
		roomInfo.setPeakFee(Integer.parseInt(request.getParameter("peakFee")));
		// 예약정보
		BookDTO bookInfo = new BookDTO();
		bookInfo.setUserNo(userNo);
		bookInfo.setBookPersonnel(Integer.parseInt(request.getParameter("people")));
		bookInfo.setBookCheckDate(request.getParameter("checkInDate"));
		bookInfo.setBookCheckoutDate(request.getParameter("checkOutDate"));
		bookInfo.setBookCheckIn(request.getParameter("checkInTime"));
		Date checkOut = java.sql.Date.valueOf(request.getParameter("checkOutDate"));
		Date checkIn = java.sql.Date.valueOf(request.getParameter("checkInDate"));
		int bookDay = checkOut.getDate() - checkIn.getDate();
		int totalPrice = roomInfo.getRoomFee() * bookDay;
		bookInfo.setDay(checkOut.getDate() - checkIn.getDate());
		
		//쿠폰과 포인트를 가져와야 한다.
//		System.out.println(accomoInfo);
//		System.out.println(roomInfo);
//		System.out.println(bookInfo);
		
		List couponPoint = new BookService().selectCouponPoint(userNo);

		request.setAttribute("accomoInfo", accomoInfo);
		request.setAttribute("roomInfo", roomInfo);
		request.setAttribute("bookInfo", bookInfo);
		request.setAttribute("totalPrice", totalPrice);
		request.getRequestDispatcher("/WEB-INF/views/guest/accomoInfo/payment.jsp").forward(request, response);;
	}

}
