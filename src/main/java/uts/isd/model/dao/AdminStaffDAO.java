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

    // You can add more methods here for retrieving, updating, or deleting staff records
}
