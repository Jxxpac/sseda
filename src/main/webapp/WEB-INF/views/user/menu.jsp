<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div id="menu">
<ul class="menubox">
  <li class="menuline"><a href="main.jsp">Home</a></li>
  <li><a href="/it/item">Item</a></li>
  <li><a href="/bo/board">Board</a></li>
  <li><a href="/qa/qna">고객센터</a></li>
  <c:set value="${sess_id}" var="id" />
  <c:set value="${sess_pw}" var="pw" />
  <c:set value="${sess_name}" var="name" />
  <c:if test="${id == null}">
  <li><a href="/mem/gologin">login</a></li>
  <li><a href="/mem/gosignup">회원가입</a></li>
  </c:if>
  <c:if test="${id != null}">
  <li><a href="/mem/usercheck?id=${id}&pw=${pw}">Mypage</a></li>
  <li>${name} 님</li>
  <li><a href="/mem/logout">logout</a></li>
  </c:if>
</ul>
</div>
