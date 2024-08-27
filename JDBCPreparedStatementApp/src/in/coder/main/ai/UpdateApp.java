package in.coder.main.ai;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.coder.util.ai.JdbcUtil;

public class UpdateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlUpdateQuery = "Update students set sage=? where sid=?";
			if(connection!=null){
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}
			
			if(pstmt!=null) {
				scanner = new Scanner(System.in);
				System.out.println("Enter the sid: ");
				int id = scanner.nextInt();
				
				System.out.println("Enter the sage: ");
				int sage = scanner.nextInt();
				
				pstmt.setInt(1, sage);;
				pstmt.setInt(2, id);
				
				System.out.println(sqlUpdateQuery);
				int rowsAffected = pstmt.executeUpdate();
				System.out.println("No of rows Affected: "+rowsAffected);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
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
