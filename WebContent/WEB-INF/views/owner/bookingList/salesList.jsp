<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>봉그다 숙박숙박 :: 예약 관리</title>
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
		padding: 3px;
		line-height: 2.5;
		font-weight: 500;
		width: auto;
	}
	th a:hover{
		color: #6eceda !important;
	}
	.table > tbody > tr > td{
		padding: 0px;
	}
	table.table tr td {
    text-align: -webkit-right;
	}
	table.table tr td.midName{
		text-align: center;
	}
	.pagination {
    	margin-top: auto;
	}
 </style>
</head>
<body>
<!--header-->
<!--header-->
<div class="header">
	<div class="container">
		<!--logo-->
			<div class="logo">
				<h1><a href=/bonggeuda/owner/main>Bonggeuda</a></h1>
			</div>
		<!--//logo-->
		<div class="top-nav">
			<ul class="right-icons">
				<li><a href="/bonggeuda/owner/registration">숙소등록</a></li>
				<li><a href="/bonggeuda/owner/managementRoom">숙소관리</a></li>
				<li><a href="/bonggeuda/owner/bookingList">예약관리</a></li>
				<li><a href="/bonggeuda/owner/notice">공지사항</a></li>
				<li><a href="/bonggeuda/owner/mypage">마이페이지</a></li>
				<li><a href="/bonggeuda/"><i class="glyphicon glyphicon-user"></i>Logout</a></li>
			</ul>
		</div>
	</div>
</div>
<!--header-->
<!--//-->	
<div class=" banner-booking"> <!--상단 메뉴바-->
	<div class=" container">
		<h3>예약 관리</h3> 
	<!---->
	<div class="clearfix"> </div>
		<!--initiate accordion-->
		<script type="text/javascript">
			$(function() {
			    var menu_ul = $('.menu > li > ul'),
			           menu_a  = $('.menu > li > a');
			    menu_ul.hide();
			    menu_a.click(function(e) {
			        e.preventDefault();
			        if(!$(this).hasClass('active')) {
			            menu_a.removeClass('active');
			            menu_ul.filter(':visible').slideUp('normal');
			            $(this).addClass('active').next().stop(true,true).slideDown('normal');
			        } else {
			            $(this).removeClass('active');
			            $(this).next().stop(true,true).slideUp('normal');
			        }
			    });
			});
		</script>
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
				<li class="blog-list"><a href="/bonggeuda/owner/bookingList">실시간 예약 현황</a></li>
				<li class="blog-list"><a href="/bonggeuda/owner/bookingPastList">지난 예약</a></li>
				<li class="blog-list"><a href="/bonggeuda/owner/book/question">고객 문의</a></li>
				<li class="blog-list" style="font-size: 1.3em; font-weight: 600;"><a href="/bonggeuda/owner/sales" style="color: #6eceda;">매출 내역</a></li>
			</ul>
			</nav>
			
			<c:forEach var="sales" items="${ requestScope.selectSales }">
			<div id="content" class="sub_wrap more_wrap">
				<div class="align_rt">
					<!-- Tab -->
					<div class="tab">
						<span class="tab_btn active"><c:out value="${ sales.accomoName }"></c:out></span>
						<span class="tab_btn" onclick="location.href='booking_sales2.html'">다른숙소명</a></span>
					</div>
				</div>
			</div>
			<table class="table" style="width: 1000px;">
				<thead>
					<tr>
						<th  style="background: #eaeaea;"><b>숙소명</b></th>
					</tr>
				</thead>
				<tbody>
				   	<tr>
						<th><c:out value="${ sales.accomoName }"></c:out></th>
					</tr>
				</tbody>
			</table>
			<br>
			</c:forEach>
			
			<table class="table" style="width: 1000px;">
				<thead>
					<tr>
						<th colspan="4" style="background: #eaeaea;"><b>객실별 예약건수</b></th>
					</tr>
					<th><b>기간</b></th>
					<th><b>예약</b></th>
					<th><b>객실명</b></th>
					<th><b>합산예약</b></th>
				</thead>
				<tbody>
				   	<tr>
						<th rowspan="3">2021 - 05</th>
						<c:forEach var="sales" items="${ requestScope.selectSales }">
							<td class="midName"><c:out value="${ sales.roomName }"></c:out></td>
							<td><c:out value="${ sales.bookCount }"></c:out> (건)</td>
						</c:forEach>
						<th rowspan="3"> 총 28 (건)</th>
					</tr>				   	
					<tr>
						<td class="midName">통나무 2호</td>
						<td>10 (건)</td>
					</tr>
					<tr>
						<td class="midName">통나무 3호</td>
						<td>13 (건)</td>
					</tr>
					<tr>
						<th rowspan="3">2021 - 04</th>
						<td class="midName">통나무 1호</td>
						<td>8 (건)</td>
						<th rowspan="3"> 총 26 (건)</th>
					</tr>				   	
					<tr>
						<td class="midName">통나무 2호</td>
						<td>7 (건)</td>
					</tr>
					<tr>
						<td class="midName">통나무 3호</td>
						<td>11 (건)</td>
					</tr>
					<tr>
						<th rowspan="3">2021 - 03</th>
						<td class="midName">통나무 1호</td>
						<td>5 (건)</td>
						<th rowspan="3"> 총 17 (건)</th>
					</tr>				   	
					<tr>
						<td class="midName">통나무 2호</td>
						<td>5 (건)</td>
					</tr>
					<tr>
						<td class="midName">통나무 3호</td>
						<td>7 (건)</td>
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
			 <br>
			 <table class="table" style="width: 1000px;">
				 <thead>
					 <tr>
						 <th colspan="6" style="background: #eaeaea;"><b>월 매출</b></th>
					 </tr>
					 <th><b>기간</b></th>
					 <th><b>매출액</b></th>
					 <th><b>수수료</b></th>
					 <th><b>정산액</b></th>
				 </thead>
				 <tbody>
					<tr>
						<th>2021 - 05</th>
						<td>3,000,000 (원)</td>
						<td>300,000 (원)</td>
						<td>2,700,000 (원)</td>
					</tr>
					<tr>
						<th>2021 - 04</th>
						<td>3,000,000 (원)</td>
						<td>300,000 (원)</td>
						<td>2,700,000 (원)</td>
					</tr>
					<tr>
						<th>2021 - 03</th>
						<td>3,000,000 (원)</td>
						<td>300,000 (원)</td>
						<td>2,700,000 (원)</td>
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
<br><br><br><br><br>
<br><br><br><br><br>
<br><br><br><br><br>
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