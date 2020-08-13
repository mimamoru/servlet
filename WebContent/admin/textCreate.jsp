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
<link rel="stylesheet" href="css/textLook.css">
<link rel="stylesheet" href="css/common.css">
<script src="https://kit.fontawesome.com/67f6d5ae4d.js" crossorigin="anonymous"></script>
 <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

</head>
<body class="hold-transition fixed skin-blue-light sidebar-mini ">

<h1>Create New Card</h1>

<div class="container-fluid">
<table id="bookList" >
  <thead>
    <tr class="d-flex"><th class="col-2">Favorite</th> <th class="col-2">Kind</th> <th class="col-6">Title</th> <th class="col-2">Finish</th></tr>
  </thead>
<tbody id="tbody">
 <tr class="d-flex">
 <td class="col-2">
 <button class="favorite-btn circle_spread_btn" value="${myBook.favorite}"><i class="far fa-star"></i></button><input class="favorite-input" type="hidden"  value="${myBook.id}">
 </td>
<td class="col-2">
<input class="mbid" type="hidden" value="${myBook.id}">
 <input  name="kind_num" type="hidden" value="${kind_num}">
   <input  class="my" name="book-kind_num" type="hidden" value="${myBook.kind_num}">

<select id="kind-select" class="s1" >
<c:forEach var="kind" items="${kinds}">
 <option class="type-drop" value="${kind.kind_num}" ><c:out value="${kind.kind_name}" /></option>
 </c:forEach>
</select>
</td>

<td class="col-6">
<input id="text-form" name="title" type="text" placeholder="Title" >
</td>

<td class="col-2">

<div class="pagelink">
<button id="create-btn"   class="cp_btn" name="send"><i class="fas fa-check-circle"></i></button>
</div>
</td>

 </tr>
</tbody>


</table>
</div>
<!--
<form enctype="multipart/form-data" > -->
<%-- <button  class="favorite-btn" type="button" >favorite</button>
<select id="kind-select">

<c:forEach var="kind" items="${kinds}">

 <option value="${kind.kind_num}"><c:out value="${kind.kind_name}" /></option>
  </c:forEach>

</select>
  <input id="title" name="title" type="text" placeholder="タイトル">
  <button id="create-btn" type="button" name="send" ><i class="fas fa-pencil-alt"></i></button><br>

  --%>
<div id="wrap">

 <div>
 <textarea id="contents" name="text">

 </textarea>
 </div>
<div class="pagelink">
<button id="back-btn" class="cp_btn"  ><i class="far fa-arrow-alt-circle-left"></i></button>
<!-- </form> -->
</div>
</div>

<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/textCreate.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/lang/summernote-ja-JP.js"></script>







</body>
</html>