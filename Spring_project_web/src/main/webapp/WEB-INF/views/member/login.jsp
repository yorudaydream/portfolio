<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@ include file="../common/style.jsp" %>
<style>
* {background: #333;}
</style>

<script type="text/javascript">
$(document).ready(function(){
    $("#loginBtn").click(function(){
        // 태크.val() : 태그에 입력된 값
        // 태크.val("값") : 태그의 값을 변경 
        var userId = $("#userId").val();
        var userPw = $("#userPw").val();
        if(userId == ""){
            alert("아이디를 입력하세요.");
            $("#userId").focus(); // 입력포커스 이동
            return; // 함수 종료
        }
        if(userPw == ""){
            alert("비밀번호를 입력하세요.");
            $("#userPw").focus();
            return;
        }
		// 폼 내부의 데이터를 전송할 주소
        document.loginBox.action="$/member/loginCheck.do"
        // 제출
        document.loginBox.submit();
    });
</script>
</head>
<body>
	<div class="contentsWrap tAlignCenter">
	<form action="login.do" method="post" name="loginBox">
		<div class="loginBox">
			<div class="logo">
				<img src="" alt="logo">
			</div>
			<div class="inputBox">
				<p>
					<!--<span>ID</span> -->
					<input type="text"  id="userId" class="inputId" name="id"
						placeholder="아이디입력">
				</p>
				<p>
					<!--<span>PW</span> -->
					<input type="password" id="userPw" class="inputPw" name="pw"
						placeholder="비밀번호입력">
				</p>
			</div>
			<a href="iforgot.jsp" class="forgot">아이디/비밀번호를 잊어버리셨나요?</a> <br>
			<p>
				<button id="loginBtn">LOGIN</button>
			</p>
			<p><input type="button" onclick="location.href='./join'" value="아직 회윈이 아니신가요?"></p>
			<!-- <p><button onclick="location.href='./join'">아직 회윈이 아니신가요?</button></p> -->
		</div>
		</form>
	</div>
</body>
</html>