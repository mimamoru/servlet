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

<td><c:out value="${myBook.title}" /></td>
   </tr>
</c:forEach>
</table>
<button type="button" onclick="location.href='BookPuchConfServlet'"> 共有する</button>
その後非同期でBookPushServletにbooks id ourbookid渡す
<div id="push-modal" class="modal">
		<div id="push-form">
				<h2>共有</h2>
				<form action="LoginServlet" method="post">
					<input class="form-control" name="name" type="text" placeholder="BOOK名">
					<input class="form-control" name="pass" type="password" placeholder="パスワード">
					<button id="back" class="back-btn" onclick="location.href='BookPushListServlet'">戻る</button>
					<!-- 遷移というか　hide -->
					<button id="login" class="submit-btn" onClick="location.href='BookPushServlet'">共有</button>
				</form>
			</div>
		</div>
<button type="button" onclick="location.href='BookMainServlet'">メインへ</button>


<button type="button" onclick="location.href='BookOServlet'">共有した</button>
<form action="BookOServlet" method="post">
<p>並び順<br></p>
<select name="order">
<option class="pulldown" value="0">作成順</option>
<option class="pulldown" value="1">タイトル順</option>
</select>
</form>

 <form action="BookOdelServlet" method="post">
<c:forEach var="ourBook" items="${ourBooks}">
<li><c:out value="${ourBook.id}" />:<c:out value="${ourBook.name}" /></li>
</c:forEach>
<button type="button" onclick="location.href='BookODelServlet'">共有取り消し</button>
</form>
<button type="button" onclick="location.href='BookMainServlet'">メインへ</button>




</body>
</html>