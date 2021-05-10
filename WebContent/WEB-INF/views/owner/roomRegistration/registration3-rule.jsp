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
<title>봉그다 숙박숙박 :: 숙소 등록</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--menu-->
<script src="js/scripts.js"></script>
<link href="css/styles.css" rel="stylesheet">
<!--//menu-->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Real Home Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--달력-->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
<div class=" banner-buying"> <!--상단 메뉴바-->
	<div class=" container">
		<h3>숙소 등록</h3> 
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
<!--등록 단계 버튼-->
<div class="menu-step">
	<div class="todo-layer">
		<nav>
			<ul class="stepbox" id="ulStep">
				<li>
				<a href="registration.html">                        
					<span class="btn-todo-off"><img src="../img/icon/step1.png" width="64px" height="64px"></span>
					<br><br>
					<span class="todo-desc on" style="color: rgb(226, 226, 226);">사업자정보 확인</span>
				</a>                    
				</li>
				<li class="prog">
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
				</li>
				<li>
				<a href="registration2-intro.html">                        
					<span class="btn-todo-off"><img src="../img/icon/step2.png" width="64px" height="64px"></span>
					<br><br>
					<span class="todo-desc" style="color: rgb(226, 226, 226);">소개 작성</span>
				</a>                    
				</li>
				<li class="prog">
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
				</li>
				<li>
				<a href="registration3-rule.html">                        
					<span class="btn-todo-on"><img src="../img/icon/step3.png" width="64px" height="64px"></span>
					<br><br>
					<span class="todo-desc" style="color: #6eceda;">이용규칙 관리</span>
				</a>                    
				</li>
				<li class="prog">
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
					<span>&nbsp;</span>
					<span class="do">&nbsp;</span>
				</li>
				<li>
				<a href="registration4-room.html">                        
					<span class="btn-todo-off"><img src="../img/icon/step4.png" width="64px" height="64px"></span>
					<br><br>
					<span class="todo-desc" style="color: rgb(226, 226, 226);">객실 등록</span>
				</a>                    
				</li>
			</ul>
		</nav>
	</div>
</div>
<table id="registTb" class="table table-bordered">
	<thead>

	</thead>
		<tbody>
			<br><br><br>
			<tr class="tr1">
				<th>
					이용시간
				</th>
				<td>
					<div class="warning">
						<p> 
							* 봉그다 숙박숙박은 24시간 체크인 예약 가능 사이트입니다.
							<br>
							* 자세한 요금 규정은 공지사항을 참고해 주세요.
							<a href="QnA.html">&nbsp[바로가기]</a>                        
						</p>
					</div>
					<div class="basic">
						<span class="form-title" style="display:inline-block";>체크인 시간</span>
						<span>
							<select name="bank" class="select-time">
								<option value="00:00">0:00</option>
								<option value="1:00">1:00</option>
								<option value="2:00">2:00</option>
								<option value="3:00">3:00</option>
								<option value="4:00">4:00</option>
								<option value="5:00">5:00</option>
								<option value="6:00">6:00</option>
								<option value="7:00">7:00</option>
								<option value="8:00">8:00</option>
								<option value="9:00">9:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00" selected>15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
								<option value="23:00">23:00</option>
								<option value="24:00">24:00</option>
							</select>
						</span>
					</div>
					<div class="basic">
						<span class="form-title" style="display:inline-block";>체크아웃 시간</span>
						<span>
							<select name="bank" class="select-time">
								<option value="00:00">00:00</option>
								<option value="1:00">1:00</option>
								<option value="2:00">2:00</option>
								<option value="3:00">3:00</option>
								<option value="4:00">4:00</option>
								<option value="5:00">5:00</option>
								<option value="6:00">6:00</option>
								<option value="7:00">7:00</option>
								<option value="8:00">8:00</option>
								<option value="9:00">9:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00" selected>11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
								<option value="23:00">23:00</option>
								<option value="24:00">24:00</option>
							</select>
						</span>
					</div>
				</td>
			</tr>
			<tr class="tr1">
				<th>
					성수기 설정
				</th>
				<td>
					<div class="basic">
						<span class="form-title" style="display:inline-block";>기간 선택</span>
						<label><input type="date" name="" id=""></label>
						<span>~</span>
						<label><input type="date" name="" id=""></label>
					</div>
				</td>
			</tr>
			<tr>
				<br>
				<th colspan="2" style="background-color: white; ">
					<form action="registration4-room.html">

						<button button class="submit-btn" type="submit" style="margin-top: 10px; margin-bottom: 10px;">저장하기</button>

					</form>

				</th>
				
			</tr>
		</tbody>
	</table>
<br><br><br>
<br><br><br>
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