package uts.unit;

import org.junit.jupiter.api.Test;

import uts.isd.model.User;
import uts.isd.model.dao.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDAOTest {
    
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private UserDAO userDAO;

    public UserDAOTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        userDAO = new UserDAO(conn);
    }
    
    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }

    @Test
    public void testAdd() throws SQLException {
        userDAO.addUser("John","John@jj.com","Pass123","123452254");
    }

    @Test
    public void testUpdate() throws SQLException {
        userDAO.updateUser("John","John@jj.com","pAss11","33333333");
    }

    @Test
    public void testFindUser() throws SQLException {
        userDAO.findUser("John@jj.com", "pAss11");
    }

    @Test
    public void testCheckEmail() throws SQLException {
        userDAO.checkEmail("John@jj.com");
    }

    @Test
    public void testCheckUser() throws SQLException {
        userDAO.checkUser("John@jj.com","pAss11");
    }

    @Test
    public void testGetUserID() throws SQLException {
        userDAO.getUserID("John@jj.com","pAss11");
    }

    @Test
    public void testAddlogslogin() throws SQLException {
        userDAO.addlogslogin(1);
    }

    @Test
    public void testAddlogslogout() throws SQLException {
        userDAO.addlogslogout(1);
    }

    @Test
    public void testAddlogsregister() throws SQLException {
        userDAO.addlogsregister(1);
    }

    @Test
    public void testGetAllLogs() throws SQLException {
        userDAO.getAllLogs(1);
    }

    @Test
    public void testSearchLogByDat() throws SQLException {
        userDAO.searchLogByDate("2024-05-14",1);
    }

    @Test
    public void testDeleteAllLogs() throws SQLException {
        userDAO.deleteAllLogs(1);
    }

    @Test
    public void testDelete() throws SQLException {
        userDAO.deleteUser("John@jj.com");
    }
}