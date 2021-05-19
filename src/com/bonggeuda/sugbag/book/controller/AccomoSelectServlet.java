package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.service.BookService;

/**
 * Servlet implementation class AccomoSelectServlet
 */
@WebServlet("/accomoSelect/list")
public class AccomoSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿요청확인");
		// 숙소타입구분
		String AccomoType = request.getParameter("value");
		String type="";
		switch(AccomoType) {
		    case "'hotel'" : type = "호텔"; break;
		    case "'pension'" : type = "펜션"; break;
		    case "'guestHouse'" : type = "게스트하우스"; break;
		}
		// 타입별 숙소 리스트 검색
		BookService booksvc = new BookService();
		List<AccomoInfoDTO> accomoList= booksvc.selectAccomoList(type);
		//숙소최저가(0), 평점(1) 가져오기
		List<Map> accomoPriceNStar = booksvc.selectMinPrice(type);
		String path="";
		if(accomoList != null && accomoPriceNStar.get(0) != null && accomoPriceNStar.get(1) !=null) {
			
			for(int i = 0; i < accomoList.size(); i++) {
				int accomoNo = accomoList.get(i).getAccomoNo();
				
				if(accomoPriceNStar.get(0).get(accomoNo) != null) {
				    int price =(int) accomoPriceNStar.get(0).get(accomoNo);
				    accomoList.get(i).setMinPrice(price);
				}
				
				if(accomoPriceNStar.get(1).get(accomoNo) != null) {
					double reviewScore = (double) accomoPriceNStar.get(1).get(accomoNo);
					accomoList.get(i).setReviewScore(reviewScore);
				}
			}
			
			path = "/WEB-INF/views/guest/accomoInfo/list.jsp";
			request.setAttribute("accomoList", accomoList);
		} else {
			System.out.println("실패!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
