<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/textM.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/textM.js"></script>
</head>
<body>
<h1>書籍情報の一覧</h1>



<select name="order">
<option class="pulldown" value="0">追加順</option>
<option class="pulldown" value="1">タイトル順</option>
<option class="pulldown" value="2">更新順</option>
</select>



<input id="sbox1"   type="text" placeholder="含むキーワード" />
<button id="sbtn1" type="button" onclick="return false">検索</button>
<button id="sbtn2" type="button" onclick="return false">戻す</button>

  <form action="TextDeleteServlet" method="post">
  <input  id="kind_num" type="hidden" value="${kind_num}">
 <%-- <input   name="like" type="hidden" value="${like}">
  <input   name="order" type="hidden" value="${order}"> --%>
  <table id="bookList" class="table table-hover">
  <thead>
  <tr><td>FAVORITE</td> <td>BOOK</td> <td>TITLE</td> <td>MODIFIED</td><td>GABAGE</td></tr>
  </thead>
  <tbody id="tbody">
  <c:forEach var="myBook" items="${myBooks}">
  <tr>
 <td><button class="favorite-btn circle_spread_btn" type="button" value="${myBook.favorite}"></button><input class="favorite-input" type="hidden"  value="${myBook.id}"></td>
 <%--  <td><c:out value="${myBook.favorite}" /></td> --%>
<td>
<input class="mbid" type="hidden" value="${myBook.id}">
<input  class="my" name="book-kind_num" type="hidden" value="${myBook.kind_num}">
<select class="s1" >
<c:forEach var="kind" items="${kinds}">
 <option class="type-drop " value="${kind.kind_num}" ><c:out value="${kind.kind_name}" /></option>
 </c:forEach>
</select>
</td>
<td><a href="TextLookServlet?id=${myBook.id}&kind_num=${kind_num}"><c:out value="${myBook.title}" /></a></td>
<td><input class="modified" type="hidden" value="${myBook.modified}"><c:out value="${myBook.modified}" /></td>
  <td class="form-check">
	<input class=" position-static" name="myBook_id" type="checkbox"  value="${myBook.id}">
	<input type="hidden"  value="${myBook.book_id}">

	</td>
   </tr>
</c:forEach>
</tbody>

</table>
<button type="button" onclick="location.href='BookMainServlet'">メインへ</button>
<button id="delete-button" type="button" > 削除する</button>
</form>








</body>
</html>