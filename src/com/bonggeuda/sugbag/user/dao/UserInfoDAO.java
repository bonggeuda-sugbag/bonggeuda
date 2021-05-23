package com.bonggeuda.sugbag.user.dao;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.model.dto.PageInfoDTO;
import com.bonggeuda.sugbag.user.dto.ReservationDetailDTO;
import com.bonggeuda.sugbag.user.dto.UserCouponDTO;
import com.bonggeuda.sugbag.user.dto.UserInfoDTO;
import com.bonggeuda.sugbag.user.dto.UserReservationStatusDTO;
import com.bonggeuda.sugbag.user.dto.UserleaveDTO;


public class UserInfoDAO {
	
	private Properties prop;
	
	public UserInfoDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/userInfo/userInfo-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


	public int selectTotalCount(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectTotalCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		System.out.println(totalCount);
		return totalCount;
	}
	
	public List<UserInfoDTO> selectUserList(Connection con, PageInfoDTO pageInfo) { // 사용자관리 리스트 select
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<UserInfoDTO> userList = null;
		
		String query = prop.getProperty("selectBoardList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
		
			rset = pstmt.executeQuery();
			
			userList = new ArrayList<>();
			
			while(rset.next()) {
				UserInfoDTO userInfo = new UserInfoDTO();
						
				userInfo.setUserNo(rset.getInt("USER_NO"));
				userInfo.setName(rset.getString("USER_NICKNAME"));
				userInfo.setEmail(rset.getString("USER_ID"));
				userInfo.setPhoneNumber(rset.getString("USER_PHONE"));
				
				userList.add(userInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userList;
	}


	public UserInfoDTO selectDetail(Connection con, String userNo) {  // 사용자 관리  userNo로 select
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectDetail");
		
		UserInfoDTO userInfo = new UserInfoDTO();
		
		try {
		
			pstmt = con.prepareStatement(query);
//			System.out.println("userNo :" + userNo);
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
//				System.out.println("아이디이이ㅣ이이이이이잉 : " +rset.getString("USER_ID"));		
				userInfo.setEmail(rset.getString("USER_ID"));
				userInfo.setPassword(rset.getString("USER_PWD"));
				userInfo.setName(rset.getString("USER_NICKNAME"));
				userInfo.setPhoneNumber(rset.getString("USER_PHONE"));
				userInfo.setPoint(rset.getInt("POINT"));
				userInfo.setUserNo(rset.getInt("USER_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return userInfo;
	}


	public int insertCoupon (Connection con, UserCouponDTO dto, int hduserNo) { // 사용자 쿠폰 추가 insert
		System.out.println(dto);
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertCoupon");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setDate(1, dto.getStartDate());
			pstmt.setDate(2, dto.getEndDate());
			pstmt.setInt(3, dto.getCondition());
			pstmt.setInt(4, hduserNo); //히든으로 숨겨서 가져온 회원번호
			pstmt.setString(5, dto.getCouponName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return result;
	}


	public List<UserleaveDTO> selectLeavelist(Connection con, PageInfoDTO pageInfo) { // 탈퇴회원 list select
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<UserleaveDTO> leaveList = null;
		
		String query = prop.getProperty("selectWithdrawList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
		
			rset = pstmt.executeQuery();
			
			leaveList = new ArrayList<>();
			
			while(rset.next()) {
				UserleaveDTO leaveInfo = new UserleaveDTO();
						
				leaveInfo.setLeaveNo(rset.getInt("WITHDRAW_NO"));
				leaveInfo.setEmail(rset.getString("USER_ID"));
				leaveInfo.setReason(rset.getString("WITHDRAW_REASON"));
				leaveInfo.setLeaveDate(rset.getDate("WITHDRAWDATE"));

				leaveList.add(leaveInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return leaveList;
	}


	public List<UserInfoDTO> searchSearchList(Connection con, PageInfoDTO pageInfo, String condition, String value) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = null;
		List<UserInfoDTO> userList = null;
		
		if(condition.equals("userId")) {
			
			query = prop.getProperty("selectSearch");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			pstmt.setString(3, value);

			rset = pstmt.executeQuery();
			
			userList = new ArrayList<>();
			
			while(rset.next()) {
				UserInfoDTO userInfo = new UserInfoDTO();
						
				userInfo.setUserNo(rset.getInt("USER_NO"));
				userInfo.setName(rset.getString("USER_NICKNAME"));
				userInfo.setEmail(rset.getString("USER_ID"));
				userInfo.setPhoneNumber(rset.getString("USER_PHONE"));
				
				userList.add(userInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userList;
	}


	public int searchCount(Connection con, String condition, String value) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = null;
		int totalCount = 0;
		
		if(condition.equals("userId")) {
			
			query = prop.getProperty("selectSearchCount");
		}
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalCount;

	}


	public List<UserReservationStatusDTO> selectReservationList(Connection con, PageInfoDTO pageInfo) { //사용자 예약현황 list select
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<UserReservationStatusDTO> reservationList = null;
		
		String query = prop.getProperty("selectBookList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
		
			rset = pstmt.executeQuery();
			
			reservationList = new ArrayList<>();
			
			while(rset.next()) {
				
				UserReservationStatusDTO reservationInfo = new UserReservationStatusDTO();
						
				reservationInfo.setBookNo(rset.getInt("BOOK_NO"));
				reservationInfo.setName(rset.getString("BOOK_USER_NAME"));
				reservationInfo.setEmail(rset.getString("USER_ID"));
				reservationInfo.setPrice(rset.getInt("PAYMENT_AMOUNT"));
				reservationInfo.setPeopleCount(rset.getInt("BOOK_PERSONNEL"));
				reservationInfo.setCheckDate(rset.getString("BOOK_CHECK_DATE"));
				reservationInfo.setCheckOutDate(rset.getString("BOOK_CHECKOUT_DATE"));


				reservationList.add(reservationInfo);
				System.out.println("어디있니잉"  + reservationInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reservationList;
	}


	public ReservationDetailDTO selectStatusDetail(Connection con, String bookNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectReservationDetail");
		
		ReservationDetailDTO reservationDetailInfo = new ReservationDetailDTO();
		
		try {
		
			pstmt = con.prepareStatement(query);
			System.out.println("bookNo :" + bookNo);
			pstmt.setString(1, bookNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
//				System.out.println("아이디이이ㅣ이이이이이잉 : " +rset.getString("USER_ID"));		
				reservationDetailInfo.setEmail(rset.getString("USER_ID"));
				reservationDetailInfo.setName(rset.getString("USER_NICKNAME"));
				reservationDetailInfo.setAccomoName(rset.getString("ACCOMO_NAME"));
				reservationDetailInfo.setRoomName(rset.getString("ROOM_NAME"));
				reservationDetailInfo.setPrice(rset.getInt("PAYMENT_AMOUNT"));				
				reservationDetailInfo.setPeopleCount(rset.getInt("BOOK_PERSONNEL"));
				reservationDetailInfo.setCheckDate(rset.getString("BOOK_CHECK_DATE"));
				reservationDetailInfo.setCheckOutDate(rset.getString("BOOK_CHECKOUT_DATE"));
				reservationDetailInfo.setReservationStatus(rset.getString("BOOK_APPROVE_YN"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return reservationDetailInfo;
	}


	public List<UserleaveDTO> searchLeaveList(Connection con, PageInfoDTO pageInfo, String condition, String value) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = null;
		List<UserleaveDTO> leaveList = null;
		
		if(condition.equals("userId")) {
			
			query = prop.getProperty("selectLeaveList");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			pstmt.setString(3, value);

			rset = pstmt.executeQuery();
			
			leaveList = new ArrayList<>();
			
			while(rset.next()) {
				UserleaveDTO withdrawInfo = new UserleaveDTO();
						
				withdrawInfo.setLeaveNo(rset.getInt("WITHDRAW_NO"));
				withdrawInfo.setEmail(rset.getString("USER_ID"));
				withdrawInfo.setReason(rset.getString("WITHDRAW_REASON"));
				withdrawInfo.setLeaveDate(rset.getDate("WITHDRAWDATE"));
				
				leaveList.add(withdrawInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return leaveList;
	}


	public int leaveCount(Connection con, String condition, String value) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = null;
		int leaveCount = 0;
		
		if(condition.equals("userId")) {
			
			query = prop.getProperty("selectLeaveCount");
		}
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				leaveCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return leaveCount;
	}


	public List<UserReservationStatusDTO> selectSearchIdList(Connection con, PageInfoDTO pageInfo, String condition, String value) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = null;
		List<UserReservationStatusDTO> reservationList = null;
		
		if(condition.equals("userId")) {
			
			query = prop.getProperty("selectIdBookList");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			pstmt.setString(3, value);

			rset = pstmt.executeQuery();
			
			reservationList = new ArrayList<>();
			
			while(rset.next()) {
				
				UserReservationStatusDTO reservationInfo = new UserReservationStatusDTO();
				
				reservationInfo.setBookNo(rset.getInt("BOOK_NO"));
				reservationInfo.setName(rset.getString("BOOK_USER_NAME"));
				reservationInfo.setEmail(rset.getString("USER_ID"));
				reservationInfo.setPrice(rset.getInt("PAYMENT_AMOUNT"));
				reservationInfo.setPeopleCount(rset.getInt("BOOK_PERSONNEL"));
				reservationInfo.setCheckDate(rset.getString("BOOK_CHECK_DATE"));
				reservationInfo.setCheckOutDate(rset.getString("BOOK_CHECKOUT_DATE"));
				
				reservationList.add(reservationInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reservationList;
	}


	public int bookCount(Connection con, String condition, String value) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = null;
		int bookCount = 0;
		
		if(condition.equals("userId")) {
			
			query = prop.getProperty("selectBookCount");
		}
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bookCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bookCount;
	}
}



