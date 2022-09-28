<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/member.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/find.js"></script>
</head>
<body>
<%	String id  = (String)request.getAttribute("findid"); 
	if(id != null){
		if(id.equals("존재하지 않는 이름입니다.")){
			out.println("<script>alert('존재하지 않는 이름입니다.');</script>");
		}else if(id.equals("존재하지 않는 회원정보입니다.")){
			out.println("<script>alert('존재하지 않는 회원정보입니다.');</script>");
		}else
		out.println("<script>alert('고객님의 아이디는 "+id+" 입니다.');</script>");
	}
%>
<div id="wrap" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
	<center>
	<div id="idfind">
		<h1>휴대전화로 아이디찾기</h1>
		<form method="post" action="/mem/phoneid" onsubmit="return phonecheck()" name="phone">
			<input type="text" name="name" placeholder="이름"><br>
			<input type="text" name="phonenum" placeholder="휴대전화(-없이)"><br>
			<input type="submit" value="등록">
		</form>
		<h1>이메일로 아이디찾기</h1>
		<form method="post" action="/mem/emailid" onsubmit="return emailcheck()" name="memail">
			<input type="text" name="name" placeholder="이름"><br>
			<input type="text" name="email" placeholder="이메일" style="width:13%">@
			<input type="text" name="em" id="did" style="width:13%">
			<select id="semid" onchange="idem()">
				<option value="">직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="gmail.com">gmail.com</option>
			</select><br>
			<input type="submit" value="등록">
		</form>
	</div>
</div>	
	<%@include file="../footer.jsp" %>
</body>
</html>