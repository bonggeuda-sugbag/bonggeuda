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
<title>봉그다숙박숙박</title>
<link href="resources/guest/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/guest/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--menu-->
<script src="resources/guest/js/scripts.js"></script>
<link href="resources/guest/css/styles.css" rel="stylesheet">
<!--//menu-->
<!--theme-style-->
<link href="resources/guest/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Real Home Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<style>
	.header{
		background-color: #6eceda;
	}
	.logo{

	}
.coronaBackground{
	width: 100%;
	height: 100%;
	background: url('resources/guest/images/jejuMap.PNG') no-repeat;
	background-position: 50% 0%;
}

.coronawrap{
	width:40%; 
	height:350px; 
	margin : auto;
	padding: 60px 30px 30px 30px;
}
.coronaTitle{
	margin: auto;
	width: 250px;
	background-color: #6eceda;
	margin-bottom: 20px;
	padding-top: 5px;
	height: 40px;
	border-radius: 10px;
	font-size: 18px;
	
}
.coronaTitle h3{
	margin: auto;
	color: white;
	height: 20px;


}
.coronawrap p{
	text-align: right;
	font-size: 15px;
}
.coronawrap .corona19{
	margin: auto;
	margin-top: 50px;
}
.coronawrap table{
	width: 100%;
	background: white;
}
.corona19 th,td{
	text-align: center;
	padding: 10px;
	height: 30px;
	border: 1px solid rgba(0, 0, 0, 0.8);
	border-radius: 10px;
	
}
</style>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- slide -->
<script src="resources/guest/js/responsiveslides.min.js"></script>
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
</head>
<body >


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
		
		<div class="clearfix"> </div>		</div>	
</div>

<!--//-->	
<div class=" header-right">
	<div class=" banner">
		 <div class="slider">
			<div class="callbacks_container">
			  <ul class="rslides" id="slider">		       
				 <li>
					   <div class="banner1">
						   <div class="caption">
							  <h3><span>BONGGEUDA</span></h3> <!-- 메인화면 문구설정, 총 3페이지 -->
							  <p style="text-align: left;">환영합니다!</p>
						  </div>
					  </div>
				 </li>
				 <li>
					   <div class="banner2">
						   <div class="caption">
							<h3><span>BONGGEUDA</span></h3>
							<p>안전한 여행은 봉그다와 함께~</p>
						  </div>
					  </div>
				 </li>
				 <li>
					   <div class="banner3">
						   <div class="caption">
							<h3><span>BONGGEUDA</span></h3>
							<p>다양한 숙소들을 이용해보세요.</p>
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
					<div class=" bottom-head" style="position: relative; left: 170px;">
						<a href="motelInfo.html">
							<div class="buy-media" >
								<i class="buy"> </i>
								<h6>모텔</h6>
							</div>
						</a>
					</div>
					<div class=" bottom-head"  style="position: relative; left: 310px;">
						<a href="motelInfo.jsp">
							<div class="buy-media">
							<i class="rent"> </i>
							<h6>호텔</h6>
							</div>
						</a>
					</div>
					<div class=" bottom-head"  style="position: relative; left: 470px;">
						<a href="motelInfo.jsp">
							<div class="buy-media">
							<i class="pg"> </i>
							<h6>게스트하우스</h6>
							</div>
						</a>
					</div>
	
					<div class="clearfix"> </div>
				</div>
			</div>
	</div>
	</div>
			<!--//-->
				
	<!--//header-bottom-->
	
	
<!--//header-->
<!--content-->

<hr style="margin-top: 100px;">
<div class="coronaBackground">
	<div class="coronawrap" >
		<div class="coronaTitle">
			<h3>제주도 코로나 현황</h3>
		</div>
		<p>기준일 : 2021.05.09 </p>
		<table class="corona19" >
			<thead>
				<tr>
					<th>확진자수</th>
					<th>격리중</th>
					<th>격리해제</th>
					<th>전일대비 증감</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>10</td>
					<td>500</td>
					<td>500</td>
					<td>5</td>
	
				</tr>
			</tbody>
	
		</table>
	</div>
</div>

<hr>
<div class="content">
	<div class="content-grid" style="position: relative; top: 80px; margin: 0 auto;">
		<div class="container margin:0 auto;">
			<h3 style="text-align: center;" >  봉그다 소식  </h3>
			<br><br><br>
				<div class="col-md-4 box_2">
			     	 <a href="more_notice.jsp" class="mask">
			     	   	<img class="img-responsive zoom-img" src="resources/guest/images/pc4.jpg" alt="">
			     	 </a>
			     	   <div class="most-1">
<<<<<<< HEAD
			     	   	 <h5><a href="more_notice.html">공지사항</a></h5>
=======
			     	   	 <h5><a href="more_notice.jsp">일단공지사항으로</a></h5>
>>>>>>> branch 'master' of https://github.com/bonggeuda-sugbag/bonggeuda.git
			     	   </div>
			 </div>
			  <div class="col-md-4 box_2">
		     	 <a href="event.jsp" class="mask">
			     	   	<img class="img-responsive zoom-img" src="resources/guest/images/pc5.jpg" alt="">
			     	 </a>
		     	   <div class="most-1">
<<<<<<< HEAD
			     	   	<h5><a href="event.html">이벤트</a></h5>
=======
			     	   	<h5><a href="event.jsp">일단이벤트로</a></h5>
>>>>>>> branch 'master' of https://github.com/bonggeuda-sugbag/bonggeuda.git
			     	   </div>
		     	
		      </div>
		
			  
		      </div>
		 	
			 <br><br><br><br><br><br><br>     	
		</div>
		
	</div>

	
</body>

</html>
