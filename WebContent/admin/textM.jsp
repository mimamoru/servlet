<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/textM.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/textM.js"></script>
<script src="https://kit.fontawesome.com/67f6d5ae4d.js" crossorigin="anonymous"></script>
</head>
<body>
<h1>${kind_name}</h1>


<div class="cp_ipselect">
<select id="order" class="cp_sl06" required>
<option class="pulldown" value="0">追加順</option>
<option class="pulldown" value="1">タイトル順</option>
<option class="pulldown" value="2">更新順</option>
</select>
<span class="cp_sl06_highlight"></span>
<span class="cp_sl06_selectbar"></span>
<label class="cp_sl06_selectlabel">Choose</label>
</div>


<div class="cp_iptxt">
	<input id="sbox1" class="ef" type="text" placeholder="">
	<label>Contains</label>
	<span class="focus_line"></span>
</div>


<div class="pagelink">
<button id="sbtn1" class="cp_btn" ><i class="fas fa-search"></i></button>
</div>


<div class="pagelink">
<button id="sbtn2" class="cp_btn" ><i class="fas fa-undo-alt"></i></button>
</div>


 <div class="container-fluid">
  <input  id="kind_num" type="hidden" value="${kind_num}">

 <%-- <input   name="like" type="hidden" value="${like}">
  <input   name="order" type="hidden" value="${order}"> --%>
  <table id="bookList" class="table table-hover">
  <thead>

  <tr id="del" ><th > </th> <th > </th> <th > </th> <th> </th><th ><button id="delete-button" class="nohit btn-top-radius" ><i class="far fa-trash-alt"></i></button></th></tr>
  <tr class="d-flex"><th class="col-2">Favorite</th> <th class="col-2">Kind</th> <th class="col-3">Title</th> <th class="col-3">Modified</th><th class="col-2">Delete</th></tr>
  </thead>
  <tbody id="tbody">
  <c:forEach var="myBook" items="${myBooks}">
  <tr class="d-flex">
 <td class="col-2"><button class="favorite-btn circle_spread_btn" type="button" value="${myBook.favorite}"><i class="far fa-star"></i></button><input class="favorite-input" type="hidden"  value="${myBook.id}"></td>
 <%--  <td><c:out value="${myBook.favorite}" /></td> --%>
<td class="col-2">
<input class="mbid" type="hidden" value="${myBook.id}">
<input  class="my" name="book-kind_num" type="hidden" value="${myBook.kind_num}">

<select class="s1" >
<c:forEach var="kind" items="${kinds}">
 <option class="type-drop " value="${kind.kind_num}" ><c:out value="${kind.kind_name}" /></option>
 </c:forEach>
</select>
</td>
<td class="col-3"><a href="TextLookServlet?id=${myBook.id}&kind_num=${kind_num}"><c:out value="${myBook.title}" /></a></td>
<td class="col-3"><input class="modified" type="hidden" value="${myBook.modified}"><c:out value="${myBook.modified}" /></td>
  <td class="form-check list_item col-2">
  <div class="cp_ipcheck">
	<input class="option-input06 " name="myBook_id" type="checkbox"  value="${myBook.id}">

	<input type="hidden"  value="${myBook.book_id}">
</div>
	</td>
   </tr>
</c:forEach>
</tbody>

</table>
</div>
<div class="pagelink">
<button id="backbtn" class="cp_btn" ><i class="fas fa-arrow-alt-circle-left"></i></button>
</div>









</body>
</html>