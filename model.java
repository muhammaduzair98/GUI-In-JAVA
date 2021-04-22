package pkg;


/*
@author Muhammad Uzair
*/
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class model {

	private Connection cn;
	private Component contentPane;
	private Statement s;
	private Component contenPane;
	
	public model()
	{
//		JOptionPane.showMessageDialog(null, "I am Model class");
	}
	
	public void connect()  // creating connection with the database
	{
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost/gui_17a?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
//			JOptionPane.showMessageDialog(null, "Database connected!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(contentPane, "Could not connect. \nReason: " + e.getMessage());
		}
		
	}
	
	public void saveInfo(String RollNo, String Name, String FName, String Gender, String Email, String Address)
	{
//		JOptionPane.showMessageDialog(null, "Model recieved the information");
		
		String query = "INSERT INTO students VALUES('"+RollNo+"',"
				+ "'"+Name+"',"
						+ "'"+FName+"',"
							+ "'"+Gender+"',"
								+ "'"+Email+"',"
									+ "'"+Address+"')";
		
//		JOptionPane.showMessageDialog(contentPane, query);
		
		try {
			s = cn.createStatement();  // trying to insert data into database
			s.execute(query);
			JOptionPane.showMessageDialog(contentPane, "Record Saved!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getTable()
	{
//		JOptionPane.showMessageDialog(contenPane, "Table fucntion called");
		
		String qry = "select * from students";
		ResultSet res = null;
		try {
			s = cn.createStatement();
			s.execute(qry);
			res = s.getResultSet();
			
			return res;
		} catch (SQLException e) {
			System.out.println("[ERROR] Something went wrong");
		}
		
		return res;
		
	}
	

	public ResultSet TableSearching(String search)
	{
		
		String qry = "SELECT * FROM students WHERE st_name = '"+search+"' ";
		ResultSet res = null;
		try {
			s = cn.createStatement();
			s.execute(qry);
			res = s.getResultSet();
			
			return res;
		}
		catch(SQLException e){
			System.out.println("[ERROR] Problem!");
		}
		
		return res;
		
	}
	
	
}
