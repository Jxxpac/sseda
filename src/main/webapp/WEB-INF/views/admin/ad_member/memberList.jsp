<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<script src="/admin/js/script.js"></script>
<link rel="stylesheet" href="/ad_css/manager.css">
</head>
<body>
<%@ include file="../ad_main/m_menu.jsp" %>
	<center>	
		<h2>회원 관리</h2>
		<ul class="memmenu">
			<li class="mem"><a href="/admem/memberList">회원 목록</a></li>
			<li><a href="/admem/memberDeleteList">회원 탈퇴 목록</a></li>
		</ul>
		<hr>
		<%@ include file="../ad_member/Mmanager.jsp" %>
		<br>
			<table>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>등급</th>
					<th>가입일</th>
				</tr>
				<c:set value="${member.m }" var="m" />
				<c:forEach items="${m}" var="member">
					<td onclick="location.href='/admem/memberDetail?id=${member.id}'">${member.getId()}</td>
					<td>${member.getName()}</td>
					<td>${member.getNickname()}</td>
					<td>${member.getEmail()}</td>
					<td>${member.getGrade()}</td>
					<td>${member.getWdate()}</td>
				</tr>
				</c:forEach>
			</table>
	</center>	

</body>
</html>