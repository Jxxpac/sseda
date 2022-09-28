<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<form method="post" action="/mem/checkpw">
			<div class="usercheck-password">
			<input type="password" placeholder="비밀번호를 입력해주세요." class="password" name="putpw">
			<c:set value="${chpw}" var="pw" />
			<c:set value="${id}" var="id" />
			<input type="hidden" name="chpw" value="${pw}">
			<input type="hidden" name="id" value="${id}">
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