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
import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;

public class BookDAO {

	private final Properties prop;
	public BookDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"/guest/book/book-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<AccomoInfoDTO> selectAccomoList(Connection con, String type) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<AccomoInfoDTO> accomoList = null;
		
		String query = prop.getProperty("selectAccomoInfo");
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, type);
			
			rset = pstmt.executeQuery();
			
			accomoList = new ArrayList<>();
			
			while(rset.next()) {
				AccomoInfoDTO accomoInfo = new AccomoInfoDTO();
				accomoInfo.setAccomoNo(rset.getInt("ACCOMO_NO"));
				accomoInfo.setOwnerNo(rset.getInt("OWNER_NO"));
				accomoInfo.setAccomoName(rset.getString("ACCOMO_NAME"));
				accomoInfo.setCeoName(rset.getString("CEO_NAME"));
				accomoInfo.setType(rset.getString("ACCOMO_TYPE"));
				accomoInfo.setResgstrationNo(rset.getString("REGISTRATION_NO"));
				accomoInfo.setAddress(rset.getString("ACCOMO_ADDRESS"));
				accomoInfo.setEmail(rset.getString("ACCOMO_EMAIL"));
				accomoInfo.setHomepage(rset.getString("ACCOMO_HOMEPAGE"));
				accomoInfo.setFacility(rset.getString("ACCOMO_FACILITY"));
				accomoInfo.setPath(rset.getString("ACCOMO_PATH"));
				accomoInfo.setNear(rset.getString("ACCOMO_NEAR"));
				accomoInfo.setRule(rset.getString("ACCOMO_RULE"));
				accomoInfo.setParking(rset.getString("ACCOMO_PARKING"));
				accomoInfo.setCheckIn(rset.getString("CHECK_IN"));
				accomoInfo.setCheckOut(rset.getString("CHECK_OUT"));
				accomoInfo.setPeakStart(rset.getDate("PEAK_DATE_START"));
				accomoInfo.setPeakEnd(rset.getDate("PEAK_DATE_END"));
				accomoList.add(accomoInfo);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		return accomoList;
	}

}
