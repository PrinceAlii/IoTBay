package uts.isd.model.dao;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;

public class DBConnector extends DB {

	public DBConnector() throws ClassNotFoundException, SQLException {

		Class.forName(driver);

		Properties prop = new Properties();
		prop.put("user", dbuser);
		prop.put("password", dbpassword);
		prop.put("allowPublicKeyRetrieval", "true");
		prop.put("useSSL", "false");

		try {

			conn = DriverManager.getConnection(URL + db, prop);
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection openConnection() {

		return this.conn;

	}

	public void closeConnection() throws SQLException {

		this.conn.close();

	}

}