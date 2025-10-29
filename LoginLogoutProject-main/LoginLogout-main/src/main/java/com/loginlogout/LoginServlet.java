package com.loginlogout;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("""
            <html>
                <head>
                    <title>Login Page</title>
                    <style>
                        body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; margin-top: 100px; }
                        form { background: white; display: inline-block; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
                        input { margin: 8px; padding: 8px; width: 80%; }
                        input[type=submit] { background-color: #4CAF50; color: white; border: none; cursor: pointer; width: 88%; }
                        input[type=submit]:hover { background-color: #45a049; }
                    </style>
                </head>
                <body>
                    <h2>Login</h2>
                    <form method='post' action='/login'>
                        <input type='text' name='username' placeholder='Username' required><br>
                        <input type='password' name='password' placeholder='Password' required><br>
                        <input type='submit' value='Login'>
                    </form>
                </body>
            </html>
        """);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("admin".equals(username) && "password".equals(password)) {
            request.getSession().setAttribute("user", username);
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<a href='/logout'>Logout</a>");
        } else {
            out.println("<h3>Invalid credentials! Please try again.</h3>");
            out.println("<a href='/login'>Back to Login</a>");
        }
    }
}
