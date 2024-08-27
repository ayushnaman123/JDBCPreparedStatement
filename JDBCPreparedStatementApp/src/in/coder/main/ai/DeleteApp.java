package in.coder.main.ai;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.coder.util.ai.JdbcUtil;

public class DeleteApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		int sid = 0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlDeleteQuery = "Delete from students where sid =? ";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlDeleteQuery);

			if (pstmt != null) {
				scanner = new Scanner(System.in);
				System.out.println("Enter the sid: ");
				sid = scanner.nextInt();

				pstmt.setInt(1, sid);
				System.out.println(sqlDeleteQuery);

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("Record Deleted successfully " + rowsAffected);
				} else {
					System.out.println("Record Not found for the given id " + sid);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				scanner.close();
				JdbcUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
