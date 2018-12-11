<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj Nazwę</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>

    <c:import url="../header.jsp"/>

    <form:form method="post" modelAttribute="userEditNameDto">

        <label>
            Nowa nazwa:<br/>
            <form:input path="name"/>
            <form:errors path="name" cssClass="error"/>
        </label><br/>

        <label>
            Potwierdź hasłem:<br/>
            <form:password path="password"/>
            <form:errors path="password" cssClass="error"/>
            <c:if test="${wrongPassword}"><span class="error">Niewłaściwe hasło</span></c:if>
        </label><br/>

        <input type="submit" value="Zmień nazwę"/><br/>
    </form:form><br/>
</body>
</html>
