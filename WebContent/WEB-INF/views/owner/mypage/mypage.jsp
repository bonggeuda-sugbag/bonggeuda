<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>봉그다 숙박숙박 :: 마이 페이지</title>
<link href="resources/owner/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="resources/owner/js/jquery.min.js"></script>

<script src="resources/owner/js/scripts.js"></script>
<link href="resources/owner/css/styles.css" rel="stylesheet">

<link href="resources/owner/css/style.css" rel="stylesheet" type="text/css" media="all" />	

<script src="resources/owner/js/responsiveslides.min.js"></script>

<style>
.overlay {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.7);
  transition: opacity 500ms;
  visibility: hidden;
  opacity: 0;
  z-index: 900;
}

.overlay:target {
  visibility: visible;
  opacity: 1;
}

.popup {
  position: fixed;
  width: 60%;
  padding: 10px;
  max-width: 500px;
  border-radius: 10px;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background: rgba(255, 255, 255, .9);
  /* "delay" the visibility transition */
  -webkit-transition: opacity .5s, visibility 0s linear .5s;
  transition: opacity .5s, visibility 0s linear .5s;
  z-index: 1;
}

.h4{
	text-align: center;
	font-size: 2em;
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
				<li class="blog-list" style="font-size: 1.3em; font-weight: 600;"><a href="mypage.html"style="color: #6eceda;" >마이 페이지</a></li>
				<li class="blog-list" ><a href="myPage_report.html" >신고 내역</a></li>
				<li class="blog-list" style=><a href="mypage_taxes.html" >세금 계산서 발행</a></li>
			</ul>
			</nav>
			<table id="registTb" class="table table-bordered" style="margin-top: -50px;">
			<tbody>

				<tr class="tr1">
					<th>
						<p class="thName">
							이메일 (아이디)
						</p>
					</th>
					<td>
				
						<div class="form-layer">
							<input type="text" class="select-nomalsize" name="account_holder" value="myemail@naver.com" disabled style="background-color: lightgrey;">
						</div>
						
					</td>
				</tr>
				<tr>
					<th>
						<p class="thName">
							비밀번호 
						</p>
						<td>
							<div class="form-layer" >
								<input type="password" class="select-nomalsize" name="account_holder"value="">
								<button class="submit-btn" type="submit" style="margin-left: 20px;">비밀번호 변경하기</button>
							</div>
	
						</td>
						
					</th>
				</tr>
				<tr class="tr1">
					<th>
						<p class="thName">
							휴대전화 번호
						</p>
					</th>
					<td>
						<div class="form-layer">
							<input type="text" class="select-nomalsize" name="account_holder" placeholder="휴대전화 번호" value="010-1234-5678">
							<button class="submit-btn" type="submit" style="margin-left: 20px;">휴대전화번호 변경하기</button>
						</div>
						
					</td>
				</tr>
				<tr class="tr1">
					<th>
						<p class="thName">
							신고 누적 횟수
						</p>
					</th>
					<td>
						<div class="form-layer">
							<input type="text" class="select-nomalsize" name="account_holder" value="15" disabled style="background-color: lightgrey; font-size: large; width: 70px; font-weight: bold; text-align: center; color: magenta;">
						</div>
					</td>
				</tr>
				<tr>
					<br>
					<th colspan="2" style="background-color: white; ">
						<div>
							
							<br>
							<form action="" >
								
								<button class="submit-btn" type="submit" style="margin-top: 10px; margin-bottom: 10px;  background-color: orange;"  onclick="location.href='#pop01'">
									회원 탈퇴하기
								</button>
							</form>
						</div>
					</th>
				</tr>
			</tbody>
			<br><br>
	</table>
</div>
<!-- <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    new daum.Postcode({
        oncomplete: function(daumPostCode) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
</script> -->

				<!-- 회원탈퇴 팝업창 -->
				<div id="pop01" class="overlay">
					<div class="popup">
						<a href="#none" class="close">&times;</a>
							<p style="font-size: 20px; color: red; padding-bottom: 10px;">회원탈퇴</p>

							<div class="cont-step cont-step_02" id="contStep02" style="display: block;">
								<div class="cont-step_preface">
									<h4 class="h4">왜 떠나시는지 이유가 있을까요? </h4>
								</div>
								<br>
								<!-- 탈퇴이유 -->
								<ul class="reason-list" style="text-align: left;">
									<li>
										<input id="reasonRdo0" type="radio" name="radios" value="UN_USE_FREQUENTLY">
										<label for="reasonRdo0">사용을 잘 안하게 돼요</label>
									</li>
									<li>
										<input id="reasonRdo1" type="radio" name="radios" value="HAVE_NO_LIKED_HOTEL">
										<label for="reasonRdo1">숙소가 망했어요</label>
									</li>
									<li>
										<input id="reasonRdo2" type="radio" name="radios" value="DIFFICULT_TO_USE">
										<label for="reasonRdo2">예약, 취소, 혜택받기 등 사용이 어려워요</label>
									</li>
									<li>
										<input id="reasonRdo3" type="radio" name="radios" value="POINT_COUPON_TOO_LITTLE">
										<label for="reasonRdo3">복권 1등에 당첨됐어요</label>
									</li>
									<li>
										<input id="reasonRdo4" type="radio" name="radios" value="INFO_TO_DELETE">
										<label for="reasonRdo4">개인정보 보호를 위해 삭제할 정보가 있어요</label>
									</li>
									<li>
										<input id="reasonRdo5" type="radio" name="radios" value="EXISTING_ID">
										<label for="reasonRdo5">다른 계정이 있어요</label>
									</li>
									<li>
										<input id="reasonRdo6" type="radio" name="radios" value="OTHER" checked>
										<label for="reasonRdo6">기타</label>
										<div class="reason-innder-box reason-innder-box6"  style="margin-bottom: 10px;">
											<input name="reason" style="width:100%;float: left;" placeholder="죄송합니다 제발 탈퇴하지 말아주세요">
										</div>
									</li>
									</ul>
									<br>
								<div class="password-wrap">
									<div class="button-wrap" style="text-align: center;">
										<button class="submit-btn"  style="background-color: orange; " onclick="location.href='login.html'">
										탈퇴하기
										</button>
									</div>
								</div>
							</div>
							<script>
							$(document).ready(function(){
 
								// 라디오버튼 클릭시 이벤트 발생
								$("input:radio[name=radios]").click(function(){
							 
									if($("input[name=radios]:checked").val() == "OTHER"){
										$("input:text[name=reason]").attr("disabled",false);
										// radio 버튼의 value 값이 OTHER이라면 활성화
							 
									}else {
										  $("input:text[name=reason]").attr("disabled",true);
										// 그 외에는 비활성화
									}
								});
							});
						</script>
							


					</div>
				</div>

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