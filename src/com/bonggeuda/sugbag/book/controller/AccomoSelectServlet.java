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
		String AccomoType = request.getParameter("value");
		
		String type="";
		
		switch(AccomoType) {
		    case "'hotel'" : type = "호텔"; break;
		    case "'pension'" : type = "펜션"; break;
		    case "'guestHouse'" : type = "게스트하우스"; break;
		}
		BookService booksvc = new BookService();
		List<AccomoInfoDTO> accomoList= booksvc.selectAccomoList(type);
		
		//최저가(0), 평점(1) 조회
		List<Map> priceNrvScore = booksvc.selectPriceNstar(type);
		
 		String path="";
		if(accomoList != null) {
			for(int i = 0; i < accomoList.size(); i++) {
				int accomoNo = accomoList.get(i).getAccomoNo();
				if(priceNrvScore.get(0).get(accomoNo) != null) {
					accomoList.get(i).setMinPrice((int)priceNrvScore.get(0).get(accomoNo));
				}
				if(priceNrvScore.get(1).get(accomoNo) != null) {
					accomoList.get(i).setReviewScore((double)priceNrvScore.get(1).get(accomoNo));
				}
			}
			path = "/WEB-INF/views/guest/accomoInfo/list.jsp";
			request.setAttribute("accomoList", accomoList);
		} else {
			System.out.println("숙소목록 조회에 실패했습니다.!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
