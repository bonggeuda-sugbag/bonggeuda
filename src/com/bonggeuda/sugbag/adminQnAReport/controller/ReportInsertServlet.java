package com.bonggeuda.sugbag.adminQnAReport.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.bonggeuda.sugbag.adminQnAReport.dto.ReportHistoryDTO;
import com.bonggeuda.sugbag.adminQnAReport.service.AdminReportService;

/**
 * Servlet implementation class ReportInsertServlet
 */
@WebServlet("/report/insert")
public class ReportInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminReportService reportInfoService = new AdminReportService();
		ReportHistoryDTO dto = new ReportHistoryDTO();
		
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		String content = request.getParameter("content");
		String status = request.getParameter("status");
		
		

//		int condition = Integer.parseInt(request.getParameter("condition")); //상태여부 얼먀넘어면 사용가능
      
		dto.setReportNo(reportNo);
		dto.setAnswerDate(new Date(System.currentTimeMillis()));
//		dto.setStatus(status);
		dto.setContent(content);
		
		int insertReport= reportInfoService.insertReport(dto);
		System.out.println("dto안에 값이 있나? : " + dto);
		String path="";
		if(insertReport > 0 ) {
			path= "/bonggeuda/report/list";
			response.sendRedirect(path);
		} 
	}
	


	

}
