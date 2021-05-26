package com.bonggeuda.sugbag.owner.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.model.dto.AdminQnADTO;
import com.bonggeuda.sugbag.model.dto.SettlementDTO;
import com.bonggeuda.sugbag.owner.mypage.service.OwnerMypagService;
import com.bonggeuda.sugbag.owner.notice.service.QuestionService;

/**
 * Servlet implementation class SettlementRequest
 */
@WebServlet("/owner/settlement")
public class SettlementList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OwnerMypagService stlService = new OwnerMypagService();

		/*결과값 반환*/
		List<SettlementDTO> selectStl = stlService.selectStl();
		List<AccomoDTO> selectAccomo = stlService.selectAccomo();
		
		request.setAttribute("selectStl", selectStl);
		request.setAttribute("selectAccomo", selectAccomo);
		
		String path = "";
		path = "/WEB-INF/views/owner/mypage/settlementList.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("작성했어");
		
		int accomoNo = Integer.parseInt(request.getParameter("accomoNo"));
		System.out.println(accomoNo);
		
		/*값을 전달하기 위한 비지니스 로직 호출*/
		OwnerMypagService reqStl = new OwnerMypagService();
		
		/*결과값 반환*/
		int insertStl = reqStl.insertStl(accomoNo); //값을 int형으로 반환받아야 함
		
		String path = "";
		path = "/WEB-INF/views/owner/mypage/settlementSuccess.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
