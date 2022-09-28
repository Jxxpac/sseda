function signupcheck() {
	var signupform = document.signupform;
	var id = signupform.id;
	var pw = signupform.pw;
	var name = signupform.name1;
	var nickname = signupform.nickname;
	var gender = signupform.gender;
	var phonenumber = signupform.phone;
	var email = signupform.email;
	var edo = signupform.eDomain;
	var dbcheckid = signupform.idoverlap
	var overlapch = signupform.overlapch;
	
	if(id.value == "") {
		alert("아이디를 입력해주세요.");
		id.focus();
		return false;
	}
	if(pw.value == "") {
		alert("비밀번호를 입력해주세요.");
		pw.focus();
		return false;
	}
	if(name.value == "") {
		alert("이름을 입력해주세요.");
		name.focus();
		return false;
	}
	if(nickname.value == "") {
		alert("닉네임을 입력해주세요.");
		nickname.focus();
		return false;
	}
	if(gender.value == "") {
		alert("성별을 입력해주세요.");
		nickname.focus();
		return false;
	}
	if(phonenumber.value == "") {
		alert("전화번호를 입력해주세요.");
		phonenumber.focus();
		return false;
	}
	if(email.value == "") {
		alert("이메일을 입력해주세요.");
		email.focus();
		return false;
	}
	if(edo.length == 0) {
		alert("이메일을 입력해주세요.");
		edo.focus();
		return false;
	}
	
	if(overlapch.value == "uncheck") {
		alert("아이디 중복검사를 해주세요.");
		dbcheckid.focus();
		return false;
	} else if(overlapch.value == "imposiid") {
		alert("아이디를 확인해주세요.");
		dbcheckid.focus();
		return false;
	}
	
}

function DBcheckid() {
	var overlapch = document.signupform.overlapch;
	var id = document.signupform.id.value;
	var x = new XMLHttpRequest();
	x.onreadystatechange = function() {
		if(x.readyState === 4 && x.status === 200) {
			if(x.responseText.trim() === "0") {
				overlapch.value = 'imposiid';
				alert("아이디가 중복됩니다.");
			} else {
				overlapch.value = 'check';
				alert("사용할 수 있는 아이디입니다.");
			}
		};
	}
	x.open("POST", "/sseda/mem/idcheck", true);
	x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	x.send("id="+id);
}

