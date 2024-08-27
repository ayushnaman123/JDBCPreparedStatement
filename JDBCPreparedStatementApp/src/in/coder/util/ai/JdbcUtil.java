package in.coder.util.ai;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private JdbcUtil() {}
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException, IOException   {
		FileInputStream fis = new FileInputStream("D:\\ineuron\\PracticeJDBC\\JDBCPreparedStatementApp\\src\\in\\coder\\properties\\ai\\Application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));
		System.out.println("CONNECTION CREATED ");
		return connection;
	}
	
	public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if(connection != null)
			connection.close();
		
		if(statement !=null) {
			statement.close();
		}
		
		if(resultSet != null)
			resultSet.close();
	}
}
