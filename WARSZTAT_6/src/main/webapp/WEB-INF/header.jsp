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
            <c:if test="${inHome}">
                <a href="/register">Zarejestruj się</a><br/>
                <a href="/login">Zaloguj się</a><br/>
            </c:if>
            <c:if test="${inLoggin}">
                <a href="/register">Zarejestruj się</a><br/>
            </c:if>
            <c:if test="${inRegister}">
                <a href="/login">Zaloguj się</a><br/>
            </c:if>
        </c:if>
        <c:if test="${user != null}">
            <a href="/logout">Wyloguj się</a><br/>
            <a href="/article">Wpisy</a><br/>
            <a href="/user">Użytkownicy</a><br/>
        </c:if>
    </header><br/>
</body>
</html>
