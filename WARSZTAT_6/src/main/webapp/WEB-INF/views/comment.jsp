<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Komentarz</title>
    <style>
        body{
            text-align: center;
        }
        #comments{
            display: inline-block;
        }
        .comment, .article{
            display: inline-block;
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

    <c:import url="../header.jsp"/>

    <div class="article">
        ${article.user.name}<br/>
        ${article.description}<br/>
        ${article.date}<br/>
    </div><br/>


    <div class="comment">
        <form:form method="post" modelAttribute="commentDto">
            <label>
                Dodaj komentarz:<br/>
                <form:textarea path="description"/>
                <form:errors path="description"/>
            </label><br/>

            <input type="submit" value="Dodaj komentarz"/>
        </form:form>
    </div><br/>


    <div id="comments">
        <c:forEach items="${comments}" var="c">
            <div class="comment">
                ${c.user.name}<br/>
                ${c.description}<br/>
                ${c.date}<br/>
            </div><br/>
        </c:forEach>
    </div>
</body>
</html>
