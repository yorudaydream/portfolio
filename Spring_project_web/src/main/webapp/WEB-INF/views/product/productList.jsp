<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/style.jsp" %>

</head>

<body class="sub productListPage">
<%@ include file="../common/header.jsp" %>
    <div class="history">
        <div class="contentsWrap">
            <ul class="pageHistory">
                <a href="/project/home">
                    <li>HOME</li>
                </a>
                <li></li>
                <a href="product/productList?kind=${dto.kind}">
                    <li>${dto.kind}</li>
                </a>
            </ul>
        </div>
    </div>
    <div class="contentsWrap">
        <div class="slider" id="slider">
            <ul>
                <li class=""><a href="#img1"><img src="#" alt="sliderImg1"></a></li>
                <li class="displaynone"><a href="#img2"><img src="#" alt="sliderImg2"></a></li>
                <li class="displaynone"><a href="#img3"><img src="#" alt="sliderImg3"></a></li>
                <li class="displaynone"><a href="#img4"><img src="#" alt="sliderImg4"></a></li>
                <li class="displaynone"><a href="#img5"><img src="#" alt="sliderImg5"></a></li>
            </ul>
        </div>
        <div class="subCategoryWrap">
            <div class="categoryIcon"><a href=""><img src="" alt=""></a></div>
            <div class="categoryIcon"><a href=""><img src="" alt=""></a></div>
            <div class="categoryIcon"><a href=""><img src="" alt=""></a></div>
            <div class="categoryIcon"><a href=""><img src="" alt=""></a></div>
            <div class="categoryIcon"><a href=""><img src="" alt=""></a></div>
        </div>

       <h2 class="c_title">${dto.kind}</h2>
        <div class="productList">
            <ul class="oneLine">
				<c:forEach items="${productList}" var="item" varStatus="i">
                <li class="p_one">
                    <div class="pInfoWrap">
                    	<div class="pListThumbnail"><img class="" src="${pageContext.request.contextPath}/resources/images/product/${files[i.index].fname}" alt=""></div>
                        
                        <input type="hidden" value="${item.product_id}">
                        <div class="pTitle"><a href="./productSelectOne?num=${item.product_id}">${item.title}</a></div>
                        <div class="pPrice"><span class="price">${item.price}</span><span class="price_symbol">원</span></div>
                        <!-- <div class="arrival_info"><span class="date"></span><span class="arrival_data">도착예정</span></div> -->
                        <!--<div class="evaluation"></div>-->
                    </div>
                </li>
                </c:forEach>
            <c:if test="${i%5 eq 0}"></ul></c:if>
        </div>
    </div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>