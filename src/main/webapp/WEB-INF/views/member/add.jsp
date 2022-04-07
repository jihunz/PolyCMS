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
			<h3>회원가입</h3>
		</div>
		<form method="post">
			<div>
				<label>아이디</label>
				<input type="text" name="id"/>
			</div>
			<div>
				<label>비밀번호</label>
				<input type="password" name="passwd"/>
			</div>
			<div>
				<label>이름</label>
				<input type="text" name="name"/>
			</div>
			<div>
				<label>등급</label>
				<input type="number" name="grade"/>
			</div>
			<div>
				<button>등록</button>
				<a href="./list"><button type="button">취소</button></a>
			</div>
		</form>
	</div>
</body>
</html>