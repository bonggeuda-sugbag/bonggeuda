package com.bonggeuda.sugbag.model.dao;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.common.queryBuilder.QueryBuilder;
import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.AccomoSearchDTO;
import com.bonggeuda.sugbag.model.dto.AttachmentDTO;
import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.CouponDTO;
import com.bonggeuda.sugbag.model.dto.OwnerQnADTO;
import com.bonggeuda.sugbag.model.dto.PointDTO;
import com.bonggeuda.sugbag.model.dto.ReviewDTO;
import com.bonggeuda.sugbag.model.dto.RoomDTO;

public class BookDAO {

	private final Properties prop;
	public BookDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"/guest/book/book-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 숙소리스트 검색
	 * @param con 
	 * @param type 숙소타입(호텔,펜션,게스트하우스)
	 * @return 숙소리스트
	 */
	public List<AccomoInfoDTO> selectAccomoList(Connection con, String type,int category) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<AccomoInfoDTO> accomoList = null;
		
		String query = prop.getProperty("selectAccomoInfo");
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, type);
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			accomoList = new ArrayList<>();
			
			while(rset.next()) {
				AccomoInfoDTO accomoInfo = new AccomoInfoDTO();
				AttachmentDTO attachment = new AttachmentDTO();
				
				accomoInfo.setAccomoNo(rset.getInt("ACCOMO_NO"));
				accomoInfo.setOwnerNo(rset.getInt("OWNER_NO"));
				accomoInfo.setAccomoName(rset.getString("ACCOMO_NAME"));
				accomoInfo.setCeoName(rset.getString("CEO_NAME"));
				accomoInfo.setType(rset.getString("ACCOMO_TYPE"));
				accomoInfo.setResgstrationNo(rset.getString("REGISTRATION_NO"));
				accomoInfo.setAddress(rset.getString("ACCOMO_ADDRESS"));
				accomoInfo.setEmail(rset.getString("ACCOMO_EMAIL"));
				accomoInfo.setHomepage(rset.getString("ACCOMO_HOMEPAGE"));
				accomoInfo.setFacility(rset.getString("ACCOMO_FACILITY"));
				accomoInfo.setPath(rset.getString("ACCOMO_PATH"));
				accomoInfo.setNear(rset.getString("ACCOMO_NEAR"));
				accomoInfo.setRule(rset.getString("ACCOMO_RULE"));
				accomoInfo.setParking(rset.getString("ACCOMO_PARKING"));
				accomoInfo.setCheckIn(rset.getString("CHECK_IN"));
				accomoInfo.setCheckOut(rset.getString("CHECK_OUT"));
				accomoInfo.setPeakStart(rset.getDate("PEAK_DATE_START"));
				accomoInfo.setPeakEnd(rset.getDate("PEAK_DATE_END"));
				attachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				accomoInfo.setAttachment(attachment);
				accomoList.add(accomoInfo);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		return accomoList;
	}
	/**
	 * 숙소의 리뷰 평점과 최저가 조회
	 * @param con
	 * @param type 숙소타입
	 * @return 숙소리뷰, 평점
	 */
	public List<Map> selectPriceNScore(Connection con, String type) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Map> priceNScore = null;
		
		Map<Integer, Integer> minPrice = null;
		Map<Integer, Double> reviewScore = null;
		
		// 최저가 구하기		
		String query = prop.getProperty("selectMinPrice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, type);
			
			rset = pstmt.executeQuery();

			priceNScore = new ArrayList<>();
			minPrice = new HashMap<>();
			while(rset.next()) {
				minPrice.put(rset.getInt("ACCOMO_NO"), rset.getInt("최저가"));
			}
			priceNScore.add(minPrice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//숙소 평점 구하기
		query = prop.getProperty("selectReviewScore");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, type);
			
			rset = pstmt.executeQuery();
			
			reviewScore = new HashMap<>();
			
			while(rset.next()) {
				reviewScore.put(rset.getInt("ACCOMO_NO"), rset.getDouble("평점"));
			}
			priceNScore.add(reviewScore);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return priceNScore;
	}

	public List<Map> selectMinPrice(Connection con, String type) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectMinPrice");
		
		List<Map> accomoPriceNStar = null;
		
		Map<Integer, Integer> minPrice = null;
		try {
			accomoPriceNStar = new ArrayList<>();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, type);
			
			rset = pstmt.executeQuery();
			
			minPrice = new HashMap<>();
			while(rset.next()) {
				minPrice.put(rset.getInt("ACCOMO_NO"), rset.getInt("최저가"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		accomoPriceNStar.add(minPrice);
		
		Map<Integer, Double> reviewScore = null;
		
		query = prop.getProperty("selectReviewScore");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, type);
			
			rset = pstmt.executeQuery();
			
			reviewScore = new HashMap<>();
			
			while(rset.next()) {
				reviewScore.put(rset.getInt("ACCOMO_NO"), rset.getDouble("평점"));
			}
			accomoPriceNStar.add(reviewScore);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return accomoPriceNStar;
	}

	/**
	 * 숙소 1개 정보 select
	 * @param con
	 * @param accomoNo 숙소번호
	 * @return 숙소정보
	 */
	public AccomoInfoDTO selectAccomoInfo(Connection con, int accomoNo, int categoryType) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		AccomoInfoDTO accomo = null;
		
		String query = prop.getProperty("selectOneAccomo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, accomoNo);
			pstmt.setInt(2, categoryType);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				accomo = new AccomoInfoDTO();
				
				AttachmentDTO attachment = new AttachmentDTO();
				accomo.setAccomoNo(rset.getInt("ACCOMO_NO"));
				accomo.setOwnerNo(rset.getInt("OWNER_NO"));
				accomo.setAccomoName(rset.getString("ACCOMO_NAME"));
				accomo.setCeoName(rset.getString("CEO_NAME"));
				accomo.setType(rset.getString("ACCOMO_TYPE"));
				accomo.setResgstrationNo(rset.getString("REGISTRATION_NO"));
				accomo.setAddress(rset.getString("ACCOMO_ADDRESS"));
				accomo.setEmail(rset.getString("ACCOMO_EMAIL"));
				accomo.setHomepage(rset.getString("ACCOMO_HOMEPAGE"));
				accomo.setFacility(rset.getString("ACCOMO_FACILITY"));
				accomo.setPath(rset.getString("ACCOMO_PATH"));
				accomo.setNear(rset.getString("ACCOMO_NEAR"));
				accomo.setRule(rset.getString("ACCOMO_RULE"));
				accomo.setParking(rset.getString("ACCOMO_PARKING"));
				accomo.setCheckIn(rset.getString("CHECK_IN"));
				accomo.setCheckOut(rset.getString("CHECK_OUT"));
				accomo.setPeakStart(rset.getDate("PEAK_DATE_START"));
				accomo.setPeakEnd(rset.getDate("PEAK_DATE_END"));
				attachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				accomo.setAttachment(attachment);
			}
			
			query = prop.getProperty("selectOneAccomoReviewScoe");
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, accomoNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				accomo.setReviewScore(rset.getDouble("평점"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return accomo;
	}

	/**
	 * 숙소의 객실정보 조회
	 * @param con
	 * @param accomoNo 숙소번호
	 * @return 객실리스트
	 */
	public List<RoomDTO> selectRoomList(Connection con, int accomoNo, int categoryType) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<RoomDTO> roomList = null;
		RoomDTO room = null;
		
		String query = prop.getProperty("selectRoomList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, accomoNo);
			pstmt.setInt(2, categoryType);
			
			rset = pstmt.executeQuery();
			
			roomList = new ArrayList<>();
			
			while(rset.next()) {
				room = new RoomDTO();
				AttachmentDTO attachment = new AttachmentDTO();
				room.setRoomNo(rset.getInt("ROOM_NO"));
				room.setAccomoNo(rset.getInt("ACCOMO_NO"));
				room.setRoomName(rset.getString("ROOM_NAME"));
				room.setRoomMax(rset.getInt("ROOM_MAX"));
				room.setRoomIntro(rset.getString("ROOM_INTRO"));
				room.setRoomFee(rset.getInt("ROOM_FEE"));
				room.setPeakFee(rset.getInt("PEAK_FEE"));
				attachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				room.setAttachment(attachment);
				
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return roomList;
	}

	/**
	 * 이용자 > 업주 문의 insert
	 * @param con 
	 * @param qna 문의 정보
	 * @return
	 */
	public int insertOwnerQnA(Connection con, OwnerQnADTO qna) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertOwnerQnA");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getContent());
			pstmt.setDate(3, qna.getWriteDate());
			pstmt.setInt(4, qna.getAccomoNo());
			pstmt.setInt(5, qna.getUserNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List selectCouponPoint(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List couponPoint = null;
		PointDTO point = null;
		CouponDTO userCoupon = null;
		
		String query = prop.getProperty("selectUserPoint");
		
		try {
			
			couponPoint = new ArrayList();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				point = new PointDTO();
				point.setPointNo(rset.getInt("POINT_NO"));
				point.setUserNo(rset.getInt("USER_NO"));
				point.setPoint(rset.getInt("POINT"));
				
				couponPoint.add(point);
			}
			
			query = prop.getProperty("selectUserCoupon");
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				userCoupon = new CouponDTO();
				userCoupon.setCouponNo(rset.getInt("COUPON_NO"));
				userCoupon.setCouponStart(rset.getDate("COUPON_START"));
				userCoupon.setCouponEnd(rset.getDate("COUPON_END"));
				userCoupon.setCouponCondition(rset.getString("COUPON_CONDITION"));
				userCoupon.setCouponUseYN(rset.getString("COUPON_USE_YN"));
				userCoupon.setUserNo(rset.getInt("USER_NO"));
				userCoupon.setCouponName(rset.getString("COUPON_NAME"));
				userCoupon.setCouponDiscount(rset.getInt("COUPON_DISCOUNT"));
				
				couponPoint.add(userCoupon);
				
			}
			
			System.out.println(couponPoint);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return couponPoint;
	}

	/**
	 * 숙소검색
	 * @param con
	 * @param search 검색조건
	 * @return 검색결과
	 */
	public List<AccomoInfoDTO> selectAccomoFacility(Connection con, AccomoSearchDTO search) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<AccomoInfoDTO> searchResult = null;
		
		String query = new QueryBuilder().queryBuiler(search).toString();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, search.getPersonnal());
			pstmt.setString(2, search.getType());
			pstmt.setInt(3, search.getCategory());
			
			rset = pstmt.executeQuery();
			
			searchResult = new ArrayList();
			
			while(rset.next()) {
				AccomoInfoDTO accomoInfo = new AccomoInfoDTO();
				AttachmentDTO attachment= new AttachmentDTO();
				accomoInfo.setAccomoNo(rset.getInt("번호"));
				accomoInfo.setAccomoName(rset.getString("이름"));
				accomoInfo.setMinPrice(rset.getInt("최저가"));
				accomoInfo.setPath(rset.getString("경로"));
				attachment.setThumbnailPath(rset.getString("사진"));
				accomoInfo.setAttachment(attachment);
				
				searchResult.add(accomoInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return searchResult;
	}

	/**
	 * 예약정보 Insert
	 * @param con
	 * @param bookInfo
	 * @return
	 */
	public int insertBookInfo(Connection con, BookDTO bookInfo) {
	
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBookInfo");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bookInfo.getBookUserName());
			pstmt.setInt(2, bookInfo.getBookPersonnel());
			pstmt.setString(3, bookInfo.getBookCheckDate());
			pstmt.setString(4, bookInfo.getBookCheckoutDate());
			pstmt.setString(5, bookInfo.getBookCheckIn());
			pstmt.setString(6, bookInfo.getRequest());
			pstmt.setInt(7, bookInfo.getRoomNo());
			pstmt.setInt(8, bookInfo.getUserNo());
			pstmt.setString(9, bookInfo.getUserPhone());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 베스트리뷰검색
	 * @param con
	 * @param accomoNo
	 * @return
	 */
	public List<ReviewDTO> selectBestReview(Connection con, int accomoNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ReviewDTO> bestReviewList = null;
		
		String query = prop.getProperty("selectBestReview");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, accomoNo);
			
			rset = pstmt.executeQuery();
			
			bestReviewList = new ArrayList<>();
			
			while(rset.next()) {
				ReviewDTO review = new ReviewDTO();
				
				review.setReviewNo(rset.getInt("리뷰번호"));
				review.setContent(rset.getString("리뷰내용"));
				review.setStarPoint(rset.getInt("별점"));
				review.setBookNo(rset.getInt("예약번호"));
				review.setTitle(rset.getString("리뷰제목"));
				review.setUpCnt(rset.getInt("좋아요"));
				review.setNickName(rset.getString("닉네임"));
				
				bestReviewList.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bestReviewList;
	}

	/**
	 * 리뷰 업 카운트
	 * @param con
	 * @param accomoNo
	 * @return
	 */
	public Map<Integer, Integer> selectReviewUpCnt(Connection con, int accomoNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Map<Integer,Integer> upCount = null;
		
		String query = prop.getProperty("selectUpCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, accomoNo);
			
			rset = pstmt.executeQuery();
			
			upCount = new HashMap<>();
			
			while(rset.next()) {
				upCount.put(rset.getInt("리뷰번호"), rset.getInt("좋아요"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return upCount;
	}

	/**
	 * 리뷰다운카운트
	 * @param con
	 * @param accomoNo
	 * @return
	 */
	public Map<Integer, Integer> selectReviewDownCnt(Connection con, int accomoNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Map<Integer,Integer> downCount = null;
		
		String query = prop.getProperty("selectDownCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, accomoNo);
			
			rset = pstmt.executeQuery();
			
			downCount = new HashMap<>();
			
			while(rset.next()) {
				downCount.put(rset.getInt("리뷰번호"), rset.getInt("싫어요"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return downCount;
	}

	/**
	 * 리뷰사진
	 * @param con
	 * @param accomoNo
	 * @param categoryNo
	 * @return
	 */
	public Map<Integer, String> selectAccomoReviewPicture(Connection con, int accomoNo, int categoryNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Map<Integer, String> reviewPictureList = null;
		
		String query = prop.getProperty("selectAccomoReviewPicture");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, accomoNo);
			pstmt.setInt(2, categoryNo);
			
			rset = pstmt.executeQuery();
			reviewPictureList = new HashMap<>();
			while(rset.next()) {
				reviewPictureList.put(rset.getInt("리뷰번호"), rset.getString("사진"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return reviewPictureList;
	}

	/**
	 * 숙소의 모든리뷰조회
	 * @param con
	 * @param accomoNo
	 * @param bestReview
	 * @return
	 */
	public List<ReviewDTO> selectAllReview(Connection con, int accomoNo, List<ReviewDTO> bestReview) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
		List<ReviewDTO> reviewList = null;
		String query = new QueryBuilder().reviewSelectBuilder(bestReview).toString();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, accomoNo);
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 4);
			rset = pstmt.executeQuery();
			
			reviewList = new ArrayList();
			
			while(rset.next()) {
				ReviewDTO review = new ReviewDTO();
				review.setReviewNo(rset.getInt("리뷰번호"));
				review.setContent(rset.getString("리뷰내용"));
				review.setStarPoint(rset.getInt("별점"));
				review.setBookNo(rset.getInt("예약번호"));
				review.setTitle(rset.getString("리뷰제목"));
				review.setNickName(rset.getString("작성자"));
				
				reviewList.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return reviewList;
	}
}
