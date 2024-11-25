<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<script>
	const replyForm_onSubmit = function(form) {
		form.body.value = form.body.value.trim();

		if (form.body.value.length == 0) {
			alert('내용이 없는 댓글은 작성할 수 없습니다');
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
<title>댓글 작성 페이지</title>
</head>
<body>

	<textarea name="body"></textarea>
	<input type="hidden" name="articleId" value="${article.getId()}" />
	<a href=""></a>

</body>
</html>