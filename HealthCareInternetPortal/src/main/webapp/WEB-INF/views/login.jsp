<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

</head>
<body>
<div class="container">

<div class="row">

<div class="col-md-3">
<h2><i>Newton General Hospital</i></h2>
&nbsp &nbsp &nbsp <small><i>Quality care close to home.</i></small>
</div>

<div class="col-md-6">
<img src="<c:url value="/resources/logo3.jpg"/>" alt="HIE Logo" width="650" height="125">

</div>

<div class="col-md-3">
<img src="<c:url value="/resources/logo2.jpg"/>" alt="HIE Logo" width="250" height="125">

</div>


</div><!-- end of row one-->

<br/>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
<form action="/webtools/home" method="post">

<c:if test="${not empty error }">
<p class="lead" style="color:red">Invalid user/password</p>
</c:if>


<table class="table-striped table-hovered">
<tr><th>Username <span class="glyphicon glyphicon-user"></span></th><td><input type="text" class="form-control"name="username" placeholder="Enter username"/></td></tr>
</table>
<br/>
<table class="table-striped table-hovered">
<tr><th>Password <span class="glyphicon glyphicon-lock"></span></th><td><input type="password" class="form-control" name="password" placeholder="Enter password"/></td></tr>
</table>
<br/>
<input type="submit" class="btn btn-md btn-info" value="Log In"/>&nbsp; &nbsp; &nbsp;<a href="/webtools/signuppatient" class="btn btn-info btn-info">New Patient (Sign Up)</a>
<br/><br/>
<input type="checkbox"  name="remember" value="rememberme"> &nbsp;Remember me


</form>
<br/>


</div>
<div class="col-md-3"></div>
</div>

</div><!-- end of container-->
</body>

</html>