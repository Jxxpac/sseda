<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/ad_css/Mmanagercss.css">
</head>  
<body>
<div>
<img src="/img/premium-icon-member-2815096.png"
     style="width:5%; height:4%;">    
<h3> 로그인 Q&A </h3>
<br>
</div>   

    <div class="editmem">
    <p>▶Question</p>
	<table>
		<tr>
			<th>로그인</th>
			<th>비번 질문 까먹음요</th>
			<th>wjddnqkqh</th>
			<th>2022-08-17</th>
			<th>답변 중</th>
		</tr>
			<tr>
			<td colspan ="3">알려주셈</td>
			<td></td>
			<td></td>
			</tr>
	</table>
	
	<div>
	<p>▶Answer</p>
	<textarea row="5" cols="80" placeholder="답변"  name="answer" ></textarea>
	   	<br>
	   	<form id="submit" action="/adqa/login">
	      <input type="submit" value="등록">
	      <input type="reset" value="취소">	       
	      </form>
</div>

<br>
<form id="close" action="/adqa/login">
<input type="submit" value="닫기">
</form>

</body>
</html>