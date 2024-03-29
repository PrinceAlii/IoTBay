package uts.isd.model;

import java.io.Serializable;

public class User implements Serializable {

  private String userEmail;
  private String userName;
  private String userContactNumber;
  private String userPassword;
  private int userID; 
  private String userType;
  private String userAccount;
  private boolean userStatus; 
  private int userVerificationCode; 
  private String userPosition;
  private String logAccessTimestamp;
  private String PaymentID;
  private String OrderID;

  public User() {
  }

  public User(String _email, String _name, String _phone, String _password) {
    this.userEmail = _email;
    this.userName =  _name;
    this.userContactNumber = _phone;
    this.userPassword = _password;
  }
  // public User(String _email, String _name, String _phone, String _password, int _userID, String _userType,
  //             String _userAccount, boolean _userStatus, int _userVerificationCode, String _userPosition,
  //             String _logAccessTimestamp, String _paymentID, String _orderID) {
  //   this.userEmail = _email;
  //   this.userName = _name;
  //   this.userContactNumber = _phone;
  //   this.userPassword = _password;
  //   this.userID = _userID;
  //   this.userType = _userType;
  //   this.userAccount = _userAccount;
  //   this.userStatus = _userStatus;
  //   this.userVerificationCode = _userVerificationCode;
  //   this.userPosition = _userPosition;
  //   this.logAccessTimestamp = _logAccessTimestamp;
  //   this.PaymentID = _paymentID;
  //   this.OrderID = _orderID;
  // }

  // getters

  public String getEmail() {
    return this.userEmail;
  }

  public void setEmail(String value) {
    this.userEmail = value;
  }

  public String getName() {
    return this.userName;
  }

  public void setName(String value) {
    this.userName = value;
  }

  public String getPhone() {
    return this.userContactNumber;
  }

  // setters

  public void setPhone(String value) {
    this.userContactNumber = value;
  }

  public String getPassword() {
    return this.userPassword;
  }

  public void setPassword(String value) {
    this.userPassword = value;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(String userAccount) {
    this.userAccount = userAccount;
  }

  public boolean isUserStatus() {
    return userStatus;
  }

  public void setUserStatus(boolean userStatus) {
    this.userStatus = userStatus;
  }

  public int getUserVerificationCode() {
    return userVerificationCode;
  }

  public void setUserVerificationCode(int userVerificationCode) {
    this.userVerificationCode = userVerificationCode;
  }

  public String getUserPosition() {
    return userPosition;
  }

  public void setUserPosition(String userPosition) {
    this.userPosition = userPosition;
  }

  public String getLogAccessTimestamp() {
    return logAccessTimestamp;
  }

  public void setLogAccessTimestamp(String logAccessTimestamp) {
    this.logAccessTimestamp = logAccessTimestamp;
  }

  public String getPaymentID() {
    return PaymentID;
  }

  public void setPaymentID(String paymentID) {
    PaymentID = paymentID;
  }

  public String getOrderID() {
    return OrderID;
  }

  public void setOrderID(String orderID) {
    OrderID = orderID;
  }
}
