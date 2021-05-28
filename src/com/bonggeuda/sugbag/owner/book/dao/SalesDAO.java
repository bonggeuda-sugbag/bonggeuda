package com.bonggeuda.sugbag.owner.book.dao;

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
import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.SalesDTO;

public class SalesDAO {

	private Properties prop = new Properties();

	public SalesDAO() {
	
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/bookingList/bookingList-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<SalesDTO> selectSales(Connection con, int ownerNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<SalesDTO> selectSales = new ArrayList<>();

		SalesDTO SalesDTO = new SalesDTO();
		
		String query = prop.getProperty("selectAccomoList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				SalesDTO accomoList = new SalesDTO();
				
				accomoList.setAccomoName(rset.getString("ACCOMO_NAME"));
				accomoList.setRoomName(rset.getString("ROOM_NAME"));

				selectSales.add(accomoList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectSales;
		
	}

}
