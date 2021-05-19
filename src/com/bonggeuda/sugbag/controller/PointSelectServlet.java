package com.bonggeuda.sugbag.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.PointDTO;
import com.bonggeuda.sugbag.model.dto.PointHistoryDTO;
import com.bonggeuda.sugbag.service.MypageService;

/**
 * Servlet implementation class PointSelectServlet
 */
@WebServlet("/point/select")
public class PointSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = 1;
		MypageService mypageService = new MypageService();
		
		/* 포인트 정보 조회 */		
		PointDTO pointDTO = mypageService.pointSelect(userNo);
		int point = pointDTO.getPoint();

		
		/* 포인트이력 정보 조회 */
		List<PointHistoryDTO> pointHistory = new ArrayList<>();
		pointHistory = mypageService.pointHistorySelect(userNo);
		
		
		
		
		
		String path = "";
		
		if(pointHistory != null && pointDTO != null) {
			path = "/WEB-INF/views/guest/mypage/point.jsp";
			request.setAttribute("point", point);
			request.setAttribute("pointHistory", pointHistory);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
