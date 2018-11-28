<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>

    <form:form method="post" modelAttribute="userDto">


        <label>
            Nazwa:
            <form:input path="name" type="text"/>
        </label><br/>

        <label>
            Hasło:
            <form:password path="password"/>
        </label><br/>

        <label>
            Powtórz hasło:
            <form:password path="confirmPassword"/>
        </label><br/>

        <label>
            email:
            <form:input path="email" type="email"/>
        </label><br/>


        <input type="submit" value="Zarejestruj sie"/>
    </form:form>

</body>
</html>
