package com.bonggeuda.sugbag.owner.book.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.BookHistoryDTO;
import com.bonggeuda.sugbag.model.dto.BookingContentDTO;
import com.bonggeuda.sugbag.owner.book.dao.BookingListSelectDAO;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;;

public class BookListSelectService {
	
	private BookingListSelectDAO bookDAO = new BookingListSelectDAO();

	public List<BookDTO> bookListSelect(int ownerNo) {
		
		Connection con = getConnection();
		
		List<BookDTO> bookListSelect = bookDAO.selectBookList(con, ownerNo);
		
		close(con);
		
		return bookListSelect;
	}

	public BookingContentDTO selectBookContent(int bookNo) {

		Connection con = getConnection();
		
		BookingContentDTO bookConDTO = bookDAO.selectBookContent(con, bookNo);
		
		close(con);
		
		return bookConDTO;
	}

	public List<BookDTO> bookPastListSelect(int ownerNo) {
		
		Connection con = getConnection();
		
		List<BookDTO> bookListSelect = bookDAO.selectBookPastList(con, ownerNo);
		
		close(con);
		
		return bookListSelect;
		
		
	}

	public int bookAllowUpdate(int bookNo) {

		Connection con = getConnection();
		
		int bookAllowUpdate = bookDAO.bookAllowUpdate(con,bookNo);
		
		close(con);
		
		
		if(bookAllowUpdate > 0) {
			commit(con);
		}else {
			rollback(con);
		}
	
		
		return bookAllowUpdate;
	}

	public int insertBookHistory(int bookNo) {

		Connection con = getConnection();
		
		int bookHistoryInsert = bookDAO.bookHistoryInsert(con,bookNo);
		
		if(bookHistoryInsert > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return bookHistoryInsert;
	}

	public int bookRejectUpdate(int bookNo) {
		
		Connection con = getConnection();
		
		int bookRejectUpdate = bookDAO.bookRejectUpdate(con, bookNo);
		
		close(con);
		
		
		if(bookRejectUpdate > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return bookRejectUpdate;
	}
	
	public int bookRejectHistoryInsert(int bookNo, String rejecetReason) {

		Connection con = getConnection();

		int bookHistoryInsert = bookDAO.bookRejectHistoryInsert(con, bookNo , rejecetReason);
		
		if(bookHistoryInsert > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		

		return bookHistoryInsert;
	}




}