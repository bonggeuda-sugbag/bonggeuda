<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
   (function(){
		const successCode = "${ requestScope.successCode }";
		
		let movePath = "";
		
		switch(successCode){
			case "insertAdminQnA" :
				movePath = "${ pageContext.servletContext.contextPath }/userqnalist/select";
				break;
			case "insertCancel" :
				movePath = "${ pageContext.servletContext.contextPath }/userbooklist/select";
				break;
			case "insertReview" :
				movePath = "${ pageContext.servletContext.contextPath }/userbooklist/select";
				break;
			case "infoUpdate" :
				movePath = "${ pageContext.servletContext.contextPath }/usermyinfo/select";
				break;

		}
		
		location.replace(movePath);
	})();
   </script>
</body>
</html>