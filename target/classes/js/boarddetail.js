function replyupdate(no){
			document.getElementById("replyup").style.display="block";
			var x = new XMLHttpRequest(); 
					x.onreadystatechange = function(){
						t = document.forms[replyup][content].value;
						t.innerHTML = x.responseText.trim();
					};
				x.open("POST","/sseda/bo/reply_re",true);
				x.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
				x.send("no="+no);
}
function replayclose(){
	document.getElementById("replyup").style.display="none"
}
function view(){
		var l = document.getElementById("like").value;
		if(l == 'no'){
			document.getElementById("no").style.display="inline";
		}else{
			document.getElementById("yes").style.display="inline";
		}
}

function likeon(no){
		var x = new XMLHttpRequest(); 
			x.onreadystatechange = function(){
				document.getElementById("yes").style.display="inline";
				document.getElementById("no").style.display="none";
			};
		x.open("POST","/sseda/bo/like",true);
		x.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
		x.send("no="+no+"&stat=1");
	}
function likeoff(no){
	var x = new XMLHttpRequest(); 
			x.onreadystatechange = function(){
				document.getElementById("no").style.display="inline";
				document.getElementById("yes").style.display="none";
			};
		x.open("POST","/sseda/bo/like",true);
		x.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
		x.send("no="+no+"&stat=");
}