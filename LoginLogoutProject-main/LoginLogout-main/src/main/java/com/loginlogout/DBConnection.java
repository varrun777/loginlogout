package com.loginlogout;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) return connection;
        try {
            String url = "jdbc:mariadb://localhost:3306/userdb?useSSL=false&allowPublicKeyRetrieval=true";
            String user = "root";      
            String password = "jyo6379978188";      
            
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
