package com.bonggeuda.sugbag.owner.modify.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.RmAccomoInfoDTO;
import com.bonggeuda.sugbag.owner.modify.service.ModifyAccomoService;

/**
 * Servlet implementation class ModifyAccomo
 */
@WebServlet("/owner/accomoModify")
public class ModifyAccomo extends HttpServlet {

	/**
	 * 등록승인된 아이의 숙소정보 조회해서 
	 *  값 조회해서 roomModification1 jsp 로 이동해주는 메소드
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int accomoNo = Integer.parseInt(request.getParameter("accomoNo"));
		System.out.println(accomoNo);

		RmAccomoInfoDTO rmAccomoInfo = new RmAccomoInfoDTO();
		
		ModifyAccomoService modifyService = new ModifyAccomoService();
		
		rmAccomoInfo = modifyService.selectAccomoInfo(accomoNo);
		System.out.println(" @@ " + rmAccomoInfo);
				
		request.setAttribute("rmAccomoInfo", rmAccomoInfo);
		
		String path = "";
		path = "/WEB-INF/views/owner/roomModify/roomModification.jsp";
		request.getAttribute(path);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
