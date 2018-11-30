<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello
    <c:choose>
        <c:when test="${user == null}">
            World!
        </c:when>
        <c:when test="${user != null}">
            ${user.name}
        </c:when>
    </c:choose>
    </h1>
    <a href="/register">/register</a><br/>
    <a href="/login">/login</a><br/>
    <a href="/logout">/logout</a><br/>
    <a href="/article">/article</a><br/>
    <a href=""></a><br/>
</body>
</html>
