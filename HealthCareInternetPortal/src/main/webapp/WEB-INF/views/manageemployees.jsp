<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

<div class="row">

<div class="col-md-3">
<h2><i>Newton General Hospital</i></h2>
&nbsp; &nbsp; &nbsp; <small><i>Quality care close to home.</i></small>
</div>

<div class="col-md-6">
<img src="<c:url value="/resources/logo3.jpg" />" alt="HIE Logo" width="650" height="125">

</div>

<div class="col-md-3">
<img src="<c:url value="/resources/logo2.jpg" />" alt="HIE Logo" width="250" height="125">

</div>


</div><!-- end of row one-->

<div class="row">

<nav class="navbar navbar-default">
<div class="container-fluid">
 <div class="navbar-header">
  <a class="navbar-brand" href="#">Welcome ${loginuser}</a>
</div>
<div>
 <ul class="nav navbar-nav">
 <li><a href="/webtools/admin/home">HOME</a></li>
 <li class="active"><a href="/webtools/admin/manageemployees">Manage Employees</a></li>
 
 </ul>
 
 <ul class="nav navbar-nav navbar-right">
  <li class="active"><a href="/webtools/userlogout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
  </ul>
</div>
</div>

</nav>
</div><!-- end of row two -->

<div class="row">
<div class="col-md-2"></div>

<div class="col-md-8">


<form action="/webtools/admin/addemployees" method="post">
<fieldset>
<legend>Employee Information</legend>
<table class="table">
<tr><td>First Name : </td><td><input type="text" class="form-control" name="employee.firstname" size="20"/><spring:errors path="useraccount.employee.firstname" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>Last Name : </td><td><input type="text" class="form-control" name="employee.lastname"/><spring:errors path="useraccount.employee.lastname" cssStyle="color:#ff0000"></spring:errors></td></tr>

<tr><td>SSN : </td><td><input type="text" class="form-control" name="employee.ssn"/><spring:errors path="useraccount.employee.ssn" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>Employee Type:</td><td><select name="role">
<option value="doctor">doctor</option>
<option value="nurse">nurse</option>
<option value="labassistant">labassistant</option>

<option value="admin">admin</option>
</select></td></tr>
<tr><td>Username:</td><td><input type="text" class="form-control" name="username"/><spring:errors path="useraccount.username" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>Password:</td><td><input type="password" class="form-control" name="password"/><spring:errors path="useraccount.password" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td colspan="2"><input type="submit" class="btn btn-info" value="Add Employee"/></td></tr>

</table>
</fieldset>
</form>
</div>
<div class="col-md-2"></div>
</div><!--  end of row three -->

</div><!-- end of container -->
</body>
</html>
