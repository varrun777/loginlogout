package com.loginlogout;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class EmbeddedServer {
    public static void main(String[] args) throws Exception {
        // Create Jetty server on port 8080
        Server server = new Server(8080);

        // Create a servlet context
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // Map servlets to URLs
        context.addServlet(new ServletHolder(new LoginServlet()), "/login");
        context.addServlet(new ServletHolder(new LogoutServlet()), "/logout");

        // Attach context to server
        server.setHandler(context);

        System.out.println("✅ Server started at http://localhost:8080");
        System.out.println("Use /login or /logout");

        server.start();
        server.join();
    }
}
