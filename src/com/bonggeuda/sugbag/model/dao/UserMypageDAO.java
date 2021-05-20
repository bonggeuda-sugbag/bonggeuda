package com.bonggeuda.sugbag.model.dao;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.model.dto.AttachmentDTO;
import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.CouponDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.PointDTO;
import com.bonggeuda.sugbag.model.dto.PointHistoryDTO;
import com.bonggeuda.sugbag.model.dto.ReportDTO;

public class UserMypageDAO {
	
	private Properties prop = new Properties();
	
	public UserMypageDAO() {
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "/guest/mypage/mypage-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 가지고있는 포인트 정보 조회
	 * @param con
	 * @param userNo
	 * @return
	 */
	public PointDTO pointSelect(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		PointDTO point = null;
		
		String query = prop.getProperty("point");
		
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				point = new PointDTO();
				
				point.setPoint(rset.getInt("POINT"));
			}
			
			System.out.println(point);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return point;
	}

	/**
	 * 포인트 이력 정보 조회
	 * @param con
	 * @param userNo 
	 * @return
	 */
	public List<PointHistoryDTO> pointHistorySelect(Connection con, int userNo) {

		System.out.println("서블릿요청3333");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<PointHistoryDTO> pointHistory = null;
		
		String query = prop.getProperty("pointHistory");
		
		System.out.println(query);
		
		pointHistory = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				PointHistoryDTO pointHistoryDTO = new PointHistoryDTO();
				
				pointHistoryDTO.setPointPath(rset.getString("POINT_PATH"));
				pointHistoryDTO.setGetuseType(rset.getString("GETUSE_TYPE_GU"));
				pointHistoryDTO.setGuDate(rset.getDate("GU_DATE"));
				pointHistoryDTO.setPoint(rset.getInt("POINT"));
				
				pointHistory.add(pointHistoryDTO);
				
			}
			
