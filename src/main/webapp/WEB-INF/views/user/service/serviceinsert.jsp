<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/service.css">
<link rel="stylesheet" href="/css/footer.css">
</head>
<body>
<div id="wrap" style="margin-top: 50px;">
	<%@ include file="../header.jsp" %>
	<%@ include file="../menu.jsp" %>
	<div id="serviceinsert">
		<form enctype="multipart/form-data" method="post" action="/qa/insert">
			<select name="sel">
				<option value="M">계정관리</option>
				<option value="T">멘토/멘티 관련</option>
				<option value="I">아이템 관련</option>
				<option value="E">이벤트게시판 관련</option>
				<option value="P">결제/환불 관련</option>
			</select>
			<input type="text" placeholder="제목" name="title"><br>
			<input type="file" name="file">
			<input type="hidden" value="${sess_id }" name="id">
			<textarea placeholder="내용" name="content"></textarea>
			<input type="submit" value="등록하기">
		</form>
	</div>
</div>
<%@include file="../footer.jsp" %>	
</body>
</html>