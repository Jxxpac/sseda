<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/member.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/find.js"></script>
</head>
<body>
<div id="wrap" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
	<center>
	
	<div id="idfind">
		<h1>휴대전화로 비밀번호찾기</h1>
		<form method="post">
			<input type="text" id="name" placeholder="이름"><br>
			<input type="text" id="phonenum" placeholder="휴대전화(-없이)"><br>
			<input type="button" value="등록" onclick="pwfind(1)">
		</form>
		<h1>이메일로 비밀번호찾기</h1>
		<form method="post" name="pmail">
			<input type="text" name="name" placeholder="이름"><br>
			<input type="text" name="email" placeholder="이메일" style="width:13%">@
			<input type="text" name="em" id="dpw" style="width:13%">
			<select name="sempw" onchange="pwem()">
				<option value="">직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="gmail.com">gmail.com</option>
			</select><br>
			<input type="button" value="등록" onclick="pwfind(2)">
		</form>
	</div>
<div id = "pwchange">
	<h2>비밀번호 재설정</h2>
	<form method="post" action="/mem/pwchange"  name="pwchange" onsubmit="return pwche()">
		<input type="password" placeholder="비밀번호" name="pw" id="pwc"><br><br>
		<input type="password" placeholder="비밀번호확인" name="pwcheck" id="pwca" required>
		<input type="hidden" name="id" id="ids" value="">
		<br><br><input type="submit" value="변경">
	</form>
</div>
</div>	
	<%@include file="../footer.jsp" %>
</body>
</html>