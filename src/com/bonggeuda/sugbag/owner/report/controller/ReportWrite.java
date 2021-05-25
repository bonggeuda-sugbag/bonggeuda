package com.bonggeuda.sugbag.owner.report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.ReportDTO;
import com.bonggeuda.sugbag.owner.report.dao.ReportWriteService;

/**
 * Servlet implementation class ReportWrite
 */
@WebServlet("/owner/reportWrite")
public class ReportWrite extends HttpServlet {

	/**
	 * 작성한 신고내역 볼 수 있도록 마이페이지로 이동 겸 인서트 작업
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String writerType = "owner";
		String reportedType = "guest";
		
		int userNo = Integer.parseInt(request.getParameter("userNo")); 
		int ownerNo = Integer.parseInt(request.getParameter("ownerNo")); 
		
		String reportTitle = request.getParameter("reportTitle");
		String reportContent = request.getParameter("reportContent");
		System.out.println(reportTitle + reportContent);
		
		
		
		ReportWriteService reportInsertService = new ReportWriteService();
		
		
		int reportInsert = reportInsertService.reportInsertService(writerType,reportedType,userNo,ownerNo,reportTitle,reportContent);
		
		System.out.println(reportInsert + "reportInsert");
		
		if(reportInsert > 0) {
			
			String path = "";
			path = "/WEB-INF/views/owner/report/reportSuccessPage.jsp";
			request.getAttribute(path);
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		

	}


	/**
	 * 신고 페이지로 이동 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int userNo = Integer.parseInt(request.getParameter("userNo")); 
		int ownerNo = Integer.parseInt(request.getParameter("ownerNo")); 

		
		/* 이정보 담아서  신고 jsp 로 넘겨주자 */
		BookDTO forReort = new BookDTO();
		forReort.setUserNo(userNo);
		forReort.setOwnerNo(ownerNo);
		
		
		request.setAttribute("forReort", forReort);
		
		String path = "";
		path = "/WEB-INF/views/owner/report/report.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);

	}

}
