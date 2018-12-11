<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.name}</title>
    <link rel="stylesheet" href="../../css/articles.css">
    <script src="../../js/articles.js"></script>
    <style>
        .redzone{
            padding-top: 10px;
            display: inline-block;
            min-width: 200px;
            min-height: 50px;
            border: 1px solid red;
            border-radius: 5px;
            color: red;
        }
    </style>
</head>
<body>

    <c:import url="../header.jsp"/>

    <h1>Witaj ${user.name}</h1>

    <div class="redzone">
        <a href="/editName">Edytuj nazwę</a><br/><br/>
        <a href="/editPassword">Edytuj hasło</a>
    </div><br/><br/>

    <a href="/message/${user.id}">Wyślij wiadomość do siebie</a><br/><br/>

    <h3>Twoje wpisy:</h3>
    <div id="articles">
        <c:forEach items="${articlesAndComments}" var="a">
            <div class="article">
                    ${a.article.user.name}<br/>
                    ${a.article.description}<br/>
                    ${a.article.date}<br/>

                <a href="#" class="commentsButton">komentarze(${a.commentsCount})</a>
                <a href="/comment/${a.article.id}" >Dodaj komentarz</a><br/>

                <div class="comments hide">
                    <c:forEach items="${a.comments}" var="c">
                        <div class="comment">
                                ${c.user.name}<br/>
                                ${c.description}<br/>
                                ${c.date}<br/>
                        </div><br/>
                    </c:forEach>
                </div>
            </div><br/>
        </c:forEach>
    </div>
</body>
</html>
