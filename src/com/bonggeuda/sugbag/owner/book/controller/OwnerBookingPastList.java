package com.bonggeuda.sugbag.owner.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.common.paging.PageNation;
import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.BookingContentDTO;
import com.bonggeuda.sugbag.model.dto.PageInfoDTO;
import com.bonggeuda.sugbag.owner.book.service.BookListSelectService;
import com.bonggeuda.sugbag.owner.notice.service.QuestionService;

/**
 * Servlet implementation class OwnerBookingPastList
 */
@WebServlet("/owner/bookingPastList")
public class OwnerBookingPastList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		/* 전체 게시물 수가 필요 */
		/* 데이터베이스에서 먼저 전체 게시물 수를 조회 */
		BookListSelectService BookListService = new BookListSelectService();
		
		int totalCount = BookListService.selectTotalCount();
		
		System.out.println("totalCount 체크 : " + totalCount);

		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;
		
		/* 한 번에 보여질 페이징 버튼의 수*/
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		PageInfoDTO pageInfo = PageNation.getPageInfo(pageNo, totalCount, limit, buttonAmount);

		System.out.println(pageInfo);
		
		List<BookDTO> bookList = BookListService.bookPastListSelect(pageInfo);
		
		System.out.println("전체내역조회 : " + bookList);
		
		String path = "";
		path = "/WEB-INF/views/owner/bookingList/bookingList.jsp";
		request.setAttribute("bookList", bookList);
		request.setAttribute("pageInfo", pageInfo);
		
		request.getRequestDispatcher(path).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 1. BookNO 가져오기 */
		int bookNo = Integer.parseInt(request.getParameter("bookNo")); 
		
		BookingContentDTO bookContentDTO = new BookingContentDTO();
		
		BookListSelectService bookService = new BookListSelectService();

		
		bookContentDTO = bookService.selectBookContent(bookNo);
		

		request.setAttribute("bookContentDTO", bookContentDTO );
		String path = "";
		path = "/WEB-INF/views/owner/bookingList/bookingPastContent.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
