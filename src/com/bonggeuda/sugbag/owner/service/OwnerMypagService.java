package com.bonggeuda.sugbag.owner.service;


import java.sql.Connection;

import com.bonggeuda.sugbag.owner.dao.OwnerMypageDAO;
import com.bonggeuda.sugbag.owner.dto.OwnerInfoDTO;

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





}
