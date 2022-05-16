<!DOCTYPE HTML>
<%--
  Created by IntelliJ IDEA.
  User: patry
  Date: 05.03.2022
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wspólny edytor</title>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
    <script>
        tinymce.init({
            selector: '#mytextarea',
            height: '480',
        });
    </script>
</head>
<body>
<h1>Wspólny edytor</h1>
<p>Twórz dokumenty ze wszystkimi. Daj coś od siebie</p>

<%
    String text = (String) request.getServletContext().getAttribute("text");
    if(text == null)
        text = "";
%>
<form action="" method="post">
    <textarea id="mytextarea" name="text"><%=text%></textarea>
    <input type="submit" value="Zapisz zmiany">
</form>

</body>
</html>
