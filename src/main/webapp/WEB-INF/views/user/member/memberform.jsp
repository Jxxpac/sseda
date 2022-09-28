<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/css/member.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
</head>
<script src="/js/signup.js"></script>
<body>
<div id="wrap" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
	<form method="post" name="signupform" action="signup" onsubmit="return signupcheck()">
		<div id="member">
			<input type="text" name="id" onchange="idcheck()" placeholder="아이디" >
			<input type="button" onclick="DBcheckid()" value="중복검사" class="checkid-button" name="idoverlap">
			<input type="hidden" name="overlapch" value="uncheck">
			<input type="password" name="pw" placeholder="비밀번호" style="display:block"> 
			<input type="text" name="name1" placeholder="이름" style="display:block">
			<input type="text" name="nickname" placeholder="닉네임"style="display:block">
			<fieldset style="width:42%;">
				<legend>성별</legend>
				<input type="radio" name ="gender" value="M">남자
				<input type="radio" name ="gender" value="F">여자
			</fieldset>
			<input type="number" name="phone" style="display:block"placeholder="휴대전화" maxlength="11"> 
			<input type="text" name="email" style="width:17%;"placeholder="이메일"> @
			<select name="eDomain" onchange="inputDomain()" id="sel">
      			<option value="" >직접입력</option>
      			<option value="naver.com" >naver.com</option>
      			<option value="daum.net" >daum.net</option>
      			<option value="gmail.com" >gmail.com</option>
       		</select>
			<input type="submit" value="가입하기" style="display:block">
		</div>
	</form>	
</div>	
	<%@include file="../footer.jsp" %>  		
</body>
</html>