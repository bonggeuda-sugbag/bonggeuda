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
import com.bonggeuda.sugbag.model.dto.PointDTO;
import com.bonggeuda.sugbag.model.dto.PointHistoryDTO;

public class MypageDAO {
	
	private Properties prop = new Properties();
	
	public MypageDAO() {
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "/guest/mypage/mypage-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 가지고있는 포인트 정보 조회
	 * @param con
	 * @param userNo
	 * @return
	 */
	public PointDTO pointSelect(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		PointDTO point = null;
		
		String query = prop.getProperty("point");
		
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				point = new PointDTO();
				
				point.setPoint(rset.getInt("POINT"));
			}
			
			System.out.println(point);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return point;
	}

	/**
	 * 포인트 이력 정보 조회
	 * @param con
	 * @param userNo 
	 * @return
	 */
	public List<PointHistoryDTO> pointHistorySelect(Connection con, int userNo) {

		System.out.println("서블릿요청3333");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<PointHistoryDTO> pointHistory = null;
		
		String query = prop.getProperty("pointHistory");
		
		System.out.println(query);
		
		pointHistory = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				PointHistoryDTO pointHistoryDTO = new PointHistoryDTO();
				
				pointHistoryDTO.setPointPath(rset.getString("POINT_PATH"));
				pointHistoryDTO.setGetuseType(rset.getString("GETUSE_TYPE_GU"));
				pointHistoryDTO.setGuDate(rset.getDate("GU_DATE"));
				pointHistoryDTO.setPoint(rset.getInt("POINT"));
				
				pointHistory.add(pointHistoryDTO);
				
			}
			
			System.out.println(pointHistory);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return pointHistory;
	}

}
