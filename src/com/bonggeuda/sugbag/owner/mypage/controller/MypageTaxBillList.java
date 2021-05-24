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
import com.bonggeuda.sugbag.model.dto.RequestTaxBillDTO;
import com.bonggeuda.sugbag.owner.mypage.service.OwnerMypagService;

/**
 * Servlet implementation class MypageTexBillList
 */
@WebServlet("/owner/taxbillList")
public class MypageTaxBillList extends HttpServlet {

	/**
	 * 세금 계산서 목록 조회
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		
		

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 리스트에 담기
		int  ownerNo = 1;

		
		List<RequestTaxBillDTO> taxBillList = new ArrayList<>(); // 
		
		OwnerMypagService ownerService = new OwnerMypagService();
		
		taxBillList = ownerService.selectTaxBillList(ownerNo);
		
		
		request.setAttribute("taxBillList", taxBillList);
		
		if(taxBillList != null) {
			
			String path = "";
			path = "/WEB-INF/views/owner/mypage/mypageTaxbillList.jsp";
			request.getAttribute(path);
			request.getRequestDispatcher(path).forward(request, response);
			
			
		}

		
	}

}
