package com.bonggeuda.sugbag.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.bonggeuda.sugbag.model.dao.BookDAO;
import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;

public class BookService {
	
	private final BookDAO bookDao;
	
	public BookService() {
		bookDao = new BookDAO();
	}

	/**

	 * 숙소타입별 리스트 조회
	 * @param type 숙소타입
	 * @return 타입별 숙소리스트

	 */
	public List<AccomoInfoDTO> selectAccomoList(String type) {
		
		Connection con = getConnection();
		List<AccomoInfoDTO> accomoList = null;
		
		accomoList = bookDao.selectAccomoList(con, type);
		close(con);
		return accomoList;
	}


	/**
	 * 숙소 최저가, 평점 조회
	 * @param type 숙소타입
	 * @return 숙소 최저가, 평점
	 */
	public List<Map> selectPriceNstar(String type) {
		
		Connection con = getConnection();
		List<Map> priceNrvScore = null;
		
		priceNrvScore = bookDao.selectPriceNScore(con,type);
		close(con);
		return priceNrvScore;

	}

	/**
	 * 숙소 1개 정보 조회
	 * @param booksvc
	 * @return
	 */
	public AccomoInfoDTO selectAccomoInfo(int accomoNo) {
		Connection con = getConnection();
		AccomoInfoDTO accomo = null;
		
		accomo = bookDao.selectAccomoInfo(con, accomoNo);
		close(con);
		
		return accomo;
	}

}
