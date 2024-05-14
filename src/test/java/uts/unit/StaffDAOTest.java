package uts.unit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uts.isd.model.User;
import uts.isd.model.dao.StaffDAO;

public class StaffDAOTest {

    private static Connection connection;
    private StaffDAO staffDAO;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Setup connection to the database
        String dbURL = "jdbc:mysql://localhost:3306/IOTBAY";
        String username = "your_username";
        String password = "your_password";
        connection = DriverManager.getConnection(dbURL, username, password);
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        // Close the database connection
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @BeforeEach
    public void setUp() throws Exception {
        // Create a new StaffDAO object before each test
        staffDAO = new StaffDAO(connection);
    }

    @Test
    public void testCheckUser() throws SQLException {
        // Test the checkUser method
        assertTrue(staffDAO.checkUser("john.doe@example.com", "password123"));
        assertFalse(staffDAO.checkUser("invalid@example.com", "invalidpassword"));
    }

    @Test
    public void testCheckEmail() throws SQLException {
        // Test the checkEmail method
        assertTrue(staffDAO.checkEmail("john.doe@example.com"));
        assertFalse(staffDAO.checkEmail("invalid@example.com"));
    }

    @Test
    public void testFindUser() throws SQLException {
        // Test the findUser method
        User user = staffDAO.findUser("john.doe@example.com", "password123");
        assertNotNull(user);
        assertEquals("John Doe", user.getFullName());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testAddUser() throws SQLException {
        // Test the addUser method
        staffDAO.addUser("Jane", "jane.doe@example.com", "password456", "123456789");
        assertTrue(staffDAO.checkEmail("jane.doe@example.com"));
    }

    @Test
    public void testUpdateUser() throws SQLException {
        // Test the updateUser method
        staffDAO.updateUser("Jane", "jane.doe@example.com", "newpassword", 987654321);
        User user = staffDAO.findUser("jane.doe@example.com", "newpassword");
        assertNotNull(user);
        assertEquals("Jane", user.getFullName());
        assertEquals(987654321, user.getContactNumber());
    }

    @Test
    public void testDeleteUser() throws SQLException {
        // Test the deleteUser method
        staffDAO.deleteUser("jane.doe@example.com");
        assertFalse(staffDAO.checkEmail("jane.doe@example.com"));
    }

    

}
