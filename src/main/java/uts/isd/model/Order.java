package uts.isd.model;

import java.io.Serializable;

public class Order implements Serializable {

  private String orderID;
  private int userID;
  private String paymentID;
  private int orderAmount;
  private String orderDate;

  public Order() {
  }

  public Order(String _orderID, int _userID, String _paymentID, int _orderAmount, String _orderDate) {
    this.orderID = _orderID;
    this.userID = _userID;
    this.paymentID = _paymentID;
    this.orderAmount = _orderAmount;
    this.orderDate = _orderDate;
  }

  public String getOrderID() {
    return orderID;
  }

  public void setOrderID(String orderID) {
    this.orderID = orderID;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public String getPaymentID() {
    return paymentID;
  }

  public void setPaymentID(String paymentID) {
    this.paymentID = paymentID;
  }

  public int getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(int orderAmount) {
    this.orderAmount = orderAmount;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }
}
