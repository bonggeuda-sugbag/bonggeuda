<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	div.tab, div.tab-content {
		margin-left: 20%;
	    margin-right: 4.8%;
	}
	.table tbody tr th{
		font-weight: 500 !important;
		background-color: white !important;
	}
	table.table tr th{
		text-align: center;
		padding: 5px;
		line-height: 2.5;
		font-weight: 500;
		width: auto;
	}
	th a:hover{
		color: #6eceda !important;
	}
	.table > thead > tr > th{
		padding: 7px !important;
	}
</style>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.servletContext.contextPath}/resources/owner/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.servletContext.contextPath}/resources/owner/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/owner/js/scripts.js"></script>
<link href="${pageContext.servletContext.contextPath}/resources/owner/css/styles.css" rel="stylesheet">
<link href="${pageContext.servletContext.contextPath}/resources/owner/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.servletContext.contextPath}/resources/owner/js/responsiveslides.min.js"></script>
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
				<h1><a href="/bonggeuda/owner/main">Bonggeuda</a></h1>
			</div>
		<!--//logo-->
		<div class="top-nav">
			<ul class="right-icons">
				<li><a href="/bonggeuda/owner/registration">숙소등록</a></li>
				<li><a href="/bonggeuda/owner/management">숙소관리</a></li>
				<li><a href="/bonggeuda/owner/booking">예약관리</a></li>
				<li><a href="/bonggeuda/owner/notice">공지사항</a></li>
				<li><a  href="/bonggeuda/owner/mypage">마이페이지</a></li>
				<li><a  href="login.html"><i class="glyphicon glyphicon-user"> </i>Login</a></li>
			</ul>
		</div>
	</div>
</div>
<!--header-->
<!--//-->	
<div class=" banner-booking"> <!--상단 메뉴바-->
	<div class=" container">
		<h3>1:1 문의</h3> 
	</div>
</div>
<!--blog-->
<br><br>
<div class="blog" style="padding-bottom: 20px;">
<div class="container">
	<div class="blog-list">
		<nav>
		<div class="col-md-3 blog-sidebar">
		<ul>
			<li class="blog-list"><a href="/bonggeuda/owner/notice">공지사항</a></li>
			<li class="blog-list"><a href="/bonggeuda/owner/frequently">자주 묻는 질문</a></li>
			<li class="blog-list" style="font-size: 1.3em; font-weight: 600;"><a href="/bonggeuda/owner/question/list" style="color: #6eceda;">1:1 문의</a></li>
			<li class="blog-list"><a href="/bonggeuda/owner/policy">약관 및 정책</a></li>
		</ul>
		</nav>
		<div class="tab" style="width: 1000px;">
			<span class="tab_btn active">나의 문의 내역</span>
			<span class="tab_btn" onclick="location.href='/bonggeuda/owner/question/write'">새 문의 작성</a></span>
		 </div>
		<table class="table table-hover" style="width: 1000px;">
			<thead>
				<tr>
					<th><b>번호</b></th>
					<th><b>제목</b></th>
					<th><b>등록일</b></th>
					<th><b>답변여부</b></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>1</th>
					<th>
						<a href="ManToMan_contents.html">급합니다. 정산이 안들어왔어요.</a></th>
					<th>21.05.18</th>
					<th>답변완료</th>
				</tr>   
			</tbody>
		 </table>
		 <div class="tab_each" style="display:block">
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
</div>
</div>
</div>
</div>
<!--footer-->
<div class="footer-bottom">
	<div class="container">
		<div class="col-md-4 footer-logo">
			<h2><a href="index.html">Bonggeuda</a></h2>
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