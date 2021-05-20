package com.bonggeuda.sugbag.owner.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.owner.dto.OwnerInfoDTO;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

public class OwnerMypageDAO {
	
	private Properties prop = new Properties();
	
	public OwnerMypageDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"/owner/mypage/mypage-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


	public OwnerInfoDTO selectOwner(Connection con, int ownerNo) {
		
		/* 웨어절에 ? 로 하기위해*/
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		OwnerInfoDTO ownerInfoDTO = null;
		
		String query = prop.getProperty("selectOwnerInfo");
		
				
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ownerInfoDTO = new OwnerInfoDTO();
				
				ownerInfoDTO.setOwnerID(rset.getString("OWNER_ID"));
				ownerInfoDTO.setOwnerPwd(rset.getString("OWNER_PWD"));
				ownerInfoDTO.setOwnerPhone(rset.getString("OWNER_PHONE"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
	
		return ownerInfoDTO;
	}

}
