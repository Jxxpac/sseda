<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %> 
</head>
<body>
<center>	
<h2>카테고리 등록</h2>
<hr>
<%@ include file="../ad_category/Mcategory.jsp" %>
<hr>
<div class="container">
	<form action="/sseda/ad_category/category_ins" method="post">
		<table class="table" id="table">
		
			<thead>
			<tr>
				<th class="header" width="30"><input type="checkbox" id="checkall" /></th>
				<th>romance</th>
				<th>horror</th>
				<th>sf</th>
				<th>essay_test</th>
				<th></th>
				<th>카테고리등록처리</th>
			</tr>
			</thead>
			<tbody class="tbody" id="tbody">
			<tr th:each="member :${members}" class="member">
				<td th:text="${member.romance}" class="membercenter"></td>
				<td th:text="${member.horror}" class="membercenter"></td>
				<td th:text="${member.sf}" class="membercenter"></td>
				<td th:text="${member.essay_test}" class="membercenter"></td>
				<td></td>
				<td></td>
				<td><input type="submit" class="submit" id="submit" value="등록"></td>
				</tr>
			</tbody>
				
		</table>
	</form>
</div>
</center>
</body>
</html>