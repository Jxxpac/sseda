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
<h3> 이벤트 Q&A </h3>
<br>
</div>   

    <div class="editmem">
    <p>▶Question</p>
	<table>
		<tr>
			<th>로그인</th>
			<th>이벤트 좋아요 왜이래요?</th>
			<th>nqghhkqh</th>
			<th>2022-08-17</th>
			<th>답변 중</th>
		</tr>
			<tr>
			<td colspan ="3">하트가 어젠 두개였는데 오늘은 세개예요 ㅠㅠ</td>
			<td></td>
			<td></td>
			</tr>
	</table>
	
	<div>
	<p>▶Answer</p>
	<textarea row="5" cols="80" placeholder="답변"  name="answer" ></textarea>
	   	<br>
	   	<form id="submit" action="/adqa/eventDetail.jsp">
	      <input type="submit" value="등록">
	      <input type="reset" value="취소">	       
	      </form>
</div>

<br>
<form id="close" action="/adqa/event.jsp">
<input type="submit" value="닫기">
</form>
</body>
</html>