package uts.unit;

import org.junit.jupiter.api.Test;

import uts.isd.model.dao.PaymentDAO;
import uts.isd.model.dao.DBConnector;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

public class PaymentDAOTest {
    
    private DBConnector connector;
    private Connection conn;
    private PaymentDAO paymentDAO;

    public PaymentDAOTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        paymentDAO = new PaymentDAO();
    }
    
    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }

    @Test
    public void testFindPaymentByUser() throws SQLException {
        paymentDAO.findPaymentByUser(1); 
    }

    @Test
    public void testAddPayment() throws SQLException {
        paymentDAO.addPayment("Visa", "1234567890123456", 1); 
    }

    // @Test
    // public void testDeletePayment() throws SQLException {
    //     paymentDAO.deletePayment(1); 
    // }

    @Test
    public void testIsUserDefaultPayment() throws SQLException {
        paymentDAO.isUserDefaultPayment(1, 1); 
    }

    @Test
    public void testGetPaymentHistoryByDate() throws SQLException {
        paymentDAO.getPaymentHistoryByDate(1, new java.sql.Date(System.currentTimeMillis()));
    }

    @Test
    public void testGetPaymentHistoryByPaymentIDAndDate() throws SQLException {
        paymentDAO.getPaymentHistoryByPaymentIDAndDate(1, 1, new java.sql.Date(System.currentTimeMillis())); 
    }

    @Test
    public void testGetPaymentHistory() throws SQLException {
        paymentDAO.getPaymentHistory(1); 
    }

    @Test
    public void testGetPaymentHistoryByPaymentID() throws SQLException {
        paymentDAO.getPaymentHistoryByPaymentID(1, 1); 
    }

    @Test
    public void testUpdatePayment() throws SQLException {
        paymentDAO.updatePayment(1, "MasterCard", "9876543210987654"); 
    }

    @Test
    public void testCloseConnection() throws SQLException {
        paymentDAO.closeConnection();
    }
}
