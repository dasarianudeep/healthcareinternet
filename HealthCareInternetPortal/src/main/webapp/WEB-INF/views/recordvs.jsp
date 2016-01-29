<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
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
 <li><a href="#">HOME</a></li>
 <li><a href="/webtools/nurse/processvsrequest">Process VitalSign Requests</a></li>
 <li class="active"><a href="/webtools/nurse/recordvs">Record VitalSigns</a></li>
 
 </ul>
 
 <ul class="nav navbar-nav navbar-right">
  <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
  </ul>
</div>

</div><!-- end of container fluid -->
</nav>





</div><!-- end of row two -->

<div class="row">

<div class="col-md-3"></div>
<div class="col-md-6">

<form action="/webtools/nurse/submitvitalsigns" method="post">
<fieldset>
<legend>Record VitalSigns</legend>
<table class="table-striped">
<input type="hidden" name="pid" value="${pid}"/><input type="hidden" name="eid" value="${eid}"/>
<input type="hidden" name="vswrid" value="${vswrid}"/>
<tr><td>Body Temperature</td><td><input type="text" class="form-control" name="bodytemperature" required  /><spring:errors path="vitalSigns.bodytemperature" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>Blood Pressure</td><td><input type="text" class="form-control" name="bloodpressure" required/><spring:errors path="vitalSigns.bloodpressure" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>Pulse Rate</td><td><input type="text" class="form-control" name="pulserate" required/><spring:errors path="vitalSigns.pulserate" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td>Respiratory Rate</td><td><input type="text" class="form-control" name="respiratoryrate" required /><spring:errors path="vitalSigns.respiratoryrate" cssStyle="color:#ff0000"></spring:errors></td></tr>
<tr><td colspan="2"><input type="submit" class="btn btn-md btn-info" value="Submit to Doctor" /></td></tr>


</table>

</fieldset>
</form>



</div>

<div class="col-md-3"></div>
</div><!-- end of row three-->

<div class="row">
<div class="col-md-2">
</div>

<div class="col-md-8">
<p class="text-info">Health Information Exchange and Management Systems</p>
<p><small>183 Boylston Avenue,Suite 1000,Mass Avenue,Boston,MA-02120.  All CopyRights Reserved</small></p>



</div>
<div class="col-md-2">
</div>
</div><!-- end of row four-->
</div><!-- end of container-->
</body>
</html>