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
		padding: 5px;
		line-height: 2.5;
		font-weight: 500;
		width: auto;
	}
	th a:hover{
		color: #6eceda !important;
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
				<h1><a href="index.html">Bonggeuda</a></h1>
			</div>
		<!--//logo-->
		<div class="top-nav">
			<ul class="right-icons">
				<li><a href="registration.html">숙소등록</a></li>
				<li><a href="managementYesRoom.html">숙소관리</a></li>
				<li><a href="booking.html">예약관리</a></li>
				<li><a href="QnA.html">공지사항</a></li>
				<li><a  href="mypage.html">마이페이지</a></li>
				<li><a  href="login.html"><i class="glyphicon glyphicon-user"> </i>Login</a></li>
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
                        <li class="blog-list" style=" font-size: 1.3em; font-weight: 600;">
                            <a href="booking.html" style="color: #6eceda;">실시간 예약 현황</a>
                        </li>
                        <li class="blog-list">
                            <a href="booking_past.html">지난 예약</a>
                        </li>
                        <li class="blog-list">
                            <a href="booking_QnA.html">고객 문의</a>
                        </li>
                        <li class="blog-list">
                            <a href="booking_sales.html">매출 내역</a>
                        </li>
                    </ul>
                </div>
            </nav>
			
			<div class="tab">
			    <span class="tab_btn active">예약 목록</span>
				<span style="margin-left:600px;">
					<select style="background-color: rgba(0, 0, 0, 0.05); border-radius: 5px;">
						<option>숙소명</option>
						<option>예약자</option>
						<option>예약확인</option>
						<option>이용상태</option>
					</select>
					<input type="text" name="" id="" style="width: 150px;">
					<button>
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</span>
			 </div>
			<table class="table table-hover" style="width: 1000px;">
				<thead>
				    <tr>
						<th><b>번호</b></th>
						<th><b>숙소명</b></th>
						<th><b>예약자</b></th>
						<th><b>인원</b></th>
						<th><b>전화번호</b></th>
						<th><b>날짜</b></th>
						<th><b>예약확인</b></th>
						<th><b>이용상태</b></th>
						<th><b>신고</b></th>
				    </tr>
				</thead>
				<tbody>
				   	<tr>
						<th>2</th>
						<th>
							<a href="booking_contents.html">제주 게스트하우스</a></th>
						<th>홍길동</th>
						<th>2</th>
						<th>010-2222-3333</th>
						<th>05/01 ~ 05/05</th>
						<th>확인</th>
						<th>결제완료</th>
						<th>
							<a href="report.html">
							<img src="../img/icon/siren.png" style="width: 26px; height: 26px;">
							</a>
						</th>
					</tr>   
					<tr>
						<th>1</th>
						<th>
							<a href="booking_contents.html">숲 속 통나무 집</a></th>
						<th>홍길동</th>
						<th>2</th>
						<th>010-2222-3333</th>
						<th>05/21 ~ 05/23</th>
						<th>확인</th>
						<th>승인완료</th>
						<th>
							<a href="report.html">
							<img src="../img/icon/siren.png" style="width: 26px; height: 26px;">
							</a>
						</th>
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