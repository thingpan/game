<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
	<h3>��ȭ��</h3>
	<div class="container">
	<form method="POST" action="/board-info/delete">
	<input type="hidden" name="biNum" value="${boardInfo.biNum}">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">��ȣ</th>
				<td>${boardInfo.biNum}</td>
			</tr>
			<tr>
				<th scope="col">����</th>
				<td>${boardInfo.biTitle}</td>
			</tr>
			<tr>
				<th scope="col">����</th>
				<td>${boardInfo.biContent}</td>
			</tr>
			<tr>
				<th scope="col">�ۼ���</th>
				<td>${boardInfo.uiNum}</td>
			</tr>
			<tr>
				<th scope="col">�ۼ���</th>
				<td>${boardInfo.credat}</td>
			</tr>
			<c:if test=""></c:if>
			<tr>
			<c:if test="${user.uiNum == boardInfo.uiNum}">
			<th colspan="2">
				<button type="button" onclick="goPage('/board-info/update?biNum=${boardInfo.biNum}')">����</button>
				<button>����</button>
				</th>
				</tr>
				</c:if>
		</thead>
		</table>
		</form>
		<script >
		function goPage(url){
			location.href=url;
			
		}
		
		</script>
	</div>
</body>
</html>