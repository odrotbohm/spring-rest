<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Welcome</title>
</head>
<body>
	<h1>Customers</h1>
	<ul>
		<c:forEach items="${customers}" var="customer">
			<li>
				<c:out value="${customer}" /> <a href="<c:url value="/customers/${customer.number}" />">Show</a>
				<form action="<c:url value="/customers/${customer.number}" />" method="post">
					<input type="hidden" name="_method" value="delete" />
					<input type="submit" value="Delete" />
				</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
