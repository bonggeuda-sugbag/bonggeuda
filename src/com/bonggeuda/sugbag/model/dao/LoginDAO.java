package com.bonggeuda.sugbag.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.model.dto.MemberDTO;

public class LoginDAO {

	private Properties prop = new Properties();
	
	public LoginDAO() {
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "/common/common-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MemberDTO loginCheck(Connection con, String loginEmail, String loginPassword) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
//		String query = prop.getProperty();
		
		return null;
	}
	
}
