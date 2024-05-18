package uts.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uts.isd.model.dao.AdminStaffDAO;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.Product;
import uts.isd.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdminStaffDAOTest {

    private Connection connection;
    private AdminStaffDAO adminStaffDAO;

    @BeforeEach
    public void setUp() {
        try {
            DBConnector dbConnector = new DBConnector();
            connection = dbConnector.openConnection();
            adminStaffDAO = new AdminStaffDAO(dbConnector);
        } catch (ClassNotFoundException | SQLException e) {
            // Handle the exception or log it appropriately
            e.printStackTrace();
        }
    }

    @Test
    public void testAddStaff() throws SQLException {
        User userToAdd = new User();
        userToAdd.setUserType("Company");
        userToAdd.setUserAccount("Staff");
        userToAdd.setName("John Doe");
        userToAdd.setEmail("john@example.com");
        userToAdd.setPassword("Password123");
        userToAdd.setPhone("2525252525");
        userToAdd.setUserPosition("Manager");
        adminStaffDAO.addStaff(userToAdd);
    }

    @Test
    public void testUpdateStaff() throws SQLException {
        User userToUpdate = new User();
        userToUpdate.setName("Daniel White");
        userToUpdate.setEmail("DanielWhite@mail.com");
        userToUpdate.setPassword("Password123");
        userToUpdate.setPhone("1919191919");
        userToUpdate.setUserType("Company");
        userToUpdate.setUserAccount("Staff");
        userToUpdate.setUserPosition("Salesperson");
        userToUpdate.setUserStatus(true);
        userToUpdate.setUserID(13);
        adminStaffDAO.updateStaff(userToUpdate);
    }

    @Test
    public void testDeleteStaff() throws SQLException {
        assertTrue(adminStaffDAO.deleteStaff(118));
    }

    @Test
    public void testCheckUserIDExists() throws SQLException {
        assertTrue(adminStaffDAO.checkUserIDExists(3));
    }

    @Test
    public void testCheckUserAccountIsStaff() throws SQLException {
        assertTrue(adminStaffDAO.checkUserAccountIsStaff(13));
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
