package com.bonnggeuda.sugbag.owner.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonnggeuda.sugbag.owner.dao.BookingListSelectDAO;

public class BookListSelectService {
	
	private BookingListSelectDAO bookDAO = new BookingListSelectDAO();

	public List<BookDTO> bookListSelect(int ownerNo) {
		
		Connection con = getConnection();
		
		List<BookDTO> bookListSelect = bookDAO.selectBookList(con, ownerNo);
		
		close(con);
		
		return bookListSelect;
	}

}
