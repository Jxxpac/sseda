<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 게시판</title>
<script src="/js/boarddetail.js"></script>
<link rel="stylesheet" href="/css/board.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
</head>
<body onload="view()">
<input type="hidden" value="${b.like_seqno }" id="like">
<div id="wrap" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
	<div id="detail">
		<h2>${b.title }</h2>
		<c:if test="${b.id eq sess_id }">
			<button style="float:right;" onclick="location.href='/bo/del?no=${b.no}'">삭제</button>
			<button style="float:right;" onclick="location.href='/bo/reg?no=${b.no}&content=${b.content }&name=${b.name }&title=${b.title }&open=${b.open }'">수정</button>
		</c:if>
		<button style="float:right;" onclick="location.href='/bo/report?no=${b.no}'">신고</button>
		<a style="float:left">${b.name }</a><br>
		<a style="float:left">${b.wdate }</a>
		<a style="float:left">${b.count }</a><br>
		<hr>
		<a style="display:block;height:500px;">${b.content }</a>
		<a style="float:left">좋아요:${b.like }</a><br>
		<c:if test="${sess_id  eq b.id }" >
			<a style="float:left" href="javascript:likeon(${b.no })"><img src="/img/heart.png" style="height:15px;width:15px;"id="no"></a>
			<a style="float:left" href="javascript:likeoff(${b.no })"><img src="/img/heart1.png" style="height:15px;width:15px;"id="yes"></a>
		</c:if>
		<br>
		<hr>
		<c:if test="${sess_id ne null }">
			<form method="post" action="/bo/reply" id="reply">
				<input type="text" name="content">
				<input type="hidden" name="no" value="${b.no }">
				<input type="submit" value="등록" style="float:right;">
			</form>
		</c:if>	
		<c:forEach items="${b.r }" var="r" >
			<table id="reply">
				<tr><td style="width:20%">${r.name }</td>
					<td style="width:50%">${r.content }</td>
					<td style="width:20%">${r.wdate }</td>
					<td style="width:10%">
			<c:if test="${r.id eq sess_id }">		
					<button onclick="eplyupdate(${r.no})">수정</button>
					<button onclick="location.href='/bo/redel?no=${r.no}&seqno=${b.no }'">삭제</button>
			</c:if>
			<button onclick="location.href='/bo/replyreport?no=${r.no}&seqno=${b.no }'">신고</button>
				</td>		
				</tr>
			</table>
			<hr>
		</c:forEach>
		<form method="post" action="/bo/re_reg" id="replyup">
		<hr>
			<input type="text" name="content" value="">
			<input type="hidden" name="no" value="${b.no }">
			<input type="submit" value="등록" onclick="replyclose()">
		</form>
	</div>
</div>
<%@include file="../footer.jsp" %>	
</body>
</html>