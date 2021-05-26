package com.bonggeuda.sugbag.model.dao;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.OwnerInfoDTO;

public class LoginDAO {

	private Properties prop = new Properties();
	
	public LoginDAO() {
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "/common/common-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 사용자 로그인 체크
	 * @param con
	 * @param loginEmail
	 * @param loginPassword
	 * @return
	 */
	public MemberDTO userLoginCheck(Connection con, String loginEmail, String loginPassword) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MemberDTO userMember = new MemberDTO();
		
		String query = prop.getProperty("userLoginCheck");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginEmail);
			pstmt.setString(2, loginPassword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				userMember.setUserNo(rset.getInt("USER_NO"));
				userMember.setUserId(rset.getString("USER_ID"));
				userMember.setUserPwd(rset.getString("USER_PWD"));
				userMember.setUserPhone(rset.getString("USER_PHONE"));
				userMember.setReportCnt(rset.getInt("REPORT_COUNT"));
				userMember.setNickName(rset.getString("USER_NICKNAME"));
				userMember.setWithDrawYn(rset.getString("USER_WITHDRAW_YN"));
				userMember.setUserRole(rset.getString("USER_ROLE"));
				userMember.setSignDate(rset.getDate("SIGNDATE"));
				userMember.setWithDrawDate(rset.getDate("WITHDRAWDATE"));
				
			}
			
			System.out.println("login 정보 : " + userMember);
			if(userMember.getUserId() == null) {
				userMember = null;
			}
			System.out.println("login 정보 확인 : " + userMember);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userMember;
	}

	/**
	 * 업체 로그인 체크
	 * @param con
	 * @param loginEmail
	 * @param loginPassword
	 * @return
	 */
	public OwnerInfoDTO ownerLoginCheck(Connection con, String loginEmail, String loginPassword) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		OwnerInfoDTO ownerMember = new OwnerInfoDTO();
		
		String query = prop.getProperty("ownerLoginCheck");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginEmail);
			pstmt.setString(2, loginPassword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				ownerMember.setOwnerNo(rset.getInt("OWNER_NO"));
				ownerMember.setOwnerID(rset.getString("OWNER_ID"));
				ownerMember.setOwnerPwd(rset.getString("OWNER_PWD"));
				ownerMember.setOwnerPhone(rset.getString("OWNER_PHONE"));
				ownerMember.setOwnerWithdrawYn(rset.getString("OWNER_WITHDRAW_YN"));
				ownerMember.setOwnerSignDate(rset.getDate("OWNER_SIGNDATE"));
				ownerMember.setOwnerWithDate(rset.getDate("OWNER_WITHDATE"));

			}
			
			System.out.println("login 정보 : " + ownerMember);
			
			if(ownerMember.getOwnerID() == null) {
				ownerMember = null;
			}
			System.out.println("login 정보 확인 : " + ownerMember);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ownerMember;
	}

	/**
	 * 관리자 로그인 체크
	 * @param con
	 * @param loginEmail
	 * @param loginPassword
	 * @return
	 */
	public MemberDTO adminLoginCheck(Connection con, String loginEmail, String loginPassword) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MemberDTO userMember = new MemberDTO();
		
		String query = prop.getProperty("userLoginCheck");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginEmail);
			pstmt.setString(2, loginPassword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				userMember.setUserNo(rset.getInt("USER_NO"));
				userMember.setUserId(rset.getString("USER_ID"));
				userMember.setUserPwd(rset.getString("USER_PWD"));
				userMember.setUserPhone(rset.getString("USER_PHONE"));
				userMember.setReportCnt(rset.getInt("REPORT_COUNT"));
				userMember.setNickName(rset.getString("USER_NICKNAME"));
				userMember.setWithDrawYn(rset.getString("USER_WITHDRAW_YN"));
				userMember.setUserRole(rset.getString("USER_ROLE"));
				userMember.setSignDate(rset.getDate("SIGNDATE"));
				userMember.setWithDrawDate(rset.getDate("WITHDRAWDATE"));
				
			}
			
			System.out.println("login 정보 : " + userMember);
			if(userMember.getUserId() == null) {
				userMember = null;
			}
			System.out.println("login 정보 확인 : " + userMember);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userMember;
	}
	
}
