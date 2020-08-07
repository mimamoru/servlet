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
<table>

<tr>
<c:forEach var="kind" items="${kinds}">
<td>

<c:set var="kind_num" value="${kind.kind_num}" /><a href="TextMServlet?kind_num=${kind_num}"><c:out value="${kind.kind_name}" /></a>
</td>

  </c:forEach>
   </tr>

</table>
<button type="button" onclick="location.href='TextCreateServlet'">作成</button>
<button type="button" onclick="return false;">共有</button>


<div id="push-modal" class="modal">
	<div id="push-form">
		<h2>共有</h2>
				<form action="BookSerchServlet" method="post">
					<input class="form-control" name="name" type="text"
						placeholder="BOOK名">
				<input class="form-control"
						name="pass" type="password" placeholder="パスワード">
					<button id="push-submit" class="submit-btn" onClick="location.href='BookSerchServlet'">決定</button>
				</form>
			</div>
		</div>

<div id="olist-modal" class="modal">
	<div id="push-form">
		<h2>共有</h2>
				<form action="BookSerchServlet" method="post">
					<c:forEach var="ourText" items="${ourBook.oBooks}">
<li><c:set var="book_id" value="${ourText.id}"/><a href="TextOLookServlet?id=${book.id}"><c:out value="${ourText.title}" /></a></li>

  </c:forEach>

<button type="button" onclick="location.href='TextKeetServlet'">キープする</button>
				</form>
			</div>
		</div>



<button type="button" onclick="location.href='BookPushListServlet'">共有する</button>
<button type="button" onclick="location.href='LogoutServlet'">ログアウト</button>



</body>
</html>