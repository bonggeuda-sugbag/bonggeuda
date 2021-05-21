package com.bonggeuda.sugbag.owner.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.BookingContentDTO;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

public class BookingListSelectDAO {
	private Properties prop = new Properties();

	
	public BookingListSelectDAO() {
	
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"/owner/bookingList/bookingList-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public List<BookDTO> selectBookList(Connection con, int ownerNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BookDTO> selectBookedList = new ArrayList<>();
		/* 반환 시킬 변수를 지정하자*/
		BookDTO bookDTO = new BookDTO();
		
		String query = prop.getProperty("selectBookingList");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				bookDTO = new BookDTO();
				
				bookDTO.setBookNo(rset.getInt("BOOK_NO"));
				bookDTO.setBookUserName(rset.getString("BOOK_USER_NAME"));
				bookDTO.setBookPersonnel(rset.getInt("BOOK_PERSONNEL"));
				bookDTO.setBookCheckDate(rset.getString("BOOK_CHECK_DATE")); // 디비에서도 문자열 값임.
				bookDTO.setBookCheckoutDate(rset.getString("BOOK_CHECK_DATE"));
				bookDTO.setBookApproveYn(rset.getString("BOOK_APPROVE_YN"));
				bookDTO.setBookCheckIn(rset.getString("BOOK_CHECK_IN"));
				bookDTO.setRequest(rset.getString("REQUEST"));
				bookDTO.setRoomName(rset.getString("ROOM_NAME"));
				bookDTO.setAccomoName(rset.getString("ACCOMO_NAME"));
				bookDTO.setUserPhone(rset.getString("USER_PHONE"));
				bookDTO.setBookStatusYNC(rset.getString("BOOK_STATUS_YNC"));

			       				
				selectBookedList.add(bookDTO);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectBookedList;
	}

	
	
	/**
	 * 예약 상세내용 보는 메소드
	 * @param con
	 * @param bookNo
	 * @return
	 */
	public BookingContentDTO selectBookContent(Connection con, int bookNo) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		BookingContentDTO bookConDTO = new BookingContentDTO();
		
		String query = prop.getProperty("selectBookContent");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bookNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				bookConDTO = new BookingContentDTO();
				
				bookConDTO.setBookNo(rset.getInt("BOOK_NO"));
				bookConDTO.setBookUserName(rset.getString("BOOK_USER_NAME"));
				bookConDTO.setBookPersonnel(rset.getInt("BOOK_PERSONNEL"));
				bookConDTO.setBookCheckDate(rset.getString("BOOK_CHECK_DATE"));
				bookConDTO.setBookCheckoutDate(rset.getString("BOOK_CHECKOUT_DATE"));
				bookConDTO.setBookCheckIn(rset.getString("BOOK_CHECK_IN"));
				bookConDTO.setRequest(rset.getString("REQUEST"));
				bookConDTO.setRoomName(rset.getString("ROOM_NAME"));
				bookConDTO.setPaymentFee(rset.getInt("ROOM_FEE"));
				bookConDTO.setAccomoName(rset.getString("ACCOMO_NAME"));
				bookConDTO.setEmail(rset.getString("USER_ID"));
				bookConDTO.setUserPhone(rset.getString("USER_PHONE"));
				bookConDTO.setBookRequestDate(rset.getString("PAYMENT_TIME"));
				bookConDTO.setPaymentMethod(rset.getString("PAYMENT_METHOD"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return bookConDTO;
	}

	public List<BookDTO> selectBookPastList(Connection con, int ownerNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BookDTO> selectBookedList = new ArrayList<>();
		/* 반환 시킬 변수를 지정하자*/
		BookDTO bookDTO = new BookDTO();
		
		String query = prop.getProperty("selectPastBookingList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				bookDTO = new BookDTO();
				
				bookDTO.setBookNo(rset.getInt("BOOK_NO"));
				bookDTO.setBookUserName(rset.getString("BOOK_USER_NAME"));
				bookDTO.setBookPersonnel(rset.getInt("BOOK_PERSONNEL"));
				bookDTO.setBookCheckDate(rset.getString("BOOK_CHECK_DATE")); // 디비에서도 문자열 값임.
				bookDTO.setBookCheckoutDate(rset.getString("BOOK_CHECK_DATE"));
				bookDTO.setBookApproveYn(rset.getString("BOOK_APPROVE_YN"));
				bookDTO.setBookCheckIn(rset.getString("BOOK_CHECK_IN"));
				bookDTO.setRequest(rset.getString("REQUEST"));
				bookDTO.setRoomName(rset.getString("ROOM_NAME"));
				bookDTO.setAccomoName(rset.getString("ACCOMO_NAME"));
				bookDTO.setUserPhone(rset.getString("USER_PHONE"));
				bookDTO.setBookStatusYNC(rset.getString("BOOK_STATUS_YNC"));
			       				
				selectBookedList.add(bookDTO);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectBookedList;
	}

	public int bookAllowUpdate(Connection con, int bookNo) {

		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("bookAllowUpadte");
		
		int bookAllowUpdate = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, bookNo);
			
			
			bookAllowUpdate = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		
		return bookAllowUpdate;
	}
}






















