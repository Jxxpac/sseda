<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 글</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/useritem.css">
<link rel="stylesheet" href="/css/useritem_list.css">
</head>
<body>
<div id="wrap">
 <%@ include file = "../header.jsp" %>
 <%@ include file = "../menu.jsp" %>
<section>
<div class="container">
<h1>내 게시글 정보</h1>
  <table class="rwd-table">
    <tbody>
      <tr>
        <th>번호</th>
        <th>글제목</th>
        <th>작성일자</th>
        <th>조회수</th>
        <th>추천</th>
      </tr>
      <c:set value="${myboard}" var="myboard" />
      <c:forEach items="${myboard}" var="board">
      <tr onclick="location.href='/bo/detail?no=${board.no}'">
        <td>${board.no}</td>
        <td>${board.title}</td>
        <td>${board.wdate}</td>
        <td>${board.count}</td>
        <td>${board.like}</td>
     </tr>
     </c:forEach>
    </tbody>
  </table>
</div>
</section>
<%@ include file="../footer.jsp" %>
</div>
</body>
</html>