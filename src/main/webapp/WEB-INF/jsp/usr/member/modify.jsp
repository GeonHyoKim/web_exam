<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>	
	<form action="doModify" method="post">
		
		<table>
			<th>변경할 비밀번호</th>
			<td><input type="text" name="loginPw" /></td>
			<th>변경할 비밀번호 확인</th>
			<td><input type="text" name="pwChk" /></td>
		
	
		
		</table>
		
		<button>변경하기</button>
		<a href="/usr/home/main">홈으로 가기</a>
	
	
	</form>
</body>
</html>