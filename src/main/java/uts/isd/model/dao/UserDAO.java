package uts.isd.model.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.plaf.nimbus.State;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

public class UserDAO {
    private Statement st;
    private PreparableStatement readSt;
    private String readQuery = "SELECT * FROM account";

    public UserDAO(Connection connection) throws SQL Exception {
        connection.setAutoCommit(true);
        readSt = connection.prepareStatement(readQuery);
    }

    public ArrayList<User> fethUsers () throws SQLException {
        Resultset rs = readSt.executeQuery();

        ArrayList<User> users = new ArrayList<User>();
        while (rs.next()) {
            String firstName = rs.getString
        }
    }
    
}
