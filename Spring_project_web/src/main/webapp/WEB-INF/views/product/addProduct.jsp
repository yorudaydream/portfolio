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
		$("#addBtn").click(function(){
			alert("추가");
			
			document.addProduct.submit();
		});
	});

</script>

</head>
<body>
<%@ include file="../common/header.jsp" %>  
<div class="contentsWrap">
<h1 class="pageTitle">상품등록</h1>
        <form id="addProduct" name="addProduct" action="addProduct.do" method="post" enctype="multipart/form-data">
            <table>
              <tr>
                  <th>카테고리선택</th>
                  <td>
                       <select id="kind" name="kind" class="category">
                           <option id="food" value="food">식품</option>
                           <option id="household" value="household">생활용품</option>
                           <option id="interior" value="interior">홈인테리어</option>             
                           <option id="kitchen" value="kitchen">주방용품</option>           
                           <option id="beauty" value="beauty">뷰티</option>
                           <option id="fashion" value="fashion">패션의류/잡화</option>             
                           <option id="sports" value="sports">스포츠/레저</option>         
                           <option id="digital" value="digital">가전디지털</option>
                           <option id="books" value="books">도서/음반/DVD</option>             
                           <option id="toys" value="toys">완구/취미</option>      
                           <option id="animal" value="animal">반려동물용품</option>
                           <option id="baby" value="baby">출산/유아동</option>             
                           <option id="office" value="office">문구/오피스</option>          
                       </select>
                   </td>
              	</tr>
                    
                <tr>
                    <th>제목</th>
                    <td><input id="title" type="text" name="title" value=""></td>
                </tr>
                <tr>
                    <th>판매처</th>
                    <td><input id="seller" type="text" name="seller" value="${member.name}" readonly></td>
                </tr>
                <!-- <tr>
                    <th>원가</th>
                    <td><input id="origin_price" type="text" name="origin_price"></td>
                </tr>
                <tr>
                    <th>할인율</th>
                    <td><input id="discount"  type="text" name="discount" ></td>
                </tr> -->
                <tr>
                    <th>판매가</th>
                    <td><input id="price" type="text" name="price" placeholder="최대 99999999원" maxlength="8"></td>
                </tr>
                <tr>
                	<th>판매갯수</th>
                	<td><input type="text" id="amount" name="amount" placeholder="최대 99999999개까지" maxlength="8"></td>
                </tr>
                <tr>
                    <th>상품이미지</th>
                    <td><input id="photo" type="file" name="upload"></td>
                </tr>
                <tr>
                    <th>상품소개</th>
                    <td><textarea id="pComment"></textarea></td>
                </tr>
                <tr>
                    <td class="btnWrap" colspan="2" align="center"><input type="button" class="btn" id="addBtn" value="등록"><input class="btn" type="button" value="목록" id="listBtn" onclick="location.href='/project/product/productList'"></td>
                </tr>
            </table>
 
        </form>
</div>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>