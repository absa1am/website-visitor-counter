package com.example.visitorcounter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "homeServlet", value = "/")
public class HomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();

        Object pageCounter = servletContext.getAttribute("pageVisitorCounter");

        if (pageCounter == null) {
            servletContext.setAttribute("pageVisitorCounter", 0L);
        } else {
            servletContext.setAttribute("pageVisitorCounter", (Long) pageCounter + 1);
        }

        System.out.println(servletContext.getAttribute("pageVisitorCounter"));

        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }

}
