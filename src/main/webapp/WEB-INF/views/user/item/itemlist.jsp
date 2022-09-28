<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:choose>
<c:when test="${item.check.category eq '1' }">
	<title>소설</title>
</c:when>
<c:when test="${item.check.category eq '2' }">
	<title>웹소설</title>
</c:when>
<c:when test="${item.check.category eq '3' }">
	<title>에세이</title>
</c:when>
<c:when test="${item.check.category eq '4' }">
	<title>시</title>
</c:when>
<c:when test="${item.check.category eq 'N' }">
	<title>아이템페이지</title>
</c:when>
</c:choose>
<link rel="stylesheet" href="/css/item.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/insert.js"></script>
</head>
<body>
<div id="wrap" style="margin-top: 50px;">
	<%@ include file="../header.jsp" %>
	<%@ include file="../menu.jsp" %>
	<br>
<center>
	<form id="keyword" action="/it/item">
		<select name="cate">
			<option value=""
			<c:if test="${item.check.category eq ''}">selected</c:if>>전체</option>
			<option value="N"
			<c:if test="${item.check.category eq 'N'}"> selected</c:if>>소설</option>
			<option value="W"
			<c:if test="${item.check.category eq 'W'}">selected</c:if>>웹소설</option>
			<option value="E"
			<c:if test="${item.check.category eq 'E'}">selected</c:if>>에세이</option>
			<option value="P"
			<c:if test="${item.check.category eq 'P'}">selected</c:if>>시</option>
		</select>
		<select name="mt">
			<option value=""
			<c:if test="${item.check.meto_meti ne ''}">selected</c:if>>전체</option>
			<option value="O"
			<c:if test="${item.check.meto_meti eq 'O' }">selected</c:if>>멘토</option>
			<option value="I"
			<c:if test="${item.check.meto_meti eq 'I' }">selected</c:if>>멘티</option>
		</select>
		<select name="ser">
			<option value=""
			<c:if test="${item.check.division ne '' }">selected</c:if>>전체</option>
			<option value="t" 
			<c:if test="${item.check.division eq 't' }">selected</c:if>>제목</option>
			<option value="c"
			<c:if test="${item.check.division eq 'c' }">selected</c:if>>내용</option>
			<option value="n"
			<c:if test="${item.check.division eq 'n' }">selected</c:if>>이름</option>
		</select>
		<c:choose>
			<c:when test="${item.check.division ne '' }">
				<input type="text" name="keyword" value="${item.check.key }">
			</c:when>
			<c:otherwise>
				<input type="text" name="keyword">
			</c:otherwise>	
		</c:choose>
			<input type="submit" value="검색">
	</form>
		<div class="container">
		<c:if test="${sess_id != null }">
			<c:set value="${sess_id }" var="id"/>
		</c:if>
		<c:if test="${sess_id == null }">
			<c:set value="" var="id"/>
		</c:if>
	    	<a href="javascript:check('${id }',1)" class="button btnPush btnPurple" style="top: 36%; left: 93%">글등록</a>
	  	</div>
  	<center>
	<div id="list">
	<c:set value="${item }" var ="item" />
	<c:forEach items="${item.item }" var="i" >
		<table class="itemlist" border="1">
			<tr><td colspan="2" style="height:150px;"onclick="location.href='/it/detail?no=${i.seqno}'"><div style="height:150px;"><img src="/img/logo.png" style="height:100%;width:100%;"></div></td>
			<tr><td>제목</td><td>${i.title }</td>
			<tr><td>작성일자</td><td>${i.wdate }</td>
			<tr><td>작성자</td><td>${i.name }</td>
			<tr><td>조회수</td><td>${i.count }</td>
		</table>
	</c:forEach>
	</div>
	<center>	
		<div class="pagination">
	    <c:if test="${page.prev }">
		  <a href="/it/item?cpage=${page.start -1 }&row=${page.c.row}">&laquo;</a>
		</c:if>
		  <c:forEach var="n" begin="${page.start }" end="${page.end }">
		  	<a href="/it/item?cpage=${n }&row=${page.c.row}&cate=${item.check.category}&mt=${item.check.meto_meti}&ser=${item.check.division}&key=${item.check.key}"
		  	   class="${page.c.cpage == n ?"active" :"" }">${n}</a>
		  </c:forEach>
		<c:if test="${page.next }">
		  <a href="/it/item?cpage=${page.end +1 }&row=${page.c.row}">&raquo;</a>
		</c:if>
		</div>
	</center>	
	<%@include file="../footer.jsp" %>
</div>	
</body>
</html>