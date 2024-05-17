package uts.unit;

import org.junit.jupiter.api.Test;

import uts.isd.model.dao.AdminStaffDAO;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.Product;
import uts.isd.model.User;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdminStaffDAOTest {

    private DBConnector connector;
    private Connection conn;
    private AdminStaffDAO adminStaffDAO;

    @Test
    public void testAddStaff() throws SQLException {
        adminStaffDAO.addStaff(new User("staff", "john_doe", "John Doe", "john@example.com", "123456789", "password123", "Manager"));
        assertTrue(adminStaffDAO.fetchStaff().stream().anyMatch(user -> user.getName().equals("John Doe")));
    }

    @Test
    public void testUpdateStaff() throws SQLException {
        User userToUpdate = new User(1, "staff", "john_doe", "John Doe", "john@example.com", "123456789", "newpassword", "Manager", true);
        adminStaffDAO.updateStaff(userToUpdate);
        User updatedUser = adminStaffDAO.fetchStaff().stream().filter(u -> u.getUserID() == 1).findFirst().orElse(null);
        assertNotNull(updatedUser);
        assertEquals("newpassword", updatedUser.getPassword());
    }

    @Test
    public void testDeleteStaff() throws SQLException {
        assertTrue(adminStaffDAO.deleteStaff(2));
    }

    @Test
    public void testCheckUserIDExists() throws SQLException {
        assertTrue(adminStaffDAO.checkUserIDExists(3));
    }

    @Test
    public void testCheckUserAccountIsStaff() throws SQLException {
        assertTrue(adminStaffDAO.checkUserAccountIsStaff(4));
    }

    @Test
    public void testFetchStaff() throws SQLException {
        ArrayList<User> staffList = adminStaffDAO.fetchStaff();
        assertNotNull(staffList);
    }

    @Test
    public void testSearchStaffByName() throws SQLException {
        ArrayList<User> staffList = adminStaffDAO.searchStaffByName("John");
        assertNotNull(staffList);
    }

    @Test
    public void testSearchStaffByNameAndPosition() throws SQLException {
        ArrayList<User> staffList = adminStaffDAO.searchStaffByNameAndPosition("John", "Manager");
        assertNotNull(staffList);
    }
}
