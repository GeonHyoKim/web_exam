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
		<form action="/usr/member/doModify" method="post">
			<table>
				
				<th>변경 할 비빌번호</th>
				<td><input type="text" name="loginPw" /></td>
				<th>변경 할 비빌번호 확인 </th>
				<td><input type="text" name="pwChk" /></td>

			<button>변경하기</button>
		</form>
	</div>
</body>
</html>