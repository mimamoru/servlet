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


<p class="title"  >${myBook.title}</p>
<p class="text" >${myBook.text}</p>


<button type="button" onclick="location.href='BookMainServlet'">戻る</button>



</body>
</html>