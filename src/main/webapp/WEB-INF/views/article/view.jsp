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
			<h4>조회수 : ${item.viewCount}</h4>
		</div>
		<div>
			<div id="good_count">
				<p>${item.goodCount}</p>
				<button>좋아요</button>			
			</div>
			<div id="bad_count">
				<p>${item.badCount}</p>
				<button>싫어요</button>
			</div>
		</div>
		<div>
			<a href="../list">목록</a>
		</div>
	</div>
</body>
<script src="/js/jquery-3.6.0.min.js"></script>
<script src="/js/article/article_count.js"></script>
</html>