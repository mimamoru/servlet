<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/textLook.css">
<link rel="stylesheet" href="css/common.css">
 <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script src="https://kit.fontawesome.com/67f6d5ae4d.js" crossorigin="anonymous"></script>

</head>
<body>
<table id="bookList" >
  <thead>
    <tr class="d-flex"><th class="col-2">Favorite</th> <th class="col-1">Kind</th> <th class="col-4">Title</th> <th class="col-3">Modified</th><th id="tgl-btn" class="col-1">Edit</th><th class="col-1">Delete</th></tr>
  </thead>


<!-- <form>
<table>
<thead>
<tr>
 <td>favorite</td>
<td>
kind
</td>
<td>title</td>
<td>modified</td>
<td></td>
<td></td>

   </tr>
   </thead> -->


 <tbody id="tbody">
 <tr class="d-flex">
 <td class="col-2">
 <button class="favorite-btn circle_spread_btn" value="${myBook.favorite}"><i class="far fa-star"></i></button><input class="favorite-input" type="hidden"  value="${myBook.id}">
 </td>
<td class="col-1">
<input class="mbid" type="hidden" value="${myBook.id}">
 <input  name="kind_num" type="hidden" value="${kind_num}">
   <input  class="my" name="book-kind_num" type="hidden" value="${myBook.kind_num}">

<select class="s1" >
<c:forEach var="kind" items="${kinds}">
 <option class="type-drop" value="${kind.kind_num}" ><c:out value="${kind.kind_name}" /></option>
 </c:forEach>
</select>
</td>

<td class="col-4">
<input id="text-form" class="edit-second" type="text" value="${myBook.title}" readonly>
</td>
<td class="col-3">${myBook.modified}</td>
<td class="col-1">
<div class="pagelink">
<button id="edit-btn"  class="cp_btn"><i class="far fa-edit"></i></button>
</div>
<div class="pagelink nohit">
<button id="finish-btn"   class="cp_btn"><i class="fas fa-check-circle"></i></button>
</div>
</td>

<td class="col-1">
<div class="pagelink">
<button class="delete-btn cp_btn"  value="${myBook.book_id}">

<i class="far fa-trash-alt"></i></button>
</div>
</td>

 </tr>
</tbody>


</table>



<%-- <p class="text" >${myBook.text}</p> --%>
<div id="wrap">

 <div>
  <textarea id="contents" name="text">
${myBook.text}
 </textarea>
 </div>

<div class="pagelink">

<button id="back-btn" class="cp_btn"  ><i class="far fa-arrow-alt-circle-left"></i></button>

</div>
</div>
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/textLook.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/lang/summernote-ja-JP.js"></script>
</body>
</html>