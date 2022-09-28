<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %>
</head>
<body>
<center>
<h2>이벤트 질문 글 </h2>
	<ul class="memmenu">
			<li class="mem"><a href="/adqa/mentor">멘토＊멘티 Q&A</a></li>
			<li><a href="/adqa/login">로그인 Q&A</a></li>
			<li><a href="/adqa/refund">환불 Q&A</a></li>
			<li><a href="/adqa/item">아이템 Q&A</a></li>
			<li><a href="/qaad/event">이벤트 Q&A</a></li>
		</ul>
<hr>
<%@ include file="../ad_service/Mservice.jsp" %>
<br>
<table>
				<tr>
					<th>카테고리</th>
					<th>아이디</th>
					<th>타이틀</th>
					<th>날짜</th>
					<th>답변처리 상태</th>
				</tr>
					<tr onclick="location.href='/adqa/event'">
					<td>이벤트</td>
					<td>nqghhkqh</td>
					<td>이벤트 좋아요 왜이래요?</td>
					<td>2022-08-17</td>
					<td>답변 완료</td>
				</tr>
				<tr>
					<th>카테고리</th>
					<th>아이디</th>
					<th>타이틀</th>
					<th>날짜</th>
					<th>답변처리 상태</th>
				</tr>
					<tr onclick="location.href='/sseda/ad_service/eventQDetail.jsp'">
					<td>로그인</td>
					<td>xodud96255</td>
					<td>이벤트 상품이 뭐죠??/</td>
					<td>2022-08-16</td>
					<td>답변 중</td>
				</tr>
			</table>
</body>
</html>