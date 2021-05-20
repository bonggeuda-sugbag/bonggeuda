package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.RoomDTO;
import com.bonggeuda.sugbag.service.BookService;

/**
 * Servlet implementation class RoomSelectServlet
 */
@WebServlet("/accomoSelect/room")
public class RoomSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("왜 여기로 또 들어오지?");
		int accomoNo = Integer.parseInt(request.getParameter("no"));
		//숙소정보, 사진조회
		BookService booksvc = new BookService();
		int categoryType = 3;
		AccomoInfoDTO accomo = booksvc.selectAccomoInfo(accomoNo, categoryType);

		//객실정보 조회
		categoryType = 4;
		List<RoomDTO> roomList = booksvc.selectRoomList(accomoNo,categoryType);
		String path ="";
		if(accomo != null && roomList!=null) {
			path = "/WEB-INF/views/guest/accomoInfo/book.jsp";
			request.setAttribute("accomo", accomo);
			request.setAttribute("roomList", roomList);
		} else {
			System.out.println("숙소상세보기실패~^^");
		}
		
		request.getRequestDispatcher(path).forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
