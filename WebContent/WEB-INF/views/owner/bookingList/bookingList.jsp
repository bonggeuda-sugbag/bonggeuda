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
                            <a style="color: #6eceda;">실시간 예약 현황</a>
                        </li>
                        <form action="/bonggeuda/owner/bookingPastList" method="get"> <!--   -->
                        <li class="blog-list">
                            <a href="/bonggeuda/owner/bookingPastList">지난 예약</a>
                        </li>
                        </form>
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
						<th><b>객실명</b></th>
						<th><b>예약자</b></th>
						<th><b>전화번호</b></th>
						<th><b>예약 인원</b></th>
						<th><b>시작 날짜</b></th>
						<th><b>종료 날짜</b></th>
						<th><b>예약확인</b></th>
						<th><b>이용상태</b></th>
						
				    </tr>
				</thead>
				<tbody>
				<c:forEach var="board" items="${ requestScope.bookList }">
				   	<tr>
				   	<c:set var="i" value="${i+1 }"/>				   	
				   	
						<th>${ i}</th>
						<th><c:out value="${ board.accomoName }"/></th>
 						<th>
 						<form action="/bonggeuda/owner/bookingList" method="post"><button type="submit" class="submit-btn"><c:out value="${ board.roomName }"/> </button>
						<input type="hidden" name="bookNo" value="${board.bookNo}">
						
						</th>
 						</form>
 						</th>
						<th><c:out value="${ board.bookUserName }"/></th>
						<th><c:out value="${ board.userPhone }"/></th> 
						<th><c:out value="${ board.bookPersonnel }"/></th> 
						<th><c:out value="${ board.bookCheckDate }"/></th>
						<th><c:out value="${ board.bookCheckoutDate }"/></th>
						<th>승인 대기</th>  
						<th>
						<c:choose>
							
							<c:when test="${ board.bookStatusYNC eq 'Y'}">
							 결제 완료
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