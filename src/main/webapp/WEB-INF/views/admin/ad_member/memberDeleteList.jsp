<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %>
</head>


<body>
<center>	
<h2>회원 탈퇴 관리</h2>
	<ul class="memmenu">
			<li class="mem"><a href="/admem/memberList">회원 목록</a></li>
			<li><a href="/admem/memberDeleteList">회원 탈퇴 목록</a></li>
		</ul>
	<hr>
<%@ include file="../ad_member/MmemDelete.jsp" %>

	<table>
		<tr>
			<th><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></th>
			<th>아이디</th>
			<th>이름</th>
			<th>닉네임</th>
			<th>이메일</th>
			<th>등급</th>
			<th>탈퇴요청날짜</th>
			<th>승인처리</th>
		</tr>
			<c:forEach items="${member}" var="m">
			<form method="post" action="/admem/memberDelete" onsubmit="return check(this)">
			<td><input type="checkbox"  name="vehicle1" value="Bike"></td>
			<td>${m.getId()}</td>
			<td>${m.getName()}</td>
			<td>${m.getNickname()}</td>
			<td>${m.getEmail()}</td>
			<td>${m.getGrade()}</td>
			<td>${m.getIsdeldate()}</td>
			<td><input type="submit" name="approval"  value="승인"></td>
			 </form>
		 </c:forEach> 
		 
		   <script>
		    	function check(f){    	    		
		    		if(f.approval.value == "승인" ){
		    			alert(" 정말로 승인처리 하시겠습니까?");    	
		    			return false;
		    		}    
		    		return true;
		    	}
    		</script>
		 
		 
		 
		</table>
</center>
</body>
</html>