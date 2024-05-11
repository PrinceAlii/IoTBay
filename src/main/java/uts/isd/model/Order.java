package uts.isd.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private int orderID;
    private int userID;
    private int productID;
    private int orderAmount;
    private Date orderLogTimestamp;
    private int productQuantity;

    public Order() {
    }

    public Order(int _orderID, int _userID, int _productID, int _orderAmount, Date _orderLogTimestamp, int _productQuantity) {
        this.orderID = _orderID;
        this.userID = _userID;
        this.productID = _productID;
        this.orderAmount = _orderAmount;
        this.orderLogTimestamp = _orderLogTimestamp;
        this.productQuantity = _productQuantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getOrderLogTimestamp() {
        return orderLogTimestamp;
    }

    public void setOrderLogTimestamp(Date orderLogTimestamp) {
        this.orderLogTimestamp = orderLogTimestamp;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
