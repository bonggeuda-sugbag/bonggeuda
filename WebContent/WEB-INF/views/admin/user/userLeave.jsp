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
            margin-right: 5%;
      }
   </style>

<title>Real Home A Real Estate Category Flat Bootstarp Resposive Website Template | Blog :: w3layouts</title>
<link href="${pageContext.servletContext.contextPath }/resources/admin/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.servletContext.contextPath }/resources/admin/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--menu-->
<script src="${pageContext.servletContext.contextPath }/resources/admin/js/scripts.js"></script>
<link href="${pageContext.servletContext.contextPath }/resources/admin/css/styles.css" rel="stylesheet">
<!--//menu-->
<!--theme-style-->
<link href="${pageContext.servletContext.contextPath }/resources/admin/css/style.css" rel="stylesheet" type="text/css" media="all" /> 
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
				<li><span ><a  href="adminUserManagement.html">사용자관리</a></span></li>
				<li><a  href="adminCompanyManagementInfo.html">업체관리</a></li>
				<li><a  href="adminReservationStatus.html">예약현황</a></li>
				<li><a  href="adminPaymentInformation.html">매출관리</a></li>
				<li><a  href="adminOnlineQuestionUser.html">문의&신고</a></li>
				<li><a  href="adminOnlineNotice.html">공지사항</a></li>
         </ul>

         
      <div class="clearfix"> </div>
         <!---pop-up-box---->
               
            <link href="${pageContext.servletContext.contextPath }/resources/admin/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
            <script src="${pageContext.servletContext.contextPath }/resources/admin/js/jquery.magnific-popup.js" type="text/javascript"></script>
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
                 <script src="${pageContext.servletContext.contextPath }/resources/admin/js/easyResponsiveTabs.js" type="text/javascript"></script>
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
   <h3><span>사용자 관리</span></h3> 

   <div class="clearfix"> </div>            
   </div>
</div>
<!--//header-->
<!--blog-->
<div class="blog">
<div class="container">
   <div class="blog-list">
      <nav>
      <div class="col-md-3 blog-sidebar">
      <ul>
         <li class="blog-list"><a href="adminUserManagement.html">사용자 정보</a></li>
         <li class="blog-list"><a href="adminUserManagementBlist.html">블랙리스트 회원</a></li>
         <li class="blog-list"><a href="adminUserManagementLeave.html" style="color: #6eceda; font-size: 1.3em; font-weight: 600;">탈퇴 회원</a></li>
      </ul>
      </nav>
      <table class="table" style="width: 800px;">
         
         <div class="tab">
            <span class="tab_btn active" >탈퇴 회원</span>
         </div>
		 </thead>
            <tr>
               <th>번호</th>
               <th>아이디</th>
               <th>탈퇴 사유</th>
               <th>탈퇴 날짜</th>
               <th>기록삭제 예정일</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="user" items="${ requestScope.userList }">
			<form action="${ pageContext.servletContext.contextPath }/user/leave" method="get">
			<tr>
				<td><c:out value="${ user.leaveNo }"/></td>
				<td><c:out value="${ user.email }"/></td>
				<td><c:out value="${ user.reason }"/></td>
				<td><c:out value="${ user.leaveDate }"/></td>
			</tr>
            </form>
			</c:forEach>
         </tbody>
      </table>

      <label style="color: #6eceda; font-size: 1.3em; font-weight: 600;">회원 검색</label>
      <input type="text" name="" id="" style="width: 150px;"><button><i class="glyphicon glyphicon-search"></i></button>
   </div>
   
   <div class="clearfix"> 
   </div>
   
   <%-- 페이지 처리 --%>
		<div class="pagingArea" align="center">
			<c:choose>
			    <c:when test="${ empty requestScope.searchValue }">
			    
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button disabled><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button id="prevPage"><</button>
					</c:if>
		
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button disabled><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
						</c:if> <!-- 이부분은 버튼의 색을 바꾸기 위해 만들어준 분기 처리이다. -->
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button disabled>></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button id="nextPage">></button>
					</c:if>
					
			     </c:when>
			    <c:otherwise>
   			
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button disabled><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button id="searchPrevPage"><</button>
					</c:if>
		
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button disabled><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button onclick="seachPageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
						</c:if>
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button disabled>></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button id="searchNextPage">></button>
					</c:if>
					
			    </c:otherwise>
			</c:choose>   
		</div>
		
		<script>
		const link = "${ pageContext.servletContext.contextPath }/user/list";
		const searchLink = "${ pageContext.servletContext.contextPath }/board/search";
			
		if(document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function() {
				location.href = link + "?currentPage=1";
			}
		}
		
		if(document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }";
			}
		}
		
		if(document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }";
			}
		}
		
		if(document.getElementById("maxPage")) {
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.maxPage }";
			}
		}
		
		if(document.getElementById("searchStartPage")) {
			const $searchStartPage = document.getElementById("searchStartPage");
			$searchStartPage.onclick = function() {
				location.href = searchLink + "?currentPage=1&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchPrevPage")) {
			const $searchPrevPage = document.getElementById("searchPrevPage");
			$searchPrevPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchNextPage")) {
			const $searchNextPage = document.getElementById("searchNextPage");
			$searchNextPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchMaxPage")) {
			const $searchMaxPage = document.getElementById("searchMaxPage");
			$searchMaxPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.maxPage }&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementsByTagName("td")) {
			
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onclick = function() {
					/* 게시물 번호까지 알아왔으니 이제 상세보기는 할 수 있겠지? */
					alert(this.parentNode.children[0].innerText);
					location.href = "${ pageContext.servletContext.contextPath }/user/detail/";
				}
				
			}
			
		}
		
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
		}
		function seachPageButtonAction(text) {
			location.href = searchLink + "?currentPage=" + text + "&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
		}
	</script>
   
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
      <div class="clearfix"> 

      </div>
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