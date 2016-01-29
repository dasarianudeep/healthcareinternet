<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
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
<div class="col-md-3"></div>
<div class="col-md-6">
<form action="/webtools/registerpatient" method="post">
<spring:errors path="patient.*"></spring:errors>
<table class="table-condensed">
<tr><td>First Name</td><td><input type="text" name="firstname" class="form-control"/><spring:errors path="patient.firstname" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>Last Name</td><td><input type="text" name="lastname" class="form-control"/><spring:errors path="patient.lastname" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>Gender</td><td><input type="text" name="gender" class="form-control"/><spring:errors path="patient.gender" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>Age </td><td><input type="text" name="age" class="form-control"/><spring:errors path="patient.age" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>SSN </td><td><input type="text" name="ssn" class="form-control"/><spring:errors path="patient.ssn" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>City </td><td><input type="text" name="city" class="form-control"/><spring:errors path="patient.city" cssStyle="color:#ff0000" ></spring:errors></td></tr>
<tr><td>Username</td><td><input type="text" name="useraccount.username" class="form-control"/><spring:errors path="patient.useraccount.username" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>Password</td><td><input type="text" name="useraccount.password" class="form-control"/><spring:errors path="patient.useraccount.password" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td colspan="2"><input type="submit" class="btn btn-info" value="Create Patient"/></td></tr>
<input type="hidden" name="useraccount.role" value="nulllll"/>

</table>

</form>

</div>
<div class="col-md-3"></div>
</div><!-- end of row two -->


</div><!-- end of the container -->
</body>
</html>