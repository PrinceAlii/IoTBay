package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import uts.isd.model.UserAccessLogs;
import uts.isd.model.User;


public class UserDAO {
 
    private Statement st;
    private Connection conn; // (ALI)


    public UserDAO (Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();

    }

    // (ALI)
    public UserDAO() throws ClassNotFoundException, SQLException { 
        DBConnector dbConnector = new DBConnector();
        conn = dbConnector.openConnection();
        conn.setAutoCommit(true);
        st = conn.createStatement();
    }
    

    //check if user is already in the database. Return if user is already in database
    public boolean checkUser(String email, String password) throws SQLException {

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
        String userType = "User";
        String accountType = "Registered User";
        int userStatus = 1;

        st.executeUpdate("INSERT INTO IOTBAY.User (userType, userAccount, userName, userEmail, userPassword, userContactNumber, userStatus) " + 
            "VALUES('" + userType + "', '" + accountType + "', '" + name + "', '" + email + "', '" + password + "', '" + phone + "', " + userStatus + ")");
    }

    //update a user-data into the database
    public void updateUser(String name, String email, String password, String phone) throws SQLException {
        st.executeUpdate("UPDATE IOTBAY.User SET userName='" + name + "', userContactNumber='" + phone + "', userEmail='" + email + "', userPassword='"+ password +"' WHERE userEmail ='"+ email +"'" );
    }

    //delete a user-data from the database
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.User WHERE userEmail='" + email + "'" );
    }

    //adds a ccount log to the table when logging out
    public void addlogslogout(int userID) throws SQLException {
        String logout1 = "Logged Out";
        String fetch = "INSERT INTO IOTBAY.UserAccessLogs (UserID, STATUS, Date, Time) VALUES (" + userID + ", '" + logout1 + "', CURRENT_DATE, CURRENT_TIME)";
        st.executeUpdate(fetch);
    }

    //adds a loging log to the account log table when signing in
    public void addlogslogin(int userID) throws SQLException {
        String login1 = "Logged In";
        String fetch = "INSERT INTO IOTBAY.UserAccessLogs (UserID, STATUS, Date, Time) VALUES (" + userID + ", '" + login1 + "', CURRENT_DATE, CURRENT_TIME)";
        st.executeUpdate(fetch);
    }

    //adds a register log ti the account table when registering
    public void addlogsregister(int userID) throws SQLException {
        String Register1 = "Registered";
        String fetch = "INSERT INTO IOTBAY.UserAccessLogs (UserID, STATUS, Date, Time) VALUES (" + userID + ", '" + Register1 + "', CURRENT_DATE, CURRENT_TIME)";
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

    // Get user time Logs depending on User ID
    public ArrayList<UserAccessLogs> getAllLogs(int userID) throws SQLException {
        
        ArrayList<UserAccessLogs> logList = new ArrayList<UserAccessLogs>();
        
        String fetch = "SELECT * FROM IOTBAY.UserAccessLogs WHERE UserID =" + userID;
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {

            Date date = rs.getDate(4);
            Time time = rs.getTime(5);
            int user = rs.getInt(2);
            String status = rs.getString(3);

            UserAccessLogs log = new UserAccessLogs(date.toString(),time.toString(), user, status);  
            logList.add(log);
        }
        return logList;
    }


    public void deleteAllLogs(int userID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.UserAccessLogs WHERE UserID =" + userID);
    }

    public ArrayList<UserAccessLogs> searchLogByDate(String logAccessDate, int userID) throws SQLException {

        ArrayList<UserAccessLogs> logList = new ArrayList<UserAccessLogs>();

        String fetch = "SELECT * FROM IOTBAY.UserAccessLogs WHERE Date = '" + logAccessDate + "' AND UserID = " + userID;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {

            Date date = rs.getDate(4);
            Time time = rs.getTime(5);
            int user = rs.getInt(2);
            String status = rs.getString(3);

            UserAccessLogs log = new UserAccessLogs(date.toString(),time.toString(), user, status);  
            logList.add(log);
        }
        return logList;
    }

    public void updateUserPaymentID(int userID, int paymentID) throws SQLException {
        st.executeUpdate("UPDATE user SET paymentID = " + paymentID + " WHERE userID = " + userID);
        }
}



