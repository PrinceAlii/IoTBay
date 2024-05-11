package uts.isd.model;

import java.io.Serializable;

public class UserAccessLogs implements Serializable {

  
  private String logAccessTimestamp;
  private int userID;
  private String logStatus; 

  public UserAccessLogs(String _logAccessTimestamp, int _userID, String _logStatus) {
    this.logAccessTimestamp = _logAccessTimestamp;
    this.userID = _userID;
    this.logStatus = _logStatus;
  }


  public String getLogAccessTimestamp() {
    return logAccessTimestamp;
  }

  public void setLogAccessTimestamp(String logAccessTimestamp) {
    this.logAccessTimestamp = logAccessTimestamp;
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
