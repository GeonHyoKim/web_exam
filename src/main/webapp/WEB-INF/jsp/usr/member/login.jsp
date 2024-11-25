<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<script>
	const loginForm_onSubmit = function(form) {
		form.email.value = form.email.value.trim();
		form.loginPw.value = form.loginPw.value.trim();
		
		if (form.email.value.length == 0) {
			alert('이메일을 입력해주세요');
			form.email.focus();
			return;
		}
		
		if (form.loginPw.value.length == 0) {
			alert('비밀번호를 입력해주세요');
			form.loginPw.focus();
			return;
		}
		
		form.submit();
	}
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>	
	<form action="doLogin" method="post" onsubmit="loginForm_onSubmit(this); return false;">
		
		<table>
			<th>이메일</th>
			<td><input type="text" name="email" /></td>
			<th>비밀번호</th>
			<td><input type="text" name="loginPw" /></td>
		
	
		
		</table>
		
		<button>로그인하기</button>
		<a href="/usr/home/main">홈으로 가기</a>
	
	</form>
</body>
</html>