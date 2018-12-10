<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Użytkownicy</title>
</head>
<body>

    <c:import url="../header.jsp"/>

    <c:forEach items="${users}" var="u">
        <a href="/user/${u.id}">${u.name}</a><br/>
    </c:forEach>

</body>
</html>
