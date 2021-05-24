<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<style>
	div.mmiddle {
    	margin-left: 25%;
    	margin-right: 25%;
	}
	td {
		font-size: 20px;
		color: #a3a3a3;
	}
	tr, td {
		width: 180px;
		height: 50px;
		text-align: left;
	}
	.review-btn {
		border-radius: 10px;
		margin-top: 5px;
		background: #6eceda;
		color: white;
		border-style: none;
		box-shadow: 0 3px 0 #0e8c73;
		height: 35px;
	}
	.review-btn:hover {
		background-color: #4aa9b6;
		box-shadow: 0 3px 0 #23a188;
	}
	.review-btn:active {
		box-shadow: none;
	}
	</style>
<title>봉그다 숙박숙박</title>
<link href="${pageContext.servletContext.contextPath}/resources/guest/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.servletContext.contextPath}/resources/guest/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--menu-->
<script src="${pageContext.servletContext.contextPath}/resources/guest/js/scripts.js"></script>
<link href="${pageContext.servletContext.contextPath}/resources/guest/css/styles.css" rel="stylesheet">
<!--//menu-->
<!--theme-style-->
<link href="${pageContext.servletContext.contextPath}/resources/guest/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Real Home Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<!--header-->
<div class="header">
	<div class="container">
		<!--logo-->
			<div class="logo">
				<h1><a href="index.jsp">Bonggeuda</a></h1>
			</div>
		<!--//logo-->
		<div class="top-nav">
			<ul class="right-icons">

				<li><span ><a  href="index.html">메인페이지</a></span></li>
				<li><a  href="more_notice.html">더보기</a></li>
				<!-- <li><a  href="blog.html">내주변</a></li> -->
				<li><a  href="mypage_point.html">마이페이지</a></li>
            	<li><a  href="login.html"><i class="glyphicon glyphicon-user"> </i>로그인</a></li>

			</ul>
			</div>
			
		<div class="clearfix"> </div>
		<div class="clearfix"> </div>
	</div>	
</div>
<!--//-->	
<div class=" banner-buying">
	<div class=" container">
	<h3><span>마이페이지</span></h3> 

	<div class="clearfix"> </div>      		
	</div>
</div>
<!--//header-->
<!--blog-->
<div class="blog">
<div class="container">
	<h3></h3>
	<div class="blog-list">
		<nav>
		<div class="col-md-3 blog-sidebar">
		<ul style="padding-top: 70px;">
			<li class="blog-list"><a href="mypage_point.jsp">포인트</a></li>
			<li class="blog-list"><a href="mypage_coupon.jsp">쿠폰함</a></li>
			<li class="blog-list" style=" font-size: 1.3em; font-weight: 600;"><a href="mypage_reservation.jsp" style="color: #6eceda;">예약 내역</a></li>
			<li class="blog-list"><a href="mypage_myinformation.jsp">내 정보 관리</a></li>
			<li class="blog-list"><a href="warningList.jsp">신고내역</a></li>
		</ul>
		</div>
		</nav>
	</div>


	<div class="mmiddle">

	<div id="cont_area" style="padding-top: 30px;"><!-- 본문 콘텐츠-->
		<div class="cont_inner" id="policy_page" style="min-height: 435px; text-align: left; float: left; width: 100%;">

			<div style="font-size: 15px; border: 1px solid; width: 100px; background: #d3d3d3; border-style: none; border-radius: 5px;">이용 완료</div>
			<div style="font-size: 30px; margin-bottom: 20px; text-align: left;"><c:out value="${ requestScope.userCompleteContent.accomoName }"/> <c:out value="${ requestScope.userCancleContent.roomName }"/></div>
			<img src="${pageContext.servletContext.contextPath}/${ requestScope.userCompleteContent.thumbnailPath }" style="width: 70%; margin-bottom: 50px; width: 100%">

			<div class="reservation_information">
				<table style="margin-bottom: 30px; width: 90%;">
					<tr>
						<td>체크인</td>
						<td><c:out value="${ requestScope.userCompleteContent.bookCheckDate }"/> &nbsp <c:out value="${ requestScope.userCompleteContent.bookCheckIn }"/></td>
					</tr>
					<tr>
						<td>체크아웃</td>
						<td><c:out value="${ requestScope.userCompleteContent.checkoutDate }"/> &nbsp <c:out value="${ requestScope.userCompleteContent.checkOut }"/></td>
					</tr>
					<tr>
						<td>예약번호</td>
						<td><c:out value="${ requestScope.userCompleteContent.bookNo }"/></td>
					</tr>
					<tr>
						<td>예약자 이름</td>
						<td><c:out value="${ requestScope.userCompleteContent.bookUserName }"/></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><c:out value="${ requestScope.userCompleteContent.bookPhone }"/></td>
					</tr>
				</table>
			</div>

			<hr>

			<div style="text-align: left; float: left; font-size: 20px; margin-bottom: 30px; width: 100%;">
				<table style="width: 90%;">
					<tr>
						<td colspan="2">결제 정보</td>
					</tr>
					<tr>
						<td>총 결제금액</td>
						<td style="color: #6eceda;"><c:out value="${ requestScope.userCompleteContent.paymentAmount }"/>원</td>
					</tr>
				</table>
			</div>

			<div>
				<button class="review-btn" type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/userbookcancle/selectandinsert?bookNo=${ requestScope.userBookContent.bookNo }';">리뷰작성</button>
			</div>

		</div>
	</div>

	<div class="clearfix"> </div>
	<br><br><br>
	</div>
