package com.bonggeuda.sugbag.user.service;


import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dto.PageInfoDTO;
import com.bonggeuda.sugbag.user.dao.UserInfoDAO;
import com.bonggeuda.sugbag.user.dto.ReservationDetailDTO;
import com.bonggeuda.sugbag.user.dto.UserCouponDTO;
import com.bonggeuda.sugbag.user.dto.UserInfoDTO;
import com.bonggeuda.sugbag.user.dto.UserReservationStatusDTO;
import com.bonggeuda.sugbag.user.dto.UserleaveDTO;



public class UserInfoService {
	
	private final UserInfoDAO userInfoDAO;
	
	public UserInfoService() {
		userInfoDAO = new UserInfoDAO();
	}
	
	public int selectTotalCount() {
		
		Connection con = getConnection();
		
		int totalCount = userInfoDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

	public List<UserInfoDTO> selectBoardList(PageInfoDTO pageInfo) {
	
		Connection con = getConnection();
		
		List<UserInfoDTO> userList = userInfoDAO.selectUserList(con, pageInfo);
		
		close(con);
		
		return userList;
		
	}
	
	public UserInfoDTO selectDetail(String userNo) {
		
		Connection con = getConnection();
		
		UserInfoDTO userInfo = userInfoDAO.selectDetail(con, userNo);
		
		close(con);
		
		return userInfo;
	}


	public int insertCoupon(UserCouponDTO dto,  int hduserNo) {
		

		Connection con = getConnection();
		
		int insertCoupon = userInfoDAO.insertCoupon (con, dto , hduserNo);
		
		if(insertCoupon  > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return insertCoupon ;
	}

	public List<UserleaveDTO> selectLeavelist(PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<UserleaveDTO> leaveList = userInfoDAO.selectLeavelist(con, pageInfo);
		
		close(con);
		
		return leaveList;
	}

	public List<UserInfoDTO> selectSearchList(String condition, String value, PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<UserInfoDTO> searchList = userInfoDAO.searchSearchList(con, pageInfo, condition, value);
		
		close(con);
		
		return searchList;
	}

	public int searchCount(String condition, String value) {
		
		Connection con = getConnection();
		
		int totalCount = userInfoDAO.searchCount(con, condition, value);
		
		close(con);
		
		return totalCount;
		
	}

	public List<UserReservationStatusDTO> selectReservationList(PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<UserReservationStatusDTO> reservationList = userInfoDAO.selectReservationList(con, pageInfo);
		
		close(con);
		
		return reservationList;
	}

	public ReservationDetailDTO selectStatusDetail(String bookNo) {
		
		Connection con = getConnection();
		
		ReservationDetailDTO reservationDetailInfo = userInfoDAO.selectStatusDetail(con, bookNo);
		
		close(con);
		
		return reservationDetailInfo;
	}

	public List<UserleaveDTO> searchLeaveList(String condition, String value, PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<UserleaveDTO> leaveList = userInfoDAO.searchLeaveList(con, pageInfo, condition, value);
		
		close(con);
		
		return leaveList;
	}

	public int searchLeaveCount(String condition, String value) {
	
		Connection con = getConnection();
		
		int leaveCount = userInfoDAO.leaveCount(con, condition, value);
		
		close(con);
		
		return leaveCount;
	}

	public List<UserReservationStatusDTO> selectSearchIdList(String condition, String value, PageInfoDTO pageInfo) {
	
		Connection con = getConnection();
		
		List<UserReservationStatusDTO> reservationList = userInfoDAO.selectSearchIdList(con, pageInfo, condition, value);
		
		close(con);
		
		return reservationList;
	}

	public int searchBookCount(String condition, String value) {
		
		Connection con = getConnection();
		
		int bookCount = userInfoDAO.bookCount(con, condition, value);
		
		close(con);
		
		return bookCount;
	}




}
