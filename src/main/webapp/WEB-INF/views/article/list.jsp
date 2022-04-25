<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="/js/drag_order_dom.js"></script>
</head>
<body>
	<div>
		<div>
			<h3>${boardId}목록</h3>
		</div>
		<div>총 ${pager.total} 건	</div>
		<div>
			<form>
				<select name="search">
					<option value="0">전체</option>
					<option value="1">제목</option>
					<option value="2">내용</option>
					<option value="3">작성자</option>
				</select>
				<input type="text" name="keyword" placeholder="검색어를 입력해주세요"/>
				<button>검색</button>
			</form>
		</div>
		<div>
			<table border='1'>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>좋아요</th>
						<th>싫어요</th>
						<c:if test="${sessionScope.member != null}">
							<th>관리</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="7">등록 된 글이 없습니다.</td>
						</tr>
					</c:if>

					<c:forEach items="${list}" var="item">
						<tr class="dragItem">
							<td>${item.articleId}</td>
							<td><a href="view/${item.articleId}">${item.subject}</a></td>
							<td>${item.memberId}</td>
							<td>${item.viewCount}</td>
							<td>${item.goodCount}</td>
							<td>${item.badCount}</td>
							<c:if test="${sessionScope.member != null}">
								<td>
									<a href="update/${item.articleId}">수정</a>
									<a href="delete/${item.articleId}">삭제</a>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="7">
							<div>
								<div>
									<a href="?page=1">처음</a>
								</div>
								<div>
									<a href="?page=${pager.prev}">이전</a>
								</div>

								<c:forEach var="page" items="${pager.list}">
									<div>
										<a href="?page=${page}">${page}</a>
									</div>
								</c:forEach>

								<div>
									<a href="?page=${pager.next}">다음</a>
								</div>
								<div>
									<a href="?page=${pager.last}">마지막</a>
								</div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div>
			<div>
				<a href="add">추가</a>
			</div>
			<div>
				<a href="../../list">이전</a>
			</div>
			<div>
				<a href="dummy">대량추가</a>
			</div>
			<div>
				<a href="init">초기화</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		new DragOrder("tbody")
	</script>
</body>
</html>