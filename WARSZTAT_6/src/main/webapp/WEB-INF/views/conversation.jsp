<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rozmowa</title>
    <style>
        .error{
            color: red;
        }
        body{
            text-align: center;
        }
        #messages, .message{
            display: inline-block;
        }
        .message{
            margin-top: 10px;
            width: 300px;
            min-height: 50px;
            border: 1px solid black;
            border-radius: 5px;
            background-color: darkgray;
        }
    </style>
</head>
<body>

    <h3><a href="/">Strona główna</a></h3>

    <form:form method="post" modelAttribute="messageDto">


        <label>
            Napisz wiadomosc:<br/>
            <form:input path="description"/>
            <form:errors path="description" cssClass="error"/>
        </label><br/>


        <input type="submit"/>
    </form:form>


    <div id="messages">
        <c:forEach items="${messages}" var="m">
            <div class="message">
                ${m.fromUser.name}  >>> ${m.toUser.name}<br/>
                ${m.description}<br/>
                ${m.date}<br/>
            </div><br/>
        </c:forEach>
    </div>
</body>
</html>
