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
<title>Real Home A Real Estate Category Flat Bootstarp Resposive Website Template | Buy :: w3layouts</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--menu-->
<script src="js/scripts.js"></script>
<link href="css/styles.css" rel="stylesheet">

<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<!-- <link href="css/common.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/product.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="all" /> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Real Home Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<style>
.container h3{
	display: block; 
	font-size: 18px; 
	color: rgba(0,0,0,0.87);
}

.list_wrap button{
	width: 180px;
	height: 30px;
	padding: 1px 5px 1px 5px;
}

.suksoList{
    width: 800px; height:250px;background-color: pink;
	
}

.banner-buying h3 span {
    border-bottom: 7px solid #6eceda;
}

.accept{
	width: 100px; 
	height: 80; 
	padding: 8px 0 8px 0;
	background: #6eceda; 
	color: white; 
	border-style: none;
	box-shadow: 0 3px 0 #0e8c73;
	border-radius: 10px;
}

.reset{
	margin-right: 10px; 
	width: 100px; 
	height: 80; 
	padding: 8px 0 8px 0; 
	border-radius: 10px; 
	border-style: none;
	box-shadow: 0 3px 0 rgba(0, 0, 0, 0.4);
}
.infoThumb{
	width: 100%; 
	height: 50%; 
	margin-top: 120px; 
	padding: 20px 20px 5px 20px;
}
.infoThumb h2{
	text-align: left; 
	color: white;
	font-size: 30px;
}
.infoScore{
	color: orange; 
	width: 85%; 
	text-align: left;
	font-size: 20px;
}

.infoPrice{
	color:white; 
	width : 15%; 
	text-align:right;
	font-size:  20px; 
	font-weight: bold;
}

</style>
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
		<!-- 상단메뉴바 -->
		<div class="top-nav">
			<ul class="right-icons">
				<li><span ><a  href="index.jsp">메인페이지</a></span></li>
				<li><a  href="more_notice.jsp">더보기</a></li>
				<li><a  href="blog.jsp">내주변</a></li>
				<li><a  href="mypage_point.jsp">마이페이지</a></li>
				<li><a  href="login.jsp"><i class="glyphicon glyphicon-user"> </i>로그인</a></li>
			</ul>
			<!-- //상단메뉴바 -->
				
			</div>
		<div class="clearfix"> </div>
		</div>
		<div class="clearfix"> </div>
		</div>	
</div>
<!--//-->	
<div class=" banner-buying">
	<div class=" container">
	<h3 style="color: #fff; font-weight: 500; font-size: 3em;"><span style="border-bottom: 7px solid #6eceda;">숙소예약</span></h3> 
	<!---->
	
	<div class="clearfix"> </div>
		<!--initiate accordion-->
		
      		
	</div>
</div>
<!--//header-->
<div class="container" style="width: 1000; height: 800; display: flex;">
	

	<!-- Filter -->
	<div class="filter_wrap" style=" width: 300; height: 400; float: left; display: inline-block !important; top: 40px; margin: 0 32px 0 31px; padding-bottom: 10px; border: 1px solid rgba(0,0,0,0.08); border-radius: 4px; ">
		
		<hr>
		<section class="date_wrap" style="display: block; margin:10px 0 24px 0 ;  border-bottom: none; box-sizing: border-box;">
			<h3 style="display: block; font-size: 18px; color: rgba(0,0,0,0.87);">숙박일</h3>
			<br>
			<div style="margin-bottom: 10px;">
				입실<input type="date" style="margin-left: 10px;">
			</div>
			<div>
				퇴실<input type="date" style="margin-left: 10px;">
			</div>					
		</section>
		<hr>
		<h3 style="margin-bottom: 15px;">상세조건</h3>

		<div>
			<button class="reset" >초기화</button>
			<button class="accept" >적용</button>
		</div>
		<hr>
		<div>
			<h3 style="margin-bottom: 15px;">인원</h3>
			<input type="number" min="1" placeholder="1" style="width:50px;padding-left: 10px; text-align: center;">  명</input>
		</div>
		<hr>
		<div  style="position :relative; width: 250px; ; display: block; padding: 0 0 0 15px;" >
			<ul >
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" id="possible">  예약 가능</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  주방/식당</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  건조기</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  탈수기</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  엘레베이터</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  객실내흡연</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  와이파이</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  욕실용품</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  에어컨</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  객실샤워실</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  반려견동반</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  드라이기</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  조식포함</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  주차장</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  욕조</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  짐보관가능</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  공용PC</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  개인사물함</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  TV</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  무료주차</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  BBQ</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  프린터사용</li>
				<li align = "left" style="margin-bottom: 15px;"><input type="checkbox" >  개인콘센트</li>
			</ul>
			<hr>
		
			
		</div>
		

		
			
		</div>
		<div style="width: 900px; height: 900px; padding: 10px; display: flex; flex-direction: column;">

			<div class=list_wrap style="width:900px; height:30px; margin: 30px 0 0 10px; display: flex; margin-bottom: 50px;">
				<button type="button" data-sort="HIT">
					<span>추천 순</span>
				</button>
				<button type="button" data-sort="DISTANCE">
					<span>거리 순</span>
				</button>
				<button type="button" data-sort="LOWPRICE">
					<span>낮은 가격 순</span>
				</button>
				<button type="button" data-sort="HIGHPRICE">
					<span>높은 가격 순</span>
				</button>
				<button style="margin-left: 14px;width:60px; height: 30px;">지도</button>
			</div>
			
			<div class="suksoList" style="background: url(../userWebFront/images/sampleHouse.PNG) no-repeat; background-size: 800px 250px;" onclick="location.href='moteldetailBook.jsp';" >
				
				<div class="infoThumb" >
					<h2>돌체파르니엔펜션</h2>
					<br>
					<div style="display: flex;">
						<div class="infoScore">평점 7.7(5)</div>
						<div class="infoPrice">72,000원</div>
					</div>
					
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