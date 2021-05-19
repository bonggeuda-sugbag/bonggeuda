package com.bonggeuda.sugbag.accomo.model.service;

import java.sql.Connection;

import com.bonggeuda.sugbag.accomo.model.dao.AccomoDAO;
import com.bonggeuda.sugbag.accomo.model.dto.AccomoDTO;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

public class AccomoService {

	/*EmployeeDAO와 연결할 필드 변수*/
	private AccomoDAO accomoDAO = new AccomoDAO();
	
	public int InsertAccomoServlet(AccomoDTO accomoDTO) {

		Connection con = getConnection();

		/*Connection과 함께 정보를 전달하여 조회.*/
		int inserAccomo = accomoDAO.InsertAccomo(con, accomoDTO); //전달할땐 DTO에 값을 넣어 행 형태(empDTO)로 전달 -> 그리고 InsertEmpToDb 메소드에서 int형태의 값을 반환받아옴
		
		close(con);
		
		return inserAccomo;
	}



}
