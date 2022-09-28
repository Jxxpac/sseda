<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/loginjs.js"></script>
</head>
<body onload="init()">
<input type="hidden" name="loginmsg" value="<%= request.getAttribute("loginmsg") %>">
	<%@ include file = "../header.jsp" %>
	<center>
	<div id="login">
		<h1>로그인</h1>
		<form method="post" action="/mem/login">
			<input type="text" name="id" placeholder="아이디"><br>
			<input type="password" name="pw" placeholder="비밀번호"style="display:block;"><br>
			<input type="submit" value="로그인">
			<a href="/mem/idfind">아이디찾기</a> |
			<a href="/mem/pwfind">비밀번호찾기</a> |
			<a href="/member/memberform.jsp">회원가입</a>
		</form>
	</div>
  
<%@include file="../footer.jsp" %>  
  
</body>
</html>