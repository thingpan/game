<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user-info/delete?uiNum=${userInfo.uiNum}" method="POST">
<h3>유저 상세화면</h3>


이름:${userInfo.uiName }
생년월일:${userInfo.uiBirth }
소개:${userInfo.uiDesc }
가입일:${userInfo.credat }


<button>삭제</button>
</form>
<button type ="button"onclick="location.href='/user-info/update?uiNum=${userInfo.uiNum}'">수정</button>
</body>
</html>