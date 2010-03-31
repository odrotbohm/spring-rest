<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Welcome</title>
</head>
<body>
	<h1>Customer ${customer.name}</h1>
	<ul>
		<li>Customer number: <c:out value="${customer.number}" /></li>
		<li>Firstname: <c:out value="${customer.firstname}" /></li>
		<li>Lastname: <c:out value="${customer.lastname}" /></li>
	</ul>
	
	<a href="<c:url value="/customers" />">Back</a>
</body>
</html>
