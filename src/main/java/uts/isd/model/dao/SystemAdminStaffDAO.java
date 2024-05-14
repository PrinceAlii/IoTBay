package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import uts.isd.model.Staff;

public class SystemAdminStaffDAO {

    private Connection connection;

    public SystemAdminStaffDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean checkStaff(String email, String password) throws SQLException {
        String query = "SELECT * FROM IOTBAY.Staff WHERE staffEmail = ? AND staffPassword = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean checkEmail(String email) throws SQLException {
        String query = "SELECT * FROM IOTBAY.Staff WHERE staffEmail = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next();
            }
        }
    }

    public StaffDAO findStaff(String email, String password) throws SQLException {
        String query = "SELECT * FROM IOTBAY.Staff WHERE staffEmail = ? AND staffPassword = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int staffID = rs.getInt("staffID");
                    String staffName = rs.getString("staffName");
                    String staffContactNumber = rs.getString("staffContactNumber");
                    String staffType = rs.getString("staffType");
                    boolean staffStatus = rs.getBoolean("staffStatus");
                    String staffPosition = rs.getString("staffPosition");
                    return new StaffDAO(staffID, staffName, email, password, staffContactNumber, staffType, staffStatus, staffPosition);
                }
            }
        }
        return null;
    }

    public void addStaff(String name, String email, String password, String phone, String staffType) throws SQLException {
        String query = "INSERT INTO IOTBAY.Staff (staffName, staffEmail, staffPassword, staffContactNumber, staffType) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, phone);
            statement.setString(5, staffType);
            statement.executeUpdate();
        }
    }

    public void updateStaff(String name, String email, String password, String phone) throws SQLException {
        String query = "UPDATE IOTBAY.Staff SET staffName = ?, staffPassword = ?, staffContactNumber = ? WHERE staffEmail = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.executeUpdate();
        }
    }

    public void deleteStaff(String email) throws SQLException {
        String query = "DELETE FROM IOTBAY.Staff WHERE staffEmail = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.executeUpdate();
        }
    }

    public ArrayList<StaffDAO> fetchStaff() throws SQLException {
        ArrayList<StaffDAO> staffList = new ArrayList<>();
        String query = "SELECT * FROM IOTBAY.Staff";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int staffID = rs.getInt("staffID");
                String staffName = rs.getString("staffName");
                String staffEmail = rs.getString("staffEmail");
                String staffPassword = rs.getString("staffPassword");
                String staffContactNumber = rs.getString("staffContactNumber");
                String staffType = rs.getString("staffType");
                boolean staffStatus = rs.getBoolean("staffStatus");
                String staffPosition = rs.getString("staffPosition");
                staffList.add(new StaffDAO(staffID, staffName, staffEmail, staffPassword, staffContactNumber, staffType, staffStatus, staffPosition));
            }
        }
        return staffList;
    }

    public void close() {
        // You can add any necessary cleanup code here
    }

    public void addStaff(StaffDAO newStaff) throws SQLException {
        String query = "INSERT INTO IOTBAY.Staff (staffName, staffEmail, staffPassword, staffContactNumber, staffType) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newStaff.getName());
            statement.setString(2, newStaff.getEmail());
            statement.setString(3, (newStaff).getPassword());
            statement.setString(4, newStaff.getPhone());
            statement.setString(5, newStaff.getStaffType());
            statement.executeUpdate();
        }
    }
}
