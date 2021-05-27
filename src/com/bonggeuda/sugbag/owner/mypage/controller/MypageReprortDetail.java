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
		System.out.println(reportDTO);
		
		// 거절 사유 보여주자 셀렉트 한번더 => 데이터 정상화 되면 풍어야댐
		//String rejectReason = selctReportDetailService.selectRejectReason(reportNo);
		//System.out.println("거절 사유는 ? " + rejectReason);
		
		// 이미지 경로 조회
		String imagePath = selctReportDetailService.selectImagePath(reportNo);
		System.out.println(imagePath);
		
		request.setAttribute("reportDTO",reportDTO );
		//request.setAttribute("rejectReason", rejectReason);
		request.setAttribute("imagePath", imagePath);
		
		
		String path = "";
		path = "/WEB-INF/views/owner/mypage/mypageReportDetail.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);

	}

}
