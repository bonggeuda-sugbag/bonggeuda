package com.bonggeuda.sugbag.usermoreinfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.NoticeDTO;
import com.bonggeuda.sugbag.service.UserMoreInfoService;

/**
 * Servlet implementation class UserNoticeSelect
 */
@WebServlet("/usernotice/select")
public class UserNoticeSelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserMoreInfoService moreinfoService = new UserMoreInfoService();
		
		List<NoticeDTO> notice = new ArrayList<>();
		notice = moreinfoService.selectNotice();
		
		
		
		String path = "/WEB-INF/views/guest/moreNotice/moreNotice.jsp";
		request.setAttribute("notice", notice);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
