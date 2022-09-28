<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <link rel="stylesheet" href="/ad_css/Mmanagercss.css"> 
 
	<div class="memwrap">
	<form method="post" action="#">
		<div>
		<p><strong>•댓글 신고 날짜</strong></p>
		<input type="date" id="dateFrom" name="date">~<input type="date" id="dateTo" name="todate">
		</div>
	<div>	
	<p><strong>•검색어</strong></p>
	<select>
			<option>전체</option>
			<option>아이디</option>
			<option>닉네임</option>
		</select>
<input type="text" name="keyword" id="keyword">
<input type="submit" value="검색">
</div>
</form>
</div>