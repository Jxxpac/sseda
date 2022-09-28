	function pwche(){
		var pw = document.getElementById("pwc").value;
		var pwcheck = document.getElementById("pwca").value;
		if(pw == pwcheck){
			return true;
		}else{
			alert("비밀번호가 일치하지 않습니다.")
			return false;
		}
	}	
	function pwfind(no){
		var x = new XMLHttpRequest(); 
		var name = null;
		var num = null
		var email = null;
		if(no == "1"){
			name = document.getElementById("name").value;
			num = document.getElementById("phonenum").value;
		}else{
			name = document.forms[pmail][name].value;
			email = document.forms[pmail][email].value+"@"+document.forms[pmail][sempw].value;
		}
		x.onreadystatechange = function(){
			var rt = x.responseText.trim();
			var num = null;
			if(rt.length != "1"){
				num = rt.substring(0,1);
			}else{
				num = rt; 
			}
			if(num == "1"){
				alert("회원정보가 없습니다.")
			}else if(num == "2"){
				alert("이름이 틀렸습니다.")
			}else if(rt.length > 3){
				document.getElementById("pwchange").style.display = "block";
				document.getElementById("ids").value=rt;
			}
		};
		if(no == 1){
			x.open("POST","/mem/phonepw",true);
			
		}else{
			x.open("POST","/mem/emailpw",true);
		}
		x.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
		if(no == 1){
			x.send("name="+name+"&num="+num);
		}else{
			x.send("name="+name+"&email="+email);
		}
	}
		