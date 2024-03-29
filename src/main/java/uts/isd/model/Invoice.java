package uts.isd.model;

import java.io.Serializable;

public class Invoice implements Serializable {

  private int invoiceID;
  private String orderID;
  private String paymentID;
  private String invoiceDate;

  public Invoice() {
  }

  public Invoice(int _invoiceID, String _orderID, String _paymentID, String _invoiceDate) {
    this.invoiceID = _invoiceID;
    this.orderID = _orderID;
    this.paymentID = _paymentID;
    this.invoiceDate = _invoiceDate;
  }


  public int getInvoiceID() {
    return invoiceID;
  }

  public void setInvoiceID(int invoiceID) {
    this.invoiceID = invoiceID;
  }

  public String getOrderID() {
    return orderID;
  }

  public void setOrderID(String orderID) {
    this.orderID = orderID;
  }

  public String getPaymentID() {
    return paymentID;
  }

  public void setPaymentID(String paymentID) {
    this.paymentID = paymentID;
  }

  public String getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(String invoiceDate) {
    this.invoiceDate = invoiceDate;
  }
}
