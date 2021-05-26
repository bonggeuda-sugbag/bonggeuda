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
<title>봉그다 숙박숙박 :: 세금계산서 신청</title>
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
<!-- <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> -->
<style>
	.col-md-3 {
    height: 600px;
	}
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
				<li><a href="/bonggeuda/"><i class="glyphicon glyphicon-user"></i>Logout</a></li>
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
				<li class="blog-list"><a href="/bonggeuda/owner/mypgeReport" >신고 내역</a></li>
				<li class="blog-list"><a href="/bonggeuda/owner/settlement" >정산 신청</a></li>
				<li class="blog-list" style="font-size: 1.3em; font-weight: 600;"><a href="/bonggeuda/owner/taxbillList" style="color: #6eceda;">세금 계산서 발행</a></li>
			</ul>
			</nav>
		</div>
		<form action="/bonggeuda/owner/requestTaxBill" method="get"><!-- 여기서 클릭 하면 인서트가 되고 내역 페이지로 넘어간다. -->
		<table id="registTb" class="table table-bordered" style="margin: initial;">
			<tbody>
			<div class="basic">
				<tr>
					<th> 숙소 선택</th>
					<td>
					<select name="accmoName" class="select-time" style="font-size: 15px;">
					<c:forEach var="accmoNames" items="${ requestScope.accomoNameList }">						
						<option  value="${ accmoNames.accomoName }">
							<c:out value="${ accmoNames.accomoName }"/>							
						</option>
					</c:forEach>
					</select>
					</td>
				</tr>
			
				<tr>
					<th rowspan="2">세금 계산서<br> 날짜 설정</th>
					
				<td style="height: 100px">
					<p>* 관리자 승인 후 다운로드 버튼이 활성화 됩니다.</p>

					<span class="form-title" style="display:inline-block; margin-top: 20px;" >기간 선택</span>
					<label><input type="date" name="startDate" id="" required></label>
					<span>~</span>
					<label><input type="date" name="endDate" id=""></label>
					
					
				</td>
			</tr>
			<tr>
				<td style="text-align: center;">
					<button type="submit" class="submit-btn" onclick=taxBillToAdmin()>신청하기</button>
					
				</td>
				
			</tr>
		</div>
	</tbody>
</table>
</form>
<script>

</script>
</div>
</div>
</body>
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