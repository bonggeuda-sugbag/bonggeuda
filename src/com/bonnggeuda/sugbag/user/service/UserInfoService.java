package com.bonnggeuda.sugbag.user.service;


import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dto.PageInfoDTO;
import com.bonnggeuda.sugbag.user.dao.UserInfoDAO;
import com.bonnggeuda.sugbag.user.dto.UserInfoDTO;

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

}
