package in.coder.main.ai;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.coder.util.ai.JdbcUtil;

public class SelectApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner scanner = null;
		int id = 0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlSelectQuery = "Select sid, sname, sage, saddress from students where sid =?";
			if(connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			
			if(pstmt != null) {
				scanner = new Scanner(System.in);
				System.out.println("Enter the student id : ");
				 id = scanner.nextInt();
				
				pstmt.setInt(1, id);
				
				System.out.println(sqlSelectQuery);
				
				resultSet = pstmt.executeQuery();
				
			}
			
			if(resultSet != null) {
				
				if(resultSet.next()) {
					System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				}else {
					System.out.println("RECORD NOT AVAILABLE FOR THE GIVEN SID :"+id);
				}
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
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
		
		
		
		
	}

}
