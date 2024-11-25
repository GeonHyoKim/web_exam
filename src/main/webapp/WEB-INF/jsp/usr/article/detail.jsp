<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<script>
	const replyForm_onSubmit = function(form) {
		form.reply.value = form.email.value.trim();

		if (form.reply.value.length == 0) {
			alert('댓글을 입력해주세요');
			form.reply.focus();
			return;
		}

		form.submit();
	}
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>게시글번호 :</th>
				<th>${article.getId() }</th>
			<tr>
				<th>제목 :</th>
				<th>${article.getTitle() }</th>
			<tr>
				<th>내용 :</th>
				<th>${article.getBody() }</th>
			</tr>
		</table>

		<a href="/usr/article/list">Article List</a> <a href="/">home</a>
		<hr>
		<hr>
		<hr>
	</div>


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


	<table>
		
			<c:forEach var="reply" items="${replies }">

				<div>작성자(memberId)  : ${reply.getMemberId() }</div>
				<div>댓글 내용 : ${reply.getBody() }</div>
				<div>작성 시간 : ${reply.getRegDate() }</div>
				<hr>
		</c:forEach>
	
		


	</table>
	<form action="/usr/reply/doWrite" method="post" onsubmit="replyForm_onSubmit(this); return false;">
		<input type="hidden" name="relId" value="${article.getId() }" />
		<textarea name="body"></textarea>
		<button>댓글 작성</button>
	</form>
	
	<a href="/usr/home/main">홈으로 가기</a>
	


</body>
</html>