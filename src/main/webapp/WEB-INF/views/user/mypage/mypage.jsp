<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/mypage.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/sseda/js/meesagejs.js"></script>
</head>
<body>
<div id="wrap">
 <section>
  <%@ include file = "../header.jsp" %>
  <%@ include file = "../menu.jsp" %>
  <c:set value="${firstmy}" var="my" />	
 	<header>
      <div class="thumb-wrapper stagger-item">
        <a href="#"><img class="thumb" src="/img/user-thumb.png"/></a>
       <!--  <div class="badge"></div> -->
      </div>

      <div class="text-area">
        <h2 class="greeting stagger-item">${my.name}님</h2>
      </div>

      <div class="mail mouse-effect stagger-item">
        <span>${my.email}</span>
      </div>
    </header>
    <ul class="list">
      <li class="item mouse-effect stagger-item">
        <div class="left">
          <img src="/sseda/img/account.svg" />
          <div class="name"><a href="/mem/userinfo?id=${my.id}">내 정보 관리</a></div>
        </div>
      </li>

      <li class="item mouse-effect stagger-item">
        <div class="left">
          <img src="/sseda/img/business.svg" />
          <div class="name"><a href="/mem/userinfoitem?id=${my.id}">내 아이템</a></div>
        </div>
      </li>

      <li class="item mouse-effect stagger-item">
        <div class="left">
          <img src="/sseda/img/business.svg" />
          <div class="name"><a href="/mem/userinfoboard?id=${my.id}">내가 쓴 글</a></div>
        </div>
      </li>
      
      <li class="item mouse-effect stagger-item">
        <div class="left">
          <img src="/sseda/img/business.svg" />
          <div class="name"><a href="/mem/userinforeply?id=${my.id}">내가 쓴 댓글</a></div>
        </div>
      </li>
      
      <li class="item mouse-effect stagger-item">
        <div class="left">
          <img src="/sseda/img/business.svg" />
          <div class="name"><a href="userinfo_like.jsp">내 관심목록</a></div>
        </div>
      </li>
      
      <li class="item mouse-effect stagger-item">
        <div class="left">
          <img src="/sseda/img/business.svg" />
          <div class="name"><a href="usernote.jsp">쪽지</a></div>
        </div>
      </li>
      
       <li class="item mouse-effect stagger-item">
        <div class="left">
          <img src="/sseda/img/business.svg" />
          <div class="name"><a href="/ma/matching">매칭</a></div>
        </div>
      </li>
      
      <li class="item mouse-effect stagger-item">
        <div class="left">
          <img src="/sseda/img/puzzle.svg" />
          <div class="name"><a href="/ma/myrating">평점 조회</a></div>
        </div>
      </li>
     
      <li class="item mouse-effect stagger-item">
        <div class="left">
          <img src="/sseda/img/puzzle.svg" />
          <div class="name"><a href="/qa/myquestion">나의1:1문의현황</a></div>
        </div>
      </li>
      
      <li class="item mouse-effect stagger-item">
        <div class="left">
          <img src="/sseda/img/business.svg" />
          <div class="name"><a href="userinfo_account">결제</a></div>
        </div>
      </li>
    </ul>
 </section> 
	<%@ include file= "../footer.jsp" %>
</div>
</body>
</html>