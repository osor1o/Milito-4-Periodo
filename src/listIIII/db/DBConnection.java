package listIIII.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection getConnection() throws Exception {
		String url = "jdbc:mysql:user";
		String driver = "org.mysql.Driver";
		String user = "homestead";
		String password = "secret";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
}
