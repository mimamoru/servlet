<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/bookPush.css">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/bookPush.js"></script>
</head>
<body>
<h1>Share Cards</h1>



<div class="cp_tab">

	<div id="panel1" class="cp_tabpanels">
		<label for="tab5_1">My Cards</label>
		<input id="tab5_1" name="cp_tab" type="radio" checked="checked">
		<div class="cp_tabpanel">
			<h4>Please Select Cards To Share</h4>
			<div>
        <select name="order" class="select1">
          <option class="pulldown" value="0">追加順</option>
          <option class="pulldown" value="1">タイトル順</option>
          <option class="pulldown" value="2">更新順</option>
          </select>
          <input id="sbox1"   type="text" placeholder="含むキーワード" />
          <button id="sbtn1" type="button" onclick="return false">検索</button>
          <button id="sbtn2" type="button" onclick="return false">戻す</button>
          <div class="table">
            <table>
            <thead><tr><td>title</td><td>modified</td><td></td></tr></thead>
            <tbody id="table1">
             <c:forEach var="myBook" items="${myBooks}">
             <tr>
              <td><label class="form-check-label" for="check1a" >${myBook.title}</label></td>
              <td class="form-modified">${myBook.modified}</td>
              <td><input name="book_id" class="form-check-input" type="checkbox"  value="${myBook.book_id}"></td>

              </tr>
             </c:forEach>
             </tbody>
             </table>
          </div>


          <button type="button" onclick="location.href='BookMainServlet'">メインへ</button>
          <button id="share-btn" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal1">
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
		</div>
	</div>


	<div id="panel2" class="cp_tabpanels">
		<label for="tab5_2">Shared Files</label>
		<input id="tab5_2" name="cp_tab" type="radio">
		<div id="share-tab" class="cp_tabpanel">
			<h4>Files Whitch You Shared</h4>
			<div>
        <select name="order" class="select2">
          <option class="pulldown" value="0">共有順</option>
          <option class="pulldown" value="1">名前順</option>
          </select>
          <div class="table">
            <table>
            <thead><tr><td></td><td>title</td></tr></thead>
            <tbody  id="table2">

             </tbody>
             </table>
            </div>
            <button type="button" onclick="location.href='BookMainServlet'">Main</button>
<button id="cancel" type="button" onclick="return false;">共有取り消し</button>

      </div>
		</div>
  </div>


</div>




</body>
</html>