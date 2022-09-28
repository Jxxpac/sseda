<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="/ad_css/Mmanagercss.css">
 
<div class="memwrap">
	<form method="post" action="#">
		<div class="Dgradewrap">
			<p><strong>•탈퇴 요청날짜</strong></p>
			<input type="date" id="dateFrom" name="date">~<input type="date" id="dateTo" name="todate">
		</div>
		<div>
		<p><strong>•검색어</strong></p>
		<select name="searchcase">
			<option>전체</option>
			<option>회원 아이디</option>
			<option>회원 이름</option>
			<option>회원 닉네임</option>
		</select>
		<input type="text" name="keyword" id="keyword">
		<input type="submit" value="검색" class="btn btn-sm btn-black" name="btnSearch" id="btnSearch">
		</div>
	</form>
	</div>