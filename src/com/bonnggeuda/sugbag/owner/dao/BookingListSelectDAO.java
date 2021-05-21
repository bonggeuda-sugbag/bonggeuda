package com.bonnggeuda.sugbag.owner.dao;

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
		System.out.println(query);
		
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
			       				
				selectBookedList.add(bookDTO);
				
			}
			System.out.println(selectBookedList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectBookedList;
	}

}
