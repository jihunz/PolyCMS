<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h3>게시글 변경</h3>
		</div>
		<form method="post">
			<div>
				<label>제목</label>
				<input type="text" name="subject" value="${item.subject}"/>
			</div>
			<div>
				<label>내용</label>
				<textarea name="contents">${item.contents}</textarea>
			</div>
			<div>
				<button>변경</button>
				<a href="./list"><button type="button">취소</button></a>
			</div>
		</form>
	</div>
</body>
</html>