<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link rel="stylesheet" type="text/css" href="css/textM.css">
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/textM.js"></script>
</head>
<body>
<h1>書籍情報の一覧</h1>


<form action="TextMServlet" method="post">
<input class="form-control" name="name" type="text" placeholder="検索">
<select name="order">
<option class="pulldown" value="0">作成順</option>
<option class="pulldown" value="1">タイトル順</option>
<option class="pulldown" value="2">更新順</option>
</select>
</form>

  <form action="TextDeleteServlet" method="post">
  <input  name="kind_num" type="hidden" value="${kind_num}">
 <input   name="like" type="hidden" value="${like}">
  <input   name="order" type="hidden" value="${order}">
  <table>
  <tr><td>FAVORITE</td> <td>BOOK</td> <td>TITLE</td> <td>GABAGE</td></tr>
  <c:forEach var="myBook" items="${myBooks}">

  <tr>
 <td><button class="favorite-btn" type="button" value="${myBook.favorite}">favorite</button><input class="favorite-input" type="hidden"  value="${myBook.id}"></td>
 <%--  <td><c:out value="${myBook.favorite}" /></td> --%>
<td>
<input  class="my" name="book-kind_num" type="hidden" value="${myBook.kind_num}">
<select class="s1" onChange="location.href='TextTypeServlet?id=${mybook.id}&num=value';">
<c:forEach var="kind" items="${kinds}">
 <option class="type-drop" value="${kind.kind_num}" ><c:out value="${kind.kind_name}" /></option>
 </c:forEach>
</select>
</td>
<td><a href="TextLookServlet?id=${myBook.id}"><c:out value="${myBook.title}" /></a></td>

  <td class="form-check">
	<input class="form-check-input" name="myBook_id" type="checkbox"  value="${myBook.id}">
	<input class="form-check-input position-static" type="hidden"  value="${myBook.book_id}">

	</td>
   </tr>
</c:forEach>


</table>
<button type="button" onclick="location.href='BookMainServlet'">メインへ</button>
<button id="delete-button" type="button" > 削除する</button>
</form>








</body>
</html>