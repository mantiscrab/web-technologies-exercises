package com.example.postexercise;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/verify")
public class PasswordVerifierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passwordText = request.getParameter("password");
        Password password = new Password(passwordText);
        sendResponse(password, response);
    }

    private void sendResponse(final Password password, final HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println(
            "<!DOCTYPE html>" + System.lineSeparator() +
            "<html lang=\"en\">" + System.lineSeparator() +
            "<head>"  + System.lineSeparator() +
            "    <meta charset=\"UTF-8\">"  + System.lineSeparator() +
            "    <title>Weryfikator haseł</title>" + System.lineSeparator() +
            "</head>" + System.lineSeparator() +
            "<body>" + System.lineSeparator() +
            "<h1>Twoje hasło to: " + password.getPassword() + "</h1>"  + System.lineSeparator()
        );

        if(password.isStrong()) {
            writer.println(
                    "<p>Hasło spełnia wszystkie wymogi bezpieczeństwa</p>" + System.lineSeparator()
            );
        } else {
            writer.println("<ul>");
            if(!password.isLongEnough())
                writer.println("<li>Hasło ma zbyt mało znaków</li>" + System.lineSeparator());
            if(!password.hasUpperCase())
                writer.println("<li>Hasło nie zawiera dużych liter</li>" + System.lineSeparator());
            if(!password.hasLowerCase())
                writer.println("<li>Hasło nie zawiera małych liter</li>" + System.lineSeparator());
            if(!password.hasDigit())
                writer.println("<li>Hasło nie zawiera cyfr</li>" + System.lineSeparator());
            writer.println("</ul>");
        }

        writer.println(
            "</body>" + System.lineSeparator() +
            "</html>  "
        );

    }
}
