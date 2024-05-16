package uts.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uts.isd.model.dao.AdminStaffDAO;
import uts.isd.model.dao.StaffDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminStaffDAOTest {

    private Connection connection;
    private AdminStaffDAO adminStaffDAO;

    @BeforeEach
    public void setUp() {
        // Set up the connection and AdminStaffDAO object before each test
        connection = // Set up your database connection here
        (Connection) (adminStaffDAO = new AdminStaffDAO(connection));
    }

    @Test
    public void testCheckStaff() throws SQLException {
        boolean result = adminStaffDAO.checkStaff("test@example.com", "password");
        assertTrue(result, "Staff exists in database");
    }

    @Test
    public void testCheckEmail() throws SQLException {
        boolean result = adminStaffDAO.checkEmail("test@example.com");
        assertTrue(result, "Email exists in database");
    }

    @Test
    public void testFindStaff() throws SQLException {
        StaffDAO staff = adminStaffDAO.findStaff("test@example.com", "password");
        assertNotNull(staff, "Staff exists in database");
    }

    @Test
    public void testAddStaff() throws SQLException {
        adminStaffDAO.addStaff("New Staff", "newstaff@example.com", "password", "1234567890", "Regular");
        StaffDAO staff = adminStaffDAO.findStaff("newstaff@example.com", "password");
        assertNotNull(staff, "New staff added successfully");
    }

    @Test
    public void testUpdateStaff() throws SQLException {
        adminStaffDAO.updateStaff("Updated Staff", "test@example.com", "newpassword", "9876543210");
        StaffDAO staff = adminStaffDAO.findStaff("test@example.com", "newpassword");
        assertNotNull(staff, "Staff updated successfully");
    }

    @Test
    public void testDeleteStaff() throws SQLException {
        adminStaffDAO.deleteStaff("test@example.com");
        boolean result = adminStaffDAO.checkEmail("test@example.com");
        assertFalse(result, "Staff deleted successfully");
    }

    @Test
    public void testFetchStaff() throws SQLException {
        ArrayList<StaffDAO> staffList = adminStaffDAO.fetchStaff();
        assertNotNull(staffList, "Fetched staff list successfully");
    }

}
