package com.bonggeuda.sugbag.owner.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.owner.mypage.service.OwnerMypagService;

/**
 * Servlet implementation class TaxBillRequest
 */
@WebServlet("/owner/requestTaxBill")
public class TaxBillRequest extends HttpServlet {
	
	/**
	 * 인서트 해준다
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		OwnerMypagService ownerService = new OwnerMypagService();
		int ownerNo = 1;

		int requestTaxBill = 0;
		
		String accomoName = request.getParameter("accmoName");
		// 일단 어코모 네임으로 어코모 번호 조회해오자...
		int accomoNo = ownerService.selectAccomoNo(accomoName,ownerNo);
		
		java.sql.Date startDate = java.sql.Date.valueOf( request.getParameter("startDate"));
		java.sql.Date endDate = java.sql.Date.valueOf(request.getParameter("endDate"));
		
		// 어코모 넘도 가져오기
		

				
		
		requestTaxBill = ownerService.insertRequestTaxBill(ownerNo ,startDate ,endDate,accomoNo);
		
		System.out.println(requestTaxBill);
		String path = "";
		if(requestTaxBill > 0) {
			path = "/WEB-INF/views/owner/mypage/requestTaxBillSuccess.jsp";
			request.getAttribute(path);
			request.getRequestDispatcher(path).forward(request, response);
			
		}else {
			path = "/WEB-INF/views/owner/mypage/mypage.jsp";
			request.getAttribute(path);
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		

		
	}

	/**
	 * 세금계산서 발급페이지 (숙소 이름 셀렉기능 추가)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int  ownerNo = 1;
		// 먼저 조회하기 오너 넘에 따른 어코모 네임들
		// 어커모 넘도 조회해 오기
		List<AccomoDTO> accomoNameList = new ArrayList<>();
		
		OwnerMypagService ownerService = new OwnerMypagService();
		
		
		accomoNameList = ownerService.selectAccomoNames(ownerNo);
		request.setAttribute("accomoNameList", accomoNameList);
		
		
		String path = "";
		path = "/WEB-INF/views/owner/mypage/mypageRequestTaxBill.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);


	}
	
	

}
