<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의</title>
<link rel="stylesheet" href="/css/service.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/sseda/js/service.js"></script>
</head>
<body>
<div id="wrap" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
	<div id="detail">
		<h2>아이디찾는방법</h2>
		<button id="button" onclick="answer()">답변등록</button>
		<a class="title">김정우</a><br>
		<a class="title">2022-08-01</a><br>
		<hr>
		<a id="content">아이디를 잃어버렸는데 찾는방법을 알려주세요</a>
		<form method="post" action="#" id="answer">
			<textarea></textarea>
			<input type="hidden" name="id" value="">
			<input type="hidden" name="service_seqno" value="">
			<input type="submit" value="등록" onclick="answerclose()">
		</form>
	</div>
</div>
<%@include file="../footer.jsp" %>	
</body>
</html>