package booksExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

/**
 *  ResultSet rows and columns are counted from 1 to JTable
 *  rows and columns are counted from 0. When processing 
 *  ResultSet rows or columns for use in a JTable, it is necessary
 *  to add 1 to the row or column number to manipulate the 
 *  appropriate ResultSet column (i.e., JTable column 0 is 
 *  ResultTable column 1 and JTable row 0 is ResultSet row 1)
 */
public class ResultSetTableModel extends AbstractTableModel{
	private final Connection connection;
	private final Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metadata;
	private int numberOfRows;
	
	// keep track of database connection status
	private boolean connectedToDatabase = false;
	
	// constructor initializes resultSet and obtains its metadata object;
	// determines number of rows
	public ResultSetTableModel(String url, String username, 
			String password, String query) throws SQLException, Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		connection = DriverManager.getConnection(url, username, password);
		
		// create Statement to query database
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		// update database connection status
		connectedToDatabase = true;
		
		// set query and execute it
		setQuery(query);
	}
	
	public Class getColumnClass(int column) throws IllegalStateException {
		// ensure database connection is available
		if(!connectedToDatabase) 
			throw new IllegalStateException("Not connected to Database");
			
			// determine Java class of column
		try {
			String className = metadata.getColumnName(column + 1);
			
			return Class.forName(className);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return Object.class;
	}

	// get number of columns in ResultSet
	public int getColumnCount() throws IllegalStateException {
		// ensure database connect is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}
		
		// determine number of columns
		try {
			return metadata.getColumnCount();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return 0; // if problem occur above, return 0 for number of columns
	}
	
	// get name of a particular coumn in ResultSet
	public String getColumnName(int column) throws IllegalStateException {
		if(!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		
		try {
			return metadata.getColumnName(column + 1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return "";// if problems return empty string for column name
	}
	
	// return number of rows in ResultSet
	public int getRowCount() throws IllegalStateException {
		if(!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		
		return numberOfRows;
	}
	
	// obtain value in particular row and column
	public Object getValueAt(int row, int column) throws IllegalStateException {
		if(!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		
		try {
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return "";
	}
	
	// set new database query string
	public void setQuery(String query) throws SQLException, IllegalStateException {
		if(!connectedToDatabase)
			throw new IllegalStateException("Not connected to database");
		
		// specify query and execute it
		resultSet = statement.executeQuery(query);
		
		// obtain metadata for ResultSet
		metadata = resultSet.getMetaData();
		
		// determine number of rows in ResultSet
		resultSet.last();// move to last row
		numberOfRows = resultSet.getRow();
		
		// notify JTable that model has changeed
		fireTableStructureChanged();
	}
	
	// close Statement and connection
	public void disconnectFromDatabase() {
		if(connectedToDatabase) {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			} finally {
				connectedToDatabase = false;
			}
		}
	}
}
