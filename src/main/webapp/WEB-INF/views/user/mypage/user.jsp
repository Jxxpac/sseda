<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/userinfo.css">
<link rel="stylesheet" href="/css/footer.css">
</head>
<body>
<div id="wrap">
	<%@ include file = "../header.jsp" %>
	<%@ include file = "../menu.jsp" %>
<section>	
 <div class="usercontent">
		<div class="columncontent" style="text-align: center">
			<form method="post" action="userinfo.jsp">
			<div class="usercheck-password">
			<input type="password" placeholder="비밀번호를 입력해주세요." class="password">
			</div>
			<input type="submit" value="확인" class="usercheck">
			</form>
		</div>
 </div>
</section>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>