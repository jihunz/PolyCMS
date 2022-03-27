<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	$(function() {
		
	});

	function viewCount() {
	    let articleId = $(event.target).attr("articleId");

	    $.ajax(`/viewCount/${articleId}`, {
	        method: "POST",
			data: 1,
			contentType: false,
			processData: false,
	        success: result => {
	            console.log("count success")
				return;
	        },
	        error: xhr => { alert(`오류 발생: ${xhr.statusText}`) }
	    });
	}
</script>
</head>
<body>
	<div>
		<div>
			<h3>${boardId} 목록</h3>
		</div>
		<div>
			<table border='1'>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>조회수</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="7">등록 된 글이 없습니다.</td>
						</tr>
					</c:if>
					
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.articleId}</td>
							<td><a href="view/${item.articleId}">${item.subject}</a></td>
							<td>${item.viewCount}</td>
							<td>					
								<a href="update/${item.articleId}">수정</a>
								<a href="delete/${item.articleId}">삭제</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<a href="add">추가</a>
			<a href="../../list">이전</a>
		</div>
	</div>
	<!-- <script src="../../../../resources/js/article/list.js"></script> -->
</body>
</html>