</div>
</div>
<!--//blog-->
<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top-at">
			<div class="col-md-3 amet-sed">
				<h4>Our Company</h4>
				<ul class="nav-bottom">
					<li><a href="about.html">About Us</a></li>
					<li><a href="blog.html">For Sale By Owner Blog</a></li>
					<li><a href="mobile_app.html">Mobile</a></li>
					<li><a href="terms.html">Terms & Conditions</a></li>
					<li><a href="privacy.html">Privacy Policy</a></li>	
					<li><a href="blog.html">Blog</a></li>
					
				</ul>	
			</div>
			<div class="col-md-3 amet-sed ">
				<h4>Work With Us</h4>
					<ul class="nav-bottom">
						<li><a href="single.html">Real Estate Brokers</a></li>
						<li><a href="single.html">Business Development</a></li>
						<li><a href="single.html">Affiliate Programs</a></li>
						<li><a href="contact.html">Sitemap</a></li>
						<li><a href="career.html">Careers</a></li>
						<li><a href="feedback.html">Feedback</a></li>	
					</ul>	
			</div>
			<div class="col-md-3 amet-sed">
				<h4>Customer Support</h4>
				<p>Mon-Fri, 7AM-7PM </p>
				<p>Sat-Sun, 8AM-5PM </p>
				<p>177-869-6559</p>
					<ul class="nav-bottom">
						<li><a href="#">Live Chat</a></li>
						<li><a href="faqs.html">Frequently Asked Questions</a></li>
						<li><a href="suggestion.html">Make a Suggestion</a></li>
					</ul>	
			</div>
			<div class="col-md-3 amet-sed ">
				<h4>Property Services</h4>
				   <ul class="nav-bottom">
						<li><a href="single.html">Residential Property</a></li>
						<li><a href="single.html">Commercial Property</a></li>
						<li><a href="login.html">Login</a></li>
						<li><a href="register.html">Register</a></li>
						<li><a href="typo.html">Short Codes</a></li>	
					</ul>	
					<ul class="social">
						<li><a href="#"><i> </i></a></li>
						<li><a href="#"><i class="gmail"> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>
						<li><a href="#"><i class="camera"> </i></a></li>
						<li><a href="#"><i class="dribble"> </i></a></li>
					</ul>
			</div>
		<div class="clearfix"> </div>
		</div>
	</div>
	<div class="footer-bottom">
		<div class="container">
			<div class="col-md-4 footer-logo">
				<h2><a href="index.html">REAL HOME</a></h2>
			</div>
			<div class="col-md-8 footer-class">
				<p >© 2015 Real Home. All Rights Reserved | Design by  <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
			</div>
		<div class="clearfix"> </div>
	 	</div>
	</div>
</div>
<!--//footer-->
</body>
</html>