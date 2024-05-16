package uts.isd.model;

import java.io.Serializable;

public class User implements Serializable {

  private int userID;
  private String userName;
  private String userEmail;
  private String userPassword;
  private String userContactNumber;
  private String userType;
  private String userAccount;
  private boolean userStatus;
  private String userPosition;
  private String PaymentID;

  public User() {}

  public User(int _userID, String _userName, String _userEmail, String _userPassword, String _userContactNumber, 
              String _userType, String _userAccount, boolean userStatus, String _userPosition,
              String _PaymentID) {
                this.userID = _userID;
                this.userName = _userName;
                this.userEmail = _userEmail;
                this.userPassword = _userPassword;
                this.userContactNumber = _userContactNumber;
                this.userType = _userType;
                this.userAccount = _userAccount;
                this.userStatus = userStatus;
                this.userPosition = _userPosition;
                this.PaymentID = _PaymentID;

  }

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

  public void setPhone(String phone) {
    this.userContactNumber = phone;
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

  public String getUserPosition() {
    return userPosition;
  }

  public void setUserPosition(String userPosition) {
    this.userPosition = userPosition;
  }

  public String getPaymentID() {
    return PaymentID;
  }

  public void setPaymentID(String paymentID) {
    PaymentID = paymentID;
  }

public Object getUserName() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUserName'");
}

public Object getUserEmail() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUserEmail'");
}

public Object getUserPassword() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUserPassword'");
}

public Object getUserContactNumber() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUserContactNumber'");
}

public Object getFullName() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFullName'");
}

public Object getContactNumber() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getContactNumber'");
}
}
