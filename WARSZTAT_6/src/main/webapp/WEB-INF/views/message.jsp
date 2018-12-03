<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wiadomosc</title>
</head>
<body>


    <c:forEach items="${users}" var="u">
        <a href="/message/${u.id}">${u.name}</a><br/>
    </c:forEach>

</body>
</html>
