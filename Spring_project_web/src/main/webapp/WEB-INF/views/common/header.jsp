<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
	<header id="header">
		<div class="top">
			<div class="contentsWrap">
				<!--el choose하고 when으로 조건줘서 로그인햇으면 Member 비로그인은 noMem보이게-->
				<c:choose>
					<c:when test="${member ne null}">
						<ul class="Member">
							<li class=""><a href="/project/member/logOut">로그아웃</a></li>
							<li class=""><a href="/project/mypage/my">마이페이지</a></li>
							<li class=""><a href="/project/cart/cartList">장바구니</a></li>
							<li class=""><a href="/project/mypage/myOrderList">내주문</a></li>
						</ul>

					</c:when>
					<c:otherwise>
						<ul class="noMem">
							<li class=""><a href="/project/member/login">로그인</a></li>
							<li class=""><a href="/project/member/join">회원가입</a></li>
							<li class=""><a href="/project/cart/cartList">장바구니</a></li>
						</ul>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
		<div class="headerMenu">
			<div class="contentsWrap">
				<div class="logoBox">
					<a href="/project"><img src="../images/logo.jpg" alt="logo"></a>
				</div>
				<ul class="category">
					<li class=""><a href="/project/product/productList?kind=''">NEW</a></li>
					<li class=""><a href="/project/product/productList">BEST</a></li>
					<li class=""><a href="/project/product/productList">리빙</a></li>
					<li class=""><a href="/project/product/productList">가전</a></li>
					<li class=""><a href="/project/product/productList">식품</a></li>
					<li class=""><a href="/project/product/productList">사업자전용</a></li>
				</ul>
			</div>
		</div>

	</header>