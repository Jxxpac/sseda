<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %>
</head>
<body>
<center>	
<h2>게시물 목록</h2>
<hr>
<%@ include file="Sboard.jsp" %>
<hr>
<div class="container">
		<table class="table" id="table">
		
			<thead>
			<tr>
				<th class="header" width="30"><input type="checkbox" id="checkall" /></th>
				<th>no</th>
				<th>id</th>
				<th>title</th>
				<th>date</th>
				<th>content</th>
				
			</tr>
			</thead>
	<c:forEach items="${board}" var="board">
			<tbody class="tbody" id="tbody">
			<tr th:each="member :" class="member">
				<td class="membercenter"></td>
				<td class="membercenter">${board.no}</td>
				<td class="membercenter">${board.id}</td>
				<td class="membercenter">${board.title}</td>
				<td class="membercenter">${board.wdate}</td>
				<td class="membercenter">${board.content}</td>
				
				</tr>
			</tbody>
	</c:forEach>
		</table>
</div>

</center>
</body>
</html>