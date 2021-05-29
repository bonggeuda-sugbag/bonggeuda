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
	
	public int InsertAccomo(Connection con, AccomoDTO accomoDTO, int ownerNo) {

		PreparedStatement pstmt = null;
		
		/* 반환시킬 변수 지정 */
		int insert = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("insertAccomo");

		//잘 넘어왔는지 확인용 출력

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, accomoDTO.getRequsetNo());
			pstmt.setString(2, accomoDTO.getAccomoName()); // <-위치 홀더의 시작인덱스 시작 값은 1.
			pstmt.setString(3, accomoDTO.getCeoName());
			pstmt.setString(4, accomoDTO.getAccomoType());
			pstmt.setString(5, accomoDTO.getRegistNo());
			pstmt.setString(6, accomoDTO.getAddress());
			//pstmt.setString(7, accomoDTO.getAdrDetail());
			pstmt.setString(7, accomoDTO.getEmail());
			pstmt.setString(8, accomoDTO.getHomepage());
			pstmt.setString(9, accomoDTO.getFacility());
			pstmt.setString(10, accomoDTO.getAccomoPath());
			pstmt.setString(11, accomoDTO.getNear());
			pstmt.setString(12, accomoDTO.getRule());
			pstmt.setString(13, accomoDTO.getParking());
			pstmt.setString(14, accomoDTO.getCheckIn());
			pstmt.setString(15, accomoDTO.getCheckOut());
			pstmt.setDate(16, accomoDTO.getPeakStart());
			pstmt.setDate(17, accomoDTO.getPeakEnd());
			pstmt.setInt(18, ownerNo); //업체번호
			 //등록숙소번호
			
			insert = pstmt.executeUpdate();
			
			System.out.println(insert);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
     
		return insert;
	}

	public int selectRequestNextVal(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int selectRequestNextVal = 0;
		
		String query = prop.getProperty("selectRequestNextVal");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				selectRequestNextVal = rset.getInt("NEXTVAL");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("SeqReqSelectCurrval : " + selectRequestNextVal);
		
		return selectRequestNextVal;
	}

}
