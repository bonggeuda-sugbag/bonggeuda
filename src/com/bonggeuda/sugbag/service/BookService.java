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
	 * 숙소리스트 검색
	 * @param type 숙소타입(호텔,펜션,게스트하우스)
	 * @return 선택한 타입의 숙소리스트
	 */
	public List<AccomoInfoDTO> selectAccomoList(String type) {
		
		Connection con = getConnection();
		List<AccomoInfoDTO> accomoList = null;
		
		accomoList = bookDao.selectAccomoList(con, type);
		close(con);
		return accomoList;
	}

	/**
	 * 최저가 검색
	 * @param type 숙소타입
	 * @return 숙소의 최저값
	 */
	public List<Map> selectMinPrice(String type) {
		
		Connection con = getConnection();
		List<Map> accomoPriceNStar = null;
		accomoPriceNStar = bookDao.selectMinPrice(con, type);
		
		close(con);
		return accomoPriceNStar;
	}

}
