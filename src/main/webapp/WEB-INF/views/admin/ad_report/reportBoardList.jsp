<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %>
<link rel="stylesheet" href="/ad_css/Mmanagercss.css"> 
</head>
<body>
<center>	
<h2>신고 게시글 관리</h2>
<%@ include file="../ad_report/Sreport.jsp" %>
<hr>
	<div class="memwrap">
	<form method="post" action="#">
		<div>
		<p><strong>•게시글 신고 날짜</strong></p>
		<input type="date" id="dateFrom" name="date">~<input type="date" id="dateTo" name="todate">
		</div>
	<div>	
	<p><strong>•검색어</strong></p>
	<select>
			<option>전체</option>
			<option>아이디</option>
			<option>닉네임</option>
			<option>제목</option>
		</select>
<input type="text" name="keyword" id="keyword">
<input type="submit" value="검색">
</div>
</form>
</div>
<table>
	<tr>
		<th><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></th>
		<th>아이디</th>
		<th>제목</th>
		<th>게시날짜</th>
		<th>신고수</th>
		<th>신고 날짜</th>
		<th>삭제처리</th>
	</tr>
	<tr>
		<td><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></td>
		<td>태영</td>
		<td>집에갑니다</td>
		<td>22-08-21</td>
		<td>25</td>
		<td>22-09-31</td>
		<td><input type="submit" class="submit" id="submit" value="삭제"></td>
	</tr>
</table>
</center>
</body>
</html>