package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uts.isd.model.Order;

public class OrderDAO {
    private Connection conn;

    public OrderDAO() throws ClassNotFoundException, SQLException {
        DBConnector dbConnector = new DBConnector();
        conn = dbConnector.openConnection();
    }

    public List<Order> findOrderByUser(int userID) throws SQLException {
        List<Order> orderDetailList = new ArrayList<>();
        String fetch = "SELECT * FROM IOTBAY.Order WHERE userID = ?";
        PreparedStatement stmt = conn.prepareStatement(fetch);
        stmt.setInt(1, userID);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int productID = rs.getInt("productID");
            int orderAmount = rs.getInt("orderAMount");
            java.sql.Timestamp orderLogTimestamp = rs.getTimestamp("orderLogTimestamp");
            int productQuantity = rs.getInt("productQuantity");

            // Converting SQL Timestamp to java.util.Date
            java.util.Date orderDate = new java.util.Date(orderLogTimestamp.getTime());

            Order order = new Order(orderID, userID, productID, orderAmount, orderDate, productQuantity);
            orderDetailList.add(order);
        }

        return orderDetailList;
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}
