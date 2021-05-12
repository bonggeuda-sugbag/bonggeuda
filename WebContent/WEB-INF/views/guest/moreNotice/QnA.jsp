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
	<style>
		
div.tab, div.tab-content {
    margin-left: 25%;
    margin-right: 25%;
}

div.tab_each, div.list_none {
	margin-left: 25%;
    margin-right: 25%;
}

.inquiry .tab_each{display:none}
.inquiry .tab_each:first-child{display:block}
.inquiry .tab{display:none}
.tab_each{clear:both;border-top:1px solid rgba(0,0,0,0.08)}


table.table2{
    border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    line-height: 1.5;
	margin-bottom: 20px;
    }
	table.table2 tr {
        padding: 8px;
        vertical-align: top;
        border-bottom: 1px solid #ccc;
    }
    table.table2 td {
        padding: 8px;
        vertical-align: top;
        border-bottom: 1px solid #ccc;
    }
	textarea {
		resize: none;
		width: 550px;
	}

	.submit_QnA {
		width: 100px;
		border-radius: 10px;
		background: #6eceda;
		color: white;
		border-style: none;
		box-shadow: 0 3px 0 #0e8c73;
		height: 35px;
	}
	.submit_QnA:hover {
	background-color: #4aa9b6;
	box-shadow: 0 3px 0 #23a188;
	}
	.submit_QnA:active {
	box-shadow: none;
	}

	</style>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Real Home A Real Estate Category Flat Bootstarp Resposive Website Template | Blog :: w3layouts</title>
<link href="resources/guest/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/guest/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--menu-->
<script src="resources/guest/js/scripts.js"></script>
<link href="resources/guest/css/styles.css" rel="stylesheet">
<!--//menu-->
<!--theme-style-->
<link href="resources/guest/css/style.css" rel="stylesheet" type="text/css" media="all" />	
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
				<h1><a href="index.jsp">Bonggeuda</a></h1>
			</div>
		<!--//logo-->
		<div class="top-nav">
			<ul class="right-icons">
				<li><span ><a  href="index.jsp">메인페이지</a></span></li>
				<li><a  href="more_notice.jsp">더보기</a></li>
				<!-- <li><a  href="blog.jsp">내주변</a></li> -->
				<li><a  href="mypage_point.jsp">마이페이지</a></li>
            <li><a  href="login.jsp"><i class="glyphicon glyphicon-user"> </i>로그인</a></li>
			</ul>

				<!---
				<a href="#" class="right_bt" id="activator"><i class="glyphicon glyphicon-menu-hamburger"></i>  </a>
			--->
			</div>
			
		<div class="clearfix"> </div>
			<!---pop-up-box---->
				   
				<link href="resources/guest/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
				<script src="resources/guest/js/jquery.magnific-popup.js" type="text/javascript"></script>
			<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
					    <!----- tabs-box ---->
				<div class="sap_tabs">	
				     <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
						  <ul class="resp-tabs-list">
						  	  <li class="resp-tab-item " aria-controls="tab_item-0" role="tab"><span>All Homes</span></li>
							  <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>For Sale</span></li>
							  <li class="resp-tab-item" aria-controls="tab_item-2" role="tab"><span>For Rent</span></li>
							  <div class="clearfix"></div>
						  </ul>				  	 
						  <div class="resp-tabs-container">
						  		<h2 class="resp-accordion resp-tab-active" role="tab" aria-controls="tab_item-0"><span class="resp-arrow"></span>All Homes</h2><div class="tab-1 resp-tab-content resp-tab-content-active" aria-labelledby="tab_item-0" style="display:block">
								 	<div class="facts">
									  	<div class="login">
											<input type="text" value="Search Address, Neighborhood, City or Zip" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search Address, Neighborhood, City or Zip';}">		
									 		<input type="submit" value="">
									 	</div>        
							        </div>
						  		</div>
							     <h2 class="resp-accordion" role="tab" aria-controls="tab_item-1"><span class="resp-arrow"></span>For Sale</h2><div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts">									
										<div class="login">
											<input type="text" value="Search Address, Neighborhood, City or Zip" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search Address, Neighborhood, City or Zip';}">		
									 		<input type="submit" value="">
									 	</div> 
							        </div>	
								 </div>									
							      <h2 class="resp-accordion" role="tab" aria-controls="tab_item-2"><span class="resp-arrow"></span>For Rent</h2><div class="tab-1 resp-tab-content" aria-labelledby="tab_item-2">
									 <div class="facts">
										<div class="login">
											<input type="text" value="Search Address, Neighborhood, City or Zip" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search Address, Neighborhood, City or Zip';}">		
									 		<input type="submit" value="">
									 	</div> 
							         </div>	
							    </div>
					      </div>
					 </div>
					 <script src="resources/guest/js/easyResponsiveTabs.js" type="text/javascript"></script>
				    	<script type="text/javascript">
						    $(document).ready(function () {
						        $('#horizontalTab').easyResponsiveTabs({
						            type: 'default', //Types: default, vertical, accordion           
						            width: 'auto', //auto or any width like 600px
						            fit: true   // 100% fit in a container
						        });
						    });
			  			 </script>	
				</div>
				</div>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>
					
	
		</div>
		<div class="clearfix"> </div>
		</div>	
