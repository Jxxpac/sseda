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
<title>내가 받은 매칭 신청</title>
</head>
<body>
<%@ include file = "../header.jsp" %>
<%@ include file = "../menu.jsp" %>
<div class="notediv">
	<div class="notewrap1">
	<ul class="noteul">
	<li class="sendnote"><a href="/ma/put?no=1">내가 한 매칭 신청</a></li>
	<li class="sendnote"><a href="/ma/put">내가받은 매칭 신청</a></li>
	<li class="sendnote"><a href="ma/matching">매칭리스트</a></li>
	</ul>
	</div>
	<div class="notewrap2">
	<h1>매칭신청리스트</h1>
	<table id="table" class="notetable"data-toggle="table" data-search="true" data-filter-control="true" data-show-export="true" data-click-to-select="true" data-toolbar="#toolbar">
		<thead>
			<tr>
				<th data-field="prenom" data-filter-control="input" data-sortable="true">아이디</th>
				<th data-field="date" data-filter-control="select" data-sortable="true">아이템제목</th>
				<th data-field="examen" data-filter-control="select" data-sortable="true">매칭신청날짜</th>
				<th>매칭수락</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${match }" var="m" >
				<tr>
					<td class="notename"><a href="#">${m.id }</a></td>
					<td>${m.title }</td>
					<td>${m.wdate }</td>
					<td><input type="button" value="매칭수락" onclick="location.href='/ma/accept?no=${m.item_seqno}&id=${m.id }'">
				</tr>
			</c:forEach>	
		</tbody>
	</table>
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
