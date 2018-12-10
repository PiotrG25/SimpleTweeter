<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.name}</title>
</head>
<body>

    <c:import url="../header.jsp"/>

    <div id="articles">
        <c:forEach items="${articleAndCommentsCount}" var="a">
            <div class="article">
                    ${a.article.description}<br/>
                    ${a.article.date}<br/>
                <a href="/comment/${a.article.id}">komentarze(${a.commentsCount})</a><br/>
            </div><br/>
        </c:forEach>
    </div>

</body>
</html>
