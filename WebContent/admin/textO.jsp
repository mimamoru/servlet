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


<button type="button" onclick="location.href='BookOServlet'">共有した</button>
<c:forEach var="ourText" items="${ourBook.oBooks}">
<li><c:set var="book_id" value="${ourText.id}" /><a href="TextLookServlet?id=${book.id}"><c:out value="${ourText.title}" /></li>

  </c:forEach>

<button type="button" onclick="location.href='BookMainServlet'">メインへ</button>




</body>
</html>