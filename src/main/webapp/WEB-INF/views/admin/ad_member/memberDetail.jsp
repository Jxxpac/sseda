<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="UTF-8">
<link rel="stylesheet" href="/sseda/ad_css/Mmanagercss.css">
<div class="editmain">
<img src="/sseda/img/premium-icon-member-2815096.png"
     style="width:5%; height:4%;">
     
<h3>회원 상세 정보</h3>
<br>
</div>     

    <div class="editmem">
	<p>▶ 회원 기본정보</p>
	<table>
	<c:set value="${member}" var="d" />
	<tr> 
		<th>아이디</th>
		<td>${d.id}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${d.pw}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${d.name}</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>${d.gender}</td>
	</tr>
	<tr>
		<th>휴대전화</th>
		<td>${d.phonenumber}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${d.email}</td>
	</tr>		
</div>
	</table>
	
	<div>
	<p>▶ 사이트 가입 정보</p>
	<table>
		<tr>
			<th>회원가입일</th>
			<td>${d.wdate}</td>
	<tr>
		<th>닉네임</th>
		<td>${d.nickname}</td>
	</tr>
	<tr>
		<th>회원등급</th>
		<td>${d.grade}</td>
	</tr>
	<tr>
		<th>보유금액</th>
		<td>${d.amount}</td>
	</tr>
	<tr>
		<th>탈퇴 요청여부</th>
		<td>${d.isdel}</td>
	</tr>
	</table>
</div>

<button class="close" style="float:right" onclick="location.href='/admem/memberList'">닫기</button>