<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가등록한평점</title>
<link rel="stylesheet" href="/css/rating.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/service.js"></script>
</head>
<body>
<script>
</script>
<div id="wrap" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
	<div id="men">
		<a href="/ma/myrating?no=1">내가 등록한 평점</a><br>
		<a href="/ma/myrating">내가 받은 평점</a>
	</div>
	<div id="ratinglist">
		<form method="post" action="/sseda/my/del" onsubmit="return del()">
		<input type="submit" value="삭제">
		<table>
			<tr><th><input type="checkbox">
				<th style="width:20%;">순번</th>
				<th style="width:35%;">아이템제목</th>
				<th style="width:15%;">아이디</th>
				<th style="width:10%;">점수</th>
				<th style="width:10%;">날짜</th>
				<th style="width:10%;">수정여부</th>
			<c:forEach items="${rating }" var="r" >
				<tr><td><input type="checkbox" name="check" value="${r.seqno }"></td>
					<td>${r.no }</td>
					<td>${r.title }</tD>
					<td>${r.takeid }</td>
					<td>${r.point }<input type="hidden" name="no" value="T"></td>
					<td>${r.wdate }</td>
					<td>
					<c:if test="${r.regdate >= r.sysdate }" >
						<input type="button" onclick="location.href='/ma/reg?no=${r.seqno }&point=${r.point }&id=${r.takeid }'" value="수정">
					</c:if>
					</td>
			</c:forEach>
		</table>
		</form>
	</div>	
</div>	
	<%@include file="../footer.jsp" %>
</body>
</html>