package com.example.guestbook;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = {"", "/", "/guestbook"})
public class EntryController extends HttpServlet {
    private final EntryDAO entryDAO = new EntryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Entry> allEntries = entryDAO.findAll();
        Collections.reverse(allEntries);
        request.setAttribute("allEntries", allEntries);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String content = request.getParameter("content");
        Entry entry = new Entry(author, content);
        entryDAO.save(entry);
        response.sendRedirect("guestbook");
    }
}
