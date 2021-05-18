package com.bonggeuda.sugbag.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dao.MypageDAO;
import com.bonggeuda.sugbag.model.dto.PointDTO;
import com.bonggeuda.sugbag.model.dto.PointHistoryDTO;

public class MypageService {
	
	private MypageDAO mypageDAO = new MypageDAO();

	
	/**
	 * 가지고 있는 포인트 정보 조회
	 * @param userNo 사용자번호
	 * @return
	 */
	public PointDTO pointSelect(int userNo) {

		Connection con = getConnection();
		
		PointDTO pointDTO = mypageDAO.pointSelect(con, userNo);
		
		close(con);
		
		return pointDTO;
	}


	/**
	 * 포인트 이력 정보 조회
	 * @param userNo 
	 * @return
	 */
	public List<PointHistoryDTO> pointHistorySelect(int userNo) {
		
		System.out.println("서블릿요청22222");
		
		Connection con = getConnection();
		
		List<PointHistoryDTO> pointHistory = mypageDAO.pointHistorySelect(con,userNo);
		
		close(con);
		
		return pointHistory;
	}



}
