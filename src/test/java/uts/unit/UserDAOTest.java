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

    // private char readChoice() {
    //     System.out.print("Operation CRUDS or * to exit: ");
    //     return in.nextLine().charAt(0);
    // }

    // private void runQueries() throws SQLException {
    //     char c;

    //     while ((c = readChoice()) != '*') {
    //         switch (c){
    //             case 'C':
    //                 testAdd();
    //                 break;
    //             case 'R':
    //                 testRead();
    //                 break;
    //             case 'U':
    //                 testUpdate();
    //                 break;
    //             case 'D':
    //                 //testDelete();
    //                 break;
    //             case 'S':
    //                 //showAll();
    //                 break;
    //             default:
    //                 System.out.println("Unknown Command");
    //                 break;
    //         } 
    //     }
    // }

    // private void testAdd() {
    //     System.out.println("Username: ");
    //     String name = in.nextLine();
    //     System.out.println("User Email: ");
    //     String email = in.nextLine();
    //     System.out.println("User Password: ");
    //     String password = in.nextLine();
    //     try{
    //         userDAO.addUser(name, email, password, 0);
    //     } catch (SQLException ex) {
    //         Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE,null, ex);
    //     }
    //     System.out.println("User is added to the database");     
    // }

    // private void testRead() throws SQLException {
    //     System.out.println("User Email: ");
    //     String email =in.nextLine();
    //     System.out.println("User Password: ");
    //     String password =in.nextLine();
    //     User user = userDAO.checkUser(email,password);
    //     if(user != null) {
    //         System.out.println("User" + user.getName() + " exists in database.");
    //     }else {
    //         System.out.println("Student does not exist.");
    //     }
    // }
    
    // private void testUpdate() {
    //     System.out.println("User Email: ");
    //     String email = in.nextLine();
    //     System.out.println("User Password: ");
    //     String password = in.nextLine();
    
    //     try {
    //         if (userDAO.checkUser(email, password) != null) {
    //             System.out.println("Username: ");
    //             String name = in.nextLine();
    //             System.out.println("User number: ");
    //             // Correct way to read an integer
    //             int contactNumber = Integer.parseInt(in.nextLine());
    //             userDAO.updateUser(name, email, password, contactNumber);
    //         } else {
    //             System.out.println("User does not exist.");
    //         }
    //     } catch (SQLException ex) {
    //         Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE,null, ex);
    //     }
    // }
    
    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }

    @Test
    public void testAdd() throws SQLException {
        userDAO.addUser("alex","alex@jj.com","Pass123","123452254");
    }


    @Test
    public void testUpdate() throws SQLException {
        userDAO.updateUser("John","John@jj.com","pAss11","124452254");
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
    public void testDelete() throws SQLException {
        userDAO.deleteUser("John@jj.com");
    }






}