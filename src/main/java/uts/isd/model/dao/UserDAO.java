package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uts.isd.model.User;


public class UserDAO {
 
    private Statement st;
    private PreparedStatement readSt;


    public UserDAO (Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
    }

    //find user by email in database
    public User findUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.User WHERE userEmail = '" + email + "' AND userPassword='" + password + "'";
        ResultSet rs = readSt.executeQuery(fetch);

        while (rs.next()){
            String userEmail = rs.getString(5);
            String userPassword = rs.getString(8);
            if (userEmail.equals(email) && userPassword.equals(password)){
                String userName = rs.getString(4);
                int userID = rs.getInt(1);
                int userContactNumber = rs.getInt(6);
                String userType = rs.getString(2);
                String userAccount = rs.getString(3);
                boolean userStatus = rs.getBoolean(7);
                String userPosition = rs.getString(9);
                String PaymentID = rs.getString(10);
                return new User(userID,userName, userEmail, userPassword, userContactNumber, userType, userAccount, userStatus,
                userPosition, PaymentID); 
            }
        }
        return null;
    }

    //add a user-data into the database
    public void addUser(String name, String email, String password, int contactNumber) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAY.User (userName, userEmail, userPassword, userContactNumber)" + "VALUES('" + name + "', '" + email + "', '" + password + "', '" + contactNumber + "')");
    }

    //update a user-data into the database
    public void updateUser(String name, String email, String password, int contactNumber) throws SQLException {
        st.executeUpdate("UPDATE IOTBAY.User SET userName='" + name + "', userContactNumber='" + contactNumber + "', userEmail='" + email + "', userPassword='"+ password +"' WHERE userEmail ='"+ email +"'" );
    }

    //delete a user-data from the database
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.User WHERE userEmail='" + email + "'" );
    }

    public User checkUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.User WHERE userEmail = '" + email + "' AND userPassword='" + password + "'";
        ResultSet rs = readSt.executeQuery(fetch);

        while (rs.next()){
            String userEmail = rs.getString(5);
            String userPassword = rs.getString(8);
            if (userEmail.equals(email) && userPassword.equals(password)){
                String userName = rs.getString(4);
                int userID = rs.getInt(1);
                int userContactNumber = rs.getInt(6);
                String userType = rs.getString(2);
                String userAccount = rs.getString(3);
                boolean userStatus = rs.getBoolean(7);
                String userPosition = rs.getString(9);
                String PaymentID = rs.getString(10);
                return new User(userID,userName, userEmail, userPassword, userContactNumber, userType, userAccount, userStatus,
                userPosition, PaymentID);
            }
        }
    return null;
    }

    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.User";
        ResultSet rs = readSt.executeQuery(fetch);
        ArrayList<User> users = new ArrayList();

        while(rs.next()) {
            String userEmail = rs.getString(5);
            String userName = rs.getString(4);
            String userPassword = rs.getString(8);
            int userID = rs.getInt(1);
            int userContactNumber = rs.getInt(6);
            String userType = rs.getString(2);
            String userAccount = rs.getString(3);
            boolean userStatus = rs.getBoolean(7);
            String userPosition = rs.getString(9);
            String PaymentID = rs.getString(10);
            users.add(new User(userID,userName, userEmail, userPassword, userContactNumber, userType, userAccount, userStatus,
            userPosition, PaymentID));
        }
        return users;
    }
}


