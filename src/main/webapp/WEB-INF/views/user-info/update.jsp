<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 수정</h3>
<form method="post" action="/user-info/update">

	<input type="hidden" name="uiNum" value="${userInfo.uiNum}">	
<input type="text" name="uiId"   placeholder="아이디" value="${userInfo.uiId}"><br>
<input type="text" name="uiName"  placeholder="이름"value="${userInfo.uiName}"><br>
<input type="password" name="uiPwd"   placeholder="비밀번호"value="${userInfo.uiName}"><br>
<textarea name="uiDesc" placeholder="소개"></textarea><br>
<input type="date" name="uiBirth" palceholder="생년월일"value="${userInfo.uiBirth}"><br>
<button>확인</button>
<button type ="reset">취소</button>
</form>
</body>
</html>