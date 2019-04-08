<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/style.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){

		
		$("#amount").on('keyup',function(){
			var price = $("#price").text();
			var amount = parseInt($("#amount").val());
			var total = price * amount;
			$("#totalPrice").text(total); 
			
		});
		
	
		$("#order").click(function(){

			var amount_check = $("#amount").val();
			if(amount.length == 0){
				alert("구매할 갯수를 입력해주세요.");
			}else{
			$("#pInfo").attr("method","get");
			document.pInfo.action="/project/order/addOrder";
			document.pInfo.submit();
			}
		})
		
		$("#addCart").click(function(){
			var amount = $("#amount").val();
			if(amount.length == 0){
				alert("구매할 갯수를 입력해주세요.");
			}else{
			
			document.pInfo.action="/project/cart/addCart.do";
			document.pInfo.submit();
			}
		})
	});

</script>
</head>
<body class="productSelectOne">
<%@ include file="../common/header.jsp" %> 
    <div class="contentsWrap">
        <div class="productBox">
            <div class="pThumbnail fLeft">
                <img id="" src="${pageContext.request.contextPath}/resources/images/product/${photo.fname}" alt="">
            </div>
            <form action="addCart.do" id="pInfo" name="pInfo" method="post">
            <div class="pInfoBox fLeft">
                <table>
                	<input type="hidden" name="product_id" value="${dto.product_id}">
                    <tr>
                        <th colspan="2">
                            <h2 class="pTitle" name="title">${dto.title}</h2>
                        </th>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td><span class="origin_price" name="price"><span id="price">${dto.price}<%-- <fmt:formatNumber value="${dto.price}" patten="###,###,###" /> --%></span><span>원</span></span></td>
                    </tr>
<!--                     <tr>
                        <th>할인율</th>
                        <td>
                            <p class="discount">89%</p>
                        </td>
                    </tr>
                    <tr>
                        <th>판매가</th>
                        <td><span class="price">9,900</span><span>원</span></td>
                    </tr> -->
<%--                     <tr>
                       <th>배송비</th>
                       <td>${dto.shipping}</td> 
                    </tr> --%>
                    <tr>
                        <th>옵션</th>
                        <td>
                            <select>
                                <option>.</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>주문수량</th>
                        <td><input type="text" id="amount" name="amount" var="0"></td>
                    </tr>
                    <tr>
                        <th>총 구매금액</th>
                        <td><span id="totalPrice" class="totalPrice"></span>원</td>
                    </tr>
                    <input type="hidden" name="shipping" value="2500">
                </table>
                <div class="btnWrap">
                        <input type="button" id="order" class="order btn" value="주문하기">
                        <input type="button" id="addCart" class="cart btn" value="장바구니">
                        <input type="button" id="wish" class="wish btn" value="찜하기">
                </div>
                </form>
            </div>
            <!-- <h2 class="pTitle">장갑 외 겨울잡화</h2>
            <p  class="discount" >89%</p>
            <p class="price"><span class="origin_price"><span>77777</span><span>원</span><i class="del"></i></span><span class="price">9,900</span><span>원</span></p>
            <p></p>-->
            <hr>
            <div class="productContent">
                <img id="" src="${pageContext.request.contextPath}/resources/images/product/${photo.fname}" alt="">
            </div>
            <div class="commentBox">
                
            </div>
        </div>
    </div>
<%@ include file="../common/footer.jsp" %> 
</body>

</html>