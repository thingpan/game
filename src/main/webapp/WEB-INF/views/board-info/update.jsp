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
	<h3>게시물 수정</h3>
	
	<form method="post" action="/board-info/update">
	<input type="hidden" name="biNum" value="${boardInfo.biNum}">
		<div class="form-group">
			<label for="biTitle">제목</label> <input
				type="text" class="form-control" id="biTitle"
				 name="biTitle" placeholder="제목" value="${boardInfo.biTitle}"> 
		</div>
		<div class="form-group">
			<label for="biContent">내용</label> 
				<textarea class="form-control" id="biContent" name="biContent"
				placeholder="내용">${boardInfo.biContent}</textarea>
		</div>
		

		<button type="submit" class="btn btn-primary">수정</button>

	</form>
	</div>
</body>
</html>