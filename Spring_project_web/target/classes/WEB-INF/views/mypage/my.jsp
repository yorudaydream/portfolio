<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@ include file="../common/style.jsp" %>
</head>
<body>
<%@ include file="../common/header.jsp" %>  
	<div class="contentsWrap">
        <h1 class="pTitle">MYPAGE</h1>
        <div class="myInfoWrap">
            <div class="myInfo tAlignLeft">
                <p><span class="myname">${member.name}</span>[<span class="myId">${member.id}</span>]님</p>
                <p class="myphone">${member.phone}</p>
                <p class="myemail">${member.email}</p>
                <p class="myaddress">${member.address}</p>
            </div>
            <div clas="membershipWrap">
                <div class="membership"><p>${member.name}님의 현재등급은</p> <p>${memeber.grade}등급입니다.</p></div>
                <!-- <a href="#"> -->
                <div class="membershipInfo">
                    <p class="">등급별 혜택 안내</p>
                </div>
                <!-- </a> -->
            </div>
            
        </div>
            <div class="linkBoxWrap tAlignCenter">
                <a href="/project/mypage/myInfo"><div class="linkBox">회원정보수정</div></a>
                <a href="/project/mypage/myOrderList"><div class="linkBox">주문내역/배송조회</div></a>
                <a href="/project/mypage/wishList"><div class="linkBox">위시리스트</div></a>
                <a href="/project/member/delete"><div class="linkBox">회원탈퇴</div></a>      
                <c:if test="${member.grade == 1}">
                	<a href="/project/mypage/myProductList"><div class="linkBox">등록상품리스트</div></a>
                	<a href="/project/product/addProduct"><div class="linkBox">상품등록</div></a>
                </c:if>            
            </div>
    </div>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>