			System.out.println(pointHistory);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return pointHistory;
	}

	/**
	 * 보유 쿠폰 개수 조회
	 * @param con
	 * @param userNo
	 * @return
	 */
	public int couponCount(Connection con, int userNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("couponCount");
		
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				result = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	/**
	 * 보유 쿠폰 정보 조회
	 * @param con
	 * @param userNo
	 * @return
	 */
	public List<CouponDTO> couponSelect(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<CouponDTO> couponList = new ArrayList<>();
		
		String query = prop.getProperty("couponList");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				CouponDTO coupon = new CouponDTO();
				coupon.setCouponName(rset.getString("COUPON_NAME"));
				coupon.setCouponDiscount(rset.getInt("COUPON_DISCOUNT"));
				coupon.setCouponCondition(rset.getString("COUPON_CONDITION"));
				coupon.setCouponStart(rset.getDate("COUPON_START"));
				coupon.setCouponEnd(rset.getDate("COUPON_END"));
				
				couponList.add(coupon);
			}
			
			System.out.println(couponList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return couponList;
	}

	/**
	 * 내 정보 조회
	 * @param con
	 * @param userNo
	 * @return
	 */
	public MemberDTO myinfoSelect(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MemberDTO member = null;
		
		String query = prop.getProperty("myinfoSelect");
		
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				member = new MemberDTO();
				member.setNickName(rset.getString("USER_NICKNAME"));
				member.setUserPhone(rset.getString("USER_PHONE"));
				member.setReportCnt(rset.getInt("REPORT_COUNT"));
				
			}
			System.out.println(member);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	/**
	 * 사용자 닉네임 변경
	 * @param con
	 * @param userMyinfo
	 * @return
	 */
	public int updateUserNickNmae(Connection con, MemberDTO userMyinfo) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("nickNameUpdate");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, userMyinfo.getNickName());
			pstmt.setInt(2, userMyinfo.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 사용자 전화번호 변경
	 * @param con
	 * @param userMyinfo
	 * @return
	 */
	public int updateUserPhone(Connection con, MemberDTO userMyinfo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("phoneUpdate");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, userMyinfo.getUserPhone());
			pstmt.setInt(2, userMyinfo.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 사용자 비밀번호 변경
	 * @param con
	 * @param userMyinfo
	 * @return
	 */
	public int updateUserPwd(Connection con, MemberDTO userMyinfo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("passwordUpdate");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, userMyinfo.getUserPwd());
			pstmt.setInt(2, userMyinfo.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 사용자 회원탈퇴로 정보 변경
	 * @param con
	 * @param userWithdraw
	 * @return
	 */
	public int userWithdraw(Connection con, MemberDTO userWithdraw) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("withdrawUpdate");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setDate(1, userWithdraw.getWithDrawDate());
			pstmt.setInt(2, userWithdraw.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 신고한 리스트 조회
	 * @param con
	 * @param userNo
	 * @return
	 */
	public List<ReportDTO> selectReportList(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ReportDTO> report = new ArrayList<>();
		
		String query = prop.getProperty("reportListSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				ReportDTO reportDTO = new ReportDTO();
				
				reportDTO.setReportNo(rset.getInt("REPORT_NO"));
				reportDTO.setReportTitle(rset.getString("REPORT_TITLE"));
				reportDTO.setAccomoName(rset.getString("ACCOMO_NAME"));
				reportDTO.setReportDate(rset.getDate("REPORT_DATE"));
				reportDTO.setReportStatus(rset.getString("REPORT_STATUS"));
				
				report.add(reportDTO);
			}
			
			System.out.println(report);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return report;
	}

	/**
	 * 신고 상세 내용 조회
	 * @param reportedNo 
	 * @return
	 */
	public ReportDTO selectReportContent(Connection con, int userNo, int reportedNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ReportDTO userReportContent = null;
		
		String query = prop.getProperty("reportContent");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, reportedNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				userReportContent = new ReportDTO();
				
				userReportContent.setReportTitle(rset.getString("REPORT_TITLE"));
				userReportContent.setAccomoName(rset.getString("ACCOMO_NAME"));
				userReportContent.setReportDate(rset.getDate("REPORT_DATE"));
				userReportContent.setReportReason(rset.getString("REPORT_REASON"));
				userReportContent.setReportAnswer(rset.getString("REPORT_ANSWER"));
				
			}
			
			System.out.println(userReportContent);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userReportContent;
	}

	public AttachmentDTO selectReportImg(Connection con, int userNo, int reportedNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		AttachmentDTO userReportImg = new AttachmentDTO();
		
		String query = prop.getProperty("reportImgSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, reportedNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				userReportImg.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userReportImg;
	}

	/**
	 * 닉네임 변경시 중복체크 할 닉네임 조회
	 * @param con
	 * @param inputNickName
	 * @return
	 */
	public int selectUserNickName(Connection con, String inputNickName) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("userNicknameSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, inputNickName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 예약리스트 조회
	 * @param con
	 * @param userNo
	 * @return
	 */
	public List<BookDTO> selectUserBookList(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BookDTO> bookList = new ArrayList<>();
		
		String query = prop.getProperty("userBookListSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				BookDTO bookDTO = new BookDTO();
				bookDTO.setBookNo(rset.getInt("BOOK_NO"));
				bookDTO.setBookCheckDate(rset.getString("BOOK_CHECK_DATE"));
				bookDTO.setBookCheckoutDate(rset.getString("BOOK_CHECKOUT_DATE"));
				bookDTO.setBookApproveYn(rset.getString("BOOK_APPROVE_YN"));
				bookDTO.setBookCheckIn(rset.getString("BOOK_CHECK_IN"));
				bookDTO.setRoomName(rset.getString("ROOM_NAME"));
				bookDTO.setAccomoName(rset.getString("ACCOMO_NAME"));
				
				/* 숙박일수 구하기 */
				SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date startDate = dataFormat.parse(rset.getString("BOOK_CHECK_DATE"));
					Date endDate = dataFormat.parse(rset.getString("BOOK_CHECKOUT_DATE"));
					bookDTO.setDay((endDate.getTime() - startDate.getTime())/(24*60*60*1000));
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				bookList.add(bookDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bookList;
	}

	/**
	 * 이용 완료한 목록 조회하기
	 * @param con
	 * @param userNo
	 * @return
	 */
	public List<BookDTO> completeBooklist(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BookDTO> completeBooklist = new ArrayList<>();
		
		String query = prop.getProperty("userCompleteBookListSelect");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				BookDTO completebookDTO = new BookDTO();
				completebookDTO.setBookNo(rset.getInt("BOOK_NO"));
				completebookDTO.setBookCheckDate(rset.getString("BOOK_CHECK_DATE"));
				completebookDTO.setBookCheckoutDate(rset.getString("BOOK_CHECKOUT_DATE"));
				completebookDTO.setBookApproveYn(rset.getString("BOOK_APPROVE_YN"));
				completebookDTO.setBookCheckIn(rset.getString("BOOK_CHECK_IN"));
				completebookDTO.setRoomName(rset.getString("ROOM_NAME"));
				completebookDTO.setAccomoName(rset.getString("ACCOMO_NAME"));
				
				/* 숙박일수 구하기 */
				SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date startDate = dataFormat.parse(rset.getString("BOOK_CHECK_DATE"));
					Date endDate = dataFormat.parse(rset.getString("BOOK_CHECKOUT_DATE"));
					completebookDTO.setDay((endDate.getTime() - startDate.getTime())/(24*60*60*1000));
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				completeBooklist.add(completebookDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return completeBooklist;
		
	}

}
