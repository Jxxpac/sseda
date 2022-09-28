<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/message.css">
<title>매칭리스트</title>
</head>
<body>
<%@ include file = "../header.jsp" %>
<%@ include file = "../menu.jsp" %>
<div class="notediv">
	<div class="notewrap1">
	<ul class="noteul">
	<li class="sendnote"><a href="/ma/put?no=1">내가 신청한 매칭</a></li>
	<li class="sendnote"><a href="/ma/put">내가 받은 매칭 신청</a></li>
	<li class="sendnote"><a href="/ma/matching">매칭리스트</a></li>
	</ul>
	</div>
	<div class="notewrap2">
	<h1>나의 멘티</h1>
	<table id="table" class="notetable"data-toggle="table" data-search="true" data-filter-control="true" data-show-export="true" data-click-to-select="true" data-toolbar="#toolbar">
		<thead>
			<tr>
				<th data-field="prenom" data-filter-control="input" data-sortable="true">멘티</th>
				<th data-field="date" data-filter-control="select" data-sortable="true">아이템제목</th>
				<th data-field="examen" data-filter-control="select" data-sortable="true">매칭시작날짜</th>
				<th>멘토링상태</th>
				<th>평점등록</th>
				<th>평점</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${match }" var="map" >
			<c:if test="${map.key eq 'mento' }" >
				<c:forEach items="${map.value }" var="m" >
				<tr>
					<td class="notename">${m.o_id }</td>
					<td>${m.title }</td>
					<td>${m.mat_wdate }</td>
					<td>${m.mentoring }
					<c:if test="${m.mentoring eq '진행중' }">
						<a href="/ma/stat?no=${m.seqno }">/완료처리</a>
					</c:if>					
					</td>
					<td>
					<c:if test="${m.mentoring eq '완료' }">
						<input type="button" onclick="location.href='/ma/rainsert?no=${m.i_seqno}&id=${m.o_id }'" value="등록">
					</c:if>
					</td>
					<td></td>
				</tr>
				</c:forEach>
			</c:if>
		</c:forEach>	
		</tbody>
	</table>
	</div>
	<div class="notewrap2">
	<h1>나의 멘토</h1>
	<table id="table" class="notetable"data-toggle="table" data-search="true" data-filter-control="true" data-show-export="true" data-click-to-select="true" data-toolbar="#toolbar">
		<thead>
			<tr>
				<th data-field="prenom" data-filter-control="input" data-sortable="true">멘토</th>
				<th data-field="date" data-filter-control="select" data-sortable="true">아이템제목</th>
				<th data-field="examen" data-filter-control="select" data-sortable="true">매칭시작날짜</th>
				<th>멘토링상태</th>
				<th>평점등록</th>
				<th>평점</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${match }" var="i" >
			<c:if test="${i.key eq 'menti' }">
				<c:forEach items="${i.value }" var="mi" >
				<tr>
					<td class="notename">${mi.i_id }</td>
					<td>${mi.title }</td>
					<td>${mi.mat_wdate }</td>
					<td>${mi.mentoring }
					<c:if test="${mi.mentoring eq '진행중' }">
						<a href="/ma/stat?no=${mi.seqno }">/완료처리</a>
					</c:if>	
					</td>
					<td>
					<c:if test="${mi.mentoring eq '완료' }">
						<input type="button" onclick="location.href='/ma/rainsert?no=${mi.i_seqno}&id=${mi.i_id }'" value="등록">
					</c:if>
					</td>
					<td></td>
				</tr>
				</c:forEach>
			</c:if>
		</c:forEach>	
		</tbody>
	</table>
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
