package com.bonggeuda.sugbag.owner.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.QnADTO;
import com.bonggeuda.sugbag.owner.notice.service.QuestionService;

/**
 * Servlet implementation class Question
 */
@WebServlet("/owner/question/list")
public class QuestionList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuestionService questionService = new QuestionService();

		/*결과값 반환*/
		List<QnADTO> selectQuestion = questionService.selectQuestion();
		
		request.setAttribute("selectQuestion", selectQuestion); //jsp에 값 반환
		
		/*1:1 문의로 이동*/
		String path="";
		path = "/WEB-INF/views/owner/notice/questionList.jsp";
		request.getRequestDispatcher(path).forward(request, response);	
	}

}
