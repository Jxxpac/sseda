<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %> 
</head>
<body>
<center>	
<h2>카테고리 수정</h2>
<hr>
<%@ include file="../ad_category/Mcategory.jsp" %>
<hr>
<div class="container">
	<form action="/sseda/ad_category/category_update" method="post">
		<table class="table" id="table">
		
			<thead>
			<tr>
				<th class="header" width="30"><input type="checkbox" id="checkall" /></th>
				<th>romance</th>
				<th>horror</th>
				<th>sf</th>
				<th>essay_exam</th>
				<th>카테고리수정처리</th>
			</tr>
			</thead>
			<tbody class="tbody" id="tbody">
			<tr th:each="member :${members}" class="member">
				<td th:text="${member.romnace}" class="membercenter"></td>
				<td th:text="${member.horror}" class="membercenter"></td>
				<td th:text="${member.sf}" class="membercenter"></td>
				<td th:text="${member.essay_exam}" class="membercenter"></td>
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