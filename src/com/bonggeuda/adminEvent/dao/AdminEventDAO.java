package com.bonggeuda.adminEvent.dao;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bonggeuda.adminEvent.dto.EventDTO;
import com.bonggeuda.sugbag.adminNotice.dto.AdminNoticeDTO;
import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.model.dto.PageInfoDTO;

public class AdminEventDAO {
	
	private static Properties prop;
	
	public AdminEventDAO() {
		
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/userInfo/event-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public List<EventDTO> selectEventList(Connection con, PageInfoDTO pageInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<EventDTO> eventList = null;
		
		String query = prop.getProperty("selectEventList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
		
			rset = pstmt.executeQuery();
			
			eventList = new ArrayList<>();
			
			while(rset.next()) {
				EventDTO eventInfo = new EventDTO();
						
				eventInfo.setRnum(rset.getInt("RNUM"));
				eventInfo.setNumber(rset.getInt("EVENT_NO"));
				eventInfo.setTitle(rset.getString("EVENT_TITLE"));
				eventInfo.setStartDate(rset.getDate("EVENT_START"));
				eventInfo.setEndDate(rset.getDate("EVENT_END"));
				
				
				eventList.add(eventInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return eventList;
	}

	public int selectEventTotalCount(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int eventCount = 0;
		
		String query = prop.getProperty("selectEventTotalCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				eventCount = rset.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
//		System.out.println(totalCount);
		return eventCount;
	}

}
