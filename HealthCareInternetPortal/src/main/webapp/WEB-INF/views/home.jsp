<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<spring:form action="addemployee" commandName="useraccount" method="post" >
Username:<spring:input path="username"/><br/>
Password:<spring:password path="password"/><br/>
Role:<spring:input path="role"/><br/>

<input type="submit" value="ADD"/>



</spring:form>

</body>
</html>
