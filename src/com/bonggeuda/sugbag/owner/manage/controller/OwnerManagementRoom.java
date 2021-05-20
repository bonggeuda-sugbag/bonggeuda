package com.bonggeuda.sugbag.owner.manage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.common.paging.PageNation;
import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.PageInfoDTO;
import com.bonggeuda.sugbag.model.dto.RmAccomoInfoDTO;
import com.bonggeuda.sugbag.owner.manage.service.ManagementRoomService;

import static com.bonggeuda.sugbag.common.paging.PageNation.getPageInfo;

/**
 * Servlet implementation class OwnerManagementRoom
 */
@WebServlet("/owner/managementRoom")
public class OwnerManagementRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ownerNo = 1;
		
		

		/* 전체 게시물 수가 필요 */
		/* 게시물 수가 0 이상인 경우 yesRoom jsp 로 이동 / 반대는 노룸*/
		/* 데이터베이스에서 먼저 전체 게시물 수를 조회 */
		ManagementRoomService houseBoardService = new ManagementRoomService();
		int houseCount = houseBoardService.selectHasRoom(ownerNo);
		// 카운트를 조회해 오니까 int 
		
		System.out.println("totalCount 체크 : " + houseCount);

		/* 조회해온 오너 넘버를 이용해서 accomo DTO 리스트로 가져오기 */
		List<RmAccomoInfoDTO> rmAccmoDTOList = new ArrayList<>();
		
		ManagementRoomService roomList = new ManagementRoomService();
		rmAccmoDTOList = roomList.selectRoomList(ownerNo);
		
		System.out.println(rmAccmoDTOList);
		
		/* 조회 해오면페이지 이동. */
		String path = "";
		
		if(houseCount > 0) {
			path = "/WEB-INF/views/owner/roomManagement/managementYesroom.jsp";
			request.setAttribute("rmAccmoDTOList", rmAccmoDTOList);
			

		} else {
			path = "/WEB-INF/views/owner/roomManagement/managementNoRoom.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		

	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
