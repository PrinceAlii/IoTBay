package uts.isd.model;

import java.io.Serializable;

public class OrderLineItem implements Serializable {

  private int orderLineItemID; 
  private String orderID;
  private String productID;
  private int orderQuantity;

  public OrderLineItem() {
  }

  public OrderLineItem(int _orderLineItemID, String _orderID, String _productID, int _orderQuantity) {
    this.orderLineItemID = _orderLineItemID;
    this.orderID = _orderID;
    this.productID = _productID;
    this.orderQuantity = _orderQuantity;
  }


  public int getOrderLineItemID() {
    return orderLineItemID;
  }

  public void setOrderLineItemID(int orderLineItemID) {
    this.orderLineItemID = orderLineItemID;
  }

  public String getOrderID() {
    return orderID;
  }

  public void setOrderID(String orderID) {
    this.orderID = orderID;
  }

  public String getProductID() {
    return productID;
  }

  public void setProductID(String productID) {
    this.productID = productID;
  }

  public int getOrderQuantity() {
    return orderQuantity;
  }

  public void setOrderQuantity(int orderQuantity) {
    this.orderQuantity = orderQuantity;
  }
}
