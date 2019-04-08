<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="common/style.jsp" %>
</head>
<body id="index">
<%@ include file="common/header.jsp" %>  
<!--     <div class="slider" id="slider">
    </div> -->
    <div class="contentsWrap tAlignCenter">
        <div class="quickMenu">
            <div class="triangle quickTop"><a href="#top">NEW</a></div>
            <div class="triangle quickLeft"><a href="#left">BEST</a></div>
            <div class="triangle quickRight"><a href="product/productList.jsp">전체상품</a></div>
            <div class="triangle quickBottom"><a href="#bottom">TODAY DEAL</a></div>
        </div>
    <div class="contentsWrap tAlignCenter">
            <div class="btnOneLine">
                <a href="product/productList?kind=household" class="button">생활용품</a>
                <a href="product/productList?kind=interior" class="button">홈인테리어</a>             
                <a href="product/productList?kind=kitchen" class="button">주방용품</a>              
            </div>
            <div class="btnOneLine">
                <a href="product/productList?kind=beauty" class="button">뷰티</a>
                <a href="product/productList?kind=fashion" class="button">패션의류/잡화</a>             
                <a href="product/productList?kind=sports" class="button">스포츠/레저</a>              
            </div>
            <div class="btnOneLine">
                <a href="product/productList?kind=digital" class="button">가전디지털</a>
                <a href="product/productList?kind=books" class="button">도서/음반/DVD</a>             
                <a href="product/productList?kind=toys" class="button">완구/취미</a>              
            </div>
            <div class="btnOneLine">
                <a href="product/productList?kind=animal" class="button">반려동물용품</a>
                <a href="product/productList?kind=baby" class="button">출산/유아동</a>             
                <a href="product/productList?kind=office" class="button">문구/오피스</a>              
            </div>
        </div>
    </div>
    <%@ include file="common/footer.jsp" %>
</body>
</html>