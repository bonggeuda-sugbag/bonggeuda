package com.bonggeuda.sugbag.usermoreinfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.EventDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.service.UserMoreInfoService;

/**
 * Servlet implementation class UserEventSelect
 */
@WebServlet("/userevent/select")
public class UserEventSelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = ((MemberDTO)request.getSession().getAttribute("member")).getUserNo();
		
		UserMoreInfoService moreinfoService = new UserMoreInfoService();
		
		List<EventDTO> userevent = new ArrayList<>();
		userevent = moreinfoService.selectEvent();
		
		String path = "/WEB-INF/views/guest/moreNotice/event.jsp";
		request.setAttribute("userevent", userevent);
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

}
