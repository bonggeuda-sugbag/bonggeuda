package com.bonnggeuda.sugbag.owner.dao;



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

import com.bonggeuda.sugbag.accomo.model.dto.RmAccomoInfoDTO;
import com.bonggeuda.sugbag.common.config.ConfigLocation;

public class ManagementRoomSelectDAO {
	
		private Properties prop = new Properties();

	
	public ManagementRoomSelectDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"/owner/roomManagement/roomManagement-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int selectTotalRoom(Connection con, int ownerNo) {
		
//		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectRoomCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);			
			
			while(rset.next()) {
				totalCount = rset.getInt("토탈");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		System.out.println("DAO 토탈 카운트 : " + totalCount);
		
		return totalCount;

		
	}

	public List<RmAccomoInfoDTO> selectRoomList(Connection con, int ownerNo) {
		
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		RmAccomoInfoDTO rmAccomoDTO = null;
		
		List<RmAccomoInfoDTO> roomList = new ArrayList<>();
		
		String query = prop.getProperty("roomListSelect");
		
			try {
				pstmt = con.prepareStatement(query);
				
				pstmt.setInt(1,ownerNo );
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					rmAccomoDTO = new RmAccomoInfoDTO();
					
					rmAccomoDTO.setRequestNo(rset.getInt("REQUEST_NO"));
					rmAccomoDTO.setAccomoName(rset.getString("RM_ACCOMO_NAME"));
					rmAccomoDTO.setCeoName(rset.getString("RM_CEO_NAME"));
					rmAccomoDTO.setAccomoType(rset.getString("RM_ACCOMO_TYPE"));
					rmAccomoDTO.setApprovalYN(rset.getString("APPROVAL_YN"));
					
					roomList.add(rmAccomoDTO);
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		
			
		
		return roomList;
	}

}
