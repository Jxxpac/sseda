<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/sseda/ad_css/manager.css">

<form id="keyword" action="#">
<div class="dropdown">
      <button class="dropbtn"> 
       <span class="dropbtn_icon">메뉴 리스트</span>	
      </button>
      <div class="dropdown-content">
        <a href="/sseda/ad_category/categoryinsert.jsp">카테고리 등록</a>
        <a href="/sseda/ad_category/categorydelete.jsp">카테고리 삭제 </a>
        <a href="/sseda/ad_category/categoryupdate.jsp">카테고리 수정</a>
       </div>
	</div>
	<select>
			<option>ALL</option>
			<option>NOVEL</option>
			<option>WEBNOVEL</option>
			<option>ESSAY</option>
			<option>POEM</option>
		</select>
<input type="text" name="keyword" id="keyword">
<input type="submit" value="검색">
</form>

