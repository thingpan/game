<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h3>�Խù� ����</h3>
	
	<form method="post" action="/board-info/update">
	<input type="hidden" name="biNum" value="${boardInfo.biNum}">
		<div class="form-group">
			<label for="biTitle">����</label> <input
				type="text" class="form-control" id="biTitle"
				 name="biTitle" placeholder="����" value="${boardInfo.biTitle}"> 
		</div>
		<div class="form-group">
			<label for="biContent">����</label> 
				<textarea class="form-control" id="biContent" name="biContent"
				placeholder="����">${boardInfo.biContent}</textarea>
		</div>
		

		<button type="submit" class="btn btn-primary">����</button>

	</form>
	</div>
</body>
</html>