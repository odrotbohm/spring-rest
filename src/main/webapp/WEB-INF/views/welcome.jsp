<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Welcome</title>
</head>
<body>
<h1>
	Congratulations! You're running Spring!
</h1>
<ul>
	<li><a href="<c:url value="/customers" />">Customers</a></li>
</ul>
</body>
</html>
