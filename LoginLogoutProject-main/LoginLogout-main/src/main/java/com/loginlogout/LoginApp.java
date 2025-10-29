package com.loginlogout;

import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO dao = new UserDAO();

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (dao.validateUser(username, password)) {
            System.out.println("✅ Login successful! Welcome, " + username);
            System.out.println("Type 'logout' to exit:");
            String cmd = sc.nextLine();
            if (cmd.equalsIgnoreCase("logout")) {
                System.out.println("👋 Logged out successfully.");
            }
        } else {
            System.out.println("❌ Invalid username or password.");
        }
        sc.close();
    }
}
