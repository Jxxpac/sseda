<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/ad_css/Mmanagercss.css">

<div class="memwrap">
	<form method="post" action="#">
	<div class="gradewrap">
		<p><strong>•답변 상태 </strong></p>
		<input type="checkbox" name="grade" class="memsubmit"><p>처리 중 </p>
		<input type="checkbox" name="grade" class="memsubmit"><p>처리 완료</p>
		</div>
		<div>
		<p><strong>•질문 게시 날짜</strong></p>
		<input type="date" id="dateFrom" name="date">~<input type="date" id="dateTo" name="todate">
		</div>
		<div>
		<p><strong>•검색어</strong></p>
	<select>
			<option>전체</option>
			<option>멘토</option>
			<option>로그인</option>
			<option>환불</option>
			<option>아이템</option>
			<option>이벤트</option>
		</select>
<input type="text" name="keyword" id="keyword">
<input type="submit" value="검색">
	</div>
	</form>
	</div>
