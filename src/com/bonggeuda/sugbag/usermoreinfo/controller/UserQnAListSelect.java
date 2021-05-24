package com.bonggeuda.sugbag.usermoreinfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AdminQnADTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.OwnerQnADTO;
import com.bonggeuda.sugbag.model.dto.QnADTO;
import com.bonggeuda.sugbag.service.UserMoreInfoService;

/**
 * Servlet implementation class UserQnAListSelect
 */
@WebServlet("/userqnalist/select")
public class UserQnAListSelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = ((MemberDTO)request.getSession().getAttribute("member")).getUserNo();
		
		UserMoreInfoService moreinfoService = new UserMoreInfoService();
		
//		/* 업체에게 문의리스트 조회 */
//		List<OwnerQnADTO> ownerQnA = new ArrayList<>();
//		ownerQnA = moreinfoService.selectOwnerQnA(userNo);
//		
//		/* 관리자에게 문의리스트 조회 */
//		List<AdminQnADTO> adminQnA = new ArrayList<>();
//		adminQnA = moreinfoService.selectAdminQnA(userNo);
		
		/* 관리자에게 + 업체에게 문의리스트 조회 */
		List<QnADTO> userqna = new ArrayList<>();
		userqna = moreinfoService.selectQnA(userNo);
		
		
		String path = "/WEB-INF/views/guest/moreNotice/QnA.jsp";
//		request.setAttribute("ownerQnA", ownerQnA);
//		request.setAttribute("adminQnA", adminQnA);
		request.setAttribute("userqna", userqna);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}