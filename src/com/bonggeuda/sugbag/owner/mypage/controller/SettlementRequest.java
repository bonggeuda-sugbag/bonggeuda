package com.bonggeuda.sugbag.owner.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.SettlementDTO;
import com.bonggeuda.sugbag.owner.mypage.service.OwnerMypagService;

/**
 * Servlet implementation class SettlementRequest
 */
@WebServlet("/owner/settlement")
public class SettlementRequest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		OwnerMypagService stlService = new OwnerMypagService();

		/*결과값 반환*/
		List<SettlementDTO> selectStl = stlService.selectStl();
		
		request.setAttribute("selectStl", selectStl);
		
		String path = "";
		path = "/WEB-INF/views/owner/mypage/requestSettlement.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
