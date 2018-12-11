<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.name}</title>
    <link rel="stylesheet" href="../../css/articles.css">
    <script src="../../js/articles.js"></script>
</head>
<body>

    <c:import url="../header.jsp"/>

    <h1>Użytkownik: ${thisUser.name}</h1>

    <a href="/message/${thisUser.id}">Wyślij wiedomość</a><br/><br/>

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
