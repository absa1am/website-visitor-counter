package com.example.visitorcounter;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();

        Object pageCounter = servletContext.getAttribute("pageVisitorCounter");

        if (pageCounter == null) {
            servletContext.setAttribute("pageVisitorCounter", 0L);
        } else {
            servletContext.setAttribute("pageVisitorCounter", (Long) pageCounter + 1);
        }

        System.out.println(servletContext.getAttribute("pageVisitorCounter"));

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}