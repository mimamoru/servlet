<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<link rel="stylesheet" href="css/fbootstrap.css">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script src="js/script.js"></script>
</head>
<body>
<h1>書籍情報の一覧</h1>


<form action="TextMServlet" method="post">
<input class="form-control" name="name" type="text"
						placeholder="検索">
	<p>並び順<br>
<select name="order">
<option class="pulldown" value="0">作成順</option>
<option class="pulldown" value="1">タイトル順</option>
<option class="pulldown" value="2">更新順</option>

</select></p>
						</form>
<table>

 <c:forEach var="myBook" items="${myBooks}">
  <tr>
  <td><c:out value="${myBook.favorite}" /></td>
<td><select onChange="location.href='TextTypeServlet?id=${mybook.id}&num=value';">
<c:forEach var="kind" items="${kinds}">

 <option value="${kind.kind_num}"><c:out value="${kind.kind_name}" /></option>
  </c:forEach>

</select></td>
<td><a href="TextLookServlet?id=${myBook.id}"><c:out value="${myBook.title}" /></a></td>

  <td> 削除</td>
   </tr>
</c:forEach>
</table>



<button type="button" onclick="location.href='BookMainServlet'">メインへ</button>



</body>
</html>