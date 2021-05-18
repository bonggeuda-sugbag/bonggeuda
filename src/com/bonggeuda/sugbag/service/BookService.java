package com.bonggeuda.sugbag.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dao.BookDAO;
import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;

public class BookService {
	
	private final BookDAO bookDao;
	
	public BookService() {
		bookDao = new BookDAO();
	}

	public List<AccomoInfoDTO> selectAccomoList(String type) {
		
		Connection con = getConnection();
		List<AccomoInfoDTO> accomoList = null;
		
		accomoList = bookDao.selectAccomoList(con, type);
		close(con);
		return accomoList;
	}

}
