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
		<h1>Add new product</h1>
		<form:form action="addProduct" method="post" modelAttribute="product">
			<table>
				<tr>
					<td>Name</td>
					<td>
						<form:input path="name" /> <br />
					</td>
				</tr>
				<tr>
					<td>Price</td>
					<td>
						<form:input path="price" /> <br />
					</td>
				</tr>

				<tr>
					<td>Overview</td>
					<td>
						<form:input path="overview" /> <br />
					</td>
				</tr>
				<tr>
					<td>Weight</td>
					<td>
						<form:input path="weight" /> <br />
					</td>
				</tr>
				<tr>
					<td>Size</td>
					<td>
						<form:input path="size" /> <br />
					</td>
				</tr>
				<tr>
					<td>Image url</td>
					<td>
						<form:input path="imageUrl" /> <br />
					</td>
				</tr>
				<tr>
					<td>Category</td>
					<td>
						<form:input path="category.category" /> <br />
					</td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">Submit</button></td>
				</tr>
			</table>
		</form:form>

		<h2>Product List</h2>
		<table>
			<tr>
                <td><strong>id</strong></td>
				<td><strong>name</strong></td>
				<td><strong>overview</strong></td>
				<td><strong>weight</strong></td>
				<td><strong>imageUrl</strong></td>
				<td><strong>category</strong></td>
				<td><strong>price</strong></td>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.overview}</td>
                    <td>${product.weight}</td>
                    <td>${product.imageUrl}</td>
                    <td>${product.category.category}</td>
                    <td>${product.price}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>