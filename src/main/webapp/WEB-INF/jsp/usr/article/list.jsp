<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Article List</title>
</head>
<body>
	<div>
		<table>
			<thead>
				<tr>
					<th>게시글번호</th>
					<th>제목</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${articles }">
					<tr>
						<td>${article.getId()}</td>
						<td><a href="/usr/article/detail?id=${article.getId() }">${article.getTitle() }</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<c:if test="${empty articles}">
				<tr>
					<td colspan="2">게시물이 없습니다.</td>
				</tr>
			</c:if>
		</table>

		
		
		<a href="/">home</a>
	</div>
</body>
</html>