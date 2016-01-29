<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 <li class="active"><a href="#">HOME</a></li>
 <li><a href="/webtools/lab/processlabrequests">Process Laboratory Requests</a></li>
 
 
 </ul>
 
 <ul class="nav navbar-nav navbar-right">
  <li><a href="/webtools/userlogout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
  </ul>
</div>

</div><!-- end of container fluid -->
</nav>





</div><!-- end of row two -->

<div class="row">
<div class="col-md-3"></div>

<div class="col-md-6">
<strong>Process Lab Test Requests</strong>
<table class="table-hover">
<tr><th>Patient ID</th><th>Encounter ID</th><th>Requested Doctor</th><th>Lab Assistant</th><th>Status</th><th>Action</th></tr>
<c:forEach items="${list}" var="req">
<tr><c:set var="ltwid" value="${req.workrequestid}"></c:set><td>${req.patientid}<c:set var="pid" value="${req.patientid}"></c:set></td><td>${req.encounterid}<c:set var="eid" value="${req.encounterid}"></c:set></td><td>${req.doctorname }</td><td>${req.labassistantname}</td><td>${req.workrequeststatus}</td><td><a href="/webtools/lab/peformlabtests?pid=${pid}&eid=${eid}&ltwid=${ltwid}" class="btn btn-link">Perform LabTests</a></td></tr>
</c:forEach>

</table>

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