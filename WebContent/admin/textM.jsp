<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
</head>
<body>
<h1>書籍情報の一覧</h1>
<table>

<tr>
<c:forEach var="kind" items="${kinds}">
<td><c:out value="${kind.kind_name}" /></td>

  </c:forEach>
   </tr>

</table>

<form action="BookMListServlet" method="post">
<input class="form-control" name="name" type="text"
						placeholder="検索"></form>
<table>

 <c:forEach var="myBook" items="${myBooks}">
  <tr>
  <td><c:out value="${myBook.favorite}" /></td>
   <td><c:out value="${myBook.kind_num}" /></td>

<td><a href="TextLookServlet?id=${myBook.id}"><c:out value="${myBook.title}" /></a></td>

  <td> 削除</td>
   </tr>
</c:forEach>
</table>



<button type="button" onclick="location.href='BookMainServlet'">メインへ</button>



</body>
</html>