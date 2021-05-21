package com.bonggeuda.sugbag.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dao.UserMoreInfoDAO;
import com.bonggeuda.sugbag.model.dto.EventDTO;
import com.bonggeuda.sugbag.model.dto.NoticeDTO;
import com.bonggeuda.sugbag.model.dto.OwnerQnADTO;

public class UserMoreInfoService {

	UserMoreInfoDAO moreinfoDAO = new UserMoreInfoDAO();
	
	/**
	 * 공지사항 조회
	 * @return
	 */
	public List<NoticeDTO> selectNotice() {
		
		Connection con = getConnection();
		
		List<NoticeDTO> notice = moreinfoDAO.selectNotice(con);
		
		close(con);
				
		return notice;
	}

	/**
	 * 이벤트 조회
	 * @return
	 */
	public List<EventDTO> selectEvent() {

		Connection con = getConnection();
		
		List<EventDTO> event = moreinfoDAO.selectEvent(con);
		
		close(con);
		return event;
	}

	/**
	 * 업체에게 문의리스트 조회
	 * @param userNo
	 * @return
	 */
	public List<OwnerQnADTO> selectOwnerQnA(int userNo) {

		Connection con = getConnection();
		
		List<OwnerQnADTO> ownerQnA = moreinfoDAO.selectOwnerQnA(con, userNo);
		
		close(con);
		
		return ownerQnA;
	}

}
