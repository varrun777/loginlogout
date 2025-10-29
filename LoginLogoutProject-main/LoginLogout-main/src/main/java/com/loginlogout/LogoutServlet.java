package com.loginlogout;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>You have been logged out.</h3>");
        out.println("<a href='/login.html'>Login Again</a>");
    }
}
