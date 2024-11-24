<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/usr/article/doWrite" method="post">
			<table>
				<th>제목</th>
				<td><input type="text" name="title" /></td>
				<th>내용</th>
				<td><input type="text" name="body" /></td>
			</table>
		

			<button>글 작성하기</button>
		</form>
	</div>
</body>
</html>