package com.bonggeuda.sugbag.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bonggeuda.sugbag.model.dto.MemberDTO;

/**
 * Servlet implementation class ownerLoginTest
 */
@WebServlet("/login/owner")
public class ownerLoginTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MemberDTO member = new MemberDTO(1,"user01","pass01","010-1111-1111",0,"넘버원","N","U",new java.sql.Date(System.currentTimeMillis()), null);
//		HttpSession session = request.getSession();
//		session.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/owner/main/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
