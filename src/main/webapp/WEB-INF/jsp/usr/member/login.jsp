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
		<form action="/usr/member/doLogin" method="post">
			<table>
				<th>이메일</th>
				<td><input type="text" name="eMail" /></td>
				<th>비빌번호</th>
				<td><input type="text" name="loginPw" /></td>
			</table>
		

			<button>로그인</button>
		</form>
	</div>
</body>
</html>