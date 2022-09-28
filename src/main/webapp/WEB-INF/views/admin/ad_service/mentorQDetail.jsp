<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/ad_css/Mmanagercss.css">
</head>  
<body>
<div>
<img src="/sseda/img/premium-icon-member-2815096.png"
     style="width:5%; height:4%;">    
<h3>멘토 * 멘티 Q&A</h3>
<br>
</div>   

    <div class="editmem">
    <p>▶Question</p>
	<table>
		<tr>
			<th>멘토</th>
			<th>멘토 메칭이 그지같아요,..;;</th>
			<th>xofs255</th>
			<th>2022-08-17</th>
			<th>답변 중</th>
		</tr>
			<tr>
			<td colspan ="3">ㅡㅡ 이따구로 만들고 지금 이용하라고 하는 건가요????
			나참 어이가 없어서~!~~ 똑바로 만들어 주세요 -_-;;지존 짱나네여</td>
			<td></td>
			<td></td>
			</tr>
	</table>
	
	<div>
	<p>▶Answer</p>
	<textarea row="5" cols="80" placeholder="답변"  name="answer" ></textarea>
	   	<br>
	   	<form id="submit" action="/adqa/mentor">
	      <input type="submit" value="등록">
	      <input type="reset" value="취소">	       
	      </form>
</div>

<br>
<form id="close" action="/adqa/mentor">
<input type="submit" value="닫기">
</form>

</body>
</html>