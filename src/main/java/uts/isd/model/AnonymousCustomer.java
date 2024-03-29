package uts.isd.model;

import java.io.Serializable;

public class AnonymousCustomer implements Serializable {
    
    private int userID;
    private String paymentID;
    private String orderID;

    public AnonymousCustomer() {
    }

    public AnonymousCustomer(int _userID, String _paymentID, String _orderID) {
    this.userID = _userID;
    this.paymentID = _paymentID;
    this.orderID = _orderID;

}

    public int getUserID() {
        return userID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPaymentID (String paymentID) {
        this.paymentID = paymentID;
    }

    public void setOrderID (String orderID) {
        this.orderID = orderID;
    }

}
