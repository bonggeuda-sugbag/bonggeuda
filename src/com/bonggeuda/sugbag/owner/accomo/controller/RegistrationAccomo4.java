package com.bonggeuda.sugbag.owner.accomo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.model.dto.RoomDTO;
import com.bonggeuda.sugbag.owner.accomo.service.AccomoService;
import com.bonggeuda.sugbag.owner.room.service.RoomService;

/**
 * Servlet implementation class RegistrationAccomo4
 */
@WebServlet("/registration4")
public class RegistrationAccomo4 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String roomName = request.getParameter("roomName");
		int roomMax = Integer.parseInt(request.getParameter("roomMax"));
		//객실사진받아오기
		String roomIntro = request.getParameter("roomIntro");
		int roomFee = Integer.parseInt(request.getParameter("roomFee"));
		int peakFee = Integer.parseInt(request.getParameter("peakFee"));
	
		/*전달받은 값을 넣어줄 객체 선언*/
		RoomDTO roomDTO = new RoomDTO();
		
		roomDTO.setRoomName(roomName);
		roomDTO.setRoomMax(roomMax);
		roomDTO.setRoomIntro(roomIntro);
		roomDTO.setRoomFee(roomFee);
		roomDTO.setPeakFee(peakFee);
		
		/*전달받았는지 확인*/
		System.out.println(roomName);
		System.out.println(roomMax);
		System.out.println(roomIntro);
		System.out.println(roomFee);
		System.out.println(peakFee);
		
		/*값을 전달하기 위한 비지니스 로직 호출*/
		RoomService roomService = new RoomService();
		
		/*결과값 반환*/
		int insertRoom = roomService.InsertRoomServlet(roomDTO); //값을 int형으로 반환받아야 함
		
		/*메인페이지로 이동*/
		String path="";

		path = "/WEB-INF/views/owner/main/main.jsp";
		//request.setAttribute("accomoList", accomoList);

		request.getRequestDispatcher(path).forward(request, response);
	}

}
