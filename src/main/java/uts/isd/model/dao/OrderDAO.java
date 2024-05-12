package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uts.isd.model.Order;

public class OrderDAO {
    private Connection conn;

    public OrderDAO() throws ClassNotFoundException, SQLException {
        DBConnector dbConnector = new DBConnector();
        conn = dbConnector.openConnection();
    }
    // find orders based on the provided parameters
    public List<Order> findOrders(int userID, Integer orderID, Date orderDate) throws SQLException {
        List<Order> orderDetailList = new ArrayList<>();
        StringBuilder fetchQuery = new StringBuilder("SELECT * FROM IOTBAY.Order WHERE userID = ?");

        if (orderID != null) {
            fetchQuery.append(" AND orderID = ?");
        }
        if (orderDate != null) {
            fetchQuery.append(" AND CAST(orderLogTimestamp AS DATE) = ?");
        }

        PreparedStatement stmt = conn.prepareStatement(fetchQuery.toString());
        stmt.setInt(1, userID);
        int paramIndex = 2;

        if (orderID != null) {
            stmt.setInt(paramIndex++, orderID);
        }
        if (orderDate != null) {
            stmt.setDate(paramIndex, new java.sql.Date(orderDate.getTime()));
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int fetchedOrderID = rs.getInt("orderID");
            int productID = rs.getInt("productID");
            int orderAmount = rs.getInt("orderAmount");
            java.sql.Timestamp orderLogTimestamp = rs.getTimestamp("orderLogTimestamp");
            int productQuantity = rs.getInt("productQuantity");
            Date orderDateFromDB = new Date(orderLogTimestamp.getTime());

            // creating an Order object with the retrieved order details and adding it to the list
            Order order = new Order(fetchedOrderID, userID, productID, orderAmount, orderDateFromDB, productQuantity);
            orderDetailList.add(order);
        }

        return orderDetailList; // returning the list of order detail
    }

    public void closeConnection() throws SQLException { // close the database connection
        conn.close();
    }
}