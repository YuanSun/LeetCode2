package booksExample;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
public class DisplayQueryResults extends JFrame{
	// database URL, usename, pasword
	private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	// default query retrieves all data from Authors table
	private static final String DEFAULT_QUERY = "Select * from Authors";
	
	private static void main(String args[]) throws Exception {
		try {
			ResultSetTableModel tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
			
			// set up JTextArea in which user types querys
			final JTextArea queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);
			
			JScrollPane scrollPane = new JScrollPane(queryArea, 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			// set up JButton for submitting queries
			JButton submitButton = new JButton("Submit Query");
			
			// create box to manage placement of query Area and 
			// submitButton in GUI
			Box boxNorth = Box.createHorizontalBox();
			boxNorth.add(scrollPane);
			boxNorth.add(submitButton);
			
			// craete JTable based on the tableModel
			JTable resultTable = new JTable(tableModel);
			
			JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			Box boxSouth = Box.createHorizontalBox();
			
			boxSouth.add(filterLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterButton);
			
			// place GUI components on JFrame's content pane
		} catch (SQLException ex) {
			
		}
	}
}
