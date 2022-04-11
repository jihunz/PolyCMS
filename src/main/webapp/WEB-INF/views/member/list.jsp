<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h3>회원 목록</h3>
		</div>
		<div>
			<table border='1'>
				<thead>
					<tr>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이름</th>
						<th>가입일시</th>
						<th>권한</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="6">등록 된 회원이 없습니다.</td>
						</tr>
					</c:if>
					
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.passwd}</td>
							<td>${item.name}</td>
							<td><fmt:formatDate value="${item.regDate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/></td>
							<td>${item.grade}</td>
							<td>
								<a href="update/${item.id}">수정</a>
								<a href="delete/${item.id}">삭제</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<div>
				<a href="add">추가</a>
			</div>
			<div>
				<a href="../">이전</a>
			</div>
		</div>
	</div>
</body>
</html>