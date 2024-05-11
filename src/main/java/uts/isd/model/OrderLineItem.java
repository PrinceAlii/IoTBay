package uts.isd.model;

import java.io.Serializable;

public class OrderLineItem implements Serializable {

  private int orderLineItemID; 
  private int orderID;
  private int productID;
  private int orderQuantity;

  public OrderLineItem() {
  }

  public OrderLineItem(int _orderLineItemID, int _orderID, int _productID, int _orderQuantity) {
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

  public int getOrderID() {
    return orderID;
  }

  public void setOrderID(int orderID) {
    this.orderID = orderID;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public int getOrderQuantity() {
    return orderQuantity;
  }

  public void setOrderQuantity(int orderQuantity) {
    this.orderQuantity = orderQuantity;
  }
}
