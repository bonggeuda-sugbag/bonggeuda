package com.bonggeuda.sugbag.owner.room.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import com.bonggeuda.sugbag.model.dto.RoomDTO;
import com.bonggeuda.sugbag.owner.accomo.dao.AccomoDAO;
import com.bonggeuda.sugbag.owner.room.dao.RoomDAO;

public class RoomService {

	/*RoomDAO와 연결할 필드 변수*/
	private RoomDAO roomDAO = new RoomDAO();
	
	public int InsertRoomServlet(RoomDTO roomDTO) {

		Connection con = getConnection();

		/*Connection과 함께 정보를 전달하여 조회.*/
		int inserRoom = roomDAO.InsertRoom(con, roomDTO); //전달할땐 DTO에 값을 넣어 행 형태(empDTO)로 전달 -> 그리고 InsertEmpToDb 메소드에서 int형태의 값을 반환받아옴
		
		if(inserRoom > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return inserRoom;
	}

}
