package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.RoomDTO;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/book/booking")
public class BookingServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("예약서블릿 호출");
		System.out.println("숙소이름 : " + request.getParameter("accomoName")); //완료
		System.out.println("숙소번호 : " + request.getParameter("accomoNo"));  //완료
		System.out.println("객실번호 : " + request.getParameter("roomNo"));    //완료
		System.out.println("객실이름 : " + request.getParameter("roomName"));  //완료
		System.out.println("가격 : " + request.getParameter("price"));         //완료
		System.out.println("최대인원 : " + request.getParameter("roomMax"));   //완료
		System.out.println("지정체크인시간 : " + request.getParameter("AccomoCheckIn")); //완료
		System.out.println("성수기요금 : " + request.getParameter("peakFee"));  // 완료
		
		System.out.println("체크인날짜 : " + request.getParameter("checkInDate"));
		System.out.println("체크아웃날짜 : " + request.getParameter("checkOutDate"));
		System.out.println("인원 : " + request.getParameter("people"));
		System.out.println("사용자체크인시간 : " + request.getParameter("checkInTime"));
		
		MemberDTO member = (MemberDTO)request.getSession().getAttribute("member");
		int userNo = member.getUserNo();
		//기존 숙소정보
		AccomoInfoDTO accomo = new AccomoInfoDTO();
		accomo.setAccomoNo(Integer.parseInt(request.getParameter("accomoNo")));
		accomo.setAccomoName(request.getParameter("accomoName"));
		accomo.setCheckIn(request.getParameter("AccomoCheckIn"));
		//기존 객실정보
		RoomDTO room = new RoomDTO();
		room.setRoomNo(Integer.parseInt(request.getParameter("roomNo")));
		room.setRoomName(request.getParameter("roomName"));
		room.setRoomFee(Integer.parseInt(request.getParameter("price")));
		room.setPeakFee(Integer.parseInt(request.getParameter("peakFee")));
		room.setRoomMax(Integer.parseInt(request.getParameter("roomMax")));
		room.setPeakFee(Integer.parseInt(request.getParameter("peakFee")));
		// 예약정보
		
		
		
		
		request.setAttribute("roomNo", request.getParameter("no"));
		
		
		request.getRequestDispatcher("/WEB-INF/views/guest/accomoInfo/payment.jsp").forward(request, response);;
	}

}
