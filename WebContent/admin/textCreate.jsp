<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link href="summernote-master/dist/summernote.css" rel="stylesheet">
<script src="summernote-master/dist/summernote.min.js"></script>
<script src="summernote-master/dist/lang/summernote-ja-JP.js"></script>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<link rel="stylesheet" href="css/fbootstrap.css">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script src="js/script.js"></script>
</head>
<body>
<h1>書籍情報の一覧</h1>




<form method="post" enctype="multipart/form-data" action="TextCreateServlet">
<select >
<c:forEach var="kind" items="${kinds}">

 <option value="${kind.kind_num}"><c:out value="${kind.kind_name}" /></option>
  </c:forEach>

</select>
  <input class="title" name="name" type="text" placeholder="タイトル"><br>
  <textarea class="form-control" id="detail" name="detail" rows="5"></textarea><br>
<button type="button" onclick="location.href='BookMainServlet'">戻る</button><button type="submit" name="send" >保存</button></form>









</body>
</html>