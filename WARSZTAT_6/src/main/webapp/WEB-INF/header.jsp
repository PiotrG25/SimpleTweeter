<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <header>
        <c:if test="${user == null}">
            <a href="/register">/register</a><br/>
            <a href="/login">/login</a><br/>
        </c:if>
        <c:if test="${user != null}">
            <a href="/logout">/logout</a><br/>
            <a href="/article">/article</a><br/>
            <a href="/message">/message</a><br/>
        </c:if>
    </header>
</body>
</html>
