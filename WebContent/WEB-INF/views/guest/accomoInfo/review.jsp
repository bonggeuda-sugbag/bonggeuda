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
<title>Real Home A Real Estate Category Flat Bootstarp Resposive Website Template | Buy :: w3layouts</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--menu-->
<script src="js/scripts.js"></script>
<link href="css/styles.css" rel="stylesheet">

<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<!-- <link href="css/common.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/product.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="all" /> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Real Home Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<style>
.container h3{
	display: block; 
	font-size: 18px; 
	color: rgba(0,0,0,0.87);
}

.list_wrap button{
	width: 180px;
	height: 30px;
	padding: 1px 5px 1px 5px;
}
.detailList{
    width: 1000px; height: 300px; margin-bottom: 15px; padding: 20px 20px 20px 20px;border: 1px solid rgba(0, 0, 0, 0.08);  display: flex;
}

.detailImg{
    width:45%; height:100%; background-color: green; margin-right: 20px;
}

.detailInfo{
   width: 53%; background-color: honeydew; display: block;
}

.reviewWrap li{
    margin-top: 50px;
    /* margin-bottom: 13px; */
}

.reviewWrap div{
    text-align: left;
    margin-bottom: 13px;
}


.hostAnswer{
    background-color: rgba(0, 0, 0, 0.08);
    margin: 10px 10px 10px 10px;
    padding: 10px 10px 10px 10px;
}

.reviewStar{
    clear: both;
    width: 120px;
    height: 24px;
    background: url(../userWebFront/images/reviewStar.png) 0 0 no-repeat;
    background-size: 120px auto;
    background-position: 0 -24px;
    text-align: right;
    
}

.reviewTitle{
    display: flex;
}

.like{
    width: 30px;
    height: 20px;
    margin-left: 13px;
    background: url(../userWebFront/images/like.png) 0 0 no-repeat;
    background-size: 20px 20px;
    
}

.topReview{
    border: 1px solid;
    width: 100px;
    background: #6eceda;
    color: white;
    border-radius: 5px;
}
</style>
</head>
<body>
<!--header-->


<jsp:include page="../../common/guestheader.jsp"/>
    
    <!--//-->	
    <!-- 숙소상세정보 -->
    <center>

        <div style="width: 1170px; margin-top: 30px; padding: 10px 35px 10px 35px;">
            <!-- 숙소사진, 이름 -->
            <div style=" width : 1100px; height : 500px; padding:10px 10px 10px 0px;display: flex; flex-direction: row;">
                <!-- 숙소사진 -->
                <div style=" width : 600px; height: 470px; display: block;background: url(../userWebFront/images/ga2.jpg) no-repeat; background-size: 600px 470px;">
                    
                </div>
                <!-- 숙소이름 -->
                <div style="width:400px; height: 470px; display: block; margin-left: 50px; ">
                    <div><h2>최고급 호텔</h2></div>
                    <br><br>
                    <div><h3 style="text-align: left; color: cornflowerblue;">평점 : 10점 / 만족해요~</h3></div>
                    <br><br>
                    <div><h4 style="text-align: left;">주소 : 강남구 강남동</h4></div>
                    <br><br>
                    <div style="background-color: rgba(0, 0, 0, 0.08);  padding: 20px 20px 20px 20px;">
                        <h4 style="text-align: left;"><b>사장님 한마디</b></h4>
                        <br>
                        <p style="text-align: left;">제주도 최고의 호텔!!<br>여기로오세요~</p>
                    </div>

                </div>
            </div>

            <br><br>
            <!-- 안내/예약, 정보, 리뷰 -->
            
            <div style="width:600px; height:30px; display: flex; ">
                <button type="button" style="padding:0 20px 0 20px">
                    <span><a href="moteldetailBook.jsp">객실안내 / 예약</a></span>
				</button>
				<button type="button" style="padding : 0 20px 0 20px" >
                    <span><a href="moteldetailInfo.jsp">숙소정보</a></span>
				</button>
				<button type="button" style="padding : 0 20px 0 20px" >
                    <span>리뷰</span>
				</button>
			</div>
            <hr>
            <!-- 리뷰정보 -->
            <div id="btn3_content">
                <div style="margin: 0 auto;">
                    <br>
                    <h3>만족해요</h3>
                    <br>
                        <div style="display: flex; width: 180px; margin: 0 auto;">
                            <div class="reviewStar" ></div>
                            <div  style="margin: 0 auto; width: 50px"><h3>8.7</h3></div>
                            
                        </div>
                    <br>
                     <p>
                        전체리뷰  :  100개 | 제휴점 답변  :  99개
                    </p>
                </div>
                <hr>   
                <ul class = reviewWrap>
                    <li>
                        <div class="guestReview">
                            <div class="topReview" style="text-align: center;">베스트리뷰</div>
                            <div class="reviewTitle">
                                <div>
                                    <h4><strong>여기만한 곳은 어디에도 없을거에요.</strong></h4>
                                </div>
                                <div class="like" onclick="alert('이게 최선일까? 색깔도 바꿀예정');"></div>
                                <div><p>160</p></div>
                            </div>
                            <div class="reviewScore">
                                <h5>별표시가 들어갈 거에요</h5>
                            </div>
                            <div class="suksoName" >
                                <b>[조식 1+1 패키지] 슈페리어 트윈 객실 이용 · 햇살02</b>
                            </div>
                            <div class=reviewContext>
                                <p>여기 너무 좋았어요 <br>다음에 또 오고 싶어요!!<br>최고링</p>
                            </div>
                            <div class=reviewPicture>
                                사진첨부예정
                            </div>
                        </div>
                        <!-- <div class="hostAnswer">
                            <div class="hostAnswerTitle">
                                <Strong>답변 제목입니다</Strong>
                            </div> 
                            <div class="hostAnswerContext">
                                <p>답변 내용입니다.<br>다음에 또 이용해주세요~ <br> 감사합니다~</p>
                            </div>
                        </div> -->
                        
                    </li>
                    <hr>
                    <li>
                        <div class="guestReview">
                            <div class="reviewTitle">
                                <div>
                                    <h4><strong>일반리뷰</strong></h4>
                                </div>
                                <div class="like"></div>
                                <div><p>7</p></div>
                            </div>
                            <div class="reviewScore">
                                <h5>별표시가 들어갈 거에요</h5>
                            </div>
                            <div class="suksoName" >
                                <b>객실타입 :슈페리어 트리플 객실 이용 · 햇살02</b>
                            </div>
                            <div class=reviewContext>
                                <p>여기 너무 좋았어요 <br>다음에 또 오고 싶어요!!<br>최고링</p>
                            </div>
                        </div>
                        <!-- <div class="hostAnswer">
                            <div class="hostAnswerTitle">
                                <Strong>두번쨰 답변 제목입니다</Strong>
                            </div> 
                            <div class="hostAnswerContext">
                                <p>두번쨰 답변 내용입니다.<br>다음에 또 이용해주세요~ <br> 감사합니다~</p>
                            </div>
                        </div> -->
                    </li>
    
                </ul>
                <hr>
                <!-- //리뷰내용 -->
            </div>
            
             <!-- //리뷰정보 -->
             <!-- 리뷰내용 -->
           
           
        </div>
        </center>


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