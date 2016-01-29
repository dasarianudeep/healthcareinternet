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

<nav class="navbar navbar-default">
<div class="container-fluid">
 <div class="navbar-header">
  <a class="navbar-brand" href="#">Welcome ${loginuser}</a>
</div>
<div>
 <ul class="nav navbar-nav">
 <li><a href="#">HOME</a></li>
 <li class="active"><a href="/webtools/doctor/diagnosepatient">Patient Diagnosis</a></li>
 <li><a href="/webtools/doctor/examinevitalsigns">VitalSigns Examination</a></li>
 <li><a href="/webtools/doctor/analyzelabresults">Lab Results Analysis</a></li>
 
 </ul>
 
 <ul class="nav navbar-nav navbar-right">
  <li><a href="/webtools/userlogout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
  </ul>
</div>
</div><!-- end of container-fluid -->


</nav>





</div><!-- end of row two -->

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
<form action="/webtools/doctor/successvitalsigns" method="post">
<fieldset>
<legend>Prelimnary Diagnosis</legend>
Diagnosis Progress:
 <div class="progress">
  <div class="progress-bar progress-bar-striped active" role="progressbar"
  aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width:30%">
    30%
  </div>
</div>
<table class="table-hover">

<tr><td>Patient ID:</td>
<td>
<div class="form-group">
<input type="text" class="form-control" name="patient.employeeid" id="patientid" />
<spring:errors path="encounter.patient.employeeid" cssStyle="color:#ff0000"></spring:errors>
</div>
</td></tr>
<tr><td>Complaint</td>
<td>
<div class="form-group">
<input type="text" class="form-control" name="patientComplaint" id="patientComplaint"/>
<spring:errors path="encounter.patientComplaint" cssStyle="color:#ff0000"></spring:errors>
</div>
</td></tr>

<tr><td>Brief Symptoms</td>
<td>
<div class="form-group">
<textarea class="form-control" rows="2" id="briefSymptoms" name="briefSymptoms"></textarea>
<spring:errors path="encounter.briefSymptoms" cssStyle="color:#ff0000"></spring:errors>
</div>
</td></tr>

<tr><td>Onset Time</td>
<td>
<div class="form-group">
<textarea class="form-control" rows="2" id="starttimeSysmptoms" name="starttimeSysmptoms"></textarea>
<spring:errors path="encounter.starttimeSysmptoms" cssStyle="color:#ff0000"></spring:errors>
</div>
</td></tr>

<tr><td>Frequency of Occurence</td>
<td>
<div class="form-group">
<textarea class="form-control" rows="2" id="frequencySymptoms" name="frequencySymptoms"></textarea>
<spring:errors path="encounter.frequencySymptoms" cssStyle="color:#ff0000"></spring:errors>
</div>
</td></tr>

<tr><td>Do you consume alcohol?</td>

<td><div class="form-group"><label class="radio-inline"><input type="radio" name="isAlcoholic" id="isAlcoholic" value="yes">Yes</label></div></td>
<td><div class="form-group"><label class="radio-inline"><input type="radio" name="isAlcoholic" id="isAlcoholic" value="no">No</label></div>
<spring:errors path="encounter.isAlcoholic" cssStyle="color:#ff0000"></spring:errors>
</td></tr>

<tr><td>Are you a chronic smoker?</td>
<td><div class="form-group"><label class="radio-inline"><input type="radio" name="isTobaccoConsumer" id="isTobaccoConsumer" value="yes"/>Yes</label></div></td>
<td><div class="form-group"><label class="radio-inline"><input type="radio" name="isTobaccoConsumer" id="isTobaccoConsumer" value="no"/>No</label></div>
<spring:errors path="encounter.isTobaccoConsumer" cssStyle="color:#ff0000"></spring:errors>
</td></tr>

<tr><td>Are you Pregnant?</td>
<td><div class="form-group"><label class="radio-inline"><input type="radio" name="isPregnant" id="isTobaccoConsumer" value="yes"/>Yes</label></div></td>
<td><div class="form-group"><label class="radio-inline"><input type="radio" name="isPregnant" id="isTobaccoConsumer" value="no"/>No</label></div></td>
<td><div class="form-group"><label class="radio-inline"><input type="radio" name="isPregnant" id="isTobaccoConsumer" value="not applicable"/>Not Applicable</label></div>
<spring:errors path="encounter.isTobaccoConsumer" cssStyle="color:#ff0000"></spring:errors>
</td></tr>

<tr><td colspan="3"><input type="submit" class="btn btn-info btn-block" value="Send To record VitalSign"/></td></tr>

</table>
</fieldset>
</form>


<c:out value="${print}"/>


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