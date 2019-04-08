<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/style.jsp" %>
</head>
<body>
<%@ include file="../common/header.jsp" %> 
	<div class="contentsWrap">
        <h2 class="pTitle">주문정보</h2>
        <div class="orderListWrap">
           <h4>주문할 상품</h4>
           
            <table class="orderList">
                <thead>
                    <th class="name">구입 상품명</th>
                    <th class="amount">수량</th>
                    <th class="price">가격</th>
                </thead>
                <tbody>
                    <tr class="productInfo">
                   		<input type="hidden" value="${product.product_id}" readonly>
                   		<td class="name"><img src="${pageContext.request.contextPath}/resources/images/product/${param.thumbnail}" alt="상품썸네일" style="width:90px; height:112px;"><span>${product.title}</span></td>
	                    <td class="amount">${order.amount}</td>
                        <td class="price">${product.price}</td>
                    </tr>
                    <tr class="option">
                        <td colspan="6">
                            <div class=""><img src="" alt="option"><span class="choose">[필수]color:yellow</span></div>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                	<tr>
                		<td colspan="4"><span class="f_bold fs_18">총 결제금액 : ${order.total}</span></td>
                	</tr>
                </tfoot>
            </table>
            
            <h4 class="smallTitle">주문자 정보</h4>
            <table class="memberInfo">
            	<tr>
            		<th class="mName">이름</th>
            		<td class="memberName" name="name" readonly value="">${member.name}</td> 
            		<th class="mphone">연락처</th>
                    <td class="memberPhone">${member.phone1} - ${member.phone2} - ${member.phone3}</td>
            	</tr>
            	<tr>
            		<th class="mEmail">email</th>
            		<td class="memberEmail">${member.email}</td>
            	</tr>
            </table>
            
            <h4 class="smallTitle">배송지 정보</h4>
            <table class="memberInfo">
            	<tr>
            		<th class="mName">이름</th>
            		<td class="memberName" name="name" value="">${orderman.name}</td> 
            		<th class="mphone">연락처</th>
                    <td class="memberPhone">${orderman.orderphone1} - ${orderman.orderphone2} - ${orderman.orderphone3}</td>
            	</tr>
            	<tr>
            		<th class="mAddress">주소</th>
            		<td class="memberAddress" colspan="3">
						<div class="form-group">${orderman.addr1} ${orderman.addr2} ${orderman.addr3}</div>
					</td>
            	</tr>
            </table>
            
             <h4 class="smallTitle">결제정보</h4>
             
             <div class="checkInfo">
             <c:choose> 
             	<c:when test="${orderman.use == 1}">
             		카드
             	</c:when>
             	<c:when test="${orderman.use == 2}">
             		무통장
             	</c:when>
             	<c:otherwise>
             		기타
             	</c:otherwise>
             
             </c:choose>
             </div>
             
            
            <div class="btnWrap">
                <a href="/project/"><div class="btn" id="">메인화면으로</div></a>
            </div>
        </div>
    </div>

<%@ include file="../common/footer.jsp" %> 
</body>
</html>