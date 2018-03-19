<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>online-shop</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/components.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/icons.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/responsee.css"/>">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

    </head>
    <body class="size-1280">
        <div>
            <header>
                <jsp:include page="header.jsp"></jsp:include>
            </header>

            <form action="editUsers">
                <button type="submit">Show user</button>
            </form>
            <form action="showProducts">
                <button type="submit">Show products</button>
            </form>

            <div class="line">
                <div class="box">
                        <div class="margin2x">
                           <!-- CONTENT -->
                           <section class="s-12 m-8 l-9 right">
                               <jsp:include page="content.jsp"></jsp:include>
                           </section>

                           <!-- ASIDE NAV -->
                           <aside class="s-12 m-4 l-3">
                                <jsp:include page="sideMenu.jsp"></jsp:include>
                           </aside>
                        </div>
                </div>
            </div>
            <footer class="line">
                <jsp:include page="footer.jsp"></jsp:include>
            </footer>
        </div>
    </body>
</html>