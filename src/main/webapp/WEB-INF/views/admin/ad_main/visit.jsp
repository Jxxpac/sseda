<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="../ad_css/manager.css">

<center>
<h2>방문자 현황</h2>
<div class="visit" style="display: flex;">
<h2>TOTAL MONTH WEEK TODAY</h2>
</div>
</center>
<div class ="total" style="display: flex;">

  <h2 class="count-1"> 1,500</h2>
  <h2 class="count-2"> 150</h2>
  <h2 class="count-3"> 35</h2>
  <h2 class="count-4"> 17</h2>
</div>






<script>
	const $counter = document.querySelector(".count");
	const max = 17242;
	counter($counter, max);
	
	const counter = ($counter, max) => {
	  let now = max;

	  const handle = setInterval(() => {
	    $counter.innerHTML = Math.ceil(max - now);
	  
	    // 목표수치에 도달하면 정지
	    if (now < 1) {
	      clearInterval(handle);
	    }
	    
	    // 증가되는 값이 계속하여 작아짐
	    const step = now / 10;
	    
	    // 값을 적용시키면서 다음 차례에 영향을 끼침
	    now -= step;
	  }, 50);
	}

	window.onload = () => {
	  // 카운트를 적용시킬 요소
	  const $counter = document.querySelector(".count");
	  
	  // 목표 수치
	  const max = 17249;
	  
	  setTimeout(() => counter($counter, max), 2000);
	}

</script>