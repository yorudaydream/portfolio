<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="contentsWrap">
<h1 class="pageTitle">상품정보수정</h1>
        <form action="updateProduct.do" method="post" enctype="multipart/form-data">
            <table>
              <tr>
                  <th>카테고리선택</th>
                  <td>
                       <select id="kind" name="kind" class="category">
                           <option id="food">식품</option>
                           <option id="household">생활용품</option>
                           <option id="interior">홈인테리어</option>             
                           <option id="kitchen">주방용품</option>           
                           <option id="beauty">뷰티</option>
                           <option id="fashion">패션의류/잡화</option>             
                           <option id="sports">스포츠/레저</option>         
                           <option id="digital">가전디지털</option>
                           <option id="books">도서/음반/DVD</option>             
                           <option id="toys">완구/취미</option>      
                           <option id="animal">반려동물용품</option>
                           <option id="baby">출산/유아동</option>             
                           <option id="office">문구/오피스</option>          
                       </select>
                   </td>
              </tr>
                <tr>
                    <th>제목</th>
                    <td><input id="title" name="" type="text" name="title"></td>
                </tr>
                <tr>
                    <th>판매처</th>
                    <td><input id="seller" name="" type="text" name="seller"></td>
                </tr>
                <tr>
                    <th>원가</th>
                    <td><input id="origin_price" name="" type="text" name="origin_price"></td>
                </tr>
                <tr>
                    <th>할인율</th>
                    <td><input id="discount" name="" type="text" name="discount" ></td>
                </tr>
                <tr>
                    <th>판매가</th>
                    <td><input id="price" name="" type="text" name="price" ></td>
                </tr>
                <tr>
                    <th>상품이미지</th>
                    <td><input id="photo" name="" type="file" name="photo"></td>
                </tr>
                <tr>
                    <th>상품소개</th>
                    <td><textarea id="pComment"></textarea></td>
                </tr>
 
                <tr>
                    <td class="btnWrap" colspan="2" align="center"><input id="" name="" type="submit" class="btn" id="addBtn" value="등록"><input class="btn" type="button" value="목록" id="listBtn"><input class="btn fRight" type="button" value="삭제" id="delete"></td>
                </tr>
            </table>
 
        </form>
</div>
</body>
</html>