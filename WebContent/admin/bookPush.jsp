<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link rel="stylesheet" type="text/css" href="css/bookPush.css">
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/bookPush.js"></script>
</head>
<body>
<h1>書籍情報の一覧</h1>


<ul class="nav nav-tabs" role="tablist">
  <li class="nav-item">
    <a class="nav-link active" id="item1-tab" data-toggle="tab" href="#item1" role="tab" aria-controls="item1" aria-selected="true">my text</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="item2-tab" data-toggle="tab" href="#item2" role="tab" aria-controls="item2" aria-selected="false">pushed book</a>
  </li>
</ul>
<div class="tab-content">
  <div class="tab-pane fade show active" id="item1" role="tabpanel" aria-labelledby="item1-tab">
<!--   <form action="TextMServlet" method="post"> -->

<input id="sbox1"   type="text" placeholder="含むキーワード" />
<button id="sbtn1" type="button" onclick="return false">検索</button>
<button id="sbtn2" type="button" onclick="return false">戻す</button>

<select name="order" class="select1">
<option class="pulldown" value="0">追加順</option>
<option class="pulldown" value="1">タイトル順</option>
<option class="pulldown" value="2">更新順</option>
</select>

<!-- </form> -->


  <div class="form-check">
	<table >
	<thead><tr><td></td><td>title</td><td>modified</td></tr></thead>
	<tbody id="table1">
	 <c:forEach var="myBook" items="${myBooks}">
	 <tr>
	  <td><input class="form-check-input" type="checkbox"  value="${myBook.book_id}"></td>
	  <td><label class="form-check-label" for="check1a" >${myBook.title}</label></td>
	  <td><input class="form-modified" type="text"  value="${myBook.modified}">
	  </td>
	  </tr>
	 </c:forEach>
	 </tbody>
	 </table>
	</div>
<!-- <button type="button" onclick="return false;"> 共有する</button>
その後非同期でBookPushServletにbooks id ourbookid渡す

 -->
<button type="button" onclick="location.href='BookMainServlet'">メインへ</button>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal1">
  共有する
</button>
<div class="modal fade" id="modal1" tabindex="-1"
      role="dialog" aria-labelledby="label1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="label1">PUSH TEXT</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
			<input id="share-name" class="form-control" name="name" type="text" placeholder="BOOK名">
			<input id="share-pass" class="form-control" name="pass" type="password" placeholder="パスワード">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCEL</button>
        <button id="share" type="button" class="btn btn-primary">OK</button>
      </div>
    </div>
  </div>
</div>



</div>


<div class="tab-pane fade" id="item2" role="tabpanel" aria-labelledby="item2-tab">

<form action="BookOServlet" method="post">

<select name="order" class="select2">
<option class="pulldown" value="0">共有順</option>
<option class="pulldown" value="1">名前順</option>
</select>
</form>

<!-- <form action="BookOdelServlet" method="post"> -->

	<div class="form-check table1">
	<table>
	<thead><tr><td></td><td>title</td></tr></thead>
	<tbody  id="table2">
	 <c:forEach var="ourBook" items="${ourBooks}">
	 <tr>
	 <td>
	  <input class="form-check-input" type="checkbox"  value="${ourBook.id}"> </td>
	  <td>
	  <label class="form-check-label" for="check1a">${ourBook.name}</label>
	  </td>
	   </tr>
	 </c:forEach>
	 </tbody>
	 </table>
	</div>
<button type="button" onclick="location.href='BookMainServlet'">メインへ</button>
<button id="cancel" type="button" onclick="return false;">共有取り消し</button>

<!-- </form> -->

</div>

</div>





</body>
</html>