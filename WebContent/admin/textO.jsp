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
<form action="TextKeepServlet" method="post">
	<div class="form-check">
	 <c:forEach var="oBook" items="${ourBook.getOBooks()}">
	  <input class="form-check-input" type="checkbox" name="book_ids" value="${oBook.id}">
	   <input class="form-check-input" type="hidden" name="titles" value="${oBook.title}">
	   <input class="form-check-input" type="hidden" name="texts" value="${oBook.text}">
	   <input class="form-check-input" type="hidden" name="dates" value="${oBook.modified}">
	  <a href="TextOLookServlet?id=${oBook.id}"><label class="form-check-label" for="check1a">${oBook.title}</label></a><br>
	 </c:forEach>
	</div>
<button type="button" onclick="location.href='BookMainServlet'">戻る</button>
<button type="submit" onclick="location.href='TextKeepServlet'" onclick="return false;">KEEP</button>

</form>




</body>
</html>