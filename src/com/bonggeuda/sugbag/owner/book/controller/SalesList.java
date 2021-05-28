package com.bonggeuda.sugbag.owner.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bonggeuda.sugbag.model.dto.SalesDTO;
import com.bonggeuda.sugbag.owner.book.service.SalesService;

/**
 * Servlet implementation class Sales
 */
@WebServlet("/owner/sales")
public class SalesList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//로그인 값
		HttpSession session = request.getSession();
		int ownerNo = (Integer)session.getAttribute("ownerNo"); 	
		System.out.println(ownerNo);

		SalesService salesService = new SalesService();

		List<SalesDTO> selectSales = salesService.selectSales(ownerNo);
		
		System.out.println(selectSales);
		
		String path = "";
		path = "/WEB-INF/views/owner/bookingList/salesList.jsp";
		request.setAttribute("selectSales", selectSales);

		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