</div>
<!--//-->	
<div class=" banner-buying">
	<div class=" container">
	<h3><span>더보기</span></h3> 

	<div class="clearfix"> </div>      		
	</div>
</div>
<!--//header-->
<!--blog-->
<div class="blog" style="padding-bottom: 20px;">
<div class="container">
	<h3></h3>
	<div class="blog-list">
		<nav>
		<div class="col-md-3 blog-sidebar">
		<ul style="padding-top: 70px;">
			<li class="blog-list"><a href="moreNotice.jsp">공지사항</a></li>
			<li class="blog-list"><a href="event.jsp">이벤트</a></li>
			<li class="blog-list"><a href="FAQ1.jsp">자주 묻는 질문</a></li>
			<li class="blog-list active" style="font-size: 1.3em; font-weight: 600;"><a href="QnA.jsp" style="color: #6eceda;">1:1 문의</a></li>
			<li class="blog-list"><a href="policy1.jsp">약관 및 정책</a></li>
		</ul>
		</nav>
	</div>


<div id="content" class="sub_wrap more_wrap">
	<div class="align_rt">
		<!-- Tab -->
		<div class="tab">

			<span class="tab_btn active" data-toggle="tab" href="#home" >나의 문의 내역</span>
			<span class="tab_btn" data-toggle="tab" href="#menu1">새 문의 작성</span>

		</div>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
			  <br>등록된 1:1 문의가 없습니다.<br><br>
			  <b>봉그다 숙박숙박은 회원님들의 소중한 의견에 귀기울여 <br> 신속하고 정확하게 답변드리도록 하겠습니다.</b>
			</div>
			<div id="home" class="tab-pane fade in active">
				<table class="table table-hover" style="margin-top: 20px; width: 740px;">
					<thead>
						<tr>
							<th style="text-align: center;"><b>번호</b></th>
							<th style="text-align: center;"><b>제목</b></th>
							<th style="text-align: center;"><b>작성자</b></th>
							<th style="text-align: center;"><b>작성일</b></th>
							<th style="text-align: center;"><b>답변</b></th>
						</tr>
					</thead>
					<tbody>
						   <tr>
							<td style="text-align: center;">2</td>
							<td>							
								<a href="QnA_contents.jsp">예약 변경하고 싶어서 글 남깁니다.</a>
							</td>
							<td>홍길동</td>
							<td>21.05.24</td>
							<td>N</td>
						</tr>   
						<tr>
							<td style="text-align: center;">1</td>
							<td>							
								<a href="QnA_contents.jsp">숙소 이용시 취사 가능한가요?</a>
							</td>
							<td>홍길동</td>
							<td>21.05.24</td>
							<td>N</td>
						 </tr>   
					</tbody>
				 </table>
			</div>

			<div id="menu1" class="tab-pane fade">

				<form method = "get" action = "QnA.jsp">
					<table  style="padding-top:50px;" align = center width=100% border=0 cellpadding=2 >
							<tr>
							<td bgcolor=white>
							<table class = "table2">
								<tr>
								<td style="width: 50px;">제목</td>
								<td><select id="QnAType" style="width: 500px;">
									<option value="cancel">교환/취소/환불 문의</option>
									<option value="shipping">회원정보 수정 및 탈퇴 문의</option>
									<option value="else">기타 문의</option>
                           	 		</select>
								</td>
								</tr>
				
								<tr>
								<!-- <td>내용</td> -->
								<td colspan="2"><textarea name = content cols=85 rows=15 placeholder="관리자 문의 작성공간입니다. 문의 내용을 입력해주세요"></textarea></td>
								</tr>
								</table>
				
								<center>
									<button class="submit_QnA" onclick="location.href='QnA.jsp'; notice();">작성</button>
								</center>
							</td>
							</tr>
					</table>
					</form>
			</div>
		  </div>
	</div>

	<script>
		function notice(){
			alert("문의가 등록 되었습니다.")
		}
		
	</script>

	<script>
		let targetLink = document.querySelectorAll('.tab span');
		for(var i = 0; i < targetLink.length; i++) {
			targetLink[i].addEventListener('click', function(e){
        		e.preventDefault();
				for(var x = 0; x < targetLink.length; x++){
            		targetLink[x].classList.remove('active');
            		e.target.classList.add('active');
        		}
			}
		)};
	</script>

