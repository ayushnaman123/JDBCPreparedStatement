package in.coder.main.ai;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.coder.util.ai.JdbcUtil;

public class InsertApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner scanner = null;

		try {
			connection = JdbcUtil.getJdbcConnection();

			String sqlInsertQuery = "Insert into students(`sname`, `sage`, `saddress`) values(?,?,?)";
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlInsertQuery);

			}

			if (preparedStatement != null) {
				scanner = new Scanner(System.in);
				System.out.println("Enter student name: ");
				String name = scanner.next();

				System.out.println("Enter student age: ");
				int age = scanner.nextInt();

				System.out.println("Enter student address: ");
				String address = scanner.next();

				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, age);
				preparedStatement.setString(3, address);
                System.out.println(sqlInsertQuery);
				int rowsAffected = preparedStatement.executeUpdate();
				System.out.println("No of rows affected:: " + rowsAffected);

			}

		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				scanner.close();
				JdbcUtil.cleanUp(connection, preparedStatement, null);
				System.out.println("CONNECTION CLOSED...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
