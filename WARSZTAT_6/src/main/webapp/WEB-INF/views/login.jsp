<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>

    <h3><a href="/">Strona główna</a></h3>

    <form:form method="post" modelAttribute="userLoginDto">


        <label>
            Email:<br/>
            <form:input path="email"/>
            <form:errors path="email" cssClass="error"/>
        </label><br/>

        <label>
            Hasło:<br/>
            <form:password path="password"/>
            <form:errors path="password" cssClass="error"/>

            <c:if test="${error}"><span class="error">Niewłaściwy email lub hałso</span></c:if>
        </label><br/>


        <input type="submit" value="Zaloguj się"/>
    </form:form>
</body>
</html>
