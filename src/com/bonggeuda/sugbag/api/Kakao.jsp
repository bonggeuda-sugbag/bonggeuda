<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<!-- <script>
        // SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('a7a7d31934ea456b4904f34a7be7a873');

        // SDK 초기화 여부를 판단합니다.
        console.log(Kakao.isInitialized());
    </script> -->

<h1>카카오페이 이용하기</h1>

<form method="post" action="/payment/ready">
    <button>카카오페이로 결제하기</button>
</form>
</head>
<body>
</body>
</html>