<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>

    <%
        request.setAttribute("inRegister", true);
    %>
    <c:import url="../header.jsp"/>

    <form:form method="post" modelAttribute="userRegisterDto">


        <label>
            Nazwa:<br/>
            <form:input path="name" type="text"/>
            <form:errors path="name" cssClass="error"/>
        </label><br/>

        <label>
            Hasło:<br/>
            <form:password path="password"/>
            <form:errors path="password" cssClass="error"/>
        </label><br/>

        <label>
            Powtórz hasło:<br/>
            <form:password path="confirmPassword"/>
            <form:errors path="confirmPassword" cssClass="error"/>

            <c:if test="${differentPassword}"><span class="error">różne hasła</span></c:if>
        </label><br/>

        <label>
            Email:<br/>
            <form:input path="email" type="email"/>
            <form:errors path="email" cssClass="error"/>

            <c:if test="${emailTaken}"><span class="error">Ten email jest już zajęty</span></c:if>
        </label><br/>


        <input type="submit" value="Zarejestruj sie"/>
    </form:form>
</body>
</html>
