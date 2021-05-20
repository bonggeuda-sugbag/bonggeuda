package com.bonggeuda.sugbag.user.service;


import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dto.PageInfoDTO;
import com.bonggeuda.sugbag.user.dao.UserInfoDAO;
import com.bonggeuda.sugbag.user.dto.UserInfoDTO;

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
	
	public UserInfoDTO selectDetail(String userNo) {
		
		Connection con = getConnection();
		
		UserInfoDTO userInfo = userInfoDAO.selectDetail(con, userNo);
		
		close(con);
		
		return userInfo;
	}

}
