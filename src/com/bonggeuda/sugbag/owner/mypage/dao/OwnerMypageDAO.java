package com.bonggeuda.sugbag.owner.mypage.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.model.dto.NoticeDTO;
import com.bonggeuda.sugbag.model.dto.OwnerInfoDTO;
import com.bonggeuda.sugbag.model.dto.ReportDTO;
import com.bonggeuda.sugbag.model.dto.RequestTaxBillDTO;
import com.bonggeuda.sugbag.model.dto.SettlementDTO;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

public class OwnerMypageDAO {
	
	private Properties prop = new Properties();
	
	public OwnerMypageDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/mypage/mypage-mapper.xml"));
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
				ownerInfoDTO.setOwnerNo(rset.getInt("OWNER_NO"));
				
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
		} finally {
			close(pstmt);
			close(con);
			close(rset);
		}


		
		
		return rejectReason;
	}


	public int ownerWithdrawUpdateDAO(Connection con, int ownerNo) {
		
		PreparedStatement pstmt = null;

		String query = prop.getProperty("ownerWithdrawUpdate");
		
		int ownerWithdrawUpdate = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, ownerNo);
			
			ownerWithdrawUpdate = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		return ownerWithdrawUpdate;
	}

	public List<RequestTaxBillDTO> selectTaxBillListDAO(Connection con, int ownerNo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<RequestTaxBillDTO> selectTaxBillList = new ArrayList<RequestTaxBillDTO>();
		RequestTaxBillDTO requestTaxBillDTO = new RequestTaxBillDTO();
		
		String query = prop.getProperty("selectTaxBillList");
		
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1,ownerNo );
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				requestTaxBillDTO = new RequestTaxBillDTO();
				
				requestTaxBillDTO.setAccomoNo(rset.getInt("ACCOMO_NO"));
				requestTaxBillDTO.setRequestDate(rset.getString("REQUEST_DATE"));
				requestTaxBillDTO.setRequestStartDate(rset.getString("REQUEST_START"));
				requestTaxBillDTO.setRequestEndDate(rset.getString("REQUEST_END"));
				requestTaxBillDTO.setRequestNo(rset.getInt("REQUEST_NO"));
				requestTaxBillDTO.setResponseYn(rset.getString("RESPONSE_YN"));
				requestTaxBillDTO.setAccomoName(rset.getString("ACCOMO_NAME"));
				
				selectTaxBillList.add(requestTaxBillDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
			close(rset);
		}

		
		return selectTaxBillList;
	}

	public int insertRequestTaxBillDAO(Connection con, int ownerNo, Date startDate, Date endDate, int accomoNo) {
		
		PreparedStatement pstmt = null;

		ResultSet rset = null;
		
		int insertRequestTaxBill = 0;
		
		RequestTaxBillDTO taxBillDTO = new RequestTaxBillDTO();
		
		String query = prop.getProperty("insertRequestTaxBill");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			pstmt.setInt(3, accomoNo);
			
			insertRequestTaxBill = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		
		
		return insertRequestTaxBill;
	}

	public List<AccomoDTO> selectAccomoNamesDAO(int ownerNo, Connection con) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		AccomoDTO accomoDTO = new AccomoDTO();
		
		List<AccomoDTO> selectAccomoNames = new ArrayList<AccomoDTO>();
		
		String query = prop.getProperty("selectAccomoNames");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, ownerNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()){
				accomoDTO = new AccomoDTO();
				
				accomoDTO.setAccomoName(rset.getString("ACCOMO_NAME"));
				accomoDTO.setAccomoNo(rset.getInt("ACCOMO_NO"));
				
				selectAccomoNames.add(accomoDTO);
			}
			
			rset = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return selectAccomoNames;
	}

	public int selectAccomoNoDAO(Connection con, String accomoName, int ownerNo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		int accomoNo = 0;
		
		String query = prop.getProperty("selectAccomoNo");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, accomoName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				accomoNo = rset.getInt("ACCOMO_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return accomoNo;
	}

	public List<SettlementDTO> selectStl(Connection con) {
		
		System.out.println("들어왔나");
		
		Statement stmt = null;
		
		ResultSet rset = null;

		/* 반환시킬 변수 지정 */
		List<SettlementDTO> selectStl = null;
		
		/* --> selectedAll 가지고 xml감 */
		String query = prop.getProperty("selectStl");
		
		/*쿼리문 잘 실행되는지 출력*/
		System.out.println(query);

		/*디비에 들어가서 쿼리문에 따른 값 받아오기*/
		try {
			stmt = con.prepareStatement(query);
			
			rset = stmt.executeQuery(query);
			selectStl = new ArrayList<>(); //모든 행을 다 받아서 최종 리스트를 만듬
			
			while(rset.next()) {
				
				SettlementDTO stl = new SettlementDTO();

				stl.setReqStlNo(rset.getInt("REQUEST_STL_NO"));
				stl.setAccomoNo(rset.getInt("ACCOMO_NO"));
				stl.setReqDate(rset.getDate("REQUEST_DATE"));
				stl.setStlYn(rset.getString("STL_YN"));
				
				selectStl.add(stl); //한 행씩 저장됨
			}
			
			System.out.println(selectStl);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return selectStl;
	}

}
