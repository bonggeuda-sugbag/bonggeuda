package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.ReviewDTO;
import com.bonggeuda.sugbag.service.BookService;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/accomoSelect/review")
public class ReviewSelectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bsvc = new BookService();
		//1. 베스트 리뷰 조회
		int accomoNo = Integer.parseInt(request.getParameter("no"));
		Map<Integer,ReviewDTO> bestReview =  bsvc.selectBestReview(accomoNo);
		
		//2. 리뷰의 UP, DOWN을 COUNT 한 값 가져오기
		List<Map<Integer,Integer>> upDownCnt = bsvc.selectUpDownCnt(accomoNo);
		System.out.println(upDownCnt);
		String path = "/WEB-INF/views/guest/accomoInfo/book.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
