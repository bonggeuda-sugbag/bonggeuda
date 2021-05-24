package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.CouponDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.PointDTO;
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
		
		List couponPoint = new BookService().selectCouponPoint(userNo);
		
		PointDTO point = null;
		List<CouponDTO> couponList = new ArrayList<>();

		for(int i = 0; i < couponPoint.size(); i++) {
			
			if(couponPoint.get(i) != null) {
				if(couponPoint.get(i) instanceof PointDTO)  {
					point = (PointDTO) couponPoint.get(i);
				} else if(couponPoint.get(i) instanceof CouponDTO) {
					CouponDTO coupon = (CouponDTO) couponPoint.get(i);
					Date today = new java.sql.Date(System.currentTimeMillis());
					int condition = Integer.parseInt(coupon.getCouponCondition());

					//1. 쿠폰시작일 <= 오늘날짜 <= 쿠폰종료일, 2.사용조건금액 <= 전체금액
					if(today.getDate()-coupon.getCouponStart().getDate() >= 0 && today.getDate()-coupon.getCouponEnd().getDate() <= 0 && condition <= totalPrice) {
						couponList.add(coupon);
					}
				}
			}
		}
		String path = "";
//		point.setPoint(0);
		if(accomoInfo != null && roomInfo != null && bookInfo != null) {
			
			path = "/WEB-INF/views/guest/accomoInfo/payment.jsp";
			request.setAttribute("accomoInfo", accomoInfo);
			request.setAttribute("roomInfo", roomInfo);
			request.setAttribute("bookInfo", bookInfo);
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("couponList", couponList);
			request.setAttribute("point", point);
		} else {
			System.out.println("에러페이지 갈 예정");
		}
		request.getRequestDispatcher(path).forward(request, response);;
	}

}
