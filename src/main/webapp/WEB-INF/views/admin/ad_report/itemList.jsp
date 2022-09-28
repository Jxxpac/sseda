<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %>
<link rel="stylesheet" href="/sseda/ad_css/Mmanagercss.css">
</head>
<body>
<center>	
<h2>신고 아이템 관리</h2>
<ul class="memmenu">
			<li class="mem"><a href="/adit/itemlist">아이템 목록</a></li>
			<li><a href="/adre/itemList">신고 아이템 관리</a></li>
		</ul>
<hr>

<div class="memwrap">
    
	<form method="post" action="#">
		<div class="gradewrap">
 		<p><strong>•등급</strong></p>
		<input type="checkbox" name="grade" class="memsubmit"><p>멘토</p>
		<input type="checkbox" name="grade" class="memsubmit"><p>멘티</p>
		<input type="checkbox" name="grade" class="memsubmit"><p>관리자</p>
		</div>
		<div>
		<p><strong>•아이템 신고 날짜</strong></p>
		<input type="date" id="dateFrom" name="date">~<input type="date" id="dateTo" name="todate">
		</div>
		<div>
		<p><strong>•검색어</strong></p>
		<select>
			<option>카테고리</option>  
			<option>웹소설</option>  
			<option>문학</option>  
			<option>시</option>  
			<option>에세이</option>  
			</select>
		<select name="searchcase">
			<option>전체</option>
			<option>회원 아이디</option>
			<option>아이템 제목</option>
		</select>
		<input type="text" name="keyword" id="keyword">
		<input type="submit" value="검색" class="btn btn-sm btn-black" name="btnSearch" id="btnSearch">
		</div>
	</form>
</div>
<table>
	<tr>
		<th><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></th>
		<th>카테고리</th>
		<th>아이디</th>
		<th>등급</th>
		<th>제목</th>
		<th>게시날짜</th>
		<th>신고수</th>
		<th>신고 날짜</th>
		<th>삭제처리</th>
	</tr>
	<tr>
		<td><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></td>
		<td>에세이</td>
		<td>태영</td>
		<td>멘토</td>
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