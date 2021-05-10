<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>봉그다 숙박숙박</title>
<link href="resources/owner/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/owner/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--menu-->
<script src="resources/owner/js/scripts.js"></script>
<link href="resources/owner/css/styles.css" rel="stylesheet">
<!--//menu-->
<!--theme-style-->
<link href="resources/owner/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Real Home Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- slide -->
<script src="js/responsiveslides.min.js"></script>
   <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  	</script>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	<title>Simple Icon Hover Effects with CSS Transitions and Animations</title>
	<meta name="description" content="Simple Icon Hover Effects with CSS Transitions and Animations" />
	<meta name="keywords" content="icons, hover, round, circular, transition, animation, css3" />
	<meta name="author" content="Codrops" />
	<link rel="shortcut icon" href="../favicon.ico"> 
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<link rel="stylesheet" type="text/css" href="css/component.css" />
	<script src="js/modernizr.custom.js"></script>
<style>
	.col-md-3 {
		width: 25%;
		height: auto;
		text-align: center;
	}
</style>
</head>
<body >
<!--header-->
<div class="header">
	<div class="container">
		<!--logo-->
			<div class="logo">
				<h1><a href="main.jsp">Bonggeuda</a></h1>
			</div>
		<!--//logo-->
		<div class="top-nav">
			<ul class="right-icons">
				<li><a href="mypage.jsp">마이페이지</a></li>
				<li><a href="login.jsp"><i class="glyphicon glyphicon-user"> </i>Logout</a></li>
			</ul>
		</div>
	</div>
</div>
<!--header-->
<!--//-->	
	<div class=" header-right">
		<div class=" banner">
			 <div class="slider">
			    <div class="callbacks_container">
			      <ul class="rslides" id="slider">		       
					 <li>
			          	 <div class="banner1">
			           		<div class="caption">
					          	<h3><span>BONGGEUDA SUKBAK SUKBAK</span></h3> <!-- 메인화면 문구설정, 총 3페이지 -->
					          	<p>업주 여러분 환영합니다 !</p>
			          		</div>
			          	</div>
			         </li>
					 <li>
			          	 <div class="banner2">
			           		<div class="caption">
								<h3><span>봉그다 숙박숙박</span></h3>
								<p>여러분의 멋진 숙소를 등록해 보세요.</p>
			          		</div>
			          	</div>
			         </li>
			         <li>
			          	 <div class="banner3">
			           		<div class="caption">
								<h3><span>봉그다 숙박숙박</span></h3>
								<p>다양한 고객들과 소통해 보세요.</p>
			          		</div>
			          	</div>
			         </li>		
			      </ul>
			  </div>
			</div>
		</div>
	</div>
	<!--header-bottom-->
	<div class="banner-bottom-top">
			<div class="container">
			<div class="bottom-header">
				<div class="header-bottom">
					<div class=" bottom-head">
						<a href="/WebContent/WEB-INF/views/owner/roomRegistration/registration.jsp"> <!--숙소 등록 페이지로 연결-->
							<div class="buy-media">
								<i class="buy"> </i>
								<h6>숙소 등록</h6>
							</div>
						</a>
					</div>
					<div class=" bottom-head">
						<a href="managementNoRoom.jsp"> <!--숙소 관리 페이지로 연결-->
							<div class="buy-media">
							<i class="rent"> </i>
							<h6>숙소 관리</h6>
							</div>
						</a>
					</div>
					<div class=" bottom-head">
						<a href="booking.jsp"> <!--예약 관리 페이지로 연결-->
							<div class="buy-media">
							<i class="pg"> </i>
							<h6>예약 관리</h6>
							</div>
						</a>
					</div>
					<div class=" bottom-head">
						<a href="QnA.jsp">
							<div class="buy-media">
							<i class="sell"> </i>
							<h6>Q & A</h6>
							</div>
						</a>
					
						</a>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--//-->		
<!--//header-bottom-->
<!--//header-->
<!--content-->
<div class="content">
	<div class="content-grid">
		<div class="container">
			<h3 style="font-family:'nanum';">나의 숙소</h3>
			<div class="col-md-4 box_2">
			 	<a href="managementYesRoom.jsp" class="mask">
			 		<img class="img-responsive zoom-img" src="resources/owner/images/pc4.jpg" alt="">
			 		<span class="four">100,000원</span>
			 	</a>
			 	<div class="most-1">
			 	   	<h5><a href="single.jsp">숲 속 통나무집</a></h5>
			 	    	<p>게스트 하우스</p> 
			</div>
			<aside>
					<div class="hi-icon-wrap hi-icon-effect-3 hi-icon-effect-3b" style="margin-top: -160px; margin-left: 800px;">
						<a href="roomRegistration/registration.jsp" class="hi-icon hi-icon-pencil">Edit</a>
					</div>
			</aside>
			</div>
		</div>
	</div>
</div>
<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top-at">
			<div class="col-md-3 amet-sed">
				<h4>Our Company</h4>
				<ul class="nav-bottom">
					<li><a href="about.jsp">About Us</a></li>
					<li><a href="blog.jsp">For Sale By Owner Blog</a></li>
					<li><a href="mobile_app.jsp">Mobile</a></li>
					<li><a href="terms.jsp">Terms & Conditions</a></li>
					<li><a href="privacy.jsp">Privacy Policy</a></li>	
					<li><a href="blog.jsp">Blog</a></li>
					
				</ul>	
			</div>
			<div class="col-md-3 amet-sed ">
				<h4>Work With Us</h4>
					<ul class="nav-bottom">
						<li><a href="single.jsp">Real Estate Brokers</a></li>
						<li><a href="single.jsp">Business Development</a></li>
						<li><a href="single.jsp">Affiliate Programs</a></li>
						<li><a href="contact.jsp">Sitemap</a></li>
						<li><a href="career.jsp">Careers</a></li>
						<li><a href="feedback.jsp">Feedback</a></li>	
					</ul>	
			</div>
			<div class="col-md-3 amet-sed">
				<h4>Customer Support</h4>
				<p>Mon-Fri, 7AM-7PM </p>
				<p>Sat-Sun, 8AM-5PM </p>
				<p>177-869-6559</p>
					<ul class="nav-bottom">
						<li><a href="#">Live Chat</a></li>
						<li><a href="faqs.jsp">Frequently Asked Questions</a></li>
						<li><a href="suggestion.jsp">Make a Suggestion</a></li>
					</ul>	
			</div>
			<div class="col-md-3 amet-sed ">
				<h4>Property Services</h4>
				   <ul class="nav-bottom">
						<li><a href="single.jsp">Residential Property</a></li>
						<li><a href="single.jsp">Commercial Property</a></li>
						<li><a href="login.jsp">Login</a></li>
						<li><a href="register.jsp">Register</a></li>
						<li><a href="typo.jsp">Short Codes</a></li>	
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
				<h2><a href="main.jsp">Bonggeuda</a></h2>
			</div>
			<div class="col-md-8 footer-class">
				<p >© 2021 Bonggeuda SUKBAKSUKBAK. All Rights Reserved | Design by  <a href="http://w3layouts.com/" target="_blank">Bonggeuda</a> </p>
			</div>
		<div class="clearfix"> </div>
	 	</div>
	</div>
</div>
<!--//footer-->
</body>
</html>