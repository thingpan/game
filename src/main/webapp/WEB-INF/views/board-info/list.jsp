<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />

</head>
<body>
	<h3>�Խ���</h3>
	<form action="/board-info/list" method="GET">
		<select name="searchType">
			<option value="1">����</option>
			<option value="2">�ۼ���</option>
			<option value="3">����</option>
			<option value="4">����+����</option>
			<option value="5">�ۼ���+����</option>
			<option value="6">����+�ۼ���</option>
			<option value="7">����+�ۼ���+����</option>

		</select> <input type="text" name="searchStr" placeholder="�˻���">
		<button>�˻�</button>
	</form>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">��ȣ</th>
					<th scope="col">����</th>
					<th scope="col">�ۼ���</th>
					<th scope="col">�ۼ���</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardInfoList}" var="board">
					<tr>
						<td>${board.biNum}</td>
						<td><a href="/board-info/view?biNum=${board.biNum}">${board.biTitle}</td>
						<td>${board.uiName}</td>
						<td>${board.credat}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right"><button type="button"
							class="btn btn-primary" onclick="goPage('/board-info/insert')">���</button>
				</tr>

			</tbody>
		</table>

	</div>
	<script>
		function goPage(url) {
			location.href = url;
		}
	</script>
</body>
</html>