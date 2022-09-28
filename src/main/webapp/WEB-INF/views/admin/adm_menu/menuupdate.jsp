<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %> 
</head>
<body>
<center>	
<h2>메뉴 수정</h2>
<hr>
<%@ include file="../adm_menu/adm_Mmenu.jsp" %>
<hr>
<div class="container">
	<form action="/admin/menu_update" method="post">
		<table class="table" id="table">
		
			<thead>
			<tr>
				<th class="header" width="30"><input type="checkbox" id="checkall" /></th>
				<th>novel</th>
				<th>web_novel</th>
				<th>essay</th>
				<th>poem</th>
				<th>메뉴수정</th>
			</tr>
			</thead>
			<tbody class="tbody" id="tbody">
			<tr th:each="member :${members}" class="member">
				<td th:text="${member.novel}" class="membercenter"></td>
				<td th:text="${member.web_novel}" class="membercenter"></td>
				<td th:text="${member.essay}" class="membercenter"></td>
				<td th:text="${member.poem}" class="membercenter"></td>
				<td></td>
				<td><input type="submit" class="submit" id="submit" value="수정"></td>
				</tr>
			</tbody>
				
		</table>
	</form>
</div>
</center>
</body>
</html>