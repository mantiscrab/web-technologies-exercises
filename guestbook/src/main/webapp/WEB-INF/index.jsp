<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Księga gości</title>
    <link rel="stylesheet" href="style.css">
    <style>
        div {
            text-align: center;
        }

        textarea {
            display: block;
            width: 100%;
            height: 100px;
            margin-left: 0;
            margin-right: 0;
        }

        p {
            margin: 5px;
        }
    </style>
</head>
<body>
<div>
    <h1>Księga gości</h1>
    <form id="entry" method="post">
        <fieldset>
            <legend>Zostaw po sobie ślad</legend>
            <p>
                <label for="author">Twoja nazwa</label>
                <input id="author" name="author" placeholder="Jan Kowalski" required>
            </p>
            <p>
                <label for="content">Treść wiadomości</label>
            </p>
            <p>
                <textarea id="content" name="content" form="entry" placeholder="Zacznij pisać..." required></textarea>
            </p>
            <input type="submit" value="Wyślij">
        </fieldset>
    </form>
    <c:if test="${not empty requestScope.allEntries}">
        <h2>Wasze wpisy(<c:out value="${fn:length(requestScope.allEntries)}"></c:out>)</h2>
        <c:forEach items="${requestScope.allEntries}" var="entry">
            <h3><c:out value="${entry.author}"></c:out></h3>
            <p><c:out value="${entry.content}"></c:out></p>
        </c:forEach>
    </c:if>
</div>

</body>
</html>