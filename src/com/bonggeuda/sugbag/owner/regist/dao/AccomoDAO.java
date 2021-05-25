package com.bonggeuda.sugbag.owner.regist.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.model.dto.AccomoDTO;

public class AccomoDAO {

	/* Properties 객체를 이용해서 쿼리문을 조회해서 사용. 기본 생성자를 통해서 쿼리문을 조회. */
	private Properties prop = new Properties();

	public AccomoDAO() {
		//registration-mapper.xml 생성
		try {

			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/registration/registration-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectEnNo(Connection con) {

		PreparedStatement pstmt = null;

		Statement stmt = null;
		
		/* 반환시킬 변수 지정 */
		ResultSet rset = null;
		
		int selectEnNo = 0;
		
		String selectQuery = prop.getProperty("selectEnNo");

		//잘 넘어왔는지 확인용 출력
		System.out.println(selectQuery);
		
		try {
			pstmt = con.prepareStatement(selectQuery);

			rset = pstmt.executeQuery();
						
			if(rset.next()) {		
				
				selectEnNo = rset.getInt("MAX(EN_ACCOMO_NO)");
			}
			System.out.println("등록숙소번호 : " + selectEnNo);
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
				
		return selectEnNo;
	}
	
	public int InsertAccomo(Connection con, AccomoDTO accomoDTO) {

		PreparedStatement pstmt = null;
		
		/* 반환시킬 변수 지정 */
		int insert = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("insertAccomo");

		//잘 넘어왔는지 확인용 출력
		System.out.println(query);

		try {
			pstmt = con.prepareStatement(query);			
			pstmt.setString(1, accomoDTO.getAccomoName()); // <-위치 홀더의 시작인덱스 시작 값은 1.
			pstmt.setString(2, accomoDTO.getCeoName());
			pstmt.setString(3, accomoDTO.getAccomoType());
			pstmt.setString(4, accomoDTO.getRegistNo());
			pstmt.setString(5, accomoDTO.getAddress());
			//pstmt.setString(7, accomoDTO.getAdrDetail());
			pstmt.setString(6, accomoDTO.getEmail());
			pstmt.setString(7, accomoDTO.getHomepage());
			pstmt.setString(8, accomoDTO.getFacility());
			pstmt.setString(9, accomoDTO.getAccomoPath());
			pstmt.setString(10, accomoDTO.getNear());
			pstmt.setString(11, accomoDTO.getRule());
			pstmt.setString(12, accomoDTO.getParking());
			pstmt.setString(13, accomoDTO.getCheckIn());
			pstmt.setString(14, accomoDTO.getCheckOut());
			pstmt.setDate(15, accomoDTO.getPeakStart());
			pstmt.setDate(16, accomoDTO.getPeakEnd());
			pstmt.setInt(17, accomoDTO.getOwnerNo());		//업체번호
			pstmt.setInt(18, accomoDTO.getEnAccomoNo());	//등록숙소번호
			
			insert = pstmt.executeUpdate();
			
			System.out.println(insert);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
     
		return insert;
	}

}
