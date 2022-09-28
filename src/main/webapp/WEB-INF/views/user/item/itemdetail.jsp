<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소설</title>
<link rel="stylesheet" href="/css/item.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
</head>
<body>
<div id="wrapper" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
	<div id="detail">
	<c:set value="${detail }" var="d" />
		<h2 style="display:inline">${d.title }</h2><br>
		<c:set value="${sess_id }" var="sid" />
		<c:if test="${d.id eq sid }">
			<button style="float:right;" onclick="location.href='/it/delete?no=${d.seqno}'">삭제</button>
			<button style="float:right;" onclick="location.href='/it/itemreg?no=${d.seqno}&title=${d.title }&content=${d.content }&open=${d.open }'">수정</button><br><br><br><br>
		</c:if>
		<c:if test="${d.id != sess_id }">
			<c:choose>
				<c:when test="${d.cfcheck eq 'O' }">
					<button style="float:right;" onclick="location.href='/ma/apply?no=${d.seqno}'">멘토신청</button>
				</c:when>
				<c:otherwise>
					<button style="float:right;" onclick="location.href='/ma/apply?no=${d.seqno}'">멘티신청</button>
				</c:otherwise>
			</c:choose>	
			<button style="float:right" onclick="location.href='/it/report?no=${d.seqno}'">신고하기</button>
		</c:if>
		<a style="float:left">${d.name }</a><br>
		<a style="float:left">등록일자:${d.wdate }</a><br>
		<a style="float:left">조회수:${d.count }</a><br>
		<a style="float:left">가격:${d.price }</a><br>
		<hr>
		<a style="display:block;height:500px;">${d.content }</a>
	</div>
</div>
<%@include file="../footer.jsp" %>  
</body>
</html>