package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uts.isd.model.User;

public class AdminStaffDAO {

    private final Connection conn;

    public AdminStaffDAO(DBConnector dbConnector) {
        this.conn = dbConnector.openConnection();
    }

    // Method to add a new staff record to the database
    public void addStaff(User user) throws SQLException {
        String query = "INSERT INTO User (userType, userAccount, userName, userEmail, userContactNumber, userPassword, userPosition) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, user.getUserType());
            statement.setString(2, user.getUserAccount());
            statement.setString(3, user.getName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getPassword());
            statement.setString(7, user.getUserPosition());
            statement.executeUpdate();
        }
    }

    // Method to update an existing staff record in the database
    public void updateStaff(User user) throws SQLException {
        String query = "UPDATE User SET userName=?, userEmail=?, userPassword=?, userContactNumber=?, userType=?, userAccount=?, userPosition=?, userStatus=? WHERE userID=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getUserType());
            statement.setString(6, user.getUserAccount());
            statement.setString(7, user.getUserPosition());
            statement.setBoolean(8, user.isUserStatus());
            statement.setInt(9, user.getUserID());
            statement.executeUpdate();
        }
    }

    // Method to delete a staff record from the database
    public boolean deleteStaff(int userID) throws SQLException {
        String query = "DELETE FROM User WHERE userID=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, userID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // Method to check if the user with the given user ID exists
    public boolean checkUserIDExists(int userID) throws SQLException {
        String query = "SELECT COUNT(*) FROM User WHERE userID=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, userID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    // Method to check if the user account is "staff"
    public boolean checkUserAccountIsStaff(int userID) throws SQLException {
        String query = "SELECT userAccount FROM User WHERE userID=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, userID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String userAccount = resultSet.getString("userAccount");
                    return "staff".equalsIgnoreCase(userAccount);
                }
            }
        }
        return false;
    }

    // Method to fetch all staff members from the database
    public ArrayList<User> fetchStaff() throws SQLException {
        ArrayList<User> staffList = new ArrayList<>();
        String query = "SELECT * FROM User WHERE userAccount = 'staff'";
        try (PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setName(resultSet.getString("userName"));
                user.setEmail(resultSet.getString("userEmail"));
                user.setPhone(resultSet.getString("userContactNumber"));
                user.setUserPosition(resultSet.getString("userPosition"));
                staffList.add(user);
            }
        }
        return staffList;
    }

    // Method to search staff by name in the database
    public ArrayList<User> searchStaffByName(String searchKeyword) throws SQLException {
        ArrayList<User> staffList = new ArrayList<>();
        String query = "SELECT * FROM User WHERE userAccount = 'staff' AND userName LIKE ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, "%" + searchKeyword + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setUserID(resultSet.getInt("userID"));
                    user.setName(resultSet.getString("userName"));
                    user.setEmail(resultSet.getString("userEmail"));
                    user.setPhone(resultSet.getString("userContactNumber"));
                    user.setUserPosition(resultSet.getString("userPosition"));
                    staffList.add(user);
                }
            }
        }
        return staffList;
    }

    // Method to search staff by name and position in the database
    public ArrayList<User> searchStaffByNameAndPosition(String searchKeyword, String userPosition) throws SQLException {
        ArrayList<User> staffList = new ArrayList<>();
        String query = "SELECT * FROM User WHERE userAccount = 'staff' AND userName LIKE ? AND (userPosition = ? OR userPosition = 'Administrator')";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, "%" + searchKeyword + "%");
            statement.setString(2, userPosition);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setUserID(resultSet.getInt("userID"));
                    user.setName(resultSet.getString("userName"));
                    user.setEmail(resultSet.getString("userEmail"));
                    user.setPhone(resultSet.getString("userContactNumber"));
                    user.setUserPosition(resultSet.getString("userPosition"));
                    staffList.add(user);
                }
            }
        }
        return staffList;
}


}
