package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.OwnerQnADTO;

/**
 * Servlet implementation class AccomoQuestionServlet
 */
@WebServlet("/book/question")
public class AccomoQuestionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("ownerNo"));
        
        OwnerQnADTO qna = new OwnerQnADTO();
        MemberDTO member = (MemberDTO)request.getSession().getAttribute("member");
        
        qna.setOwnerNo(Integer.parseInt(request.getParameter("ownerNo")));
        qna.setTitle(request.getParameter("title"));
        qna.setContent(request.getParameter("content"));
        qna.setUserNo(member.getUserNo());
        qna.setWriteDate(new Date(System.currentTimeMillis()));
        
        
        
        
	}

}
