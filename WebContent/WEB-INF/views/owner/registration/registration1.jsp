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

<!-- <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> -->
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
<div class="clearfix"> </div>
</div>	
</div>
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
					<span class="btn-todo-on"><img src="../img/icon/step1.png" width="64px" height="64px"></span>
					<br><br>
					<span class="todo-desc on" style="color: #6eceda;">사업자정보 확인</span>
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
			<tr class="tr1">
				<th>
					<p class="thName">
						매출 정산
						<br>
						계좌 정보
					</p>
				</th>
				<td>
					<p class="description">
					<b>정산받을 계좌의 정보(은행, 계좌번호, 예금주)</b>를 봉그다숙박 관리자에게 메일로 보내주세요.<br>
					관리자 메일 : bonggeuda@subak.com	
					</p>
				</td>
			</tr>
			<tr class="tr1">
				<th>
					<p class="thName">
						사업자 <br>
						등록 정보
					</p>
				</th>
				<td>
			
					<div class="form-layer">
						<span class="form-title" style="display:inline-block";>상호명<br>(법인명)</span>
						<input type="text" class="select-nomalsize" name="account_holder" placeholder="사업자 등록증상 상호명" value="">
					</div>
					<p class="description">* 게스트하우스 이름은 별도로 기입이 가능하오니 필히 사업자 상호, 등록번호를 입력해주시기 바랍니다.
					</p>
					<div class="form-layer">
						<span class="form-title" style="display:inline-block";>등록증상<br>대표명</span>
						<input type="text" class="select-nomalsize" name="account_holder" placeholder="대표자 명을 입력하세요" value="">
					</div>

					<div class="form-layer">
						<span class="form-title" style="display:inline-block";>업종</span>
						<label class="checkbox-inline icon-label"><input type="radio" value="모텔" name="b_type[]" >모텔</label>
						<label class="checkbox-inline icon-label"><input type="radio" value="호텔" name="b_type[]">호텔</label>
						<label class="checkbox-inline icon-label"><input type="radio" value="게스트하우스" name="b_type[]">게스트하우스</label>

					</div>
					<div class="form-layer">
						<span class="form-title" style="display:inline-block";>사업자<br> 등록번호</span>
						<input type="text" class="select-nomalsize" name="account_holder" placeholder="숫자만 입력하세요" value="">
					</div>
					<div class="form-layer">
						<span class="form-title" style="display:inline-block";>업체 주소</span>
						<input type="text" class="select-nomalsize"  style="margin-bottom: 8px;"  name="account_holder" placeholder="사업자 등록증상 주소를 입력하세요" value="">
						<button class="submit-btn" type="submit" style="margin-left: 10px;" onclick="daumPostCode()"  >주소 검색</button>
						<br>
						<input type="text" style="margin-left: 125px; margin-top: 0px;" class="select-nomalsize" name="account_holder" placeholder="나머지 주소를 입력하세요." value="">
					</div>
					<div class="form-layer">
						<span class="form-title" style="display:inline-block";>세금계산서<br> 이메일</span>
						<input type="text" class="select-nomalsize" name="account_holder" placeholder="이메일을 입력하세요" value="">
					</div>

				</td>
			</tr>
			<tr>
				<th>
					<p class="thName">
						호스트 <br>
						홈페이지<br>
						(선택정보)
					</p>
					<td>
						<div class="form-layer">
							<span class="form-title" style="display:inline-block";>홈페이지</span>
							<input type="text" class="select-nomalsize" name="account_holder" placeholder="홈페이지 주소" value="">
						</div>

					</td>
					
				</th>
			</tr>
			<tr>
				<br>
				<th colspan="2" style="background-color: white; ">
					<form action="registration2-intro.html">

						<button class="submit-btn" type="submit" style="margin-top: 10px; margin-bottom: 10px;">저장하기</button>

					</form>

				</th>
				
			</tr>

		</tbody>
		<br><br>
</table>
<!-- <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    new daum.Postcode({
        oncomplete: function(daumPostCode) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
</script> -->

<script>
	function daumPostCode(){
		alert("주소를 찾아봅시다~");

	}
	
</script>
<script>
    new daum.Postcode({
        oncomplete: function(data) {
            
        }
    }).open();
</script>
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