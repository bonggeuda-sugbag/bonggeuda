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
import com.bonggeuda.sugbag.model.dto.AdminQnADTO;
import com.bonggeuda.sugbag.model.dto.EventDTO;
import com.bonggeuda.sugbag.model.dto.NoticeDTO;
import com.bonggeuda.sugbag.model.dto.OwnerQnADTO;
import com.bonggeuda.sugbag.model.dto.QnADTO;

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
	 * @param qnaNo 
	 * @return
	 */
	public OwnerQnADTO selectOwnerQnA(Connection con, int userNo, int qnaNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		OwnerQnADTO ownerQnA = new OwnerQnADTO();
		
		String query = prop.getProperty("ownerQnAContentSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, qnaNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				ownerQnA.setTitle(rset.getString("OWNER_QNA_TITLE"));
				ownerQnA.setContent(rset.getString("OWNER_QNA_CONTENT"));
				ownerQnA.setWriteDate(rset.getDate("OWNER_QNA_DATE"));
				ownerQnA.setAnswerYN(rset.getString("OWNER_ANSWER_YN"));
				ownerQnA.setAccomoNo(rset.getInt("ACCOMO_NO"));
				ownerQnA.setAccomoName(rset.getString("ACCOMO_NAME"));
				ownerQnA.setOwnerAnswerContent(rset.getString("OWNER_ANSWER_CONTENT"));
				
			}
			System.out.println(ownerQnA);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return ownerQnA;
	}

	/**
	 * 관리자에게 문의리스트 조회
	 * @param con
	 * @param userNo
	 * @param qnaNo 
	 * @return
	 */
	public AdminQnADTO selectAdminQnA(Connection con, int userNo, int qnaNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		AdminQnADTO adminQnA = new AdminQnADTO();
		
		String query = prop.getProperty("adminQnAContentSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, qnaNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				adminQnA.setAdminQnATitle(rset.getString("ADMIN_QNA_TITLE"));
				adminQnA.setAdminQnADate(rset.getDate("ADMIN_QNA_DATE"));
				adminQnA.setAdminAnswerYn(rset.getString("ADMIN_ANSWER_YN"));
				adminQnA.setAdminQnAContent(rset.getString("ADMIN_QNA_CONTENT"));
				adminQnA.setAnswerContent(rset.getString("ANSWER_CONTENT"));
				
			}
			System.out.println(adminQnA);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return adminQnA;
	}

	/**
	 * 관리자에게 + 업체에게 문의리스트 조회
	 * @param con
	 * @param userNo
	 * @return
	 */
	public List<QnADTO> selectQnA(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<QnADTO> qna = new ArrayList<>();
		
		String query = prop.getProperty("adminQnAListSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				QnADTO qnaDTO = new QnADTO();
				qnaDTO.setQnaNo(rset.getInt("ADMIN_QNA_NO"));
				qnaDTO.setQnaTitle(rset.getString("ADMIN_QNA_TITLE"));
				qnaDTO.setQnaDate(rset.getDate("ADMIN_QNA_DATE"));
				qnaDTO.setAnswerYn(rset.getString("ADMIN_ANSWER_YN"));
				qnaDTO.setQnaContent(rset.getString("ADMIN_QNA_CONTENT"));
				qnaDTO.setWriter("관리자");
				
				qna.add(qnaDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		String query2 = prop.getProperty("ownerQnAListSelect");
		System.out.println(query2);
			
		try {
			pstmt = con.prepareStatement(query2);
			pstmt.setInt(1, userNo);
				
			rset = pstmt.executeQuery();
				
			while(rset.next()) {
					
				QnADTO qnaDTO = new QnADTO();
				qnaDTO.setQnaNo(rset.getInt("OWNER_QNA_NO"));
				qnaDTO.setQnaTitle(rset.getString("OWNER_QNA_TITLE"));
				qnaDTO.setQnaDate(rset.getDate("OWNER_QNA_DATE"));
				qnaDTO.setAnswerYn(rset.getString("OWNER_ANSWER_YN"));
				qnaDTO.setQnaContent(rset.getString("OWNER_QNA_CONTENT"));
				qnaDTO.setWriter(rset.getString("ACCOMO_NAME"));
					
				qna.add(qnaDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("gogogoog : " + qna);
		return qna;
	}

}
