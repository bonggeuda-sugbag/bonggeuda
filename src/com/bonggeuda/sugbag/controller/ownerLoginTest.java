package com.bonggeuda.sugbag.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bonggeuda.sugbag.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.owner.mypage.service.OwnerMypagService;

/**
 * Servlet implementation class ownerLoginTest
 */
@WebServlet("/login/owner")
public class ownerLoginTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		OwnerInfoDTO member = new OwnerInfoDTO(2,"abc222@naver.com","abc222","010-2222-2222","N",new java.sql.Date(System.currentTimeMillis()),null);
//		HttpSession session = request.getSession();
//		session.setAttribute("member", member);
		/*해당 오너 넘으로 이미지 조회 */
		HttpSession session = request.getSession();
		int ownerNo = (Integer)session.getAttribute("ownerNo");
		System.out.println("ownerNo @@@@@@@@ : " + ownerNo);
		
		OwnerMypagService ownerService = new OwnerMypagService();
		
		List<AccomoDTO> accomoList = new ArrayList<>();
		
		accomoList = ownerService.selectAccomoList(ownerNo);
		System.out.println("accomoList : " + accomoList);
		//request.setAttribute("accomoList", accomoList);
		session.setAttribute("accomoList",accomoList);
		request.getRequestDispatcher("/WEB-INF/views/owner/main/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
