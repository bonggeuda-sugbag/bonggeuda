package com.bonnggeuda.sugbag.user.dao;

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
import com.bonnggeuda.sugbag.user.dto.UserInfoDTO;

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
	
	public List<UserInfoDTO> selectUserList(Connection con, PageInfoDTO pageInfo) {
		
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


	public UserInfoDTO selectDetail(Connection con, String userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectDetail");
		
		UserInfoDTO userInfo = new UserInfoDTO();
		
		try {
		
			pstmt = con.prepareStatement(query);
			System.out.println("userNo :" + userNo);
//			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println("아이디이이ㅣ이이이이이잉 : " +rset.getString("USER_ID"));		
				userInfo.setEmail(rset.getString("USER_ID"));
				userInfo.setPassword(rset.getString("USER_PWD"));
				userInfo.setName(rset.getString("USER_NICKNAME"));
				userInfo.setPhoneNumber(rset.getString("USER_PHONE"));
				userInfo.setPoint(rset.getInt("POINT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return userInfo;
	}


}
