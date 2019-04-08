<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/style.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#orderBtn").click(function(){
		   
		   document.cartfrm.action = "/project/order/addOrder.do";
		   document.cartfrm.submit();
	})
	
});
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>  
    <div class="contentsWrap">
        <h1 class="pTitle">장바구니</h1>
        
        <div class="cartListWrap">
        <form action="addOrder.do" id="cartfrm" name="cartfrm" method="post">
            <table class="cartList">
                <thead>
                    <th class="num">번호</th>
                    <th class="name">제품명</th>
                    <th class="amount">수량</th>
                    <th class="price">가격</th>
                    <th class="shippingprice">배송비</th>
                    <th class="cancle">취소</th>
                </thead>
                <tbody>
                	<c:forEach items="${productList}" var="pInfo" varStatus="i">
                    <tr class="productInfo">
                        <td class="num">1</td>
                        <input type="hidden" name="product_id" var="${pInfo.product_id}">
                        <a href="#"><td class="name"><div class="productPhoto"><img src="${pageContext.request.contextPath}/resources/images/product/${photo.fname}" alt=""></div><span>구데타마</span></td></a>
	                   <td class="amount">${pInfo.amount}<br><button id="mod">수정</button></td>
                        <td class="price">${pInfo.price}</td>
                        <td class="shippingprice" name="shipping">2500</td>
                        <td class="cancle"><button id="go_wish">관심상품</button><br><button id="del">삭제</button></td>
                    </tr>
                    <tr class="option">
                        <td colspan="6">
                            <div class=""><img src="" alt="option"><span class="choose">[필수]color:yellow</span></div>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            <div class="btnWrap">
                <div class="orderBtn" id="orderBtn">주문하기</div>
                <a href="/project/home"><div class="continue" id="continue">계속쇼핑하기</div></a>
                <a href="#"><div class="clear" id="clear">장바구니비우기</div></a>
            </div>
        </form>
        </div>
    </div>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>