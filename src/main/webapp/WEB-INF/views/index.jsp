<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>PolyCMS</h1>
	
	<c:if test="${sessionScope.member != null}">
		<div>
			<span>${sessionScope.member.id}</span>
			<span>님 환영합니다</span>
		</div>
		<div>
			<a href="/logout">로그아웃</a>
		</div>
	</c:if>
	
	<c:if test="${sessionScope.member == null}">
		<div>
			<a href="/login">로그인</a>
		</div>
	</c:if>
	<div>
		<ul>
			<li><a href="board/list">게시판 관리</a></li>
			<li><a href="member/list">사용자 관리</a></li>
		</ul>	
	</div>
	<div>
		<ul>
			<c:if test="${list.size() < 1}">
				<li>등록된 게시판이 없습니다</li>
			</c:if>
			<c:forEach var="item" items="${list}">
				<li><a href="/board/${item.boardId}/article/list">${item.subject}</a></li>			
			</c:forEach>
		</ul>
	</div>
	
</body>
</html>