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

	public int insertThumbnail(RoomDTO thumbnail, ArrayList<RoomDTO> roomList) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		// 인서트 되기전 최댓값 이니까
		int roomRequestNextNo = roomDAO.selectRequestNextRoomNo(con); 
		
		
		int inserRoom = roomDAO.InsertRoom(con, roomList);
		
		List<AttachmentDTO> fileList = thumbnail.getAttachmentList();
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			roomRequestNextNo++;
			attachmentResult += roomDAO.insertAttachment(con, fileList.get(i),roomRequestNextNo);
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

}
