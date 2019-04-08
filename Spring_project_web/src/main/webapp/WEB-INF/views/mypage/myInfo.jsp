<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/project/resources/js/addressapi.js"></script>
<%@ include file="../common/style.jsp" %>
<title>Insert title here</title><script>
        $(document).ready(function(){
          $("#memberUpdate").click(function(){  
        	          		    
        		    var userId = $("#userId").val();
        		    var userpw = $("#userPw").val();
        		    var userPwChk = $("#userPwChk").val();
        		    var userName = $("#userName").val();
        		    var email = $("#email").val();
        		    var addr1 = $("#addr1").val();
        		    var addr2 = $("#addr2").val();
        		    var addr3 = $("#addr3").val();
        		    
        		    if(userpw.length == 0){
        		        alert("비밀번호를 입력해 주세요"); 
        		        $("#userPw").focus();
        		        return false;
        		    }
        		 
        		    if(userpw != userPwChk){
        		        alert("비밀번호가 서로 다릅니다. 비밀번호를 확인해 주세요."); 
        		        $("#userPwChk").focus();
        		        return false; 
        		    }
        		 
        		    if(userName.length == 0){
        		        alert("이름을 입력해주세요");
        		        $("#userName").focus();
        		        return false;
        		    }
        		    
        		    if(email.length == 0){
        		        alert("이메일을 입력해주세요");
        		        $("#email").focus();
        		        return false;
        		    }
        		    
        		    if(addr1.length == 0 || addr2.length == 0 || addr3.length == 0 ){
        		        alert("주소를 입력해주세요");
        		        $("#addr3").focus();
        		        return false;
	              }else {
	            	  /* var f = document.myUpdatefrm; 
	          		  f.phone.value = f.phone1.value + f.phone2.value + f.phone3.value; 
	          		  f.address.value = f.addr1.value + f.addr2.value + f.addr3.value;  */
	          		  
	          		  alert("회원정보수정 성공");
	                  /* document.myUpdatefrm.action="/project/mypage/myInfo.do"; */
	                  document.myUpdatefrm.submit();
	              }
	          });  

          
          $(".userName").keyup(function(event){
            	if(!(event.keyCode >=37 && event.keyCode<=40)){
            		var regKorean =  /^[ㄱ-ㅎ가-힣]+$/;
            		var regEng = /^[A-za-z]/g;
            		var inputVal = $(this).val();
            		if (!regEng.test(inputVal) && !regKorean.test(inputVal)){
            			alert("이름에는 숫자나 특수문자가 들어갈 수 없습니다.")
            			return;
            		}
            	} 
            });
          

        });
    </script>

</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="contentsWrap tAlignCenter">
  <h1 class="pTitle">회원가입 페이지</h1>
    <div class="contentsWrap">
        <h3>회원정보 입력</h3>
        <p>*표시는 필수 입력 칸입니다.</p>
        <form id="myUpdate" name="myUpdatefrm" action="myInfo.do" method="post">
            <table class="memberJoin">
                <tbody>
                    <tr>
                        <th>아이디*</th>
                        <td class="id"><input type="text" id="userId" name="id" value="${member.id}" readonly>
                        </td>
                    </tr>
                    <tr>
                        <th>비밀번호*</th>
                        <td><input type="password" id="userPw" name="pw"></td>
                    </tr>
                    <tr>
                        <th>비밀번호 확인*</th>
                        <td><input type="password" id="userPwChk"name="pwCheck"></td>
                    </tr>
                    <tr>
                        <th>이름*</th>
                        <td><input type="text" name="name" id="userName" class="userName" value="${member.name}" readonly></td>
                    </tr>
                    <tr>
                        <th>이메일*</th>
                        <td><input type="text" name="email" id="email" value="${member.email}"></td>
                    </tr>
                    <tr>
                        <th>연락처*</th>
                        <td class="phone"><input type="text" name="phone1" maxlength="4" value="${member.phone1}">-<input type="text" name="phone2" maxlength="4" value="${member.phone2}">-<input type="text" name="phone3" maxlength="4" value="${member.phone3}"></td>
                    	<!-- <input type="hidden" name="phone"> -->
                    </tr>
                    <tr>
                        <th>주소*</th>
                        <td>    
                        	<!-- <input type="hidden" name="address">   -->            
							<input class="form-control" style="width: 40%; display: inline;" placeholder="우편번호" name="addr1" id="addr1" value="${member.addr1}" type="text" readonly="readonly" >
							    <button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
							</div>
							<div class="form-group">
							    <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="addr2" id="addr2" type="text"  readonly="readonly" value="${member.addr2}" />
							</div>
							<div class="form-group">
							    <input class="form-control" placeholder="상세주소" name="addr3" id="addr3"  value="${member.addr3}" type="text"  />
							</div>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2" align="center"><input type="button" id="memberUpdate" value="회원정보수정"><input type="reset" value="다시작성"></td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
    </div>

</body>
</html>