<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring5 MVC Hibernate Demo</title>
		<style type="text/css">
			.error {
				color: red;
			}
			table {
				width: 50%;
				border-collapse: collapse;
				border-spacing: 0px;
			}
			table td {
				border: 1px solid #565454;
				padding: 20px;
			}
		</style>
	</head>
	<body>
        <h2>Personal Page</h2>
		<table>
			<tr>
				<td><strong>Id</strong></td>
				<td><strong>Login</strong></td>
				<td><strong>Password</strong></td>
				<td><strong>Salt</strong></td>
				<td><strong>Name</strong></td>
				<td><strong>Surname</strong></td>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.login}</td>
					<td>${user.password}</td>
                    <td>${user.salt}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>