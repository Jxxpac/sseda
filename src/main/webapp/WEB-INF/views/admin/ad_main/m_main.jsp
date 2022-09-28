<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<%@ include file="m_menu.jsp" %>
</head>
<body>
<%@ include file="visit.jsp" %>
<center><h2>회원 가입 현황</h2> </center>
 <div class="graph-wrapper">
    <div class="percent-indicator">
      <div class="per-0"></div>
      <div class="per-20"></div>
      <div class="per-40"></div>
      <div class="per-60"></div>
      <div class="per-80"></div>
      <div class="per-100"></div>
    </div>
    <ul class="graph">
      <li class="TOTAL p-100"></li>
      <li class="TODAY p-75"></li>
      <li class="WEEK p-60"></li>
      <li class="MONTH p-35"></li>
    </ul>
  </div>
 <center>
 <button onclick="location.href='/admem/memberList'">상세보기</button>
  <br>
	<div class="newlist">
	  <table class="newboard">
		<h2> 최근 게시글</h2>
			<tr>
				<th>ID</th>
				<th>TITLE</th>
				<th>GRADE</th>
				<th>WDATE</th>
				<th>VIEWS</th>
			</tr>
			<tr>
				<td>아이디</td>
				<td>제목</td>
				<td>등급</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>제목</td>
				<td>등급</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>제목</td>
				<td>등급</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
	</table>  
  		<button onclick="location.href='/ad_board/boardList'">상세 보기</button>
			
	<h2>최근 아이템</h2>
		  <table class="newreply">
			<tr>	
				<th>ID</th>
				<th>TITLE</th>
				<th>GRADE</th>
				<th>WDATE</th>
				<th>VIEWS</th>
			</tr>
			<tr>
				<td>회원넘버</td>
				<td>아이디</td>
				<td>제목</td>
				<td>등급</td>
				<td>날짜</td>
			</tr>
			<tr>
				<td>회원넘버</td>
				<td>아이디</td>
				<td>제목</td>
				<td>등급</td>
				<td>날짜</td>
			</tr>
			<tr>
				<td>회원넘버</td>
				<td>아이디</td>
				<td>제목</td>
				<td>등급</td>
				<td>날짜</td>
			</tr>
		</table>
		</div>
  		<button onclick="location.href='/adit/itemlist'">상세 보기</button>
</body>
</html>