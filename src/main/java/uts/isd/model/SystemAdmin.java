package uts.isd.model;

import java.io.Serializable;

public class SystemAdmin implements Serializable {

  private int userID;
  private String name;
  private String password;

  public SystemAdmin() {
  }

  public SystemAdmin(int _userID, String _name, String _password) {
    this.userID = _userID;
    this.name = _name;
    this.password = _password;
  }


  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
