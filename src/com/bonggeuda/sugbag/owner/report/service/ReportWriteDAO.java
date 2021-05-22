package com.bonggeuda.sugbag.owner.report.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;

public class ReportWriteDAO {
	
	private Properties prop = new Properties();

	
	public ReportWriteDAO() {
	
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"/owner/report/report-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public int insertReport(Connection con, String writerType, String reportedType, int userNo, int ownerNo, String reportTitle,
			String reportContent) {
		
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertReport");
		
		int insertReport = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, writerType);
			pstmt.setString(2, reportContent);
			pstmt.setInt(3, ownerNo);
			pstmt.setString(4, reportTitle);
			pstmt.setString(5, reportedType);
			pstmt.setInt(6, userNo);
			
			insertReport = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		
		
		
		return insertReport;
	}

}
