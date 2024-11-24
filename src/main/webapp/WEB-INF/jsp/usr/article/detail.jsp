<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table>
				<tr>
					<th>게시글번호 : </th>
					<th>${article.getId() }</th>
					<tr>
					<th>제목 : </th>
					<th>${article.getTitle() }</th>
					<tr>
					<th>내용 : </th>
					<th>${article.getBody() }</th>
				</tr>
		</table>


		<a href="/">home</a>
	</div>
</body>
</html>