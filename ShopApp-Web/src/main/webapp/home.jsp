<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<body>
	<center>
		<h2>All Users</h2>
		<table style="width: 50%;" border="1" cellspacing="0" cellpadding="8">
			<thead>
				<tr style="font-weight: bold;">
					<td>User ID</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
				</tr>
			</thead>
			<%-- <tbody>
			<c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
      </c:forEach>
			</tbody> --%>
			<tbody>.
				<c:forEach var="per" items="${it.result}">
					<tr>
						<td><c:out value="${per.userId}" /></td>
						<td><c:out value="${per.firstName}" /></td>
						<td><c:out value="${per.lastName}" /></td>
						<td><c:out value="${per.emailId}" /></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</center>
</body>
</html>
