package uts.isd.model;

import java.io.Serializable;

public class AccessLogs implements Serializable {

  
  private String logAccessTimestamp;
  private int userID;
  private boolean logStatus; 

  public AccessLogs() {
  }

  public AccessLogs(String _logAccessTimestamp, int _userID, boolean _logStatus) {
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

  public boolean isLogStatus() {
    return logStatus;
  }

  public void setLogStatus(boolean logStatus) {
    this.logStatus = logStatus;
  }
}
