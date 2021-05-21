package com.bonggeuda.sugbag.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.bonggeuda.sugbag.model.dao.BookDAO;
import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.OwnerQnADTO;
import com.bonggeuda.sugbag.model.dto.RoomDTO;

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
	public List<AccomoInfoDTO> selectAccomoList(String type,int category) {
		
		Connection con = getConnection();
		List<AccomoInfoDTO> accomoList = null;
		
		accomoList = bookDao.selectAccomoList(con, type, category);
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
	 * @param accomoNo 숙소번호, categoryType 첨부파일 카테고리
	 * @return
	 */
	public AccomoInfoDTO selectAccomoInfo(int accomoNo, int categoryType) {
		Connection con = getConnection();
		AccomoInfoDTO accomo = null;
		
		accomo = bookDao.selectAccomoInfo(con, accomoNo, categoryType);
		close(con);
		
		return accomo;
	}

	/**
	 * 숙소의 객실정보 조회
	 * @param accomoNo 숙소번호
	 * @return
	 */
	public List<RoomDTO> selectRoomList(int accomoNo,int categoryType) {
		
		Connection con = getConnection();
		List<RoomDTO> roomList = null;
		
		roomList = bookDao.selectRoomList(con, accomoNo, categoryType);
		
		close(con);
		return roomList;
	}

	/**
	 * 고객->업주 문의 등록
	 * @param qna 문의정보
	 * @return
	 */
	public int insertOwnerQnA(OwnerQnADTO qna) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = bookDao.insertOwnerQnA(con, qna);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}

	/**
	 * 이용자 1명의 쿠폰과 포인트를 조회
	 * @param userNo 이용자번호
	 * @return
	 */
	public List selectCouponPoint(int userNo) {
		
		Connection con = getConnection();
		
		List couponPoint = null;
		
		couponPoint = bookDao.selectCouponPoint(con, userNo);
				
		return couponPoint;
	}

}
