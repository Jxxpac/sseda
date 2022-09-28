<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<link rel="stylesheet" href="/css/service.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/service.js"></script>
<script src="/js/insert.js"></script>
</head>
<body onload="all();all()">
<div id="wrap" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
	<center>
	<div id="service">
		<div class="container">
		<c:if test="${sess_id != null }">
			<c:set value="${sess_id }" var="id"/>
		</c:if>
		<c:if test="${sess_id == null }">
			<c:set value="" var="id"/>
		</c:if>
	    	<a href="javascript:check('${id }',3)" class="button btnPush btnPurple" style="top: 36%; left: 93%">글등록</a>
	  	</div>
	  	<c:if test="${sess_id != null }">
	  		<a id="myquestion" href="/qa/myquestion">나의 문의현황</a>
	  	</c:if>
		<h1>자주 찾는 도움말</h1><br><br>
		<a id="all" href="javascript:all()">전체</a>		
		<a id="mem" href="javascript:mem()">계정관리</a>		
		<a id="lim" href="javascript:lim()">아이템</a>
		<a id="bre" href="javascript:bre()">이벤트게시판</a>		
		<a id="men" href="javascript:men()">멘토/멘티</a>		
		<a id="data" href="javascript:data()">환불/결제</a><br><br>
		<div id="servicebox">
			<div id="allbox">
				<c:forEach items="${qna }" var="qna" >
					<c:if test="${qna.key eq 'A' }" >
						<c:forEach items="${qna.value }" var="q">
							<div class="contentbox" onclick="memmo('${q.question.seqno }')" style="background-color:white">
							<a class="q" style="text-decoration:none;background-color:white;">Q</a><a style="background-color:white">${q.question.title }</a>
							</div>
						</c:forEach>
					</c:if>			
				</c:forEach> 
			</div>
			<div id="membox">
				<c:forEach items="${qna }" var="qna" >
					<c:if test="${qna.key eq 'M' }" >
						<c:forEach items="${qna.value }" var="q">
							<div class="contentbox" onclick="memmo('${q.question.seqno }')" style="background-color:white">
							<a class="q" style="text-decoration:none;background-color:white;">Q</a><a style="background-color:white">${q.question.title }</a>
							</div>
						</c:forEach>
					</c:if>			
				</c:forEach> 
			</div>
			<div id="limit">
				<c:forEach items="${qna }" var="qna" >
					<c:if test="${qna.key eq 'I' }" >
						<c:forEach items="${qna.value }" var="q">
							<div class="contentbox" onclick="memmo('${q.question.seqno }')" style="background-color:white">
							<a class="q" style="text-decoration:none;background-color:white;">Q</a><a style="background-color:white">${q.question.title }</a>
							</div>
						</c:forEach>
					</c:if>			
				</c:forEach> 
			</div>
			<div id="braek">
				<c:forEach items="${qna }" var="qna" >
					<c:if test="${qna.key eq 'E' }" >
						<c:forEach items="${qna.value }" var="q">
							<div class="contentbox" onclick="memmo('${q.question.seqno }')" style="background-color:white">
							<a class="q" style="text-decoration:none;background-color:white;">Q</a><a style="background-color:white">${q.question.title }</a>
							</div>
						</c:forEach>
					</c:if>			
				</c:forEach> 
			</div>
			<div id="menbox">
				<c:forEach items="${qna }" var="qna" >
					<c:if test="${qna.key eq 'T' }" >
						<c:forEach items="${qna.value }" var="q">
							<div class="contentbox" onclick="memmo('${q.question.seqno }')" style="background-color:white">
							<a class="q" style="text-decoration:none;background-color:white;">Q</a><a style="background-color:white">${q.question.title }</a>
							</div>
						</c:forEach>
					</c:if>			
				</c:forEach> 
			</div>
			<div id="databox">
				<c:forEach items="${qna }" var="qna" >
					<c:if test="${qna.key eq 'P' }" >
						<c:forEach items="${qna.value }" var="q">
							<div class="contentbox" onclick="memmo('${q.question.seqno }')" style="background-color:white">
							<a class="q" style="text-decoration:none;background-color:white;">Q</a><a style="background-color:white">${q.question.title }</a>
							</div>
						</c:forEach>
					</c:if>			
				</c:forEach> 
			</div>
		</div>	
	</div>
</div>	
	<%@include file="../footer.jsp" %>
	<div id="modal">
			<a id="mclose" href="javascript:mclose()" style="float:right;">X</a><br><br>
			<center>
			<div>
				<a id="mtitle"></a>
			</div>
			<br><br>
			<div id="aback">
				<a id="mcontent"></a>
			</div>
			</center>
	</div>	
</body>
</html>