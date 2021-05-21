package com.bonggeuda.sugbag.model.dao;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.model.dto.EventDTO;
import com.bonggeuda.sugbag.model.dto.NoticeDTO;
import com.bonggeuda.sugbag.model.dto.OwnerQnADTO;

public class UserMoreInfoDAO {
	
	private Properties prop = new Properties();
	
	public UserMoreInfoDAO() {
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "/guest/mypage/moreinfo-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 공지사항 조회
	 * @param con
	 * @return
	 */
	public List<NoticeDTO> selectNotice(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<NoticeDTO> notice = new ArrayList<>();
		
		String query = prop.getProperty("noticeSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeDTO noticeDTO = new NoticeDTO();
				
				noticeDTO.setNoticeNo(rset.getInt("NOTICE_NO"));
				noticeDTO.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				noticeDTO.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				noticeDTO.setNoticeWriteDate(rset.getDate("NOTICE_WRITE_DATE"));
				
				notice.add(noticeDTO);
			}
			System.out.println(notice);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return notice;
	}

	public List<EventDTO> selectEvent(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<EventDTO> event = new ArrayList<>();
		
		String query = prop.getProperty("eventSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				EventDTO eventDTO = new EventDTO();
				
				eventDTO.setEvnetNo(rset.getInt("EVENT_NO"));
				eventDTO.setEventTitle(rset.getString("EVENT_TITLE"));
				eventDTO.setEventStart(rset.getDate("EVENT_START"));
				eventDTO.setEventEnd(rset.getDate("EVENT_END"));
				eventDTO.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				
				event.add(eventDTO);
			}
			
			System.out.println(event);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return event;
	}

	/**
	 * 업체에게 문의리스트 조회
	 * @param con
	 * @param userNo
	 * @return
	 */
	public List<OwnerQnADTO> selectOwnerQnA(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<OwnerQnADTO> ownerQnA = new ArrayList<>();
		
		String query = prop.getProperty("ownerQnAListSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				OwnerQnADTO ownerQnADTO = new OwnerQnADTO();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
