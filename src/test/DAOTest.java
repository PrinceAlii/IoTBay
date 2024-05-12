package uts.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.sql.Connection;
import java.sql.SQLException;
 
import org.junit.jupiter.api.test;

import uts.isd.model.dao.DBConnector;

public class DAOTest {

    private DBConnector connector;
    private Connection conn;

    public DAOtest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
    }
    @Test
    
     public void testConnection() throws SQLException {
        assertNotNull(conn);
     }
    
}
