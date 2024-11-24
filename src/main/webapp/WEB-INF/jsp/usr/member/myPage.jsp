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
			<table>
				<th>이메일</th>
				<td>${member.getEMail() }</td>
				<th>이름</th>
				<td>${member.getName() }</td>
			</table>
		
			
			<a href="/">home</a>
			<a href="/usr/member/modify">비밀번호 변경</a>
	</div>
</body>
</html>