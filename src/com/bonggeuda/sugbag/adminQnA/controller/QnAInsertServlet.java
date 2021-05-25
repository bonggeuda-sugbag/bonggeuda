package com.bonggeuda.sugbag.adminQnA.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.adminQnA.dto.QnADTO;
import com.bonggeuda.sugbag.adminQnA.service.AdminQnAService;


/**
 * Servlet implementation class QnAInsertServlet
 */
@WebServlet("/qna/insert")
public class QnAInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminQnAService qnaInfoService = new AdminQnAService();
		QnADTO dto = new QnADTO();
		
		String content = request.getParameter("content");
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));

//		int condition = Integer.parseInt(request.getParameter("condition")); //상태여부 얼먀넘어면 사용가능
      
		dto.setContent(content);
		dto.setQnaNo(qnaNo);
		dto.setWriteDate(new Date(System.currentTimeMillis()));

		int insertQna= qnaInfoService.insertQna(dto);
		System.out.println("dto안에 값이 있나? : " + dto);
		String path="";
		if(insertQna > 0 ) {
			path= "/bonggeuda/qna/list";
			response.sendRedirect(path);
		} 
	}

}
