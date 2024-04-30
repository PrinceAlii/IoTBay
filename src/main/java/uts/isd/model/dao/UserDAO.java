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
                return new User(userEmail, userName, userContactNumber, userPassword, userID); 
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

    public boolean checkUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.User WHERE userEmail = '" + email + "' AND userPassword='" + password + "'";
        ResultSet rs = readSt.executeQuery(fetch);

        while (rs.next()){
            String userEmail = rs.getString(5);
            String userPassword = rs.getString(8);
            if (userEmail.equals(email) && userPassword.equals(password)){
                return true;
            }
        }
        return false;
    }
}

    // public ArrayList<User> fetchUsers() throws SQLException {
    //     ResultSet rs = readSt.executeQuery();

    //     ArrayList<User> users = new ArrayList<User>();

    //     while(rs.next()) {
    //         String firstName = rs.getString(1);
    //         String lastName = rs.getString(2);
    //         User u = new User();
    //         u.setName(firstName + " " + lastName);

    //         System.out.println(u.getName());
            
    //         users.add(u);
    //     }
      
    //     return users;
    // }


