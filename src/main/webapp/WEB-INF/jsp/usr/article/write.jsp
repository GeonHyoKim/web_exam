<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<script>
	let validLoginId = null;

	const writeForm_onSubmit = function(form) {
		form.title.value = form.title.value.trim();
		form.body.value = form.body.value.trim();
		
		if (form.title.value.length == 0) {
			alert('제목을 입력해주세요');
			form.title.focus();
			return;
		}
		
		if (form.body.value.length == 0) {
			alert('내용을 입력해주세요');
			form.body.focus();
			return;
		}
		
		
		form.submit();
	}
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>	
	<form action="doWrite" method="post" onsubmit="writeForm_onSubmit(this); return false;">
		
		<table>
			<th>제목</th>
			<td><input type="text" name="title" /></td>
			<th>내용</th>
			<td><input type="text" name="body" /></td>
		
	
		
		</table>
		
		<button>글 작성 하기</button>
		<a href="/">home</a>
	
	
	</form>
</body>
</html>