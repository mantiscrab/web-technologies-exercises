package com.example.mvcexercise;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/verify")
public class VerifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LotteryResult guessedResult = ResultCounter.countResult(request.getParameterValues("guess"));
        request.setAttribute("result", guessedResult);
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }
}
