<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/textLook.css">
 <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">


</head>
<body>
<h1>書籍情報の一覧</h1>


<form>
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
   </thead>
   <tbody>
 <tr>
 <td><button class="favorite-btn" type="button" value="${myBook.favorite}">favorite</button></td>
<td>
<input class="mbid" type="hidden" value="${myBook.id}">
 <input  name="kind_num" type="hidden" value="${kind_num}">
<input  class="my" name="book-kind_num" type="hidden" value="${myBook.kind_num}">
<select class="s1" >
<c:forEach var="kind" items="${kinds}">
 <option class="type-drop" value="${kind.kind_num}" ><c:out value="${kind.kind_name}" /></option>
 </c:forEach>
</select>
</td>

<td><input id="text-form" type="text" value="${myBook.title}" readonly></td>
<td>${myBook.modified}</td>
<td><button id="edit-btn" type="button">edit</button></td>
<td><button class="delete-btn" type="button" value="${myBook.book_id}">delete</button></td>

   </tr>
</tbody>


</table>



<%-- <p class="text" >${myBook.text}</p> --%>


 <div>
  <textarea id="contents" name="text">
${myBook.text}
 </textarea>
 </div>


<button id="back-btn" type="button">戻る</button>
</form>

<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/textLook.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/lang/summernote-ja-JP.js"></script>
</body>
</html>