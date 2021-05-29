package com.bonggeuda.sugbag.owner.regist.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.bonggeuda.sugbag.model.dto.AttachmentDTO;
import com.bonggeuda.sugbag.model.dto.RoomDTO;
import com.bonggeuda.sugbag.owner.regist.dao.AccomoDAO;
import com.bonggeuda.sugbag.owner.regist.dao.RoomDAO;

public class RoomService {

	/*RoomDAO와 연결할 필드 변수*/
	private RoomDAO roomDAO = new RoomDAO();
	
//	public int InsertRoomServlet(ArrayList<RoomDTO> roomList, int enAccoMoNoMax) {
//		
//		System.out.println("리스트넘어오나? : " + roomList);
//		
//		Connection con = getConnection();
//
//		/*Connection과 함께 정보를 전달하여 조회.*/
//		int inserRoom = roomDAO.InsertRoom(con, roomList,enAccoMoNoMax);
//		
//		if(inserRoom > 0) {
//			commit(con);
//		} else {
//			rollback(con);
//		}
//		close(con);
//		
//		return inserRoom;
//	}

	public int insertThumbnail(RoomDTO thumbnail, List<RoomDTO> roomList) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		// 인서트 되기전 최댓값 이니까
		//int roomRequestNextNo = roomDAO.selectRequestNextRoomNo(con); 
		
		
		int insertRoom = 0;
		
		int attachmentResult = 0;

		/* 리스트에 담아줌. 이엔어코모를 변수로 줘서*/
		//List<Integer> requestNo = roomDAO.searchRequestNo(con);
		//int request = 0;

		List<AttachmentDTO> fileList = thumbnail.getAttachmentList();
		
		for(int i = 0; i < fileList.size(); i++) {
			insertRoom += roomDAO.InsertRoom(con, roomList.get(i)); // 넥스트발
			attachmentResult += roomDAO.insertAttachment(con, fileList.get(i)); // 커발
		}
		
		
		// RM_ROOM_INFO REQUEST_NO
		
		
//		/* fileList에 boardNo값을 넣는다. */
//		for(int i = 0; i < fileList.size(); i++) {
//			fileList.get(i).setRefBoardNo(boardNo);
//		}
		
		if(attachmentResult > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return attachmentResult;
	}
	
	
	

	public int selectenAccoMoNoMax() {
		Connection con = getConnection();

		int selectenAccoMoNoMax = 0;
		
		selectenAccoMoNoMax = roomDAO.selectEnAccomoNoMax(con);
		
		close(con);
		return selectenAccoMoNoMax;
	}




//	public int selectRmRoomReqNoMax() {
//		Connection con = getConnection();
//
//		int selectRmRoomReqNoMax = 0;
//		
//		selectRmRoomReqNoMax = roomDAO.selectRmRoomReqNoMaxDAO(con);
//		
//		return selectRmRoomReqNoMax;
//	}




	/**
	 * 객실 수정시 어테치 먼트 인서트 메소드
	 * @param tempFileInfo
	 * @param roomDTO 
	 * @param selectReqNoMax
	 * @return
	 */
	public int insertRmRoomThumbnail(AttachmentDTO tempFileInfo, RoomDTO roomDTO) {
		Connection con = getConnection();
		
		int result = 0;
		int resultInsertRmRoom = 0;
		
		resultInsertRmRoom = roomDAO.insertRmRoomInfoDAO(con, roomDTO);
		result = roomDAO.insertRmRoomThumbnailDAO(con, tempFileInfo);
		
		if(result > 0 && resultInsertRmRoom > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		
		return result;
	}




	/**
	 * 객실 수정정보 RM_ROOM_INFO 에 인서트
	 * @param roomDTO
	 * @return
	 */
	public int insertRmRoomInfo(RoomDTO roomDTO) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = roomDAO.insertRmRoomInfoDAO(con, roomDTO);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

}
