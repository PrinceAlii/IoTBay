package uts.isd.model;

import java.io.Serializable;

public class UserAccessLogs implements Serializable {

  
  private String logAccessDate;
  private String logAccessTime;
  private int userID;
  private String logStatus; 

  public UserAccessLogs(String _logAccessDate,String _logAccessTime, int _userID, String _logStatus) {
    this.logAccessDate = _logAccessDate;
    this.logAccessTime = _logAccessTime;
    this.userID = _userID;
    this.logStatus = _logStatus;
  }


  public String getLogAccessDate() {
    return logAccessDate;
  }

  public void setLogAccessDate(String logAccessDate) {
    this.logAccessDate = logAccessDate;
  }

  public String getLogAccessTime() {
    return logAccessTime;
  }

  public void setLogAccessTime(String logAccessTime) {
    this.logAccessTime = logAccessTime;
  }

  public int getUserID(String name) {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public String getLogStatus() {
    return logStatus;
  }

  public void setLogStatus(String logStatus) {
    this.logStatus = logStatus;
  }
}
