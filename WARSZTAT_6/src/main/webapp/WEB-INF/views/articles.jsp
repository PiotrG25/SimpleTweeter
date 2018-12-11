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
        #articles, .comments{
            display: inline-block;
        }
        .article, .comment{
            display: inline-block;
            margin-top: 10px;
            width: 300px;
            min-height: 50px;
            border: 1px solid black;
            border-radius: 5px;
            background-color: darkgray;
        }
        .comments{
            padding: 0 0 10px 0;
        }
        .comment{
            width: 250px;
        }
    </style>
</head>
<body>

    <c:import url="../header.jsp"/>

    <div class="article">
        <form:form method="post" modelAttribute="articleDto">
            <label>
                Dodaj artykul:<br/>
                <form:input path="description"/>
                <form:errors path="description"/>
            </label><br/>

            <input type="submit" value="Dodaj post"/>
        </form:form>
    </div><br/>


    <div id="articles">
        <c:forEach items="${articlesAndComments}" var="a">
            <div class="article">
                ${a.article.user.name}<br/>
                ${a.article.description}<br/>
                ${a.article.date}<br/>

                <a href="" class="commentsButton">komentarze<c:if test="${a.commentsCount > 0}">(${a.commentsCount})</c:if> </a><br/>
                <div class="comments">
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
