package com.bonggeuda.sugbag.owner.mypage.service;


import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dto.OwnerInfoDTO;
import com.bonggeuda.sugbag.model.dto.ReportDTO;
import com.bonggeuda.sugbag.owner.mypage.dao.OwnerMypageDAO;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

public class OwnerMypagService {
	
	private OwnerMypageDAO ownerDAO = new OwnerMypageDAO();
	
	

	public OwnerInfoDTO selectOwnerInfo(int ownerNo) {

		/* Connection 생성 */
		Connection con = getConnection();
		
		OwnerInfoDTO selectOwner = ownerDAO.selectOwner(con,ownerNo);
		
		/* 생각 : 트랜잭션 처리가 필요한 상황인가? (커밋,롤백) <- 셀렉트니 필요없지*/
		
		/* COnnection 닫기*/
		close(con);
		
		return selectOwner;
	}



	public List<ReportDTO> seletReportList(int ownerNo) {

		Connection con = getConnection();
		
		List<ReportDTO> selectReportList = ownerDAO.selectReportList(con,ownerNo);

		
		close(con);
		
		return selectReportList;
	}



	public ReportDTO selectReportDetail(int reportNo) {

		Connection con = getConnection();

		ReportDTO reportDTO = ownerDAO.selectReportDetail(con,reportNo);
		
		close(con);
		
		return reportDTO;
	}



	public String selectRejectReason(int reportNo) {
		Connection con = getConnection();
		
		String selectRejectReason = ownerDAO.selectRejectReason(reportNo,con);
		
		close(con);
		
		return selectRejectReason;
	}







}
