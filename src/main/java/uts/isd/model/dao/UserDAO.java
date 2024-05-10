package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uts.isd.model.User;


public class UserDAO {
 
    private Statement st;

//acess logs login/logout
//access logs search
//update and delete
//test cases for all userDAO that have an SQL code in it
// staff


    public UserDAO (Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();

    }

    //check if user is already in the database. Return if user is already in database
    public boolean checkUser(String email, String password) throws SQLException {
        // System.out.println(email);
        // System.out.println(password);

        String fetch = "SELECT * FROM IOTBAY.User WHERE userEmail = '" + email + "' AND userPassword='" + password + "'";

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()){
            String userEmail = rs.getString(5);
            String userPassword = rs.getString(8);
            if (userEmail.equals(email) && userPassword.equals(password)){
                return true;
            }
        }
        return false;
    }

    //check if user is already in the database. Return if user is already in database
    public boolean checkEmail(String email) throws SQLException {
        // System.out.println(email);

        String fetch = "SELECT * FROM IOTBAY.User WHERE userEmail = '" + email + "'";

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()){
            String userEmail = rs.getString(5);
            if (userEmail.equals(email)){
                return true;
            }
        }
        return false;
    }

    // find user by email in database, and return that users info
    public User findUser(String email, String password) throws SQLException {

        String fetch = "SELECT * FROM IOTBAY.User WHERE userEmail = '" + email + "' AND userPassword='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()){
            String userEmail = rs.getString(5);
            String userPassword = rs.getString(8);
            String userName = rs.getString(4);
            int userID = rs.getInt(1);
            String userContactNumber = rs.getString(6);
            String userType = rs.getString(2);
            String userAccount = rs.getString(3);
            boolean userStatus = rs.getBoolean(7);
            String userPosition = rs.getString(9);
            String PaymentID = rs.getString(10);

            User user = new User(userID,userName, userEmail, userPassword, userContactNumber, userType, userAccount, userStatus,
            userPosition, PaymentID);
            return user;
        }
        return null;
    }

    //add a user-data into the database
    public void addUser(String name, String email, String password, String phone) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAY.User (userName, userEmail, userPassword, userContactNumber)" + "VALUES('" + name + "', '" + email + "', '" + password + "', '" + phone + "')");
    }

    //update a user-data into the database
    public void updateUser(String name, String email, String password, String phone) throws SQLException {
        // System.out.println(name);
        // System.out.println(email);
        // System.out.println(password);
        st.executeUpdate("UPDATE IOTBAY.User SET userName='" + name + "', userContactNumber='" + phone + "', userEmail='" + email + "', userPassword='"+ password +"' WHERE userEmail ='"+ email +"'" );
    }

    //delete a user-data from the database
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.User WHERE userEmail='" + email + "'" );
    }

    //adds a ccount log to the table when logging out
    public void addlogslogout(int userID) throws SQLException {
        String logout1 = "Logged Out";
        String fetch = "INSERT INTO IOTBAY.UserAccessLogs (UserID, STATUS ,CurrentTime) VALUES (" + userID + ",'" + logout1 + "',CURRENT_TIMESTAMP)";
        st.executeUpdate(fetch);
    }

    //adds a loging log to the account log table when signing in
    public void addlogslogin(int userID) throws SQLException {
        String login1 = "Logged In";
        String fetch = "INSERT INTO IOTBAY.UserAccessLogs (UserID, STATUS ,CurrentTime) VALUES (" + userID + ",'" + login1 + "',CURRENT_TIMESTAMP)";
        st.executeUpdate(fetch);
    }

    //adds a register log ti the account table when registering
    public void addlogsregister(int userID) throws SQLException {
        String Register1 = "Registered";
        String fetch = "INSERT INTO IOTBAY.UserAccessLogs (UserID, STATUS ,CurrentTime) VALUES (" + userID + ",'" + Register1 + "',CURRENT_TIMESTAMP)";
        st.executeUpdate(fetch);
    }

     // get userID by email in database
     public int getUserID(String email, String password) throws SQLException {

        String fetch = "SELECT * FROM IOTBAY.User WHERE userEmail = '" + email + "' AND userPassword='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()){

            int userID = rs.getInt(1);
            String userEmail = rs.getString(5);
            String userPassword = rs.getString(8);

            if (userEmail.equals(email) && userPassword.equals(password)){
                return userID;
            }
        }
        return 0;
    }


    // get user Status Logs based off userID
    public ArrayList getStatusLogs(int userID) throws SQLException {
        
        ArrayList statuslist = new ArrayList();
        
        String fetch = "SELECT * FROM IOTBAY.UserAccessLogs WHERE UserID =" + userID;
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String status = rs.getString(2);

            statuslist.add(status);

        }
        return statuslist;
    }

    // Get user time Logs depending on User ID
    public ArrayList getTimeLogs(int userID) throws SQLException {
        
        ArrayList timelist = new ArrayList();
        
        String fetch = "SELECT * FROM IOTBAY.UserAccessLogs WHERE UserID =" + userID;
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String timedate = rs.getString(3);

            timelist.add(timedate);
        }
        System.out.println(timelist);
        return timelist;
    }












    // public ArrayList<User> fetchUsers() throws SQLException {
    //     String fetch = "SELECT * FROM IOTBAY.User";
    //     ResultSet rs = readSt.executeQuery(fetch);
    //     ArrayList<User> users = new ArrayList();

    //     while(rs.next()) {
    //         String userEmail = rs.getString(5);
    //         String userName = rs.getString(4);
    //         String userPassword = rs.getString(8);
    //         int userID = rs.getInt(1);
    //         int userContactNumber = rs.getInt(6);
    //         String userType = rs.getString(2);
    //         String userAccount = rs.getString(3);
    //         boolean userStatus = rs.getBoolean(7);
    //         String userPosition = rs.getString(9);
    //         String PaymentID = rs.getString(10);
    //         users.add(new User(userID,userName, userEmail, userPassword, userContactNumber, userType, userAccount, userStatus,
    //         userPosition, PaymentID));
    //     }
    //     return users;
    // }
}



