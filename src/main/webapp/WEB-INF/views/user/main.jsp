<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/homemenu.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
<script src="/js/loginjs.js"></script>
</head>
<body onload="init()">
<%@ include file = "menu.jsp" %>
<input type="hidden" name="loginmsg" value="<%= request.getAttribute("loginmsg") %>">
<div id="screen">
	<div id="logoimg">
		<a href="/main.jsp"><img src="/img/logo.png" class="logo"></a>
	</div>
	<div id="novel">
		<a href="/it/itemlist?cate=1"><img src="/img/novel.png" class="novel"></a>
	</div>
	<div id="webnovel">
		<a href="/it/itemlist?cate=2"><img src="/img/webnovel.png" class="webnovel"></a>
	</div>
	<div id="essay">
		<a href="/it/itemlist?cate=3"><img src="/img/essay.png" class="essay"></a>
	</div>
	<div id="poem">
		<a href="/it/itemlist?cate=4"><img src="/img/poem.png" class="poem"></a>
	</div>
</div>

<div id="search">
  <form action="" autocomplete="on">
  <input id="search" name="search" type="text" placeholder="Search...">
  <input id="search_submit" value="Rechercher" type="submit">
  </form>
</div>
	
</body>
</html>