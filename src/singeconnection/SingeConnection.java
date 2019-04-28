package singeconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingeConnection {

	private static String url = "jdbc:mysql://localhost:3306/consultorio?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "admin";
	private static Connection connection = null;

	static {
		connectar();
	}

	public SingeConnection() {
		connectar();
	}

	private static void connectar() {

		try {

			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
