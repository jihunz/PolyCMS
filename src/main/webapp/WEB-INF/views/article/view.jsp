<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	$(function() {
		$("#goodBtn").click(() => goodCount());
		
		$("#badBtn").click(() => badCount());
	});
	
	const currLoc = $(location).attr("href");
	const locArr = currLoc.split("/");
	const articleId = locArr[8];
	
	function goodCount() {
	    $.ajax(`./${articleId}/goodCount`, {
	        method: "POST",
			data: 'none',
			contentType: false,
	        success: result => {
	            console.log(result);
				return;
	        },
	        error: xhr => { alert(`오류 발생: ${xhr.statusText}`) }
	    });
	}
	
	function badCount() {
	    $.ajax(`./${articleId}/badCount`, {
	        method: "POST",
			data: 'none',
			contentType: false,
	        success: result => {
	            console.log(result);
				return;
	        },
	        error: xhr => { alert(`오류 발생: ${xhr.statusText}`) }
	    });
	}
</script>
<script src="../../../../resources/js/article/view.js"></script>
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
			<h4>좋아요 : ${item.goodCount}</h4>
		</div>
		<div>
			<h4>싫어요 : ${item.badCount}</h4>
		</div>
		<div>
			<button id="goodBtn">좋아요</button>
			<button id="badBtn">싫어요</button>
		</div>
		<div>
			<a href="../list">목록</a>
		</div>
	</div>
</body>
</html>