<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<script>
	const joinForm_onSubmit = function(form) {
		form.email.value = form.email.value.trim();
		form.loginPw.value = form.loginPw.value.trim();
		form.pwChk.value = form.pwChk.value.trim();
		form.name.value = form.name.value.trim();
		
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
		
		if (form.name.value.length == 0) {
			alert('이름을 입력해주세요');
			form.name.focus();
			return;
		}
		
		if (form.loginPw.value != form.pwChk.value) {
			alert('비밀번호가 일치하지 않습니다');
			form.loginPw.value = '';
			form.pwChk.value = '';
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
<title>회원가입 페이지</title>
</head>
<body>	
	<form action="doJoin" method="post" onsubmit="joinForm_onSubmit(this); return false;">
		
		<table>
			<th>이메일</th>
			<td><input type="email" name="email" /></td>
			<th>비밀번호</th>
			<td><input type="text" name="loginPw" /></td>
			<th>비밀번호 확인</th>
			<td><input type="text" name="pwChk" /></td>
			<th>이름</th>
			<td><input type="text" name="name" /></td>
	
		
		</table>
		
		<button>회원가입하기</button>
		<a href="/usr/home/main">홈으로 가기</a>
	
	</form>
</body>
</html>