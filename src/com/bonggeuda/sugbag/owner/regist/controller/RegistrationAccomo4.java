package com.bonggeuda.sugbag.owner.regist.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.RoomDTO;
import com.bonggeuda.sugbag.owner.regist.service.RoomService;

/**
 * Servlet implementation class RegistrationAccomo4
 */
@WebServlet("/registration4")
public class RegistrationAccomo4 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 값을 한번에 담아서 넘길 리스트 생성 */
		ArrayList<RoomDTO> roomList = new ArrayList<RoomDTO>();
		
		/*객실추가 1*/
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
				
		roomList.add(roomDTO);
				
		/*객실추가 2*/
		if (!request.getParameter("roomName2").isEmpty()) { //값이 입력되면 저장
			
			String roomName2 = request.getParameter("roomName2");
			int roomMax2 = Integer.parseInt(request.getParameter("roomMax2"));
			//객실사진받아오기
			String roomIntro2 = request.getParameter("roomIntro2");
			int roomFee2 = Integer.parseInt(request.getParameter("roomFee2"));
			int peakFee2 = Integer.parseInt(request.getParameter("peakFee2"));
			
			RoomDTO roomDTO2 = new RoomDTO();
			
			roomDTO2.setRoomName(roomName2);
			roomDTO2.setRoomMax(roomMax2);
			roomDTO2.setRoomIntro(roomIntro2);
			roomDTO2.setRoomFee(roomFee2);
			roomDTO2.setPeakFee(peakFee2);
						
			roomList.add(roomDTO2);
		}
		
		/*객실추가 3*/
		if (!request.getParameter("roomName3").isEmpty()) {

			String roomName3 = request.getParameter("roomName3");
			int roomMax3 = Integer.parseInt(request.getParameter("roomMax3"));
			//객실사진받아오기
			String roomIntro3 = request.getParameter("roomIntro3");
			int roomFee3 = Integer.parseInt(request.getParameter("roomFee3"));
			int peakFee3 = Integer.parseInt(request.getParameter("peakFee3"));
			
			RoomDTO roomDTO3 = new RoomDTO();
			
			roomDTO3.setRoomName(roomName3);
			roomDTO3.setRoomMax(roomMax3);
			roomDTO3.setRoomIntro(roomIntro3);
			roomDTO3.setRoomFee(roomFee3);
			roomDTO3.setPeakFee(peakFee3);
						
			roomList.add(roomDTO3);
		}
		
		/*객실추가 4*/
		if (!request.getParameter("roomName4").isEmpty()) {

			String roomName4 = request.getParameter("roomName4");
			int roomMax4 = Integer.parseInt(request.getParameter("roomMax4"));
			//객실사진받아오기
			String roomIntro4 = request.getParameter("roomIntro4");
			int roomFee4 = Integer.parseInt(request.getParameter("roomFee4"));
			int peakFee4 = Integer.parseInt(request.getParameter("peakFee4"));

			RoomDTO roomDTO4 = new RoomDTO();
			
			roomDTO4.setRoomName(roomName4);
			roomDTO4.setRoomMax(roomMax4);
			roomDTO4.setRoomIntro(roomIntro4);
			roomDTO4.setRoomFee(roomFee4);
			roomDTO4.setPeakFee(peakFee4);
						
			roomList.add(roomDTO4);
		}
		
		/*객실추가 5*/
		if (!request.getParameter("roomName5").isEmpty()) {
	
			String roomName5 = request.getParameter("roomName5");
			int roomMax5 = Integer.parseInt(request.getParameter("roomMax5"));
			//객실사진받아오기
			String roomIntro5 = request.getParameter("roomIntro5");
			int roomFee5 = Integer.parseInt(request.getParameter("roomFee5"));
			int peakFee5 = Integer.parseInt(request.getParameter("peakFee5"));
						
			RoomDTO roomDTO5 = new RoomDTO();
			
			roomDTO5.setRoomName(roomName5);
			roomDTO5.setRoomMax(roomMax5);
			roomDTO5.setRoomIntro(roomIntro5);
			roomDTO5.setRoomFee(roomFee5);
			roomDTO5.setPeakFee(peakFee5);
						
			roomList.add(roomDTO5);
		}
		
		System.out.println("리스트 값 저장 확인 : " + roomList);
		
		/*값을 전달하기 위한 비지니스 로직 호출*/
		RoomService roomService = new RoomService();
		
		/*결과값 반환*/
		int insertRoom = roomService.InsertRoomServlet(roomList); //값을 int형으로 반환받아야 함
		
		/*메인페이지로 이동*/
		String path="";

		path = "/WEB-INF/views/owner/main/main.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}

}
