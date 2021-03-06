<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>書籍管理システム</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/textO.css">
 <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script src="https://kit.fontawesome.com/67f6d5ae4d.js" crossorigin="anonymous"></script>
</head>

<body>
<h1>${ourBook.name}</h1>
<input  type="hidden" name="ourBook_id" value="${ourBook.id}">
<div class="container-fluid">
            <table id="bookList" class="table table-hover table-o">

            <thead>
            <tr id="del"><th></th><th></th><th></th><th><button id="keep-btn" class="nohit btn-top-radius" ><i class="fas fa-download"></i></button></th></tr>
            <tr class="d-flex"><th class="col-4">Title</th><th class="col-3">Modified</th><th class="col-2">Open</th><th class="col-3">Keep</th></tr></thead>

            <tbody id="table">
             <c:forEach var="oBook" items="${ourBook.getOBooks()}">
             <tr class="d-flex">
              <td class="col-4">${oBook.title}</td>
              <td class="col-3"><input class="oBook-modified" type="hidden" value="${oBook.modified}">${oBook.modified}</td>
              <td class="col-2"><div class="pagelink"><button name="${oBook.id}" type="button" class="open-btn circle_spread_btn" data-toggle="modal" data-target="#modal1"><i class="fas fa-envelope-open-text"></i></button></div></td>
			 <td class="col-3">
              <div class='check-container'>
              <input id="${oBook.id}" class="form-check-input" name="book_ids"  type="checkbox"  value="${oBook.id}">
            <label for='${oBook.id}'></label>

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
<%-- <div class="form-check">
<table>
<thead>
<tr>
 <td>title</td><td>modified</td><td><input  type="hidden" name="ourBook_id" value="${ourBook.id}"></td>
 </tr>
 </thead>
 <tbody>

	 <c:forEach var="oBook" items="${ourBook.getOBooks()}">
	  <tr>
	 <td> <input class="form-check-input" type="checkbox" name="book_ids" value="${oBook.id}">
	  <label class="form-check-label" for="check1a">${oBook.title}</label></td>
	   <td><p class="oBook-modified">${oBook.modified}</p></td>
	   <td><button  name="${oBook.id}" type="button" class="open-btn btn btn-primary" data-toggle="modal" data-target="#modal1"><i class="fas fa-envelope-open-text"></i></button></td>

 </tr>
     </c:forEach>
 </tbody>

</table>
</div> --%>




<!-- <button type="button" onclick="location.href='BookMainServlet'"><i class="far fa-arrow-alt-circle-left"></i></button>
 -->



<div class="modal fade fullscreen" id="modal1" tabindex="-1"
      role="dialog" aria-labelledby="modallabel1" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">

      <div class="modal-header">
        <h5 class="modal-title" id="modallabel1"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div id="text" class="modal-body">

      </div>


    </div>
  </div>
</div>

<script type="text/javascript" src="js/jquery-3.5.1.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"charset="UTF-8"></script>
<script type="text/javascript" src="js/textO.js" charset="UTF-8"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/lang/summernote-ja-JP.js"></script>


</body>
</html>



<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link rel="stylesheet" type="text/css" href="css/textO.css">
<link rel="stylesheet" href="css/bootstrap.css">
 <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

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
	   <p class="nolook oBook-text"> ${oBook.text}</p>
	   <input type="hidden" name="texts" value="${oBook.text}">

	  <p class="nolook oBook-modified">${oBook.modified}</p>
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
			<div>
  <textarea id="contents" name="text">
${myBook.text}
 </textarea>
 </div>
      </div>


    </div>
  </div>
</div>

<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/textO.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/lang/summernote-ja-JP.js"></script>


</body>
</html> --%>