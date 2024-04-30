package uts.isd.model.dao;

import java.sql.Connection;

public abstract class DB {
    
    protected String URL = "jdbc:mysql://localhost:3306/";
    protected String db = "IOTBAY";
    protected String dbuser = "admin";
    protected String dbpassword = "password";
    protected String params = "?useSSL=false&allowPublicKeyRetrieval=true";
    protected String driver = "com.mysql.cj.jdbc.Driver";
    protected Connection conn;
}
