package dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public void readDataBase() throws Exception {
		try {
			// load MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Setup the connection with DB
			connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/test?" + 
			"user=root&password=");
			
			// statements to issue SQL queries to the db
			statement = connect.createStatement();
			
			// result set get the result of sql
			resultSet = statement.executeQuery("select PositionId, BenchStrength, PositionName from test.position");
			
			writeResultSet(resultSet);
			
			// PreparedStatement can use variables and are more efficient
			//preparedStatement = connect
			//		.prepareStatement("select ")	
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	private void close() throws Exception {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			
			if(statement != null) {
				statement.close();
			}
			
			if(connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
		int numOfCol = metaData.getColumnCount();
		System.out.printf("Position table:%n%n");
		
		for (int i = 1; i <= numOfCol; i++) {
			System.out.printf("%-8s\t", metaData.getColumnName(i));
		}
		
		System.out.println("");
		
		while(resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number which starts at 1
			// e.g. resultSet.getString(2)
			for (int i = 1; i<= numOfCol; i++) 
				System.out.printf("%-8s\t", resultSet.getObject(i));
			System.out.println("");
		}
	}
}
