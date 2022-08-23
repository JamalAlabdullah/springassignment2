package no.noroff.accelerate.springassignment2.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgradDAO {
    // Default values that can be overridden
    private String url = "jdbc:postgresql://localhost:5432/chinook";
    private String username = "postgres";
    private String password = "postgres";

    public PostgradDAO() {
        test();
    }

    private void selectCustomers(){

    }

    public void test() {
        try(Connection conn = DriverManager.getConnection(url, username,password);) {
            System.out.println("Connected to Postgres...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PostgradDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
}