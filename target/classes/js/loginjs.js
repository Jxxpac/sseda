function init() {
	var msg = document.getElementsByName("loginmsg");

    var alert_msg;
      
      switch(msg[0].value) {
		case "loginok" : 
	 	 alert_msg = "로그인 되었습니다.";
	 	 break;
		case "pwfail" : 
		 alert_msg = "비밀번호가 틀렸습니다.";
		 break;
		case "loginfail" : 
		 alert_msg = "아이디가 틀렸습니다.";
		 break;
		case "deluser" :
		 alert_msg = "탈퇴요청한 회원입니다.";
	   }
      if(msg[0].value != "null") alert(alert_msg);
      
      
      /*if(msg[0].value == "loginok"){
      alert_msg = "로그인 되었습니다.";
      }
      if(msg[0].value == "pwfail"){
         alert_msg = "비밀번호가 틀렸습니다.";
      }
      if(msg[0].value == "loginfail"){
         alert_msg = "아이디가 틀렸습니다.";
      }*/
      
      
     
}