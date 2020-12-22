package com.ballers.MyWebApp.Servlets;

// import jdk.incubator.jpackage.internal.Log;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ServletOne", value = "/servlet-one")
public class ServletOne extends HttpServlet {
    private String message;

    public void init() {
        message = "f java ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        System.out.println("Output: Hello servlet class");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}