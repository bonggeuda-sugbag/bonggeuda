<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	
	<%-- <jsp:forward page="/WEB-INF/views/guest/accomoInfo/detailInfo.jsp"></jsp:forward> --%>



	<%-- <jsp:forward page="/WEB-INF/views/owner/main/main.jsp"></jsp:forward> --%>

	<%-- <jsp:forward page="/WEB-INF/views/guest/mypage/warningList.jsp"></jsp:forward> --%>

<%-- 	<jsp:forward page="/WEB-INF/views/guest/mypage/warningList.jsp"></jsp:forward> --%>

	<%-- <jsp:forward page="/WEB-INF/views/admin/user/userInfoDetail.jsp"></jsp:forward> --%>
	<%-- <script>
		(function(){
			
			location.href="${ pageContext.servletContext.contextPath}/user/list";    
		})();
	</script>
	--%> 
	
	<script>
		(function(){
			
			location.href="${ pageContext.servletContext.contextPath}/user/detail";    
		})();
	</script> 
	<%-- <jsp:forward page="/WEB-INF/views/admin/company/companyInfo.jsp"></jsp:forward> --%>
<%-- <jsp:forward page="/WEB-INF/views/owner/roomRegistration/registration.jsp"></jsp:forward>
 --%>

	<%-- <jsp:forward page="/WEB-INF/views/guest/accomoInfo/detailInfo.jsp"></jsp:forward> --%>
 	



</body>
</html>