</div>
</div>


	<div class="clearfix" style="margin-bottom: 100px;"> </div>
</div>

</div>
<!--//blog-->
<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top-at">
			<div class="col-md-3 amet-sed">
				<h4>Our Company</h4>
				<ul class="nav-bottom">
					<li><a href="about.html">About Us</a></li>
					<li><a href="blog.html">For Sale By Owner Blog</a></li>
					<li><a href="mobile_app.html">Mobile</a></li>
					<li><a href="terms.html">Terms & Conditions</a></li>
					<li><a href="privacy.html">Privacy Policy</a></li>	
					<li><a href="blog.html">Blog</a></li>
					
				</ul>	
			</div>
			<div class="col-md-3 amet-sed ">
				<h4>Work With Us</h4>
					<ul class="nav-bottom">
						<li><a href="single.html">Real Estate Brokers</a></li>
						<li><a href="single.html">Business Development</a></li>
						<li><a href="single.html">Affiliate Programs</a></li>
						<li><a href="contact.html">Sitemap</a></li>
						<li><a href="career.html">Careers</a></li>
						<li><a href="feedback.html">Feedback</a></li>	
					</ul>	
			</div>
			<div class="col-md-3 amet-sed">
				<h4>Customer Support</h4>
				<p>Mon-Fri, 7AM-7PM </p>
				<p>Sat-Sun, 8AM-5PM </p>
				<p>177-869-6559</p>
					<ul class="nav-bottom">
						<li><a href="#">Live Chat</a></li>
						<li><a href="faqs.html">Frequently Asked Questions</a></li>
						<li><a href="suggestion.html">Make a Suggestion</a></li>
					</ul>	
			</div>
			<div class="col-md-3 amet-sed ">
				<h4>Property Services</h4>
				   <ul class="nav-bottom">
						<li><a href="single.html">Residential Property</a></li>
						<li><a href="single.html">Commercial Property</a></li>
						<li><a href="login.html">Login</a></li>
						<li><a href="register.html">Register</a></li>
						<li><a href="typo.html">Short Codes</a></li>	
					</ul>	
					<ul class="social">
						<li><a href="#"><i> </i></a></li>
						<li><a href="#"><i class="gmail"> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>
						<li><a href="#"><i class="camera"> </i></a></li>
						<li><a href="#"><i class="dribble"> </i></a></li>
					</ul>
			</div>
		<div class="clearfix"> </div>
		</div>
	</div>
	<div class="footer-bottom">
		<div class="container">
			<div class="col-md-4 footer-logo">
				<h2><a href="index.html">REAL HOME</a></h2>
			</div>
			<div class="col-md-8 footer-class">
				<p >© 2015 Real Home. All Rights Reserved | Design by  <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
			</div>
		<div class="clearfix"> </div>
	 	</div>
	</div>
</div>
<!--//footer-->
</body>
</html>