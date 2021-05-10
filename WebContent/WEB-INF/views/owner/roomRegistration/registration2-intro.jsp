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
					<span class="btn-todo-on"><img src="../img/icon/step2.png" width="64px" height="64px"></span>
					<br><br>
					<span class="todo-desc" style="color: #6eceda;">소개 작성</span>
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
					<span class="btn-todo-off"><img src="../img/icon/step3.png" width="64px" height="64px"></span>
					<br><br>
					<span class="todo-desc" style="color: rgb(226, 226, 226);">이용규칙 관리</span>
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
			<br><br>
			<tr class="tr1">
				<th>
					업체 이미지<br>(최대 5장) 
				</th>

				<td>
					<div class="basic">
						<p class="description" style="margin-bottom: 3px;">* 객실 및 업체 전경, 로비, 주차장 등 업체의 전반적인 이미지를 업로드해주시기 바랍니다.</p>
						<p class="description" style="margin-bottom: 3px;">* 이미지 교체를 원하시면 "변경"을 선택하시고 삭제를 원하시면 우측 "삭제"를 선택하시기 바랍니다.</p>
						<p class="description"  style="margin-bottom: 3px;">* 이미지 장소는 짧게 기입해주시기 바랍니다. 예시) 전경, 로비, 주차장 등</p>
						<p class="description text-normal">* 첫 이미지가 메인 이미지이며 드래그를 통해 순서 변경이 가능합니다.</p>
						<span class="form-title" style="display:inline-block";>    </span>
						<br>
						<button type="button" class="btn btn-default btn_add" data-role="img-uploader" data-ano="2826" data-armno="0" data-type="8">+ 이미지 추가</button>
					</div>
				</td>	
			</tr>
			<th>
				편의시설<br>서비스 시설안내 
			</th>
			<td>
				<label for="theme90" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme90" name="ad_theme[]"  value="90">주방/식당
				</label>
				<label for="theme1" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme1" name="ad_theme[]"  value="90">세탁기
				</label>
				<label for="theme2" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme2" name="ad_theme[]"  value="90">건조기
				</label>
				<label for="theme3" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme3" name="ad_theme[]"  value="90">탈수기
				</label>
				<label for="theme4" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme4" name="ad_theme[]"  value="90">엘레베이터
				</label>
				<label for="theme5" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme5" name="ad_theme[]"  value="90">객실내흡연
				</label>
				<br>
				<label for="theme6" class="checkbox-inline icon-label" >
					<input type="checkbox" id="theme6" name="ad_theme[]"  value="90" >와이파이
				</label>
				<label for="theme7" class="checkbox-inline icon-label" style="margin-left: 18px;">
					<input type="checkbox" id="theme7" name="ad_theme[]"  value="90">욕실용품
				</label>
				<label for="theme8" class="checkbox-inline icon-label" style="margin-left: 0px;">
					<input type="checkbox" id="theme8" name="ad_theme[]"  value="90">에어컨
				</label>
				<label for="theme9" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme9" name="ad_theme[]"  value="90">냉장고
				</label>
				<label for="theme10" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme10" name="ad_theme[]"  value="90">객실샤워실
				</label>
				<label for="theme11" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme11" name="ad_theme[]"  value="90">반려견동반
				</label>
				<br>
				<label for="theme12" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme12" name="ad_theme[]"  value="90">드라이기
				</label>
				<label for="theme13" class="checkbox-inline icon-label" style="margin-left: 18px;">
					<input type="checkbox" id="theme13" name="ad_theme[]"  value="90">조식포함
				</label>
				<label for="theme14" class="checkbox-inline icon-label" style="margin-left: 0px;">
					<input type="checkbox" id="theme14" name="ad_theme[]"  value="90">주차장
				</label>
				<label for="theme15" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme15" name="ad_theme[]"  value="90">욕조
				</label>
				<label for="theme16" class="checkbox-inline icon-label" style="margin-left: 24px;">
					<input type="checkbox" id="theme16" name="ad_theme[]"  value="90">짐보관가능
				</label>
				<label for="theme17" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme17" name="ad_theme[]"  value="90">공용PC
				</label>
				<br>
				<label for="theme18" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme18" name="ad_theme[]"  value="90">개인사물함
				</label>
				<label for="theme19" class="checkbox-inline icon-label" style="margin-left: 7px;">
					<input type="checkbox" id="theme19" name="ad_theme[]"  value="90">TV
				</label>
				<label for="theme20" class="checkbox-inline icon-label" style="margin-left: 33px; margin-right: 0px;">
					<input type="checkbox" id="theme20" name="ad_theme[]"  value="90">무료주차
				</label>
				<label for="theme21" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme21" name="ad_theme[]"  value="90">BBQ
				</label>
				<label for="theme22" class="checkbox-inline icon-label" style="margin-left: 24px;">
					<input type="checkbox" id="theme22" name="ad_theme[]"  value="90">프린터사용
				</label>
				<label for="theme23" class="checkbox-inline icon-label">
					<input type="checkbox" id="theme23" name="ad_theme[]"  value="90">개인콘센트
				</label>

			</td>
			<tr>
				<th>
					오시는길
				</th>

				<td>
					<div class="form-layer">
						<textarea class="form-control textarea-layer" rows="9" name="find_way" placeholder="주요 버스터미널이나 기차역 혹은 공항 등에서 숙소까지 찾아가는 방법을 자세히 기재해 주세요."></textarea>
						<div remain-traffic_info" class="maxText">(최대 1000자)</div>
					</div>
					
				</td>
			</tr>
			<tr>
				<th>
					주변 정보
				</th>
				<td>
					<div>
						<p class="description" style="margin-bottom: 3px;">* 숙소 주변의 명소(교통, 관광, 쇼핑 등 )와 이동수단, 게스트하우스로부터 소요시간을 기입해주세요.</p>
					</div>
					<div class="form-layer">
						<textarea class="form-control textarea-layer" rows="9" name="find_way" placeholder="숙소 주변의 명소를 홍보하여 주세요. 교통, 관광, 쇼핑 명소부터 게스트하우스까지의 소요시간을 작성해 주시면 게스트들이 예약할 때 큰 도움이 됩니다."></textarea>
						<div remain-traffic_info" class="maxText">(최대 1000자)</div>
					</div>
				</td>
			</tr>
			<tr>
				<th>
					숙소 이용<br>
					규칙
				</th>
				<td>
					<div class="form-layer">
						<textarea class="form-control textarea-layer" rows="7" name="find_way" placeholder="숙소 내 필수 이용규칙이 있을 경우 기재해주세요."></textarea>
						<div remain-traffic_info" class="maxText">(최대 500자)</div>
					</div>
				</td>
			</tr>
			<tr>
				<th>
					주차장<br>
					정보
				</th>
				<td>
					<div class="form-layer">
						<textarea class="form-control textarea-layer" rows="7" name="find_way" placeholder="주차장 유/무료 정보 및 시간당 요금을 기재해주세요."></textarea>
						<div remain-traffic_info" class="maxText">(최대 500자)</div>
					</div>
				</td>
			</tr>
			<tr>
				<br>
				<th colspan="2" style="background-color: white; ">
					<form action="registration3-rule.html">

						<button button class="submit-btn" type="submit" style="margin-top: 10px; margin-bottom: 10px;">저장하기</button>

					</form>

				</th>
				
			</tr>
			
			
		</tbody>
</table>
<br><br>
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