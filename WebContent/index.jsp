<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<<<<<<< HEAD
	
	<%-- <jsp:forward page="/WEB-INF/views/guest/accomoInfo/detailInfo.jsp"></jsp:forward> --%>



	<%-- <jsp:forward page="/WEB-INF/views/owner/main/main.jsp"></jsp:forward> --%>

	<%-- <jsp:forward page="/WEB-INF/views/guest/mypage/warningList.jsp"></jsp:forward> --%>

<%-- 	<jsp:forward page="/WEB-INF/views/guest/mypage/warningList.jsp"></jsp:forward> --%>

	
	<script>
		(function(){
			
			location.href="${ pageContext.servletContext.contextPath}/user/list";    
		})();
	</script>
	<%-- <jsp:forward page="/WEB-INF/views/admin/company/companyInfo.jsp"></jsp:forward> --%>
<%-- <jsp:forward page="/WEB-INF/views/owner/roomRegistration/registration.jsp"></jsp:forward>
 --%>
=======
	<%-- <jsp:forward page="/WEB-INF/views/guest/accomoInfo/detailInfo.jsp"></jsp:forward> --%>
 	<jsp:forward page="/WEB-INF/views/owner/mypage/mypage.jsp"></jsp:forward>

>>>>>>> branch 'master' of https://github.com/bonggeuda-sugbag/bonggeuda.git

</body>
</html>