<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
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

    <c:if test="${user == null}">
        <a href="/register">/register</a><br/>
        <a href="/login">/login</a><br/>
    </c:if>
    <c:if test="${user != null}">
        <a href="/logout">/logout</a><br/>
    </c:if>
    <a href="/article">/article</a><br/>
    <a href="/message">/message</a><br/>
</body>
</html>
