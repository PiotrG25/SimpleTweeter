<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj hasło</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>

    <c:import url="../header.jsp"/>

    <form:form method="post" modelAttribute="userEditPasswordDto">

        <label>
            Stare hasło:<br/>
            <form:password path="oldPassword"/>
            <form:errors path="oldPassword" cssClass="error"/>
            <c:if test="${wrongPassword}"><span class="error">Niewłaściwe hasło</span></c:if>
        </label><br/>

        <label>
            Nowe hasło:<br/>
            <form:password path="newPassword"/>
            <form:errors path="newPassword" cssClass="error"/>
        </label><br/>

        <label>
            Powtórz nowe hasło:<br/>
            <form:password path="newPassword2"/>
            <form:errors path="newPassword2" cssClass="error"/>
            <c:if test="${differentPasswords}"><span class="error">Różne hasła</span></c:if>
        </label><br/>

        <input type="submit" value="Zmień hasło"/>
    </form:form>

</body>
</html>
