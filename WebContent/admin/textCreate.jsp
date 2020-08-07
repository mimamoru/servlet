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





<form action="/BookSerchServlet" method="post">
					<input class="title" name="name" type="text"
						placeholder="タイトル">
<input class="text" name="name" type="text"
						placeholder="テキスト">

				<button type="button" onclick="location.href='TextCreateServlet'">保存</button>
				</form>

<button type="button" onclick="location.href='BookMainServlet'">戻る</button>



</body>
</html>