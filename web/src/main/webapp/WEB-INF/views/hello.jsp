<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>${message}</h2>
    <h1>${title}</h1>
    <p>
        <c:if test="${not empty name}">
            Hello ${name}
        </c:if>

        <c:if test="${empty name}">
            Welcome Welcome!
        </c:if>
    </p>
</body>
</html>
