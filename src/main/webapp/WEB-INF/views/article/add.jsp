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
			<h3>게시글 등록</h3>
		</div>
		<form method="post">
			<div>
				<label for="">제목</label>
				<input type="text" name="subject"/>
			</div>
			<div>
				<label for="">내용</label>
				<textarea name="contents"></textarea>
			</div>
			<div>
				<button>등록</button>
				<a href="./list"><button type="button">취소</button></a>
			</div>
		</form>
	</div>
</body>
</html>