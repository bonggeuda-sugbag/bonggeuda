package com.bonggeuda.sugbag.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bonggeuda.sugbag.model.dao.BookDAO;
import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.AccomoSearchDTO;
import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.CouponHistoryDTO;
import com.bonggeuda.sugbag.model.dto.OwnerQnADTO;
import com.bonggeuda.sugbag.model.dto.PaymentDTO;
import com.bonggeuda.sugbag.model.dto.PointHistoryDTO;
import com.bonggeuda.sugbag.model.dto.ReviewDTO;
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

	/**
	 * 숙소 검색
	 * @param type
	 * @param checkList
	 * @param category
	 * @return
	 */
	public List<AccomoInfoDTO> selectAccomoFacility(AccomoSearchDTO search) {

		Connection con = getConnection();
		
		List<AccomoInfoDTO> seachResult = null;  
		seachResult = bookDao.selectAccomoFacility(con, search);  
		
		close(con);
		return seachResult;
	}

	/**
	 * 예약정보INSERT
	 * @param bookInfo 예약정보
	 * @return
	 */
	public int insertBookInfo(BookDTO bookInfo) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = bookDao.insertBookInfo(con, bookInfo);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}

	/**
	 * 숙소의 베스트리뷰조회
	 * @param accomoNo 숙소번호
	 * @return
	 */
	public List<ReviewDTO> selectBestReview(int accomoNo) {
		
		Connection con = getConnection();
		
		List<ReviewDTO> bestReview = null;
		
		bestReview = bookDao.selectBestReview(con, accomoNo);
		
		close(con);
		
		return bestReview;
	}

	/**
	 * 리뷰 업다운 갯수 카운트
	 * @param accomoNo
	 * @return
	 */
	public List<Map<Integer, Integer>> selectUpDownCnt(int accomoNo) {

		Connection con = getConnection();
		
		List<Map<Integer,Integer>> upNdown = null;
		
		Map<Integer,Integer> upCnt = null;
		Map<Integer,Integer> downCnt = null;
		
		upNdown = new ArrayList<>();
		upCnt = bookDao.selectReviewUpCnt(con, accomoNo);
		downCnt = bookDao.selectReviewDownCnt(con, accomoNo);
		upNdown.add(upCnt);
		upNdown.add(downCnt);
		
		return upNdown;
	}

	/**
	 * 리뷰사진 조회용
	 * @param accomoNo
	 * @param categoryNo
	 * @return
	 */
	public Map<Integer, String> selectReviewPicture(int accomoNo, int categoryNo) {

		Connection con = getConnection();
		Map<Integer, String> reviewPicture = null;
		
		reviewPicture = bookDao.selectAccomoReviewPicture(con, accomoNo, categoryNo); 
		
		close(con);
		return reviewPicture;
	}

	/**
	 * 숙소의 베스트리뷰를 제외한 전체 리뷰
	 * @param bestReview 베스트리뷰 제외를 위한 매개변수
	 * @param accomoNo 숙소번호
	 * @return
	 */
	public List<ReviewDTO> selectAllReviewList(List<ReviewDTO> bestReview, int accomoNo) {
		
		Connection con = getConnection();
		List<ReviewDTO> selectAllReviewList = bookDao.selectAllReview(con, accomoNo, bestReview);
		
		close(con);
		return selectAllReviewList;
	}

	/**
	 * 결제정보 insert
	 * @param 
	 * @return
	 */
	public int insertPaymentInfo(PaymentDTO payment) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = bookDao.insertPaymentInfo(con, payment);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}

	/**
	 * 포인트 획득 insert
	 * @param pointGet
	 * @return
	 */
	public int insertPointGet(PointHistoryDTO pointGet) {

		Connection con = getConnection();
		int result = 0;
		
		result = bookDao.insertPointGet(con, pointGet);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

	/**
	 * 쿠폰사용시 이력 INSERT
	 * @param couponUse
	 * @return
	 */
	public int insertCouponUse(CouponHistoryDTO couponUse) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = bookDao.insertCouponUse(con, couponUse);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}

	/**
	 * 포인트사용시 이력INSERT
	 * @param pointUse
	 * @return
	 */
	public int insertPointUse(PointHistoryDTO pointUse) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = bookDao.insertPointUse(con, pointUse);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}

}
