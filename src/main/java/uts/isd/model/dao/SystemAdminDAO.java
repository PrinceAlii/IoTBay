package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uts.isd.model.User;

public class SystemAdminDAO {

    private Connection conn;

    public SystemAdminDAO(Connection conn) {
        this.conn = conn;
    }

    public void updateUser(int userID, String name, String email, String phone, String userType, String userAccount, boolean userStatus) throws SQLException {
        String updateQuery = "UPDATE User SET userName=?, userEmail=?, userContactNumber=?, userType=?, userAccount=?, userStatus=? WHERE userID=?";
        try (PreparedStatement ps = conn.prepareStatement(updateQuery)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, userType);
            ps.setString(5, userAccount);
            ps.setBoolean(6, userStatus);
            ps.setInt(7, userID);
            ps.executeUpdate();
        }
    }

    public ArrayList<User> fetchUsers(String name, String phone) {
        throw new UnsupportedOperationException("Unimplemented method 'fetchUsers'");
    }

}