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
	<h3>게시판</h3>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardInfoList}" var="board">
					<tr>
						<td>${board.biNum}</td>
						<td><a href ="/board-info/view?biNum=${board.biNum}">${board.biTitle}</td>
						<td>${board.uiNum}</td>
						<td>${board.credat}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right"><button type="button"
							class="btn btn-primary" onclick="goPage('/board-info/insert')">등록</button>
				</tr>

			</tbody>
		</table>

	</div>
	<script>
		function goPage(url){
		location.href=url;
		}
		
		</script>
</body>
</html>