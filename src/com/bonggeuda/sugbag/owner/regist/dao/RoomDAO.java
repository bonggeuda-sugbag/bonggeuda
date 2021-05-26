package com.bonggeuda.sugbag.owner.regist.dao;

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
import com.bonggeuda.sugbag.model.dto.AttachmentDTO;
import com.bonggeuda.sugbag.model.dto.RoomDTO;

public class RoomDAO {

	/* Properties 객체를 이용해서 쿼리문을 조회해서 사용. 기본 생성자를 통해서 쿼리문을 조회. */
	private Properties prop = new Properties();
	
	public RoomDAO() {
		//registration-mapper.xml 생성
		try {

			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/registration/registration-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int InsertRoom(Connection con, ArrayList<RoomDTO> roomList) {
		
//		System.out.println("리스트0 : " + roomList.get(0));
//		System.out.println("리스트1 : " + roomList.get(1));
//		System.out.println(roomList.size());
		
		PreparedStatement pstmt = null;
		
		/* 반환시킬 변수 지정 */
		int insert = 0;
		
		String query = prop.getProperty("insertRoom");

		//잘 넘어왔는지 확인용 출력
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			
			for(int i=0; i < roomList.size(); i++){
				
				pstmt.setString(1, roomList.get(i).getRoomName()); // <-위치 홀더의 시작인덱스 시작 값은 1.
				pstmt.setInt(2, roomList.get(i).getRoomMax());
				pstmt.setString(3, roomList.get(i).getRoomIntro());
				pstmt.setInt(4, roomList.get(i).getRoomFee());
				pstmt.setInt(5, roomList.get(i).getPeakFee());

				insert = pstmt.executeUpdate();
				System.out.println("등록한 객실 수 : " + insert);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
     
		return insert;
	}

	public int insertAttachment(Connection con, AttachmentDTO attachmentDTO, int roomRequestNextNo) {

		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertRoomAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, attachmentDTO.getOriginName());
			pstmt.setString(2, attachmentDTO.getSavedName());
			pstmt.setString(3, attachmentDTO.getSavePath());
			pstmt.setString(4, attachmentDTO.getFileType());
			pstmt.setString(5, attachmentDTO.getThumbnailPath());
			pstmt.setInt(6, roomRequestNextNo);
			
			result = pstmt.executeUpdate();
			System.out.println("어테치먼트 리절트.. " + result);  // 리절트가 1이 나와주는데 왜 인서트 실패 라는거지?
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectEnAccomoNoMax(Connection con) {
		
		PreparedStatement pstmt = null;
		int selectEnAccomoNoMax = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectEnNo");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				selectEnAccomoNoMax = rset.getInt("MAX(EN_ACCOMO_NO)");
			}
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}

		return selectEnAccomoNoMax;
	}

	public int selectRequestNextRoomNo(Connection con) {
		
		PreparedStatement pstmt = null;
		int selectEnRoomNoMax = 0;
		ResultSet rset = null;

		String query = prop.getProperty("maxRmRoomNoNext");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				selectEnRoomNoMax = rset.getInt("MAX(REQUEST_NO)");
			}
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		
		return selectEnRoomNoMax;
	}

}