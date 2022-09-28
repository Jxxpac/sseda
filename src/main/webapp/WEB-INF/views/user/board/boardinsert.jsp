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
		<form name="iteminsert" method="post" action="/bo/boardin" id="iteminsert">
			<input type="text" name="title" style="margin-left:8%;" placeholder="제목">
			<input type="hidden" name="no" value="${no }">
			<br>
			<fieldset style="width:15%;display:inline;">
				<legend>공개여부</legend>
				<input type="radio" name="open" value="Y">공개
				<input type="radio" name="open" value="N">비공개
			</fieldset>
			<input type="file" style="width:10%" value="첨부파일"><br>
			<textarea name="content" id="content" placeholder="내용"></textarea><br>
			<input type="submit" value="등록" >
			<input type="submit" value="취소" >
		</form>
	</div>
  
<%@include file="../footer.jsp" %>  
</body>
</html>