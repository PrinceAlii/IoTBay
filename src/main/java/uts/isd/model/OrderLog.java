package uts.isd.model;

import java.io.Serializable;

public class OrderLog implements Serializable {

  private String orderLogTimestamp;
  private String orderID;

  public OrderLog() {
  }

  public OrderLog(String _orderLogTimestamp, String _orderID) {
    this.orderLogTimestamp = _orderLogTimestamp;
    this.orderID = _orderID;
  }

  public String getOrderLogTimestamp() {
    return orderLogTimestamp;
  }

  public void setOrderLogTimestamp(String orderLogTimestamp) {
    this.orderLogTimestamp = orderLogTimestamp;
  }

  public String getOrderID() {
    return orderID;
  }

  public void setOrderID(String orderID) {
    this.orderID = orderID;
  }
}
