<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/useritem.css">
<link rel="stylesheet" href="/css/useritem_list.css">
</head>
<body>
<div id="wrap">
 <%@ include file = "../header.jsp" %>
 <%@ include file = "../menu.jsp" %>
<section>
<div class="container">
	<div class="locate-rwd-table">
		<h1>내 아이템 정보</h1>
  		<table class="rwd-table">
	    	<tbody>
		      <tr>
		        <th>번호</th>
		        <th>아이템제목</th>
		        <th>가격</th>
		        <th>공개여부</th>		        
		        <th>매칭여부</th>
		        <th>아이템등록일자</th>
		      </tr>
		      <c:set value="${myitem}" var="myitem" />
		      <c:forEach items="${myitem}" var="item">
		      <tr onclick="location.href='/it/detail?no=${item.seqno}'">
		        <td>${item.seqno }</td>
		        <td>${item.title }</td>
		        <td>${item.price }</td>
		        <c:choose>
		        <c:when test="${item.open eq 'Y' }">
		        <td>공개</td>
		        </c:when>
		        <c:otherwise>
		        <td>비공개</td>
		        </c:otherwise>
		        </c:choose>
		        <c:choose>
		        <c:when test="${item.matching eq 'Y' }">
		        <td>매칭완료</td>
		        </c:when>
		        <c:otherwise>
		        <td>매칭중</td>
		        </c:otherwise>
		        </c:choose>
		        <td>${item.wdate }</td>
		      </tr>
		      </c:forEach>
	    	</tbody>
	  	</table>
	  </div>
</div>
</section>
<%@ include file="../footer.jsp" %>
</div>
</body>
</html>