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
<link rel="stylesheet" href="/css/message.css">
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
	<h1>나의 1:1 문의 현황</h1>
	<table id="table" class="notetable"data-toggle="table" data-search="true" data-filter-control="true" data-show-export="true" data-click-to-select="true" data-toolbar="#toolbar">
		<thead>
			<tr>
				<th data-field="prenom" data-filter-control="input" data-sortable="true">순번</th>
				<th data-field="date" data-filter-control="select" data-sortable="true">제목</th>
				<th data-field="examen" data-filter-control="select" data-sortable="true">문의날짜</th>
				<th data-field="examen" data-filter-control="select" data-sortable="true">답변여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${qna }" var="q" >
				<tr onclick="location.href='/qa/question?no=${q.seqno}'">
					<td class="notename">${q.no }</td>
					<td>${q.title }</td>
					<td>${q.wdate }</td>
					<td><c:if test="${q.answerProc eq 'N' }">답변처리중</c:if>
						<c:if test="${q.answerProc eq 'Y' }">답변완료</c:if></td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
