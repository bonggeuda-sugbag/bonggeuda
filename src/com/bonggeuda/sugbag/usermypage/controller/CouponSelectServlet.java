package com.bonggeuda.sugbag.usermypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.CouponDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.service.UserMypageService;

/**
 * Servlet implementation class CouponSelectServlet
 */
@WebServlet("/coupon/select")
public class CouponSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = ((MemberDTO)request.getSession().getAttribute("member")).getUserNo();
		
		UserMypageService mypageService = new UserMypageService();
		
		/* 보유 쿠폰 개수 조회 */
		int result = mypageService.couponCount(userNo);
		System.out.println(result);
		
		/* 보유 쿠폰 조회 */
		List<CouponDTO> coupon = new ArrayList<>();
		coupon = mypageService.couponSelect(userNo);
		
		
		
		
		String path = "";
		
		path = "/WEB-INF/views/guest/mypage/coupon.jsp";
		request.setAttribute("couponCount", result);
		request.setAttribute("coupon", coupon);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
