<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/sseda/ad_css/manager.css">

	<ul class="memmenu">
			<li class="mem"><a href="/adm_menu/menulist.jsp">메뉴 리스트</a></li>
			<li><a href="/adm_menu/menuinsert.jsp">메뉴 수정&삭제 </a></li>
		</ul>
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

