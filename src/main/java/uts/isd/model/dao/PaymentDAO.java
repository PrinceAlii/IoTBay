package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uts.isd.model.PaymentDetails;

public class PaymentDAO {

    private Connection conn;

    public PaymentDAO() throws ClassNotFoundException, SQLException {
        // Create a new instance of DBConnector to establish a database connection
        DBConnector dbConnector = new DBConnector();
        // Open the database connection
        conn = dbConnector.openConnection();
    }

    // Add other methods for interacting with the database
    // ...

    public List<PaymentDetails> findPaymentByUser(int userID) throws SQLException {
        List<PaymentDetails> paymentDetailsList = new ArrayList<>();
    
        String fetch = "SELECT * FROM IOTBAY.paymentdetails WHERE userID = ?";
        PreparedStatement stmt = conn.prepareStatement(fetch);
        stmt.setInt(1, userID);
        ResultSet rs = stmt.executeQuery();
    
        while (rs.next()) {
            int paymentID = rs.getInt(1);
            String paymentMethod = rs.getString(2);
            String paymentCardDetails = rs.getString(3);
            boolean savedPaymentDetails = rs.getBoolean(4);
            int userIDDB = rs.getInt(5);
    
            PaymentDetails payments = new PaymentDetails(paymentID, paymentMethod, paymentCardDetails, savedPaymentDetails, userIDDB);
            paymentDetailsList.add(payments);
        }
    
        // Print the retrieved payment details to the console for debugging
        System.out.println("Retrieved Payment Details: " + paymentDetailsList);
    
        return paymentDetailsList;
    }
    

    // Add other methods for interacting with the database
    // ...

    public void closeConnection() throws SQLException {
        // Close the database connection when it's no longer needed
        conn.close();
    }
}