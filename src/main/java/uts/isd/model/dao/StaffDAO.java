package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;

import uts.isd.model.User;

public class StaffDAO {

    private Statement st;

    public StaffDAO(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
    }

    public StaffDAO(String staffName, String staffEmail, String staffPassword) {
        //TODO Auto-generated constructor stub
    }

    public StaffDAO(String staffName, String staffEmail, String staffPassword) {
        //TODO Auto-generated constructor stub
    }

    // Check if user is already in the database. Return if user is already in database
    public boolean checkUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.User WHERE userEmail = '" + email + "' AND userPassword='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(5);
            String userPassword = rs.getString(8);
            if (userEmail.equals(email) && userPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Check if user is already in the database. Return if user is already in database
    public boolean checkEmail(String email) throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.User WHERE userEmail = '" + email + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(5);
            if (userEmail.equals(email)) {
                return true;
            }
        }
        return false;
    }

    // Find user by email in database, and return that user's info
    public User findUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.User WHERE userEmail = '" + email + "' AND userPassword='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int userID = rs.getInt(1);
            String userName = rs.getString(4);
            String userEmail = rs.getString(5);
            String userPassword = rs.getString(8);
            String userContactNumber = rs.getString(6);
            String userType = rs.getString(2);
            String userAccount = rs.getString(3);
            boolean userStatus = rs.getBoolean(7);
            String userPosition = rs.getString(9);
            String paymentID = rs.getString(10);

            return new User(userID, userName, userEmail, userPassword, userContactNumber, userType, userAccount, userStatus, userPosition, paymentID);
        }
        return null;
    }

    // Add a user-data into the database
    public void addUser(String name, String email, String password, String phone) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAY.User (userName, userEmail, userPassword, userContactNumber)" + "VALUES('" + name + "', '" + email + "', '" + password + "', '" + phone + "')");
    }

    // Update a user-data in the database
    public void updateUser(String name, String email, String password, int contactNumber) throws SQLException {
        st.executeUpdate("UPDATE IOTBAY.User SET userName='" + name + "', userContactNumber='" + contactNumber + "', userEmail='" + email + "', userPassword='" + password + "' WHERE userEmail ='" + email + "'");
    }

    // Delete a user-data from the database
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.User WHERE userEmail='" + email + "'");
    }

    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.User";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> users = new ArrayList();

        while (rs.next()) {
            int userID = rs.getInt(1);
            String userName = rs.getString(4);
            String userEmail = rs.getString(5);
            String userPassword = rs.getString(8);
            String userContactNumber = rs.getString(6);
            String userType = rs.getString(2);
            String userAccount = rs.getString(3);
            boolean userStatus = rs.getBoolean(7);
            String userPosition = rs.getString(9);
            String paymentID = rs.getString(10);
            users.add(new User(userID, userName, userEmail, userPassword, userContactNumber, userType, userAccount, userStatus, userPosition, paymentID));
        }
        return users;
    }

    @SuppressWarnings("rawtypes")
    public ArrayList<Stack> fetchStaff() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchStaff'");
    }

    public String getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }

    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    public String getPhone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPhone'");
    }

    public String getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    public String getStaffType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStaffType'");
    }

    public Object getFullName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFullName'");
    }
}
