<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/message.css">
<title>쪽지 관리</title>
</head>
<body>
<%@ include file = "../header.jsp" %>
<%@ include file = "../menu.jsp" %>
<div class="notediv">
	<div class="notewrap1">
	<ul class="noteul">
	<li class="sendnote"><a href="/mypage/usernote.jsp">받은쪽지함</a></li>
	<li class="sendnote"><a href="/mypage/usersendnotelist.jsp">보낸쪽지함</a></li>
	<li><a href="/mypage/userclearnotelist.jsp">휴지통</a></li>
	</ul>
	</div>
	<div class="notewrap2">
	<h1>휴지통</h1>
	<table id="table" class="notetable"data-toggle="table" data-search="true" data-filter-control="true" data-show-export="true" data-click-to-select="true" data-toolbar="#toolbar">
		<thead>
			<tr>
				<th data-field="state" data-checkbox="true"></th>
				<th data-field="prenom" data-filter-control="input" data-sortable="true">보낸사람</th>
				<th data-field="date" data-filter-control="select" data-sortable="true">내용</th>
				<th data-field="examen" data-filter-control="select" data-sortable="true">날짜</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="notecheckbox"><input data-index="0" name="btSelectItem" type="checkbox"></td>
				<td class="notename">김정우</td>
				<td>Title</td>
				<td>2022-00-00</td>
			</tr>
		</tbody>
	</table>
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
