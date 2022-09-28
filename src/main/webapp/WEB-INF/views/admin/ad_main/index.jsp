<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<meta name="viewport" content="width=device-width, inital-scale=1.0">	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link rel="stylesheet" href="/css/ad_login.css">
<script>
	function login(){
		var id = document.getElementById("id").value;
		if(id != 1 && id != 2){
			
		}else if(id == 1){
			alert("비밀번호가 일치하지않습니다.");
		}else{
			alert("아이디가 존재하지 않습니다.");
		}
	}
</script>
</head>
<body onload="login()">
<input type="hidden" value="${id }" id="id">
<center>
<div class="clock">
    <span id="clock" style="color:gray; font-size: 30px;">clock</span>
    <span id="apm" style="color:gray; font-size: 15px;"  >ampm</span>
    </div>
   <form name= "login" method = "post" action = "/login">
    <div class="main">
        <h1 class="logo">SSEDA.</h1>
        <div class="container">
            <input type="text" placeholder="ID" id="id" name ="id" class="account">
            <input type="password" placeholder="Password" id="password" name= "pw" class="account">
            <button type="submit" value="login" id="login" class="account">login</button>
            <p id="alert" class="account"> </p>
        </div>
    </div>   
    </form>
    <script src="/sseda/js/ad_login.js"></script>
</body>
</html>
