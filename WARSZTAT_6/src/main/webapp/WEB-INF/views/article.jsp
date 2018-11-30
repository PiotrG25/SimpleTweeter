<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artykuly</title>
    <style>
        body{
            text-align: center;
        }
        #articles, .article{
            display: inline-block;
        }
        .article{
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

    <div class="article">
        <form:form method="post" modelAttribute="articleDto">
            <label>
                Dodaj artykul:<br/>
                <form:textarea path="description"/>
                <form:errors path="description"/>
            </label><br/>

            <input type="submit" value="Dodaj post"/>
        </form:form>
    </div><br/>


    <div id="articles">
        <c:forEach items="${articles}" var="a">
            <div class="article">
                ${a.user.name}<br/>
                ${a.description}<br/>
                ${a.date}<br/>
                <a href="/comment/${a.id}">komentarze</a><br/>
            </div><br/>
        </c:forEach>
    </div>
</body>
</html>
