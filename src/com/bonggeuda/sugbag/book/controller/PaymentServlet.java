package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.BookDTO;
import com.bonggeuda.sugbag.model.dto.CouponHistoryDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.PaymentDTO;
import com.bonggeuda.sugbag.model.dto.PointHistoryDTO;
import com.bonggeuda.sugbag.service.BookService;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/book/payment")
public class PaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//key value 확인
		Map<String,String[]> requestMap = request.getParameterMap();
		Set<String> keySet = requestMap.keySet();
		Iterator<String> keyIter = keySet.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			String[] value = requestMap.get(key);
			
			System.out.println("key : " + key);
			for(int i = 0; i < value.length; i++) {
				System.out.println("value[" + i + "] : " +value[i]);
			}
		}
		
		
		//예약자번호
		MemberDTO member = (MemberDTO)request.getSession().getAttribute("member");
		int userNo = member.getUserNo();
		
		//예약정보
		BookDTO bookInfo = new BookDTO();
		bookInfo.setUserNo(userNo);
		bookInfo.setBookUserName(request.getParameter("bookName"));
		bookInfo.setBookPersonnel(Integer.parseInt(request.getParameter("personnel")));
		bookInfo.setBookCheckDate(request.getParameter("checkInDate"));
		bookInfo.setBookCheckoutDate(request.getParameter("checkOutDate"));
		bookInfo.setBookCheckIn(request.getParameter("checkInTime"));
		bookInfo.setUserPhone(request.getParameter("phone"));
		bookInfo.setRoomNo(Integer.parseInt(request.getParameter("roomNo")));
		bookInfo.setRequest(request.getParameter("request"));
		//예약정보INSERT
		BookService bsvc = new BookService();
		int result = bsvc.insertBookInfo(bookInfo);
		if(result > 0) {
			System.out.println("예약INSERT성공");
		} else {
			System.out.println("예약INSERT실패");
		}
		//결제정보
		int amount = Integer.parseInt(request.getParameter("finalPrice")); //결제금액
		int point = Integer.parseInt(request.getParameter("point"));  //포인트 사용금액
		int coupon = Integer.parseInt(request.getParameter("coupon")); //쿠폰사용금액
		
		PaymentDTO payment = new PaymentDTO();
		payment.setMethod(request.getParameter("paymentType"));
		payment.setAmount(Integer.parseInt(request.getParameter("finalPrice")));
		payment.setCouponYN("N");
		payment.setPointYN("N");
		payment.setPaymentTime(new Date(System.currentTimeMillis()));
		int discount = 0;
		
		if(point>0) {
			payment.setPointYN("Y");
			discount += point;
		}
		
		if(coupon>0) {
			payment.setCouponYN("Y");
			discount += coupon;
		}
		payment.setDiscount(discount);
		System.out.println("할인금액 : " + discount);
		//결제 insert 
		int paymentInsertResult = bsvc.insertPaymentInfo(payment);
		if(paymentInsertResult>0) {
			System.out.println("결제성공!");
		} else {
			System.out.println("결제실패!");
		}
		//쿠폰 사용시 쿠폰이력 insert
		if(payment.getCouponYN().equals("Y")) {
		    //쿠폰이력 insert
			CouponHistoryDTO couponUse = new CouponHistoryDTO();
//			int couponNo = Integer.parseInt(request.getParameter("couponNo"));
			int couponNo = 1;
			couponUse.setCouponNo(couponNo);
			couponUse.setUseDate(payment.getPaymentTime());
			
			int couponUseResult = bsvc.insertCouponUse(couponUse);
			if(couponUseResult > 0) {
				System.out.println("쿠폰사용 성공!");
			} else {
				System.out.println("쿠폰사용 실패!");
			}
		}
//		int pointNo = Integer.parseInt(request.getParameter("pointNo"));
		int pointNo = 1;
		//포인트 사용시 포인트이력 insert
		if(payment.getCouponYN().equals("Y")) {
			PointHistoryDTO pointUse = new PointHistoryDTO();
			pointUse.setGetuseType("U");
			pointUse.setPoint(point);
			pointUse.setGuDate(payment.getPaymentTime());
			pointUse.setPointNo(pointNo);
			
			int pointUseResult = bsvc.insertPointUse(pointUse);
			if(pointUseResult > 0) {
				System.out.println("포인트사용 성공!");
			} else {
				System.out.println("포인트사용 실패!");
			}
		}
		
		//포인트적립 insert
		PointHistoryDTO pointGet = new PointHistoryDTO();
		pointGet.setGetuseType("G");
		
		int getPoint = (int)(amount * 0.03);//결제금액의 3% 적립
		getPoint = ((int) Math.ceil(getPoint*0.1)) * 10; 
		pointGet.setPoint(getPoint);
		pointGet.setPointPath("숙소결제완료");
		pointGet.setGuDate(payment.getPaymentTime());
		pointGet.setPointNo(pointNo);
		int pointGetResult = bsvc.insertPointGet(pointGet);
		if(pointGetResult > 0) {
			System.out.println("포인트적립성공");
		} else {
			System.out.println("포인트적립실패");
		}
		
		
	}

}
