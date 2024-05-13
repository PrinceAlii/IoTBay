package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import uts.isd.model.User;

public class SystemAdminDAO {

    private Connection connection;

    public SystemAdminDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean checkUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM IOTBAY.User WHERE userEmail = ? AND userPassword = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean checkEmail(String email) throws SQLException {
        String query = "SELECT * FROM IOTBAY.User WHERE userEmail = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next();
            }
        }
    }

    public User findUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM IOTBAY.User WHERE userEmail = ? AND userPassword = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int userID = rs.getInt("userID");
                    String userName = rs.getString("userName");
                    String userContactNumber = rs.getString("userContactNumber");
                    String userType = rs.getString("userType");
                    String userAccount = rs.getString("userAccount");
                    boolean userStatus = rs.getBoolean("userStatus");
                    String userPosition = rs.getString("userPosition");
                    String paymentID = rs.getString("paymentID");
                    return new User(userID, userName, email, password, userContactNumber, userType, userAccount, userStatus, userPosition, paymentID);
                }
            }
        }
        return null;
    }

    public void addUser(String name, String email, String password, String phone, String userType, String userAccount) throws SQLException {
        String query = "INSERT INTO IOTBAY.User (userName, userEmail, userPassword, userContactNumber, userType, userAccount) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, phone);
            statement.setString(5, userType);
            statement.setString(6, userAccount);
            statement.executeUpdate();
        }
    }

    public void updateUser(String name, String email, String password, String phone) throws SQLException {
        String query = "UPDATE IOTBAY.User SET userName = ?, userPassword = ?, userContactNumber = ? WHERE userEmail = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.executeUpdate();
        }
    }

    public void deleteUser(String email) throws SQLException {
        String query = "DELETE FROM IOTBAY.User WHERE userEmail = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.executeUpdate();
        }
    }

    public ArrayList<User> fetchUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM IOTBAY.User";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String userName = rs.getString("userName");
                String userEmail = rs.getString("userEmail");
                String userPassword = rs.getString("userPassword");
                String userContactNumber = rs.getString("userContactNumber");
                String userType = rs.getString("userType");
                String userAccount = rs.getString("userAccount");
                boolean userStatus = rs.getBoolean("userStatus");
                String userPosition = rs.getString("userPosition");
                String paymentID = rs.getString("paymentID");
                users.add(new User(userID, userName, userEmail, userPassword, userContactNumber, userType, userAccount, userStatus, userPosition, paymentID));
            }
        }
        return users;
    }

    public void close() {
        // TODO: Implement closing connection
    }
}
