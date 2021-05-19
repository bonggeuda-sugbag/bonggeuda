package com.bonggeuda.sugbag.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dao.UserMypageDAO;
import com.bonggeuda.sugbag.model.dto.CouponDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.PointDTO;
import com.bonggeuda.sugbag.model.dto.PointHistoryDTO;

public class UserMypageService {
	
	private UserMypageDAO mypageDAO = new UserMypageDAO();

	
	/**
	 * 가지고 있는 포인트 정보 조회
	 * @param userNo 사용자번호
	 * @return
	 */
	public PointDTO pointSelect(int userNo) {

		Connection con = getConnection();
		
		PointDTO pointDTO = mypageDAO.pointSelect(con, userNo);
		
		close(con);
		
		return pointDTO;
	}


	/**
	 * 포인트 이력 정보 조회
	 * @param userNo 
	 * @return
	 */
	public List<PointHistoryDTO> pointHistorySelect(int userNo) {
		
		System.out.println("서블릿요청22222");
		
		Connection con = getConnection();
		
		List<PointHistoryDTO> pointHistory = mypageDAO.pointHistorySelect(con,userNo);
		
		close(con);
		
		return pointHistory;
	}

	/**
	 * 보유 쿠폰 개수 조회
	 * @param userNo
	 * @return
	 */
	public int couponCount(int userNo) {
		
		int result = 0;
		
		Connection con = getConnection();
		
		result = mypageDAO.couponCount(con, userNo);
		
		close(con);
		
		return result;
	}

	/**
	 * 보유 쿠폰 정보 조회
	 * @param userNo
	 * @return
	 */
	public List<CouponDTO> couponSelect(int userNo) {

		Connection con = getConnection();
		
		List<CouponDTO> coupon = mypageDAO.couponSelect(con, userNo);
		
		close(con);
		
		return coupon;
	}


	/**
	 * 내 정보 조회
	 * @param userNo
	 * @return
	 */
	public MemberDTO myinfoSelect(int userNo) {
		
		Connection con = getConnection();
		
		MemberDTO myinfo = mypageDAO.myinfoSelect(con, userNo);
		
		close(con);
		
		return myinfo;
	}


	/**
	 * 사용자 정보 변경
	 * @param userMyinfo
	 * @return
	 */
	public int updateUserNickName(MemberDTO userMyinfo) {
		
		int result = 0;
		
		Connection con = getConnection();
		
		if(userMyinfo.getNickName() != null) {
			result = mypageDAO.updateUserNickNmae(con, userMyinfo);			
		} else if(userMyinfo.getUserPhone() != null) {
			result = mypageDAO.updateUserPhone(con, userMyinfo);						
		} else if(userMyinfo.getUserPwd() != null){
			result = mypageDAO.updateUserPwd(con, userMyinfo);									
		}
		
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}




}
