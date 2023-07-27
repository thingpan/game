<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>SCOPE</h3>
<%
Map<String,String> map =new HashMap<>();
map.put("name","홍길동");
map.put("age","33");
map.put("address","서울");

//session.setAttribute("user",map);
%>
${user.name}
${user.age}

</body>
</html>