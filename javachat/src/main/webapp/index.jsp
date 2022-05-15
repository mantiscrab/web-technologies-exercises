<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>JavaChat</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div id="welcome-div">
    <h1>Witaj na JavaCzacie!</h1>
    <p>Poniżej widzisz historię konwersacji. Możesz do niej dołączyć</p>
</div>
<div id="message-div">
    <c:choose>
        <c:when test="${empty applicationScope.messages}">
            <p>Nie przesłano jeszcze żadnej wiadomości. Rozpocznij konwersację.</p>
        </c:when>
        <c:otherwise>
            <c:set value="iteration" var="1"/>
            <c:forEach var="message" items="${applicationScope.messages}">
                <c:if test="${iteration%2=='0'}">
                    <p class="dimgray">
                        <c:out value="${message}"></c:out>
                    </p>
                </c:if>
                <c:if test="${iteration%2=='1'}">
                    <p class="gray">
                        <c:out value="${message}"></c:out>
                    </p>
                </c:if>
                <c:set var="iteration" value="${iteration+1}"/>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    <form id="message" method="post">
        <textarea form="message" name="text" placeholder="Twoja wiadomość"></textarea><br/>
        <input type="text" name="author" placeholder="Twoja nazwa"><br/>
        <input type="submit" value="Wyślij">
    </form>
</div>
</body>
</html>


<c:out value="${message}"></c:out>
