<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link rel="stylesheet" type="text/css" href="css/textO.css">
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/textO.js"></script>
</head>
<body>
<h1>書籍情報の一覧</h1>
<form  method="post">
<div class="form-check">
<table>
<tr>
 <td> <input  type="hidden" name="ourBook_id" value="${ourBook.id}"></td><td></td></tr>
	 <c:forEach var="oBook" items="${ourBook.getOBooks()}">
	  <tr>
	 <td> <input class="form-check-input" type="checkbox" name="book_ids" value="${oBook.id}">
	   <input type="hidden" name="titles" value="${oBook.title}">
	   <input type="hidden" name="texts" value="${oBook.text}">
	   <input type="hidden" name="dates" value="${oBook.modified}">

	  <label class="form-check-label" for="check1a">${oBook.title}</label></td>
<td> <button  name="${oBook.id}" type="button" class="open-btn btn btn-primary" data-toggle="modal" data-target="#modal1">
 OPEN
</button></td>
 </tr>
     </c:forEach>


</table>
</div>
<button type="button" onclick="location.href='BookMainServlet'">戻る</button>
<button id="keep-btn" type="submit" onclick="return false;">KEEP</button>
</form>


<div class="modal fade" id="modal1" tabindex="-1"
      role="dialog" aria-labelledby="label1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-fluid" role="document">
    <div class="modal-content modal-dialog-fluid">

      <div class="modal-header .modal-dialog-fluid-width">
        <h5 class="modal-title" id="label1">title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div id="text" class="modal-body modal-dialog-fluid">
			<!-- <div>text</div> -->
      </div>


    </div>
  </div>
</div>




</body>
</html>