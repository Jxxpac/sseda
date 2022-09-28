function check(id,no){
    if(id == ''){
        if(confirm("로그인 하시겠습니까?")){
            location.href="/mem/gologin";
        }   
    }else{
        if(no == "1"){
            location.href="/it/insert";
        }else if(no == "2"){
            location.href="/bo/insert";
        }else if(no == "3"){
            location.href="/qa/qnainsert";
        }
    }
}