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
<script type="text/javascript" src="js/bookMain.js"></script>
</head>
<body>
<h1>書籍情報の一覧</h1>
<table>

<tr>
<c:forEach var="kind" items="${kinds}">
<td>

<c:set var="kind_num" value="${kind.kind_num}"/><a href="TextMServlet?kind_num=${kind_num}"><c:out value="${kind.kind_name}" /></a>
</td>

  </c:forEach>
   </tr>

</table>
<button type="button" onclick="location.href='TextCreateServlet'">作成</button>


<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal1">
  共有
</button>
<div class="modal fade" id="modal1" tabindex="-1"
      role="dialog" aria-labelledby="label1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
    <form action="BookSearchServlet" method="post">
      <div class="modal-header">
        <h5 class="modal-title" id="label1">SERCH BOOK</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
			<input class="form-control" name="name" type="text" placeholder="BOOK名">
			<input class="form-control" name="pass" type="password" placeholder="パスワード">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCEL</button>
        <button id="search-ok" type="submit" class="btn btn-primary" onclick="return false;">OK</button>
      </div>
      </form>
    </div>
  </div>
</div>





<button type="button" onclick="location.href='BookPushListServlet'">共有する</button>
<button type="button" onclick="location.href='LogoutServlet'">ログアウト</button>



</body>
</html>