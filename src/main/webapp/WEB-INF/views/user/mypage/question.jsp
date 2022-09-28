<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/question.css">
<title>나의 1:1 문의 현황</title>
</head>
<body>
<%@ include file = "../header.jsp" %>
<%@ include file = "../menu.jsp" %>
<div class="notediv">
	<div class="notewrap1">
	<ul class="noteul">
		<li class="sendnote"><a href="/qa/myquestion">나의1:1문의현황</a></li>
	</ul>
	</div>
	<div class="notewrap2">
		<h1>${qna.question.title }</h1><br>
		<div>
			작성일자:${qna.question.wdate }
			카테고리:${qna.question.category }	<hr>
		</div>
		<div id="content">${qna.question.content }</div>
		<c:if test="${qna.question.answerProc eq 'Y' }">
			<hr>
			<h2>답변: ${qna.answer.content }</h2>
		</c:if>
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
