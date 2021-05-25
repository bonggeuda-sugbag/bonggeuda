package com.bonggeuda.sugbag.owner.book.dao;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;

public class BookingQnADAO {

	private Properties prop = new Properties();

	public BookingQnADAO() {

		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"/owner/bookingList/bookingList-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectTotalCount(Connection con) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		/* 반환시킬 변수 지정 */
		int totalCount = 0;
		
		String query = prop.getProperty("selectTotalCount");

		//잘 넘어왔는지 확인용 출력
		System.out.println(query);
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 1);
			
			rset = pstmt.executeQuery();

			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
     
		return totalCount;
	}

}
