<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템 등록</title>
<link rel="stylesheet" href="/css/item.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
</head>
<body>
	<%@ include file = "../header.jsp" %>
	<%@ include file = "../menu.jsp" %>
	<br><br><br>
	<div id="iteminsertm">
		<form name="iteminsert" method="post" action="/it/in" id="iteminsert">
			<input type="text" name="title" style="margin-left:8%;" placeholder="제목">
			<br>
			<fieldset style="width:15%;display:inline; margin-left: -3%;">
				<legend>카테고리</legend>
				<input type="radio" name="cate" value="1">소설
				<input type="radio" name="cate" value="2">웹소설
				<input type="radio" name="cate" value="3">에세이
				<input type="radio" name="cate" value="4">시
			</fieldset>
			<fieldset style="width:15%;display:inline;">
				<legend>멘토/멘토</legend>
				<input type="radio" name="cfcheck" value="O">멘토
				<input type="radio" name="cfcheck" value="I">멘티
			</fieldset>
			<fieldset style="width:15%;display:inline;">
				<legend>공개여부</legend>
				<input type="radio" name="open" value="Y">공개
				<input type="radio" name="open" value="N">비공개
			</fieldset><br>
			<input type="file" style="width:10%" value="첨부파일">
			<input type="number" min="0" max="10000000" name="price" placeholder="가격"><br>
			<textarea name="content" id="content" placeholder="내용"></textarea><br>
			<input type="submit" value="등록" >
			<input type="submit" value="취소" >
		</form>
	</div>
  
<%@include file="../footer.jsp" %>  
  
</body>
</html>