package com.bonggeuda.sugbag.owner.manage.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.RmAccomoInfoDTO;
import com.bonggeuda.sugbag.owner.manage.dao.ManagementRoomSelectDAO;

public class ManagementRoomService {
	
	private ManagementRoomSelectDAO roomDAO = new ManagementRoomSelectDAO();
	

	public int selectHasRoom(int ownerNo) {

		/* Connection 생성 */
		Connection con = getConnection();
		
		int hasRoom = roomDAO.selectTotalRoom(con,ownerNo);
		
		close(con);
		
		return hasRoom;
	}


	public List<RmAccomoInfoDTO> selectAccomoList(int ownerNo) {
		
		Connection con = getConnection();

		List<RmAccomoInfoDTO> accomoList = roomDAO.selectAccomoListDAO(con,ownerNo);
		
		close(con);

		return accomoList;
	}


	public String selectRmImagePath(int ownerNo) {
		
		Connection con = getConnection();

		String selectrmImagePath = roomDAO.selectRmImagePathDAO(con, ownerNo);
		
		close(con);

		
		return selectrmImagePath;
	}


	public int insertRmAccomo(RmAccomoInfoDTO rmAcoomoDTO) {
		Connection con = getConnection();
		
		int insertResult =  0;
		
		insertResult = roomDAO.insertRmAccomoDAO(con,rmAcoomoDTO);

		if(insertResult > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return insertResult;
	}



}
