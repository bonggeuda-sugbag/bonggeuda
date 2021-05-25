package com.bonggeuda.sugbag.owner.manage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.RmAccomoInfoDTO;
import com.bonggeuda.sugbag.owner.manage.service.ManagementRoomService;

/**
 * Servlet implementation class OwnerManagementRoom
 */
@WebServlet("/owner/managementRoom")
public class OwnerManagementRoom extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ownerNo = 1;
		
		/* 전체 게시물 수가 필요 */
		/* 게시물 수가 0 이상인 경우 yesRoom jsp 로 이동 / 반대는 노룸*/
		/* 데이터베이스에서 먼저 전체 게시물 수를 조회 */
		ManagementRoomService accomoBoardService = new ManagementRoomService();
		int houseCount = accomoBoardService.selectHasRoom(ownerNo);
		// 카운트를 조회해 오니까 int 
		
		/* 조회해온 오너 넘버를 이용해서 accomo DTO 리스트로 가져오기 */
		List<RmAccomoInfoDTO> RmAccmoInfoDTOList = new ArrayList<>();
		
		RmAccmoInfoDTOList = accomoBoardService.selectAccomoList(ownerNo);
		System.out.println("디티오" + RmAccmoInfoDTOList);
		
		
		// RM 일경우 카테고리 넘버 1인 아이의 사진경로 가져오기
		String rmImagePathSelect = accomoBoardService.selectRmImagePath(ownerNo);
		System.out.println("rm 이미지 경로" + rmImagePathSelect);
		
		
		
		
		/* 조회 해오면페이지 이동. */
		String path = "";
		
		if(houseCount > 0) {
			request.setAttribute("RmAccmoInfoDTOList", RmAccmoInfoDTOList);
			request.setAttribute("rmImagePathSelect", rmImagePathSelect);
			
			path = "/WEB-INF/views/owner/roomManagement/managementYesRoom.jsp";
			request.getAttribute(path);
			request.getRequestDispatcher(path).forward(request, response);
			
			
		} else {
			path = "/WEB-INF/views/owner/roomManagement/managementNoRoom.jsp";
			request.getAttribute(path);
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
		

	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
