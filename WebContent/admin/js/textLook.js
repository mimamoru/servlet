<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>

</head>
<body>
<h1>書籍情報の一覧</h1>

<%-- <p class="favorite"  >${myBook.favorite}</p>
<p class="kind"  >${myBook.kind_num}</p>

<p class="title"  >${myBook.title}</p> --%>

<table>


  <tr>
  <td><c:out value="${myBook.favorite}" /></td>
<td><select onChange="location.href='TextTypeServlet?id=${mybook.id}&knum=value';">
<c:forEach var="kind" items="${kinds}">

 <option value="${kind.kind_num}"><c:out value="${kind.kind_name}" /></option>
  </c:forEach>

</select></td>
<td>${myBook.title}</td>

  <td> 削除</td>
   </tr>

</table>



<p class="text" >${myBook.text}</p>


<button type="button" onclick="location.href='TextEditServlet?id=${myBook.book_id}'">編集</button>

<button type="button" onclick="location.href='BookMainServlet'">戻る</button>



</body>
</html>