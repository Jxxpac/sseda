<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
<link rel="stylesheet" href="/css/changeuser.css">
<script src="/js/changeuserinfo.js"></script>
</head>
<body>    
<c:set value="${id}" var="id" />
		<form name="changeform">
			<input type="hidden" name="chid" value="${id}">
				<table class="changeuser-table">
					<tbody class="changeuser-hover">
						<tr>
							<td class="text-left">비밀번호</td>
							<td class="text-right"><input type="password" name="changepw" ></td>
						</tr>
						<tr>
							<td class="text-left">비밀번호 재확인</td>
							<td class="text-right"><input type="password" name="checkpw" >
							<input type="button" onclick="chms()" value="확인">
							<a class="cha" id="chms"></a>
							</td>
						</tr>
						<tr>
							<td class="text-left">닉네임</td>
							<td class="text-right"><input type="text" name="changenickname" onchange="dupnickname()">
							<!-- <input type="button" onclick="dupnickname()" value="확인"> -->
							<a class="cha" id="chni"></a>
							</td>
						</tr>
						<tr>
							<td class="text-left">휴대전화</td>
							<td class="text-right"><input type="text" name="changephone" onchange="dupcheck()">
							<a class="cha" id="chph"></a>
							</td>
						</tr>
						<tr>
							<td class="text-left">이메일</td>
							<td class="text-right"><input type="text" name="changeemail" onchange="dupcheck()">
							<a class="cha" id="chem"></a>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="button" value="수정" class="change-submit" onclick="changeuser()">
				<input type="button" value="취소" class="cancel" onclick="location.href='/mem/closechuser?id=${id}'">
				</form>
</body>
</html>