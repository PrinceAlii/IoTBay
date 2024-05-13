package uts.unit;

import org.junit.jupiter.api.Test;

//import uts.isd.model.User;
import uts.isd.model.dao.*;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
//import java.util.ArrayList;

public class DAOTest {
    
    private DBConnector connector;
    private Connection conn;
//    private UserDAO userDAO;

    public DAOTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        //userDAO = new UserDAO(conn);
    }

    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }
}
