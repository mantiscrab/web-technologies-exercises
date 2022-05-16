package com.example.contextexercise;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("")
public class SaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attributeName = "text";
        String attributeValue = request.getParameter(attributeName);
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute(attributeName,attributeValue);
        System.out.println(servletContext.getAttribute(attributeName));
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
