package DataBase_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_Connection {

	public static void main(String[] args) throws SQLException {
		/*
		 * Connection URL: "jdbc:mysql://"+host+":"+port+"/databasename";
		 */
		String host = "localhost";
		String port = "3306";

		Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/UAT_DB", "root",
				"Password@123");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from credentials where scenario='zeroBalanceCard';");

		while (resultSet.next()) {
			System.out.println(resultSet.getString("UserName"));
			System.out.println(resultSet.getString("Password"));
		}
	}

}
