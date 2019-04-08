<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/style.jsp" %>

</head>
<%@ include file="../common/header.jsp" %> 
<body id="order">
    <form action="order.do" id="orderfrm" name="orderfrm">
        <h2 class="pTitle">주문정보</h2>
        <div class="orderListWrap">
           <h4>주문할 상품</h4>
            <table class="orderList">
                <thead>
                    <th class="name">구입 상품명</th>
                    <th class="amount">수량</th>
                    <th class="price">가격</th>
                    <th class="shippingprice">배송비</th>
                </thead>
                <tbody>
                    <tr class="productInfo">
                   		<input type="hidden" value="${order.product_id}">
                        <a href="#"><td class="name"><div class="productPhoto"><img src="" alt=""></div><span>${order.title}</span></td></a>
	                   <td class="amount">${cart.amount}</td>
                        <td class="price">${order.price}</td>
                        <td class="shippingprice">2500</td>
                    </tr>
                    <tr class="option">
                        <td colspan="6">
                            <div class=""><img src="" alt="option"><span class="choose">[필수]color:yellow</span></div>
                        </td>
                    </tr>
                </tbody>
            </table>
            
            <div class="btnWrap">
                <a href="/project/order/orderList"><div class="orderBtn" id="orderBtn">주문하기</div></a>
                <a href="#"><div class="clear" id="clear">주문취소</div></a>
            </div>
        </div>
    </form>
</body>
</html>