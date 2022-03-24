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
			<h4>제목 : ${item.subject}</h4>
		</div>
		<div>
			<h4>내용 : ${item.contents}</h4>
		</div>
		<div>
			<button>좋아요</button>
			<button>싫어요</button>
		</div>
		<div>
			<a href="../list">목록</a>
		</div>
	</div>
</body>
</html>