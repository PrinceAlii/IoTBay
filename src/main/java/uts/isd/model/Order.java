// package uts.isd.model;

// import java.io.Serializable;

// public class Order implements Serializable {

//   private int orderID;
//   private int userID;
//   private int paymentID;
//   private int orderAmount;
//   private String orderDate;

//   public Order() {
//   }

//   public Order(int _orderID, int _userID, int _paymentID, int _orderAmount, String _orderDate) {
//     this.orderID = _orderID;
//     this.userID = _userID;
//     this.paymentID = _paymentID;
//     this.orderAmount = _orderAmount;
//     this.orderDate = _orderDate;
//   }

//   public int getOrderID() {
//     return orderID;
//   }

//   public void setOrderID(int orderID) {
//     this.orderID = orderID;
//   }

//   public int getUserID() {
//     return userID;
//   }

//   public void setUserID(int userID) {
//     this.userID = userID;
//   }

//   public int getPaymentID() {
//     return paymentID;
//   }

//   public void setPaymentID(int paymentID) {
//     this.paymentID = paymentID;
//   }

//   public int getOrderAmount() {
//     return orderAmount;
//   }

//   public void setOrderAmount(int orderAmount) {
//     this.orderAmount = orderAmount;
//   }

//   public String getOrderDate() {
//     return orderDate;
//   }

//   public void setOrderDate(String orderDate) {
//     this.orderDate = orderDate;
//   }
// }


//below is code i change to

package uts.isd.model;

import java.io.Serializable;
import java.util.Date; // Import Date for orderLogTimestamp

public class Order implements Serializable {

    private int orderID;
    private int userID;
    private int productID;
    private int orderAmount;
    private Date orderLogTimestamp; // Changed from String to Date
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
