<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h3>회원 정보 변경</h3>
		</div>
		<form method="post">
			<div>
				<label for="">아이디</label>
				<input type="text" name="id" value="${item.id}"/>
			</div>
			<div>
				<label for="">비밀번호</label>
				<input type="password" name="passwd" value="${item.passwd}"/>
			</div>
			<div>
				<label for="">이름</label>
				<input type="text" name="name" value="${item.name}"/>
			</div>
			<div>
				<label>등급</label>
				<input type="number" name="grade" value="${item.grade}"/>
			</div>
			<div>
				<label>가입일시</label>
				<div><fmt:formatDate value="${item.regDate}" pattern="yyyy/MM/dd HH:mm:ss"/></div>
			</div>
			<div>
				<button>등록</button>
				<a href="../list"><button type="button">취소</button></a>
			</div>
		</form>
	</div>
</body>
</html>