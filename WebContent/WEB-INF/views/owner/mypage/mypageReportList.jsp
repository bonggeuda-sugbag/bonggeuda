<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>봉그다 숙박숙박 :: 신고 내역 </title>
<link href="${pageContext.servletContext.contextPath }/resources/owner/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.servletContext.contextPath }/resources/owner/js/jquery.min.js"></script>

<script src="${pageContext.servletContext.contextPath }/resources/owner/js/scripts.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/owner/js/event.js"></script>
<link href="${pageContext.servletContext.contextPath }/resources/owner/css/styles.css" rel="stylesheet">

<link href="${pageContext.servletContext.contextPath }/resources/owner/css/style.css" rel="stylesheet" type="text/css" media="all" />	

<script src="${pageContext.servletContext.contextPath }/resources/owner/js/responsiveslides.min.js"></script>


	<meta charset="UTF-8" />

	<link rel="shortcut icon" href="../favicon.ico"> 
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/resources/owner/css/default.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/resources/owner/css/component.css" />
	<script src="${pageContext.servletContext.contextPath }/resources/owner/js/modernizr.custom.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<style>
	div.tab, div.tab-content {
		  margin-left: 20%;
		  margin-right: 4.8%;
	}
	.table tbody tr th{
		background: white;
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
 </style>
</style>
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
				<li><a href="/bonggeuda/owner/managementRoom">숙소관리</a></li>
				<li><a href="/bonggeuda/owner/bookingList">예약관리</a></li>
				<li><a href="/bonggeuda/owner/notice">공지사항</a></li>
				<li><a  href="/bonggeuda/owner/mypage">마이페이지</a></li>
				<li><a  href="login.html"><i class="glyphicon glyphicon-user"> </i>Login</a></li>
			</ul>
		</div>
	</div>
</div>
<!--//-->	
<div class=" banner-mypage"> <!--상단 메뉴바-->
	<div class=" container">
		<h3>마이페이지</h3> 
	</div>
</div>
<!--//header-->
<br><br>
<div class="blog">
	<div class="container">
		<div class="blog-list">
			<nav>
			<div class="col-md-3 blog-sidebar">
			<ul>
				<li class="blog-list"><a href="/bonggeuda/owner/mypage">마이 페이지</a></li>
				<li class="blog-list" style="font-size: 1.3em; font-weight: 600;"><a href="/bonggeuda/owner/mypgeReport" style="color: #6eceda;">신고 내역</a></li>
				<li class="blog-list" style=><a href="/bonggeuda/owner/settlement" >정산 신청</a></li>
				<li class="blog-list" style=><a href="/bonggeuda/owner/taxbillList" >세금 계산서 발행</a></li>
			</ul>
			</nav>
			
			<div class="tab">
			    <span class="tab_btn active">신고 내역</span>
			 </div>
			<table class="table table-hover" style="width: 1000px;">
				<thead>
				    <tr>
						<th><b>번호</b></th>
						<th><b>신고제목</b></th>
						<th><b>신고일자</b></th>
						<th><b>처리상태</b></th>
				    </tr>
				</thead>
				<tbody>
				<c:forEach var="reportBoard" items="${ requestScope.reportList }"> 
				<c:set var="i" value="${ i+1 }"/>
				   	<tr>
						<th>${ i }</th>
						<th>
						<form action="/bonggeuda/owner/reportDetail" method="post">
						<input type="hidden" name="reportNo" value="${reportBoard.reportNo}">
						<button class="submit-btn" type="submit" style="color: black">
						<c:out value="${ reportBoard.reportTitle }"/>
						</button>
						</form>
						</th>
						<th>
						<c:out value="${ reportBoard.reportDate }"/>
						</th>
						<th>
						<c:choose>
							
						<c:when test="${ reportBoard.reportStatus eq 'Y'}">
						처리완료
						</c:when>
						<c:when test="${ reportBoard.reportStatus eq 'N'}">
						처리중
						</c:when>
						<c:when test="${ reportBoard.reportStatus eq 'C'}">
						신고 거절
						</c:when>
						
						</c:choose>
							</th>
					</tr>   
				</c:forEach>
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