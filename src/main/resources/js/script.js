/**
 * 작성자 : 박준수 
 * 내용 : 로그인 폼 체크
 */

/* const id = document.getElementById('id')
const password = document.getElementById('password')
const login = document.getElementById('login')
let errStack = 0;

login.addEventListener('click', () => {
    if (id.value == 'acid') {
        if (password.value == '0000') {
            alert('로그인 되었습니다!')
        }
        else {
            alert('아이디와 비밀번호를 다시 한 번 확인해주세요!')
            errStack ++;
        }
    }
    else {
        alert('존재하지 않는 계정입니다.')
    }

    if (errStack >= 5) {
        alert('비밀번호를 5회 이상 틀리셨습니다. 비밀번호 찾기를 권장드립니다.')
    }
}) */

    var Target = document.getElementById("clock");
        var Target_apm = document.getElementById("apm");
        function clock() {
            var time = new Date();
            var hours = time.getHours();
            var minutes = time.getMinutes();
            var seconds = time.getSeconds();
            var AmPm ="AM";
            if(hours > 12){   
                var AmPm ="PM";
                hours %= 12;
            }

            Target.innerText = 
            `${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes}` : minutes}:${seconds < 10 ? `0${seconds}` : seconds}`;

            Target_apm.innerText = `${AmPm}`;

        }
        clock();
        setInterval(clock, 1000); // 1초마다 실행