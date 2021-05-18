package com.bonggeuda.sugbag.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.bonggeuda.sugbag.model.dao.MypageDAO;
import com.bonggeuda.sugbag.model.dto.PointDTO;

public class MypageService {
	
	private MypageDAO mypageDAO = new MypageDAO();

	
	/**
	 * 가지고 있는 포인트 정보 조회
	 * @param userNo 사용자번호
	 * @return
	 */
	public PointDTO pointSelect(int userNo) {
		System.out.println("서블릿요청222");
		Connection con = getConnection();
		
		PointDTO pointDTO = mypageDAO.pointSelect(con, userNo);
		
		close(con);
		
		return pointDTO;
	}

}
