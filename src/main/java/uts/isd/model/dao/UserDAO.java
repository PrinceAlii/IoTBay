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
    private String readQuery = "SELECT * FROM account";

    public UserDAO (Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
        readSt = connection.prepareStatement(readQuery);
    }

    public ArrayList<User> fetchUsers() throws SQLException {
        ResultSet rs = readSt.executeQuery();

        ArrayList<User> users = new ArrayList<User>();

        while(rs.next()) {
            String firstName = rs.getString(1);
            String lastName = rs.getString(2);
            User u = new User();
            u.setName(firstName + " " + lastName);

            System.out.println(u.getName());
            
            users.add(u);
        }
      
        return users;
    }

}
