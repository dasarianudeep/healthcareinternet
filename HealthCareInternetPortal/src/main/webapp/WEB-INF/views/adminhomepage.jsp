<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype HTML>
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
&nbsp &nbsp &nbsp <small><i>Quality care close to home.</i></small>
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
 <li><a href="/webtools/admin/manageemployees">Manage Employees</a></li>
 
 </ul>
 
 <ul class="nav navbar-nav navbar-right">
  <li><a href="/webtools/userlogout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
  </ul>
</div>
</div>

</nav>
</div><!-- end of row two -->

<div class="row">

<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="<c:url value="/resources/car1.jpg" />" alt="Chania">
    </div>

    <div class="item">
      <img src="<c:url value="/resources/car2.jpg" />" alt="Chania">
    </div>

    <div class="item">
      <img src="<c:url value="/resources/car3.jpg" />" alt="Flower">
    </div>

   
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>



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