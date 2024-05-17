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

}
