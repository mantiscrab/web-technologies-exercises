<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - YouTube Player</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<%
    String[] videos = request.getParameterMap().get("video");
    if(videos==null)
        out.println("<h1>Brak parametru video w adresie URL</h1>");
    else {
        out.println("<h1>Parametr video znajduje się w adresie URL</h1>");
        for (final String video : videos) {
            out.println("<iframe type=\"text/html\" width=\"640\" height=\"360\"" +
                    " src=\"http://www.youtube.com/embed/" + video + "?\"" +
                    " frameborder=\"0\"/></iframe>");
            System.out.println(video);
        }
    }


%>



</body>
</html>