package com.bonggeuda.sugbag.owner.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.ReportDTO;
import com.bonggeuda.sugbag.owner.mypage.service.OwnerMypagService;

/**
 * Servlet implementation class MypageReportDetail
 */
@WebServlet("/owner/mypgeReport")
public class MypageReportList extends HttpServlet {

	/**
	 * 업주번호 (로그인된 )에 따른 신고내역 테이블 조회하기
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ownerNo = 1;
		/* 조회해온거 리스트에 담고 테이블로 뿌려주자 */
		
		
		List<ReportDTO> reportList = new ArrayList<>();
		
		OwnerMypagService reportListService = new OwnerMypagService();
		
		reportList = reportListService.seletReportList(ownerNo);
		
		
		request.setAttribute("reportList", reportList);
		
		String path = "";
		path = "/WEB-INF/views/owner/mypage/mypageReportList.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
