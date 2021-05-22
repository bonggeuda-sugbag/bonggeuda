package com.bonggeuda.sugbag.owner.mypage.dao;

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
import com.bonggeuda.sugbag.model.dto.OwnerInfoDTO;
import com.bonggeuda.sugbag.model.dto.ReportDTO;

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


	public List<ReportDTO> selectReportList(Connection con, int ownerNo) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<ReportDTO> selectReprotList = new ArrayList<ReportDTO>();
		ReportDTO reportDTO = new ReportDTO();
		
		String query = prop.getProperty("selectReportList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				reportDTO = new ReportDTO();
				
				reportDTO.setReportNo(rset.getInt("REPORT_NO"));
				reportDTO.setWriterType(rset.getString("WRITER_TYPE"));
				reportDTO.setReportReason(rset.getString("REPORT_REASON"));
				reportDTO.setMemberNo(rset.getInt("MEMBER_NO"));
				reportDTO.setReportDate(rset.getDate("REPORT_DATE"));
				reportDTO.setReportTitle(rset.getString("REPORT_TITLE"));
				reportDTO.setReportStatus(rset.getString("REPORT_STATUS"));
				reportDTO.setReportedType(rset.getString("REPORTED_TYPE"));
				reportDTO.setReportedNo(rset.getInt("REPORTED_NO"));
				
				selectReprotList.add(reportDTO);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
		return selectReprotList;
	}


	public ReportDTO selectReportDetail(Connection con, int reportNo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		ReportDTO reportDTO = new ReportDTO();
		
		String query = prop.getProperty("selctReportDetail");
		
		try {
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, reportNo);
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				reportDTO = new ReportDTO();
				
				reportDTO.setReportNo(rset.getInt("REPORT_NO"));
				reportDTO.setWriterType(rset.getString("WRITER_TYPE"));
				reportDTO.setReportReason(rset.getString("REPORT_REASON"));
				reportDTO.setMemberNo(rset.getInt("MEMBER_NO"));
				reportDTO.setReportDate(rset.getDate("REPORT_DATE"));
				reportDTO.setReportTitle(rset.getString("REPORT_TITLE"));
				reportDTO.setReportStatus(rset.getString("REPORT_STATUS"));
				reportDTO.setReportedType(rset.getString("REPORTED_TYPE"));
				reportDTO.setReportedNo(rset.getInt("REPORTED_NO"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close(rset);
			close(pstmt);
			close(con);
		}

		return reportDTO;
	}


	public String selectRejectReason(int reportNo, Connection con ) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		ReportDTO reportDTO = new ReportDTO();
		String rejectReason = "";
		
		String query = prop.getProperty("selectRejectReason");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reportNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				
				rejectReason = rset.getString("REPORT_ANSWER");
			}
		} catch (SQLException e) {

			
			e.printStackTrace();
		}


		
		
		return rejectReason;
	}

}
