<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/userinfo.css">
<link rel="stylesheet" href="/css/footer.css">
<script src=//js/changeuserinfo.js"></script>
</head>
<body>
<div id="wrap">
	<%@ include file = "../header.jsp" %>
	<%@ include file = "../menu.jsp" %>
<section>	
 <div class="usercontent">
  <div class="columncontent" style="text-align: center">
  <div class="thumb-wrapper">
        <img class="thumb" src="/img/user-thumb.png"/>
       <!--  <div class="badge"></div> -->
      <c:set value="${mypage}" var="my" /> 
      <button class="chuserinfo-button" onclick="location.href='/mem/changeuser?id=${my.id}'">내정보수정</button>
      <button class="secessionuser-button" onclick="javascript:secession('${my.id}')">회원탈퇴요청</button>
      </div>
		<table class="table-fill">
				<tbody class="table-hover">
					<tr>
						<td class="text-left">아이디</td>
						<td class="text-right">${my.id}</td>
					</tr>
					<tr>
						<td class="text-left">이름</td>
						<td class="text-right">${my.name}</td>
					</tr>
					<tr>
						<td class="text-left">성별</td>
						<c:choose>
						<c:when test="${my.gender eq 'M ' }">
						<td class="text-right">남자</td>
						</c:when>
						<c:otherwise>
						<td class="text-right">여자</td>
						</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<td class="text-left">닉네임</td>
						<td class="text-right">${my.nickname}</td>
					</tr>
					<tr>
						<td class="text-left">휴대전화</td>
						<td class="text-right">${my.phonenumber}</td>
					</tr>
					<tr>
						<td class="text-left">이메일</td>
						<td class="text-right">${my.email}</td>
					</tr>
					<!-- <tr>
						<td class="text-left">보유금액</td>
						<td class="text-right"><button onclick="#" class="chamount-button">충전하기</button></td>
					</tr> -->
					
					
					<tr>
						<td class="text-left">등급</td>
						<td class="text-right">
						
							<c:forEach items="${my.grade}" var="grade">
							<c:if test="${grade eq 'I'}">
							멘티
							</c:if>
							<c:if test="${grade eq 'O'}">
							,멘토
							</c:if>
							</c:forEach>
							<button onclick="gradewindow('/sseda/changegrade.jsp','changegrade')" class="chgrade-button">멘토신청</button>
						</td>
					</tr>
					
			</tbody>
			</table>
  </div>	
 </div>
</section>
<%@ include file="../footer.jsp" %>
</div>
</body>
</html>