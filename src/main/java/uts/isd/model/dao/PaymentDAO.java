package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import uts.isd.model.Order;
import uts.isd.model.PaymentDetails;

public class PaymentDAO {

    private Statement st;
    private Connection conn;

    public PaymentDAO() throws ClassNotFoundException, SQLException {
        DBConnector dbConnector = new DBConnector();
        conn = dbConnector.openConnection();
        conn.setAutoCommit(true);
        st = conn.createStatement();
    }


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
    
        return paymentDetailsList;
    }


    public void addPayment(String paymentMethod, String cardNumber, int userID) throws SQLException {

        String cardNumberTrimmed = cardNumber.substring(cardNumber.length() - 4);

        st.executeUpdate("INSERT INTO IOTBAY.paymentdetails (paymentMethod, paymentCardDetails, userID, savedPaymentDetails) VALUES ('" +  paymentMethod + "', '" + cardNumberTrimmed + "', " + userID + ", 1)");
    }
    

    public void deletePayment(int paymentID) throws SQLException {

        st.executeUpdate("UPDATE IOTBAY.user SET paymentID = NULL WHERE paymentID = " + paymentID);
        st.executeUpdate("DELETE FROM IOTBAY.paymentdetails WHERE paymentID = " + paymentID);
    }

    
    public boolean isUserDefaultPayment(int paymentID, int userID) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isDefault = false;

        try {
            String query = "SELECT * FROM IOTBAY.user WHERE paymentID = ? AND userID = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, paymentID);
            stmt.setInt(2, userID);
            rs = stmt.executeQuery();
            isDefault = rs.next();

        } finally {

        }

        return isDefault;
    }
    

    public List<Order> getPaymentHistoryByDate(int userID, Date searchDate) throws SQLException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM IOTBAY.order WHERE userID = ? AND DATE(orderLogTimestamp) = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userID);
            stmt.setDate(2, new java.sql.Date(searchDate.getTime())); 
            rs = stmt.executeQuery();
            

            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("orderID"));
                order.setUserID(rs.getInt("userID"));
                order.setPaymentID(rs.getInt("paymentID"));
                order.setOrderAmount(rs.getInt("orderAmount"));
                order.setOrderLogTimestamp(rs.getDate("orderLogTimestamp"));
                orders.add(order);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {}
        return orders;
    }
    
    
    public List<Order> getPaymentHistoryByPaymentIDAndDate(int userID, int paymentID, Date searchDate) throws SQLException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM IOTBAY.order WHERE userID = ?");
            if (paymentID != 0) {
                queryBuilder.append(" AND paymentID = ?");
            }
            if (searchDate != null) {
                queryBuilder.append(" AND orderLogTimestamp >= ? AND orderLogTimestamp < DATE_ADD(?, INTERVAL 1 DAY)");
            }
    
            String query = queryBuilder.toString();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userID);
            
            int paramIndex = 2; 
            
            if (paymentID != 0) {
                stmt.setInt(paramIndex++, paymentID);
            }
            
            if (searchDate != null) {
                stmt.setDate(paramIndex++, new java.sql.Date(searchDate.getTime()));
                stmt.setDate(paramIndex++, new java.sql.Date(searchDate.getTime())); 
            }
    
            rs = stmt.executeQuery();
    
    
        } catch (SQLException ex) {
            throw ex;
        } finally {}
        return orders;
    }
    
    
    
    public List<Order> getPaymentHistory(int userID) throws SQLException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM IOTBAY.order WHERE userID = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userID);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("orderID"));
                order.setUserID(rs.getInt("userID"));
                order.setPaymentID(rs.getInt("paymentID"));
                order.setOrderAmount(rs.getInt("orderAmount"));
                order.setOrderLogTimestamp(rs.getDate("orderLogTimestamp"));
                orders.add(order);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {}
        return orders;
    }

    public List<Order> getPaymentHistoryByPaymentID(int userID, int paymentID) throws SQLException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM IOTBAY.order WHERE userID = ? AND paymentID = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userID);
            stmt.setInt(2, paymentID);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("orderID"));
                order.setUserID(rs.getInt("userID"));
                order.setPaymentID(rs.getInt("paymentID"));
                order.setOrderAmount(rs.getInt("orderAmount"));
                order.setOrderLogTimestamp(rs.getDate("orderLogTimestamp"));
                order.setProductID(rs.getInt("productID"));

                orders.add(order);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {}
        return orders;
    }
    
    
    
    
    

    public void closeConnection() throws SQLException {
        conn.close();
    }
}
