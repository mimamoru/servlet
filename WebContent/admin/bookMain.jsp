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
<td>

<c:set var="kind_num" value="${kind.kind_num}" /><a href="TextMServlet?kind_num=${kind_num}"><c:out value="${kind.kind_name}" /></a>
</td>

  </c:forEach>
   </tr>

</table>
<button type="button" onclick="location.href='TextCreateServlet'">作成</button>


<button type="button" onclick="location.href='TextCreateServlet'">共有</button>

<div id="push-modal" class="modal">
	<div id="push-form">
		<h2>共有</h2>
				<form action="/BookSerchServlet" method="post">
					<input class="form-control" name="name" type="text"
						placeholder="BOOK名">
				<input class="form-control"
						name="pass" type="password" placeholder="パスワード">
					<button id="login" class="submit-btn" onClick="return false">決定</button>
				</form>
			</div>
		</div>



<button type="button" onclick="location.href='BookPushListServlet'">共有する</button>
<button type="button" onclick="location.href='/TextRegister'">ログアウト</button>



</body>
</html>