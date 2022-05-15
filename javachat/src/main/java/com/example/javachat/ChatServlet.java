package com.example.javachat;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"", "/index"})
public class ChatServlet extends HttpServlet {

    public static final String MESSAGES = "messages";

    @Override
    public void init() {
        getServletContext().setAttribute(MESSAGES, new ArrayList<Message>());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String text = request.getParameter("text");
        ArrayList<Message> messages = (ArrayList<Message>) getServletContext().getAttribute(MESSAGES);
        messages.add(new Message(author, text));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        String messagesToString = getServletContext().getAttribute(MESSAGES).toString();
        messagesToString = messagesToString.substring(1, messagesToString.length() - 1);
        messagesToString = messagesToString.replaceAll(", ", System.lineSeparator());
        System.out.println(messagesToString);
    }
}
