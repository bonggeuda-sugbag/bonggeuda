package com.bonggeuda.sugbag.owner.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.ReportDTO;
import com.bonggeuda.sugbag.owner.mypage.service.OwnerMypagService;

/**
 * Servlet implementation class MypageReprortDetail
 */
@WebServlet("/owner/reportDetail")
public class MypageReprortDetail extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//DTO에 담자~
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		System.out.println(reportNo);
		OwnerMypagService selctReportDetailService = new OwnerMypagService();
		
		ReportDTO reportDTO  = new ReportDTO();
		
		reportDTO = selctReportDetailService.selectReportDetail(reportNo);
		
		// 거절 사유 보여주자 셀렉트 한번더
		String rejectReason = selctReportDetailService.selectRejectReason(reportNo);
		System.out.println("거절 사유는 ? " + rejectReason);
		
		request.setAttribute("reportDTO",reportDTO );
		request.setAttribute("rejectReason", rejectReason);
		
		
		String path = "";
		path = "/WEB-INF/views/owner/mypage/mypageReportDetail.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);

	}

}
