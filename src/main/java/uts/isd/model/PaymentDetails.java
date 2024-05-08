package uts.isd.model;

import java.io.Serializable;

public class PaymentDetails implements Serializable {

  private int paymentID;
  private String paymentMethod;
  private String paymentCardDetails;
  private int userID;
  private boolean savedPaymentDetails;

  public PaymentDetails() {
  }

  public PaymentDetails(int _paymentID, String _paymentMethod, String _paymentCardDetails, boolean _savedPaymentDetails,
      int _userID) {
    this.paymentID = _paymentID;
    this.paymentMethod = _paymentMethod;
    this.paymentCardDetails = _paymentCardDetails;
    this.userID = _userID;
    this.savedPaymentDetails = _savedPaymentDetails;
  }

  public int getPaymentID() {
    return paymentID;
  }

  public void setPaymentID(int paymentID) {
    this.paymentID = paymentID;
  }

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public String getPaymentCardDetails() {
    return paymentCardDetails;
  }

  public void setPaymentCardDetails(String paymentCardDetails) {
    this.paymentCardDetails = paymentCardDetails;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public boolean isSavedPaymentDetails() {
    return savedPaymentDetails;
  }

  public void setSavedPaymentDetails(boolean savedPaymentDetails) {
    this.savedPaymentDetails = savedPaymentDetails;
  }

  @Override
  public String toString() {
    return "Payment ID: " + paymentID +
        ", Payment Method: " + paymentMethod +
        ", Payment Card Details: " + paymentCardDetails +
        ", Saved Payment Details: " + savedPaymentDetails;
  }
}
