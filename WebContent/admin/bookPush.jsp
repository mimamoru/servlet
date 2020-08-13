<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bookPush.css">
<link rel="stylesheet" type="text/css" href="css/common.css">

<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/bookPush.js"></script>
<script src="https://kit.fontawesome.com/67f6d5ae4d.js" crossorigin="anonymous"></script>
</head>
<body>
<h1>Share Cards</h1>



<div class="cp_tab">

	<div id="panel1" class="cp_tabpanels">
		<label for="tab5_1">My Cards</label>
		<input id="tab5_1" name="cp_tab" type="radio" checked="checked">
		<div class="cp_tabpanel">
			<!-- <h4>Please Select Cards To Share</h4> -->


<div class="cp_ipselect">
<select  class="order select1 cp_sl06" required>
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

      <!--   <select name="order" class="select1">
          <option class="pulldown" value="0">追加順</option>
          <option class="pulldown" value="1">タイトル順</option>
          <option class="pulldown" value="2">更新順</option>
          </select>
          <input id="sbox1"   type="text" placeholder="含むキーワード" />
          <button id="sbtn1" type="button" onclick="return false">検索</button>
          <button id="sbtn2" type="button" onclick="return false">戻す</ --><!-- button> -->


          <div class="container-fluid">
            <table id="bookList1" class="table table-hover table-o">

            <thead>
            <tr id="del1"><th></th><th></th><th><button id="share-btn" class="nohit btn-top-radius" data-toggle="modal" data-target="#modal1"><i class="fas fa-share-alt-square"></i></button></th></tr>
            <tr class="d-flex"><th class="col-6">Title</th><th class="col-3">Modified</th><th class="col-3"></th></tr></thead>

            <tbody id="table1">
             <c:forEach var="myBook" items="${myBooks}">
             <tr class="d-flex">
              <td class="col-6"><label class="form-check-label" for="check1a" >${myBook.title}</label></td>
              <td class="col-3"><input class="form-modified" type="hidden" value="${myBook.modified}"><c:out value="${myBook.modified}" /></td>
              <td class="col-3 form-check">

              <div class='check-container'>
              <input id="${myBook.book_id}" class="form-check-input1" name="book_id" class="" type="checkbox"  value="${myBook.book_id}">
            <label for='${myBook.book_id}'></label>

             </div>
              </td>

              </tr>
             </c:forEach>
             </tbody>
             </table>
          </div>


         <div class="pagelink">
<button class="backbtn cp_btn" ><i class="fas fa-arrow-alt-circle-left"></i></button>
</div>
         <!--  <button id="share-btn" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal1">
            共有する
          </button> -->
          <div class="modal fade" id="modal1" tabindex="-1"
                role="dialog" aria-labelledby="label1" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="label1">Share Text</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                <input id="share-name" class="form-control" name="name" type="text" placeholder="Folder Name">
                <input id="share-pass" class="form-control" name="pass" type="password" placeholder="Password">
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fas fa-ban"></i></button>
                  <button id="share" type="button" class="btn btn-primary"><i class="far fa-check-circle"></i></button>
                </div>
              </div>
            </div>
          </div>

		</div>
	</div>


	<div id="panel2" class="cp_tabpanels">
		<label id="label2" for="tab5_2">Shared Folders</label>
		<input id="tab5_2" name="cp_tab" type="radio">
		<div id="share-tab" class="cp_tabpanel">
			<!-- <h4>Files Whitch You Shared</h4> -->
			<!-- <div> -->
		<div class="cp_ipselect">
<select class="cp_sl06 order select2" required>
<option   value="0">共有順</option>
<option   value="1">名前順</option>
</select>
<span class="cp_sl06_highlight"></span>
<span class="cp_sl06_selectbar"></span>
<label class="cp_sl06_selectlabel">Choose</label>
</div>
       <!--  <select name="order" class="select2">
          <option class="pulldown" value="0">共有順</option>
          <option class="pulldown" value="1">名前順</option>
          </select> -->

          <div class="table container-fluid">
            <table id="bookList2" class="table table-hover table-o">
            <thead><tr id="del2" ><th > </th> <th ><button id="cancel" class="nohit btn-top-radius" ><i class="fas fa-users-slash"></i></button></th></tr>
             <tr class="d-flex"><th class="col-8">Title</th> <th class="col-4" >Cancel</th></tr></thead>
            <tbody  id="table2">
             <c:forEach var="ourBook" items="${ourBooks}">
				<tr class="d-flex"><td class="col-8"><input class="form-check-label" type="hidden"><c:out value="${ourBook.name}"/></td><td class="form-check list_item col-4"><div class="cp_ipcheck"><input name="ourBook_id" class="option-input06" type="checkbox"  value="${ourBook.id}"></div></td></tr>
             </c:forEach>
             </tbody>
             </table>
            </div>
           <div class="pagelink">
<button class="backbtn cp_btn" ><i class="fas fa-arrow-alt-circle-left"></i></button>
</div>
		</div>
  </div>


</div>




</body>
</html>