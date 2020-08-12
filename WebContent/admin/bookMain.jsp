<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/bookMain.css">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/bookMain.js"></script>
<script src="https://kit.fontawesome.com/67f6d5ae4d.js" crossorigin="anonymous"></script>
</head>
<body>
<h1>My Folders</h1>


<div class="card-deck">
<div class="card bg-secondary mb-3" style="max-width: 20rem max-hetght: 10rem;">
 <div class="card-body text-light">
  <input name="kind_num" type="hidden"  value="${kinds[0].kind_num}">
   <h4 class="card-title">${kinds[0].kind_name}</h4>
  </div>
  <div class="card-footer " ></div>
</div>

<div class="card bg-danger mb-3" style="max-width: 20rem max-hetght: 10rem;">
 <div class="card-body text-light">
    <input  name="kind_num" type="hidden"  value="${kinds[1].kind_num}">
   <h4 class="card-title">${kinds[1].kind_name}</h4>
  </div>
  <div class="card-footer" data-toggle="modal" data-target="#modal2"><i class="far fa-edit"></i></div>
</div>


<div class="card bg-warning mb-3" style="max-width: 20rem max-hetght: 10rem;">
 <div class="card-body text-light">
   <input  name="kind_num" type="hidden"  value="${kinds[2].kind_num}">
   <h4 class="card-title">${kinds[2].kind_name}</h4>
  </div>
  <div class="card-footer" data-toggle="modal" data-target="#modal3"><i class="far fa-edit"></i></div>
</div>


</div>
<div class="card-deck">
<div class="card bg-success mb-3" style="max-width: 20rem max-hetght: 10rem;">
  <div class="card-body text-light">
    <input  name="kind_num" type="hidden"  value="${kinds[3].kind_num}">
   <h4 class="card-title">${kinds[3].kind_name}</h4>
  </div>
  <div class="card-footer" data-toggle="modal" data-target="#modal4"><i class="far fa-edit"></i></div>
</div>
<div class="card bg-info mb-3" style="max-width: 20rem max-hetght: 10rem;">
  <div class="card-body text-light">
    <input  name="kind_num" type="hidden"  value="${kinds[4].kind_num}">
   <h4 class="card-title">${kinds[4].kind_name}</h4>
  </div>
  <div class="card-footer" data-toggle="modal" data-target="#modal5"><i class="far fa-edit"></i></div>
</div>
  <div class="card bg-primary mb-3" style="max-width: 20rem max-hetght: 10rem;">
  <div class="card-body text-light">
    <input  name="kind_num" type="hidden"  value="${kinds[5].kind_num}">
   <h4 class="card-title">${kinds[5].kind_name}</h4>
  </div>
  <div class="card-footer" data-toggle="modal" data-target="#modal6"><i class="far fa-edit"></i></div>
</div>

</div>

<button type="button" onclick="location.href='TextCreateServlet'"><i class="fas fa-pencil-alt"></i></button>


<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal1">
<i class="fas fa-people-arrows"></i>
</button>
<div class="modal fade" id="modal1" tabindex="-1"
      role="dialog" aria-labelledby="label1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
    <form action="BookSearchServlet" method="post">
      <div class="modal-header">
        <h5 class="modal-title" id="label1">Seach Folder</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
			<input class="form-control" name="name" type="text" placeholder="Folder Name">
			<input class="form-control" name="pass" type="password" placeholder="Password">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fas fa-ban"></i></button>
        <button id="search-ok" type="submit" class="btn btn-primary" onclick="return false;"><i class="far fa-check-circle"></i></button>
      </div>
      </form>
    </div>
  </div>
</div>



<div class="modal fade" id="modal2" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
  <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
    <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        </button>
      <div class="modal-body">
        <div class="input-group mb-2">
            <input type="text" class="form-control" placeholder="new name">
            <input  name="kind_num" type="hidden"  value="${kinds[1].kind_num}">
            <div class="input-group-append">
              <button type="button" class="kind-edit btn btn-danger"><i class="far fa-check-circle"></i></button>
          </div>
          </div>
        </div>
    </div>
  </div>
</div>

<div class="modal fade" id="modal3" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
  <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
    <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        </button>
      <div class="modal-body">
        <div class="input-group mb-2">
            <input type="text" class="form-control" placeholder="new name">
            <input  name="kind_num" type="hidden"  value="${kinds[2].kind_num}">
            <div class="input-group-append">
              <button type="button" class="kind-edit btn btn-warning"><i class="far fa-check-circle"></i></button>
          </div>
          </div>
        </div>
    </div>
  </div>
</div>

<div class="modal fade" id="modal4" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
  <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
    <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        </button>
      <div class="modal-body">
        <div class="input-group mb-2">
            <input type="text" class="form-control" placeholder="new name">
            <input  name="kind_num" type="hidden"  value="${kinds[3].kind_num}">
            <div class="input-group-append">
              <button type="button" class="kind-edit btn btn-success"><i class="far fa-check-circle"></i></button>
          </div>
          </div>
        </div>
    </div>
  </div>
</div>

<div class="modal fade" id="modal5" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
  <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
    <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        </button>
      <div class="modal-body">
        <div class="input-group mb-2">
            <input type="text" class="form-control" placeholder="new name">
            <input  name="kind_num" type="hidden"  value="${kinds[4].kind_num}">
            <div class="input-group-append">
              <button type="button" class="kind-edit btn btn-info"><i class="far fa-check-circle"></i></button>
          </div>
          </div>
        </div>
    </div>
  </div>
</div>

<div class="modal fade" id="modal6" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
  <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
    <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        </button>
      <div class="modal-body">
        <div class="input-group mb-2">
            <input type="text" class="form-control" placeholder="new name">
            <input  name="kind_num" type="hidden"  value="${kinds[5].kind_num}">
            <div class="input-group-append">
              <button type="button" class="kind-edit btn btn-primary"><i class="far fa-check-circle"></i></button>
          </div>
          </div>
        </div>
    </div>
  </div>
</div>




<button type="button" onclick="location.href='BookPushListServlet'"><i class="fas fa-share-alt-square"></i></button>
<button id="logout" type="button" ><i class="fas fa-sign-out-alt"></i>Logout</button>



</body>
</html>