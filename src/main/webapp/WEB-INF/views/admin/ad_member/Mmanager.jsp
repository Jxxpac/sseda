<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <link rel="stylesheet" href="/ad_css/Mmanagercss.css">
 <script src="/sseda/js/date.js"></script>
<div class="memwrap">
	<form method="post" action="/admem/memberList">
		<div class="gradewrap">
 		<p><strong>•등급</strong></p>
 		<c:choose>
			<c:when test="${member.s.grade != null }">
				<c:choose>
					<c:when test="${fn:length(member.s.grade) eq 1 }">
						<c:choose>
							<c:when test="${member.s.grade[0] eq 'O' }">
								<input type="checkbox" name="grade" class="memsubmit" value="O" checked><p>멘토</p>
								<input type="checkbox" name="grade" class="memsubmit" value="I"><p>멘티</p>
							</c:when>
							<c:when test="${member.s.grade[0] eq 'I' }">
								<input type="checkbox" name="grade" class="memsubmit" value="O"><p>멘토</p>
								<input type="checkbox" name="grade" class="memsubmit" value="I" checked><p>멘티</p>
							</c:when>
						</c:choose>		
					</c:when>	
					<c:when test="${fn:length(member.s.grade) eq 2 }">
						<c:choose>
							<c:when test="${member.s.grade[0] eq 'O' && member.s.grade[1] eq 'I' }">
								<input type="checkbox" name="grade" class="memsubmit" value="O" checked><p>멘토</p>
								<input type="checkbox" name="grade" class="memsubmit" value="I" checked><p>멘티</p>
							</c:when>
						</c:choose>		
					</c:when>	
				</c:choose>
 			</c:when>
 			<c:otherwise>
				<input type="checkbox" name="grade" class="memsubmit" value="O"><p>멘토</p>
				<input type="checkbox" name="grade" class="memsubmit" value="I"><p>멘티</p>
 			</c:otherwise>
 		</c:choose>
		</div>
		<div>
		<p><strong>•가입날짜</strong></p>
		<c:choose>
			<c:when test="${member.s.start != null && member.s.end == null }">
				<input type="date" id="dateFrom" name="start" value="start" pattern="yyyy-mm-dd" checked>~<input type="date" id="dateTo" name="end" pattern="yyyy-mm-dd">
			</c:when>
			<c:when test="${member.s.start == null && member.s.end != null }">
				<input type="date" id="dateFrom" name="start" value="start" pattern="yyyy-mm-dd">~<input type="date" id="dateTo" name="end" checked pattern="yyyy-mm-dd">
			</c:when>
			<c:when test="${member.s.start != null && member.s.end != null }">
				<input type="date" id="dateFrom" name="start" value="start" pattern="yyyy-mm-dd" checked>~<input type="date" id="dateTo" name="end" checked pattern="yyyy-mm-dd">
			</c:when>
			<c:when test="${member.s.start == null && member.s.end == null }">
				<input type="date" id="dateFrom" name="start" value="start" pattern="yyyy-mm-dd" checked>~<input type="date" id="dateTo" name="end" checked pattern="yyyy-mm-dd">
			</c:when>
		</c:choose>
		</div>
		<div>
		<p><strong>•검색어</strong></p>
		<select name="searchcase">
		<c:choose>
			<c:when test="${member.s.sh eq null }">
				<option value="memall" selected>전체</option>
				<option value="memid">회원 아이디</option>
				<option value="memname">회원 이름</option>
				<option value="memnick">회원 닉네임</option>
			</c:when>
			<c:when test="${member.s.sh eq 'memall' }">
				<option value="memall" selected>전체</option>
				<option value="memid">회원 아이디</option>
				<option value="memname">회원 이름</option>
				<option value="memnick">회원 닉네임</option>
			</c:when>
			<c:when test="${member.s.sh eq 'memid' }">
				<option value="memall">전체</option>
				<option value="memid" selected>회원 아이디</option>
				<option value="memname">회원 이름</option>
				<option value="memnick">회원 닉네임</option>
			</c:when>
			<c:when test="${member.s.sh eq 'memname' }">
				<option value="memall">전체</option>
				<option value="memid">회원 아이디</option>
				<option value="memname" selected>회원 이름</option>
				<option value="memnick">회원 닉네임</option>
			</c:when>
			<c:when test="${member.s.sh eq 'memnick' }">
				<option value="memall">전체</option>
				<option value="memid">회원 아이디</option>
				<option value="memname">회원 이름</option>
				<option value="memnick" selected>회원 닉네임</option>
			</c:when>
		</c:choose>
		</select>
		<c:choose>
			<c:when test="${member.s.sh != null }">
				<input type="text" name="keyword" id="keyword" value="${member.s.key }">
			</c:when>
			<c:otherwise>
				<input type="text" name="keyword" id="keyword" value="${member.s.key }">
			</c:otherwise>	
		</c:choose>
		<input type="submit" value="검색"  name="btnSearch" required>
		</div>
	</form>
</div>


