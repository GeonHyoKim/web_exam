<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 페이지</title>
</head>
<body>
	<div>
			<table>
				<th>이메일</th>
				<td>${member.getEmail() }</td>
				<th>이름</th>
				<td>${member.getName() }</td>
			</table>
		
			
			<a href="/usr/member/modify">비밀번호 변경</a>
			<a href="/usr/home/main">홈으로 가기</a>
	</div>
</body>
</html>