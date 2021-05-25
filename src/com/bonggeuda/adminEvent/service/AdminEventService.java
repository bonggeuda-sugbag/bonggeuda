package com.bonggeuda.adminEvent.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.adminEvent.dao.AdminEventDAO;
import com.bonggeuda.adminEvent.dto.EventDTO;
import com.bonggeuda.sugbag.adminNotice.dao.AdminNoticeDAO;
import com.bonggeuda.sugbag.adminNotice.dto.AdminNoticeDTO;
import com.bonggeuda.sugbag.model.dto.PageInfoDTO;

public class AdminEventService {
	
	private final AdminEventDAO adminEventDAO;
	
	public AdminEventService() {
		adminEventDAO = new AdminEventDAO();
	}


	public List<EventDTO> selectEventList(PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<EventDTO> eventList = adminEventDAO.selectEventList(con, pageInfo);
		
		close(con);
		
		return eventList;
	}

	public int selectEventTotalCount() {
		
		Connection con = getConnection();
		
		int eventCount = adminEventDAO.selectEventTotalCount(con);
		
		close(con);
		
		return eventCount;
	}

}
