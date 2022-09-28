<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %>
</head>
<body>
<center>	
<h2>댓글 수정 삭제</h2>
<hr>
<%@ include file="../ad_board/Sboard.jsp" %>

		<table>
		<tr>
		<th><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></th>
		<th>BOARD_NUM</th>
		<th>ID</th>
		<th>COTENT</th>
		<th>WDATE</th>
		<th>수정</th>
				<th>삭제</th>
		</tr>
		<tr>
		<td><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></td>
		<td>보드넘버</td>
		<td>아이디</td>
		<td>내용</td>
		<td>날짜</td>
		<td><input type="submit" class="submit" id="submit" value="수정"></td>
		<td><input type="submit" class="submit" id="submit" value="삭제"></td>
		</tr>
		</table>
		</center>
</body>
</html>