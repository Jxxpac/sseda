<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %>
</head>
<body>
<center>	
<h2>신고 댓글 관리</h2>
<%@ include file="../ad_report/Sreport.jsp" %>
<hr>
<%@ include file="../ad_report/Sreply.jsp" %>
<br>
<table>
	<tr>
		<th><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></th>
		<th>아이디</th>
		<th>내용</th>
		<th>댓글날짜</th>
		<th>신고수</th>
		<th>신고 날짜</th>
		<th>삭제처리</th>
	</tr>
	<tr>
		<td><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></td>
		<td>dd78</td>
		<td>어쩌라고? 안물어봤어</td>
		<td>22-08-21</td>
		<td>80</td>
		<td>22-09-31</td>
		<td><input type="submit" class="submit" id="submit" value="삭제"></td>
	</tr>
</table>

</center>
</body>
</html>