<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/style.jsp" %>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/project/resources/js/addressapi.js"></script>
<script type="text/javascript">

$(document).ready(function(){
			var price = $("#price").text()*1;
			var amount = $("#amount").text()*1;
			var shipping = $("#shippingprice").text()*1;
			var total = price*amount+shipping;
			$("#ordertotalPrice").text(total); 
			$("#ordertotal").val(total); 
			
			$("#orderBtn").click(function(){
				var addr1 = $("#addr1").val();
     		    var addr2 = $("#addr2").val();
     		    var addr3 = $("#addr3").val();
				var phone1 = $("#phone1").val();
     		    var phone2 = $("#phone2").val();
     		    var phone3 = $("#phone3").val();
     		    
     		   if(addr1.length == 0 || addr2.length == 0 || addr3.length == 0 ){
   		        alert("주소를 입력해주세요");
   		        $("#addr3").focus();
   		        return false;
   		    	} 
     		   
     		   if(phone1.length == 0 || phone2.length == 0 || phone3.length == 0 ){
     		        alert("연락처를 입력해주세요");
     		        $("#phone3").focus();
     		        return false;
     		    	} 
     		   
     		  if(phone1.length == 0 || phone2.length == 0 || phone3.length == 0 ){
   		        alert("연락처를 입력해주세요");
   		        $("#phone3").focus();
   		        return false;
   		    	} 
   		   
     		   
     		   
     		   document.orderfrm.action = "/project/order/addOrder.do";
     		   document.orderfrm.submit();
			})
			
		});

</script>
		
</head>
<%@ include file="../common/header.jsp" %> 
<body id="order">
    <div class="contentsWrap">
    <form action="addOrder.do" id="orderfrm" name="orderfrm" method="post">
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
                   		<input type="hidden" name="product_id" value="${order.product_id}">
                        <td class="name"><a href="/project/product/productSelectOne?num=${order.product_id}"><img src="${pageContext.request.contextPath}/resources/images/product/${photo.fname}" alt="상품썸네일" style="width:90px; height:112px;"><span>${order.title}</span></a></td>
                        <input type="hidden" name="title" value="${order.title}">
                        <input type="hidden" name="thumbnail" value="${photo.fname}">
	                   	<td id="amount" class="amount">${amount}</td>
	                   	<input type="hidden" name="amount" value="${amount}">
                        <td id="price" class="price">${order.price}</td>
	                   	<input type="hidden" name="price" value="${order.price}">
                        <td id="shippingprice" class="shippingprice">${shipping}</td>
                    </tr>
                    <tr class="option">
                        <td colspan="6">
                            <div class=""><img src="" alt="option"><span class="choose">[필수]color:yellow</span></div>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                	<tr>
                		<td colspan="4"><span class="f_bold fs_18">총 결제금액 : <span id="ordertotalPrice" name="total"></span></span></td>
	                   	<input type="hidden" id="ordertotal" name="total" value="">
	                   	
                	</tr>
                </tfoot>
            </table>
            
            <h4 class="smallTitle">주문자 정보</h4>
            <table class="memberInfo">
            	<tr>
            		<th class="mName">이름</th>
            		<td class="memberName" name="name" readonly value="">${member.name}</td> 
            		<th class="mphone">연락처</th>
                    <td class="memberPhone"><input type="text" id="phone1" name="phone1" maxlength="4" value="${member.phone1}">-<input type="text" id="phone2" name="phone2" maxlength="4" value="${member.phone2}">-<input type="text" id="phone3" name="phone3" maxlength="4" value="${member.phone3}"></td>
            	</tr>
            	<tr>
            		<th class="mEmail">email</th>
            		<td class="memberEmail"><input type="text" value="${member.email}" name="email"></td>
            	</tr>
            </table>
            
            <h4 class="smallTitle">배송지 정보</h4>
            <table class="arrivalInfo">
            	<tr>
            		<th class="mName">이름</th>
            		<td class="memberName" name="name" value=""><input type="text" value="${member.name}" name="name"></td> 
            		<th class="mphone">연락처</th>
                    <td class="memberPhone"><input type="text" id="orderphone1" name="orderphone1" maxlength="4" value="${member.phone1}">-<input type="text"  id="orderphone2" name="orderphone2" maxlength="4" value="${member.phone2}">-<input type="text"  id="orderphone3" name="orderphone3" maxlength="4" value="${member.phone3}"></td>
            	</tr>
            	<tr>
            		<th class="mAddress">주소</th>
            		<td class="memberAddress" colspan="3">
							<div class="form-group"><input class="form-control" style="width: 40%; display: inline;" value="${member.addr1}" placeholder="우편번호" name="addr1" id="addr1" type="text" readonly="readonly" >
							    <button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
							</div>
							<div class="form-group">
							    <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="addr2" id="addr2" type="text"  value="${member.addr2}"readonly="readonly" />
							</div>
							<div class="form-group">
							    <input class="form-control" placeholder="상세주소" name="addr3" id="addr3"  value="${member.addr3}"type="text"  />
							</div></td>
            	</tr>
            </table>
            
            <h4 class="smallTitle">결제정보</h4>
            <table class="checkInfo">
            	<tr>
            		<td>
            		<input type="radio" id="check1" name="use" class="" value="1"><label for="check1">카드</label>
            		<input type="radio" id="check2" name="use" class="" value="2"><label for="check2">무통장</label>
            		<input type="radio" id="check3" name="use" class="" value="3"><label for="check3">기타</label>
            		</td>
            	</tr>
            </table>
            
            <div class="btnWrap">
            	<input type="button" class="orderBtn continue" id="orderBtn" value="주문하기">
                <a href="#"><div class="clear" id="clear">주문취소</div></a>
            </div>
        </div>
    </form>
    </div>
</body>
</html>