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
        <h1 class="pTitle">ORDER <span class="f_gray">LIST</span></h1>
        <p>회원님의 주문 내역입니다</p>
        <div class="tAlignCenter">
        <table class="orderTable">
            <thead>
                <tr>
                    <th class="num">번호</th>
                    <th class="orderNum">주문번호</th>
                    <th class="name">상품명</th>
                    <th class="reg_date">주문일자</th>
                    <th class="price">결제금액</th>
                    <th class="shippingNum">배송추적</th>
                    <th class="step">주문현황</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${orderList}">
                    <tr>
                        <td class="num">1</td>
                        <td class="orderNum">20190128-111111</td>
                        <td class="name">포켓몬스터 외 1건</td>
                        <td class="reg_date">2019-01-28</td>
                        <td class="price">100,000</td>
                        <td class="shippingNum">21212122</td>
                        <td class="step">발송완료</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		
        <div class="list_remocon">
            <c:if test="${pager.curBlock>1}">
                <a href="./$orderList?curPage=${pager.startNum-1}" class="f_btn">[이전]</a>
            </c:if>
            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                	<a href="./$orderList?curPage=${i}">${i}</a>	
            </c:forEach>
            <c:if test="${pager.curBlock<pager.totalBlock}">
                <a href="./$orderList?curPage=${pager.lastNum+1}" class="b_btn">[다음]</a>
            </c:if>
        </div>
        </div>
    </div>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>