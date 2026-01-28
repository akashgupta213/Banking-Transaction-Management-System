package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import java.util.ArrayList;
import java.util.List;

public class Service {

    public Connection myConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/DBName";
        String user = "your_userName";
        String password = "your_mysql_password";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public void saveAccountRecords(Account acc) {
        String query = "INSERT INTO bank (acc_number, cust_name, balance) VALUES (?, ?, ?)";
        try (Connection con = myConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, acc.getAccNumber());
            ps.setString(2, acc.getCustName());
            ps.setDouble(3, acc.getBalance());

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Record saved successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(String accNumber) {
        String query = "DELETE FROM bank WHERE acc_number = ?";
        try (Connection con = myConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, accNumber);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println(" No record found with account number " + accNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(Account acc) {
        String query = "UPDATE bank SET cust_name = ?, balance = ? WHERE acc_number = ?";
        try (Connection con = myConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, acc.getCustName());
            ps.setDouble(2, acc.getBalance());
            ps.setString(3, acc.getAccNumber());

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found with account number " + acc.getAccNumber());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchRecord(String accNumber) {
        String query = "SELECT * FROM bank WHERE acc_number = ?";
        try (Connection con = myConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, accNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Record Found:");
                System.out.println("Account Number : " + rs.getString("acc_number"));
                System.out.println("Customer Name  : " + rs.getString("cust_name"));
                System.out.println("Balance        : " + rs.getDouble("balance"));
            } else {
                System.out.println("⚠️ No record found with account number " + accNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllRecords() {
        String query = "SELECT * FROM bank";

        try (Connection con = myConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            boolean hasRecords = false;
            while (rs.next()) {
                hasRecords = true;
                System.out.println("-------------------------------");
                System.out.println("Account Number : " + rs.getString("acc_number"));
                System.out.println("Customer Name  : " + rs.getString("cust_name"));
                System.out.println("Balance        : " + rs.getDouble("balance"));
            }
            if (!hasRecords) {
                System.out.println("No records found in the database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> fetchAllRecords() {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM bank";

        try (Connection con = myConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Account acc = new Account();
                acc.setAccNumber(rs.getString("acc_number"));
                acc.setCustName(rs.getString("cust_name"));
                acc.setBalance(rs.getDouble("balance"));
                accounts.add(acc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }
}
