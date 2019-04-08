<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
    <script>
        $(document).ready(function(){
          $("#allcheck").click{
              $( '.agree' ).prop( 'checked', this.checked );
          }
        });
    </script>
<%@ include file="../common/style.jsp" %>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="contentsWrap tAlignCenter">
  <h1 class="pTitle">회원가입 페이지</h1>
    <div class="contentsWrap">
        <h3>회원정보 입력</h3>
        <div class="selectType">
               <input type="radio" name="memberType" id="n" value="0"><label for="n">일반회원</label>
               <input type="radio" name="memberType" id="c" value="1"><label for="c">사업자회원</label>
        </div>
        <form action="/product/member/join.do" method="post">
            <table class="memberJoin">
            <c:choose>
				<c:when test="${memberType eq 0}">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="memberType" value="0"><label for="n">일반회원</label>
                        </td>
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td class="id"><input type="text" name="id"><a href="">
                                <div class="id_check">아이디 중복체크</div>
                            </a></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="password" name="pw"></td>
                    </tr>
                    <tr>
                        <th>비밀번호 확인</th>
                        <td><input type="password" name="pwCheck"></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type="text" name="email"></td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td class="phone"><input type="text" name="phone1">-<input type="text" name="phone2">-<input type="text" name="phone3"></td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>
                            <input type="text" name="address"><label for="address">기본주소</label>
                            <br>
                            <input type="text" name="address2"><label for="address2">나머지주소</label>
                        </td>
                    </tr>
                </tbody>
				</c:when>
                <c:otherwise>
                <tbody>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="memberType" value="1"><label for="c">사업자회원</label>
                        </td>
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td class="id"><input type="text" name="id"><a href="">
                                <div class="id_check">아이디 중복체크</div>
                            </a></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="password" name="pw"></td>
                    </tr>
                    <tr>
                        <th>비밀번호 확인</th>
                        <td><input type="password" name="pwCheck"></td>
                    </tr>
                    <tr>
                        <th>사업자 등록번호</th>
                        <td><input type="text" name="companyNumber"></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type="text" name="email"></td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td class="phone"><input type="text" name="phone1">-<input type="text" name="phone2">-<input type="text" name="phone3"></td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>
                            <input type="text" name="address"><label for="address">기본주소</label>
                            <br>
                            <input type="text" name="address2"><label for="address2">나머지주소</label>
                        </td>
                    </tr>
                </tbody>
                </c:otherwise>
                </c:choose>
                <tfoot>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" id="btnJoin" value="가입하기"><input type="reset" value="다시작성"></td>
                    </tr>
                </tfoot>
            </table>
            <div class="agreement">
                <h3>회원약관 동의</h3>
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

</body>
</html>