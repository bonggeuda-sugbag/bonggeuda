package com.bonggeuda.sugbag.usermypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.service.UserMypageService;

/**
 * Servlet implementation class UserBookListSelect
 */
@WebServlet("/userbooklist/select")
public class UserBookListSelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = 1;
		
		UserMypageService mypageService = new UserMypageService();
		
		List<BookDTO> booklist = new ArrayList<>();
		
		booklist = mypageService.selectUserBookList(userNo);
		
		String path = "/WEB-INF/views/guest/mypage/reservation.jsp";
		request.setAttribute("booklist", booklist);
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
