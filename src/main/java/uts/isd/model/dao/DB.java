package uts.isd.model.dao;

import java.sql.Connection;

public abstract class DB {
    
    protected String URL = "jdbc:mysql://localhost:3306/"; // do I need to change this based off my comp??
    protected String db = "lab example";
    protected String dbuser = "admin";
    protected String dbpassword = "password";
    protected String params = "?useSSL=false&allowPublicKeyRetrieval=true";
    protected String driver = "com.mysql.cj.jdbc.Driver";
    protected Connection conn;
}
