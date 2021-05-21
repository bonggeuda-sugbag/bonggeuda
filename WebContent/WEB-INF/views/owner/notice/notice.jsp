<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script>
		$(document).ready(function(){
			// Add minus icon for collapse element which is open by default
			$(".collapse.show").each(function(){
				$(this).siblings(".card-header").find(".btn i").html("remove");
				$(this).prev(".card-header").addClass("highlight");
			});
			
			// Toggle plus minus icon on show hide of collapse element
			$(".collapse").on('show.bs.collapse', function(){
				$(this).parent().find(".card-header .btn i").html("remove");
			}).on('hide.bs.collapse', function(){
				$(this).parent().find(".card-header .btn i").html("add");
			});
		});
		</script>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,500|Open+Sans">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
		
		<title>봉그다 숙박숙박 :: 공지사항</title>
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
	.container, .container-lg, .container-md, .container-sm, .container-xl {
    max-width: 1300px;
	}
</style>
</head>
<body>
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
		<h3>공지사항</h3>
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
						<li class="blog-list" style="font-size: 1.3em; font-weight: 600;"><a href="QnA.html" style="color: #6eceda;">공지사항</a></li>
						<li class="blog-list"><a href="FAQ1.html">자주 묻는 질문</a></li>
						<li class="blog-list"><a href="ManToMan.html">1:1 문의</a></li>
						<li class="blog-list"><a href="policy1.html">약관 및 정책</a></li>
					</ul>
				</div>
			</nav>
		<!--공지사항 토글-->
		<div class="container-xl">
			<div class="row">
				<div class="col-lg-12">
					<div class="accordion" id="accordionExample">
						<div class="card">
							<div class="card-header" id="headingOne">
								<h2 class="clearfix mb-0">
									<a class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">[공지] 정산업무 지연 안내<i class="material-icons">add</i></a>									
								</h2>
							</div>
							<div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
								<div class="card-body">
									안녕하세요. <b>봉그다 숙박숙박</b> 입니다.<br>
									부득이한 내부 사정으로 인해 정산담당자 통화 요청 시 연락이 지연될 수 있어 안내드립니다.<br>
									너그러운 양해 부탁드리며, 변동사항이 있을 시 재공지 드리겠습니다.<br>
									감사합니다.
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingTwo">
								<h2 class="mb-0">
									<a class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">[안내] 고객 예약 건 취소 요청 방법<i class="material-icons">add</i></a>
								</h2>
							</div>
							<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
								<div class="card-body">
									안녕하세요. <b>봉그다 숙박숙박</b> 입니다.<br>
									<br>
									고객의 예약 건에 대해 취소가 필요할 경우,<br>
									구글 설문지로 요청해주시면 빠르게 처리가 가능합니다.<br>
									<br>
 									※ 취소는 고객과 통화 후 처리될 예정이며, 취소 완료 시 통지 수단에 따라 취소 내역이 발송됩니다.<br>
									※ 추가 확인이 필요하거나 특이 사항 발생 시 연락드릴 수 있습니다.<br>
									※ 제휴점 사유(만실, 가격 오등록 등)로 인해 취소 요청 시 안심 예약제에 적용되어 정산에 반영될 수 있으니 참고 부탁드립니다.<br>
									<br>
									여기어때는 편리한 숙소 운영을 위해 최선을 다하겠습니다.<br>
									그 밖에 궁금하신 부분은 고객행복센터에 문의해 주시기 바랍니다.<br>
									<br>
									감사합니다.<br>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingThree">
								<h2 class="mb-0">
									<a class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">[안내]취소 및 환불 규정<i class="material-icons">add</i></a>                     
								</h2>
							</div>
							<div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
								<div class="card-body">취소 및 환불 규정
									<br>
									- 숙박일 기준 10일전 : 100% 환불
									<br>
									- 숙박일 기준 5일전 : 50% 환불
									<br>
									- 숙박일 기준 1일전 ~ 당일 및 No-show : 환불불가
									<br>
									- 취소, 환불 시 수수료가 발생할 수 있습니다</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingFour">
								<h2 class="mb-0">
									<a class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">공지<i class="material-icons">add</i></a>                               
								</h2>
							</div>
							<div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
								<div class="card-body">공지</div>
							</div>
						</div>
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