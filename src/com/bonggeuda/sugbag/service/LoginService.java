package com.bonggeuda.sugbag.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.bonggeuda.sugbag.model.dao.LoginDAO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;

public class LoginService {
	
	private LoginDAO loginDAO = new LoginDAO();

	public MemberDTO loginCheck(String loginEmail, String loginPassword) {

		Connection con = getConnection();
		
		MemberDTO member = loginDAO.loginCheck(con, loginEmail, loginPassword);
		
		close(con);
		
		return member;
	}

}
