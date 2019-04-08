<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/project/resources/js/addressapi.js"></script>
<%@ include file="../common/style.jsp" %>
    <script>
        $(document).ready(function(){
          $("#allcheck").click(function(){
              $( '.agree' ).prop( 'checked', this.checked );
          });
          
       	  var idck = 0;
       	  
		/* 아이디 중복체크 */
          $("#id_check").click(function() {
             //userid 를 param.
               var userid =  $("#userId").val();
             	if(userid == 0){
             		alert("아이디를 입력해주세요");
             	}
               
               $.ajax({
                   async: true,
                   type : 'POST',
                   data : userid,
                   url : "idcheck.do",
                   dataType : "json",
                   contentType: "application/json; charset=UTF-8",
                   success : function(data) {
                       if (data.check > 0) {
                     	  $("#existId").html("아이디가 존재합니다. 다른 아이디를 사용해주세요.");
                           //아이디가 존제할 경우 빨강으로 , 아니면 파랑으로 
                           $("#existId").addClass("has-error")
                           $("#existId").removeClass("has-success")
                           $("#userid").focus();
                       } else {
                     	  $("#existId").html("사용가능한 아이디입니다.");
                           $("#existId").addClass("has-success")
                           $("#existId").removeClass("has-error")
                           $("#userpwd").focus();
                           //아이디가 중복하지 않으면  idck = 1 
                           idck = 1;
                           
                       }
                   },
                   error : function(error) {
                       alert("error : " + error);
                   }
               });
             }); 
       	  
          $("#btnJoin").click(function(){  
        	          		    
        		    var userId = $("#userId").val();
        		    var userpw = $("#userPw").val();
        		    var userPwChk = $("#userPwChk").val();
        		    var userName = $("#userName").val();
        		    var email = $("#email").val();
        		    var addr1 = $("#addr1").val();
        		    var addr2 = $("#addr2").val();
        		    var addr3 = $("#addr3").val();
        		     
        		    if(userId.length == 0){
        		        alert("아이디를 입력해 주세요"); 
        		        $("#userId").focus();
        		        return false;
        		    }
        		    
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
        		    } 
        		    
	              if($("#use_agree").is(":checked") == false){
	                  alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다.");
	                  return;
	              }else if($("#privacy_agree").is(":checked") == false){
	                  alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다.");
	                  return;
	              }else if(confirm("회원가입을 하시겠습니까?")){
	            	    if(idck==0){
	            	        alert('아이디 중복체크를 해주세요');
	            	        return false;
	            	    }else {
	            	   /*var f = document.joinfrm; 
	          		   f.phone.value = f.phone1.value+ "-" + f.phone2.value + "-" + f.phone3.value; 
	          		  f.address.value = f.addr1.value + "-" + f.addr2.value + "-" + f.addr3.value;  */
	          		  alert("회원가입 되었습니다. 환영합니다");
	                  $("#joinfrm").submit();
	              }
	              }
	          });  

		  $("#userId").keyup(function(event){
        	  if (!(event.keyCode >=37 && event.keyCode<=40)) {
                  var inputVal = $(this).val();
                  $(this).val(inputVal.replace(/[^a-z0-9]/gi,''));    
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
        <form id="joinfrm" name="joinfrm" action="join.do" method="post">
            <table class="memberJoin">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <input type="radio" name="grade" id="n" value="0"><label for="n">일반회원</label>
                            <input type="radio" name="grade" id="c" value="1"><label for="c">사업자회원</label>
                        </td>
                    </tr>
                    <tr>
                        <th>아이디*</th>
                        <td class="id"><input type="text" id="userId" name="id">
	                        <input type="button" id="id_check" class="id_check" value="아이디 중복체크"/>
	                        <p id="existId"></p>
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
                        <td><input type="text" name="name" id="userName" class="userName"></td>
                    </tr>
                    <tr>
                        <th>이메일*</th>
                        <td><input type="text" name="email" id="email"></td>
                    </tr>
                    <tr>
                        <th>연락처*</th>
                        <td class="phone"><input type="text" name="phone1" maxlength="4">-<input type="text" name="phone2" maxlength="4">-<input type="text" name="phone3" maxlength="4"></td>
                    	<!-- <input type="hidden" name="phone"> -->
                    </tr>
                    <tr>
                        <th>주소*</th>
                        <td>    
                        	<!-- <input type="hidden" name="address">  -->    
							<div class="form-group">         
							<input class="form-control" style="width: 40%; display: inline;" placeholder="우편번호" name="addr1" id="addr1" type="text" readonly="readonly" >
							    <button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
							</div>
							<div class="form-group">
							    <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="addr2" id="addr2" type="text" readonly="readonly" />
							</div>
							<div class="form-group">
							    <input class="form-control" placeholder="상세주소" name="addr3" id="addr3" type="text"  />
							</div>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2" align="center"><input type="button" id="btnJoin" value="가입하기"><input type="reset" value="다시작성"></td>
                    </tr>
                </tfoot>
            </table>
            <div class="agreement">
                <h3>회원약관 동의*</h3>
                <div class="agreeBox">
                    <div class="allcheck">
                        <label><input type="checkbox" id="allcheck" name="allcheck" value="all">전체동의</label>
                    </div>
                    <div class="selectAgree">
                        <ul class="">
                            <li class=""><label><input type="checkbox" class="agree" id="use_agree" name="use_agree" value="u">이용약관</label></li>
                            <li class=""><label><input type="checkbox" class="agree" id="privacy_agree" name="privacy_agree" value="p">개인정보수집 및 이용안내</label></li>
                        
                        </ul>
                    </div>
                </div>
            </div>

        </form>
    </div>
    </div>
<%@ include file="../common/footer.jsp" %>

</body>
</html>