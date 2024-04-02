package uts.isd.model;

import java.io.Serializable;

public class PurchaseLog implements Serializable {

  private String paymentDate;
  private int userID; 
  private int invoiceID;

  public PurchaseLog() {
  }

  public PurchaseLog(String _paymentDate, int _userID, int _invoiceID) {
    this.paymentDate = _paymentDate;
    this.userID = _userID;
    this.invoiceID = _invoiceID;
  }

  public String getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public int getInvoiceID() {
    return invoiceID;
  }

  public void setInvoiceID(int invoiceID) {
    this.invoiceID = invoiceID;
  }
}
