<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가쓴 댓글</title>
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
<h1>내가 쓴 댓글 정보</h1>
  <table class="rwd-table">
    <tbody>
      <tr>
        <th>댓글번호</th>
        <th>게시글제목</th>
        <th>댓글내용</th>
        <th>작성일자</th>
      </tr>
      <c:forEach items="${myreply}" var="reply">
      <tr onclick="location.href='/bo/detail?no=${reply.board_no}'">
        <td>${reply.no}</td>
        <td>${reply.board_title}</td>
        <td>${reply.content}</td>
        <td>${reply.wdate}</td>
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