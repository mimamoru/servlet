<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta http-equiv="content-type" content="text/html; charset=UTF-8">
 <title>書籍管理システム</title>
 <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<!-- <script src="summernote-master/dist/summernote.min.js"></script>
<script src="summernote-master/dist/lang/summernote-ja-JP.js"></script> -->
<!-- <link rel="stylesheet" type="text/css" href="css/stylesheet.css"> -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/textCreate.css">

 <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

</head>
<body class="hold-transition fixed skin-blue-light sidebar-mini ">

<h1>書籍情報の一覧</h1>




<form method="post" enctype="multipart/form-data" action="TextCreateServlet">
<select >
<c:forEach var="kind" items="${kinds}">

 <option value="${kind.kind_num}"><c:out value="${kind.kind_name}" /></option>
  </c:forEach>

</select>
  <input class="title" name="name" type="text" placeholder="タイトル"><br>
 <div>
 <textarea id="contents">

 </textarea>
 </div>
<button type="button" onclick="location.href='BookMainServlet'">戻る</button><button type="submit" name="send" >保存</button></form>



<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/textCreate.js"></script>
<!-- <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/lang/summernote-ja-JP.js"></script>
<!-- <script src="js/script.js"></script> -->






</body>
</html>