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
<ul>


<c:forEach var="myBook" items="${myBooks}">
<li><c:out value="${myBook.id}" />:<c:out value="${myBook.title}" /></li>

  </c:forEach>


</ul>

<button type="button" onclick="location.href='BookOServlet'">共有した</button>
<c:forEach var="ourBook" items="${ourBooks}">
<li><c:out value="${ourBook.id}" />:<c:out value="${ourBook.name}" /></li>

  </c:forEach>
  <form action="/TextRegister/BookPushServlet" method="post">
		<button type="button" onclick="location.href='BookODelServlet'">共有取り消し</button>
				</form>


<button type="button" onclick="location.href='BookPushListServlet'">mybook</button>
<c:forEach var="myBook" items="${myBooks}">
<li><c:out value="${myBook.id}" />:<c:out value="${myBook.title}" /></li>

  </c:forEach>
<form action="/TextRegister/BookPushServlet" method="post">
		<button type="button" onclick="location.href='BookPushConfServlet'">共有する</button>
				</form>



<div id="push-modal" class="modal">
		<div id="push-form">
				<h2>共有</h2>
				<form action="/TextRegister/LoginServlet" method="post">
					<input class="form-control" name="name" type="text" placeholder="BOOK名">
						 <input class="form-control" name="pass" type="password" placeholder="パスワード">
					<button id="back" class="back-btn" onclick="location.href='BookPushListServlet'">戻る</button>
					<button id="login" class="submit-btn" onClick="location.href='BookPushServlet'">共有</button>
				</form>
			</div>
		</div>
</body>
</html>