package com.bonggeuda.sugbag.owner.regist.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import com.bonggeuda.sugbag.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.owner.regist.dao.AccomoDAO;

public class AccomoService {

	/*AccomoDAO와 연결할 필드 변수*/
	private AccomoDAO accomoDAO = new AccomoDAO();
	
	public int InsertAccomoServlet(AccomoDTO accomoDTO) {

		Connection con = getConnection();

		/*Connection과 함께 정보를 전달하여 조회.*/
		int inserAccomo = accomoDAO.InsertAccomo(con, accomoDTO);
		
		if(inserAccomo > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return inserAccomo;
	}

	public int selectEnNo() {

		Connection con = getConnection();
		
		int slectEnNo = accomoDAO.selectEnNo(con);
		
		close(con);
		
		return slectEnNo;
	}

}
