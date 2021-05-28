package com.bonggeuda.sugbag.owner.book.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dto.SalesDTO;
import com.bonggeuda.sugbag.owner.book.dao.SalesDAO;

public class SalesService {

	private SalesDAO salesDAO = new SalesDAO();

	public List<SalesDTO> selectSales(int ownerNo) {
		
		Connection con = getConnection();
		
		List<SalesDTO> selectSales = salesDAO.selectSales(con, ownerNo);
		
		close(con);
		
		return selectSales;
	}

}
