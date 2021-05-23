<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>봉그다 숙박숙박 :: 숙소 등록</title>
<link href="${pageContext.servletContext.contextPath}/resources/owner/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.servletContext.contextPath}/resources/owner/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/owner/js/scripts.js"></script>
<link href="${pageContext.servletContext.contextPath}/resources/owner/css/styles.css" rel="stylesheet">
<link href="${pageContext.servletContext.contextPath}/resources/owner/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<script src="${pageContext.servletContext.contextPath}/resources/owner/js/responsiveslides.min.js"></script>
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
				<li><a href="/bonggeuda/owner/management">숙소관리</a></li>
				<li><a href="/bonggeuda/owner/booking">예약관리</a></li>
				<li><a href="/bonggeuda/owner/notice">공지사항</a></li>
				<li><a  href="/bonggeuda/owner/mypage">마이페이지</a></li>
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
               <span class="btn-todo-off"><img src="${pageContext.servletContext.contextPath}/resources/owner/icon/step1.png" width="64px" height="64px"></span>
               <br><br>
               <span class="todo-desc on" style="color: rgb(226, 226, 226);">사업자정보 확인</span>
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
               <span class="btn-todo-on"><img src="${pageContext.servletContext.contextPath}/resources/owner/icon/step2.png" width="64px" height="64px"></span>
               <br><br>
               <span class="todo-desc" style="color: #6eceda;">소개 작성</span>
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
               <span class="btn-todo-off"><img src="${pageContext.servletContext.contextPath}/resources/owner/icon/step3.png" width="64px" height="64px"></span>
               <br><br>
               <span class="todo-desc" style="color: rgb(226, 226, 226);">이용규칙 관리</span>
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
               <span class="btn-todo-off"><img src="${pageContext.servletContext.contextPath}/resources/owner/icon/step4.png" width="64px" height="64px"></span>
               <br><br>
               <span class="todo-desc" style="color: rgb(226, 226, 226);">객실 등록</span>
            </li>
         </ul>
      </nav>
   </div>
</div>
<form action="${ pageContext.servletContext.contextPath }/registration2" method="post">
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
                  <input type="file" class="btn btn-default btn_add" data-role="img-uploader" data-ano="2826" data-armno="0" data-type="8">
               </div>
            </td>   
         </tr>
         <th>
            편의시설<br>서비스 시설안내 
         </th>
         <td>
            <label for="theme1" class="checkbox-inline icon-label" style="margin-right: 25px;">
               <input type="checkbox" id="theme1" name="arrayFacility"  value="세탁기">세탁기
            </label>
            <label for="theme2" class="checkbox-inline icon-label">
               <input type="checkbox" id="theme2" name="arrayFacility"  value="건조기">건조기
            </label>
            <label for="theme5" class="checkbox-inline icon-label">
               <input type="checkbox" id="theme5" name="arrayFacility"  value="객실내흡연">객실내흡연
            </label>
            <label for="theme6" class="checkbox-inline icon-label" >
               <input type="checkbox" id="theme6" name="arrayFacility"  value="와이파이" >와이파이
            </label>
            <br>
            <label for="theme7" class="checkbox-inline icon-label" >
               <input type="checkbox" id="theme7" name="arrayFacility"  value="욕실용품">욕실용품
            </label>
            <label for="theme8" class="checkbox-inline icon-label" >
               <input type="checkbox" id="theme8" name="arrayFacility"  value="에어컨">에어컨
            </label>
            <label for="theme9" class="checkbox-inline icon-label">
               <input type="checkbox" id="theme9" name="arrayFacility"  value="냉장고">냉장고
            </label>
            <label for="theme11" class="checkbox-inline icon-label">
               <input type="checkbox" id="theme11" name="arrayFacility"  value="반려견동반">반려견동반
            </label>
            <br>
            <label for="theme13" class="checkbox-inline icon-label">
               <input type="checkbox" id="theme13" name="arrayFacility"  value="조식포함">조식포함
            </label>
            <label for="theme18" class="checkbox-inline icon-label">
               <input type="checkbox" id="theme18" name="arrayFacility"  value="개인사물함">개인사물함
            </label>
            <label for="theme19" class="checkbox-inline icon-label" >
               <input type="checkbox" id="theme19" name="arrayFacility"  value="TV">TV
            </label>
            <label for="theme20" class="checkbox-inline icon-label" >
               <input type="checkbox" id="theme20" name="arrayFacility"  value="무료주차">무료주차
            </label>
         </td>
         <tr>
            <th>
               오시는길
            </th>
            <td>
               <div class="form-layer">
                  <textarea class="form-control textarea-layer" rows="9" name="accomoPath" placeholder="주요 버스터미널이나 기차역 혹은 공항 등에서 숙소까지 찾아가는 방법을 자세히 기재해 주세요."></textarea>
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
                  <textarea class="form-control textarea-layer" rows="9" name="near" placeholder="숙소 주변의 명소를 홍보하여 주세요. 교통, 관광, 쇼핑 명소부터 게스트하우스까지의 소요시간을 작성해 주시면 게스트들이 예약할 때 큰 도움이 됩니다."></textarea>
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
                  <textarea class="form-control textarea-layer" rows="7" name="rule" placeholder="숙소 내 필수 이용규칙이 있을 경우 기재해주세요."></textarea>
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
                  <textarea class="form-control textarea-layer" rows="7" name="parking" placeholder="주차장 유/무료 정보 및 시간당 요금을 기재해주세요."></textarea>
                  <div remain-traffic_info" class="maxText">(최대 500자)</div>
               </div>
            </td>
         </tr>
         </form>
         <tr>
            <br>
            <th colspan="2" style="background-color: white; ">
                  <button name="accomoName" value="${ requestScope.accomoDTO.accomoName }" class="submit-btn" type="submit" style="margin-top: 10px; margin-bottom: 10px;">저장하기</button>
            	  <input type="hidden" name="ceoName" value="${ requestScope.accomoDTO.ceoName }">
            	  <input type="hidden" name="accomoType" value="${ requestScope.accomoDTO.accomoType }">
            	  <input type="hidden" name="registNo" value="${ requestScope.accomoDTO.registNo }">
            	  <input type="hidden" name="address" value="${ requestScope.accomoDTO.address }">
            	  <input type="hidden" name="adrDetail" value="${ requestScope.accomoDTO.adrDetail }">
            	  <input type="hidden" name="email" value="${ requestScope.accomoDTO.email }">
            	  <input type="hidden" name="homepage" value="${ requestScope.accomoDTO.homepage }">
            </th>
         </tr>
      </tbody>
</table>
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