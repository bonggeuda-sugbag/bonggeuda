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
	.point_list li, .point_list span, .point_list p{
		font-size: 18px;
	}
	.point_list li {
		padding-bottom: 10px;
		padding-top: 10px;
    	height: auto;
    	border-bottom: 1px solid rgba(0,0,0,0.2);
		width: 575px;
	}
	li.gra_grey{
		background-image: url("${ pageContext.servletContext.contextPath }/resources/guest/images/ticket.png");
		/* padding-top: 10px; */
		/* width: 350px; */
  		height: 190px;
 		background-position: 50%;
  		background-repeat: no-repeat;
  		background-size: 320px 280px;
	}

	</style>
<title>봉그다 숙박숙박</title>
<link href="${ pageContext.servletContext.contextPath }/resources/guest/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${ pageContext.servletContext.contextPath }/resources/guest/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--menu-->
<script src="${ pageContext.servletContext.contextPath }/resources/guest/js/scripts.js"></script>
<link href="${ pageContext.servletContext.contextPath }/resources/guest/css/styles.css" rel="stylesheet">
<!--//menu-->
<!--theme-style-->
<link href="${ pageContext.servletContext.contextPath }/resources/guest/css/style.css" rel="stylesheet" type="text/css" media="all" />	
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
				<li><a  href="${ pageContext.servletContext.contextPath }/usernotice/select">더보기</a></li>
				<!-- <li><a  href="blog.html">내주변</a></li> -->
				<li><a  href="${ pageContext.servletContext.contextPath }/point/select">마이페이지</a></li>
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
			<li class="blog-list"><a href="${ pageContext.servletContext.contextPath }/point/select">포인트</a></li>
			<li class="blog-list" style=" font-size: 1.3em; font-weight: 600;"><a href="${ pageContext.servletContext.contextPath }/coupon/select" style="color: #6eceda;">쿠폰함</a></li>
			<li class="blog-list"><a href="${ pageContext.servletContext.contextPath }/userbooklist/select">예약 내역</a></li>
			<li class="blog-list"><a href="${ pageContext.servletContext.contextPath }/usermyinfo/select">내 정보 관리</a></li>
			<li class="blog-list"><a href="${ pageContext.servletContext.contextPath }/userreportlist/select">신고내역</a></li>
		</ul>
		</div>
		</nav>
	</div>


	<div class="mmiddle">
	<div class="tab">
		<span class="tab_btn active">보유쿠폰</span>
		<span class="able_point" style="color: #6eceda; font-weight: bold;">: &nbsp<span><c:out value="${ requestScope.couponCount }"/></span>&nbsp장</span>
	</div>

	<div id="cont_area"><!-- 본문 콘텐츠-->
		<div class="cont_inner" id="policy_page" style="min-height: 435px; text-align: left;">
			<ul class="gra_coupon coupon_box" style="padding-top: 30px;">
				<c:forEach var="arr" items="${ coupon }" varStatus="st">
				
					<li class="gra_grey">
						<div style="padding-top: 25px;">
							<br>
							<b>호텔,펜션</b>
							<strong><c:out value="${ arr.couponName }"/></strong>
							<p><c:out value="${ arr.couponDiscount }"/>원 할인</p>
							<p><c:out value="${ arr.couponCondition }"/>원 이상 결제 시 사용가능</p>
							<p></p>
							<p></p>
							<span><c:out value="${ arr.couponStart }"/> ~ <c:out value="${ arr.couponEnd }"/></span>
						</div>
					</li>
				
				</c:forEach>
			</ul>
		</div>
	</div>
	</div>




	<div class="clearfix"> </div>
	<nav>
		<ul class="pagination">
		  <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
		  <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
		  <li><a href="#">2</a></li>
		  <li><a href="#">3</a></li>
		  <li><a href="#">4</a></li>
		  <li><a href="#">5</a></li>
		  <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
	   </ul>
	   </nav>
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