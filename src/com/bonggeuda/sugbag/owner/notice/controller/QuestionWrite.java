package com.bonggeuda.sugbag.owner.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Question
 */
@WebServlet("/owner/question/write")
public class QuestionWrite extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*1:1 문의로 이동*/
		String path="";
		path = "/WEB-INF/views/owner/notice/questionWrite.jsp";
		request.getRequestDispatcher(path).forward(request, response);	
	}

}
