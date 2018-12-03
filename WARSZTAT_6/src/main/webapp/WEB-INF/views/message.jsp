<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wiadomosc</title>
</head>
<body>

    <form method="post">
        <select name="userId" >
            <c:forEach items="${users}" var="u">
                <option value="${u.id}">${u.name}</option>
            </c:forEach>
        </select>
        <input type="submit"/>
    </form>

</body>
</html>
