<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.mvcexercise.LotteryResult" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Wynik</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    LotteryResult lotteryResult = (LotteryResult) request.getAttribute("result");
    List<Integer> chosenNumbers = lotteryResult.getChosenNumbers();
    List<Integer> winningNumbers = lotteryResult.getWinningNumbers();
    List<Integer> guessedNumbers = lotteryResult.getGuessedNumbers();
    long result = lotteryResult.getResult();
%>
<div>
    <h2>Wynik losowania: <%=winningNumbers%>
    </h2>
    <h2>Twoje liczby: <%=chosenNumbers%>
    </h2>
    <h2>Liczba trafień: <%=result%>
    </h2>
    <h2>Trafione liczby: <%=guessedNumbers%>
    </h2>
</div>
</body>
</html>
