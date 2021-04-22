package pkg;

/*
@author Muhammad Uzair
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class tableFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private controller cont;
	private static JTable table;
	private static JTable table_1;


	/**
	 * Launch the application.
	 */
	
	public void setcont(controller c) {
		this.cont = c;
	}
	

	/**
	 * Create the frame.
	 */
	public tableFrame() {
		setBackground(Color.RED);
		
		cont = main.c;
		
		setTitle("Students Table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 378);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTable = new JLabel("TABLE");
		lblTable.setBounds(5, 5, 516, 15);
		lblTable.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTable.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTable);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(25, 41, 46, 14);
		contentPane.add(lblName);
		
		txtSearch = new JTextField();
		txtSearch.setBackground(Color.WHITE);
		txtSearch.setBounds(61, 38, 86, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		
		
		JButton btnSearch = new JButton("Show All");
		btnSearch.setBackground(Color.GREEN);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cont.getDataFromTable();
			}
		});
		btnSearch.setBounds(317, 37, 89, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 100, 511, 228);
		contentPane.add(scrollPane);
		
		/*
		 * Configuring JtableView
		 */
		
		Object title[] = {
				"Roll Num",
				"Name",
				"Father Name",
				"Gender",
				"Email",
				"Address"
		};
		DefaultTableModel dm = new DefaultTableModel();
		dm.setColumnIdentifiers(title);

		table_1 = new JTable(dm);
		table_1.setModel(dm);
		
		scrollPane.setViewportView(table_1);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch_1.setForeground(new Color(0, 0, 0));
		btnSearch_1.setBackground(Color.GREEN);
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtSearch.getText();
				cont.searchFromTable(name);
			}
		});
		btnSearch_1.setBounds(157, 37, 89, 23);
		contentPane.add(btnSearch_1);
		
			
//		System.out.println("Initialize, configuring.....");
	
		
	}
	
	public static void clearTable(DefaultTableModel model) {
		
		int rowCount = model.getRowCount();
		for(int i = 0; i < rowCount; i++) {
			model.removeRow(i);
		}
	}
	
	public static void InsertDataintoTable(ResultSet res) {  // recieve Data from database, show it on frame 
		//table.add
		
		
		DefaultTableModel model = null;
		model = (DefaultTableModel) table_1.getModel();
//		model = new DefaultTableModel();
		clearTable(model);
		try {
//			System.out.println("Hey1");
			System.out.println(res.next());
			
			if (res.first()) {
//				System.out.println("Hey2");
				Object[] row = {res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)};
				model.addRow(row);
				System.out.println(row.toString());
				//System.out.println(res.next());
				
				while(res.next()) {
//					System.out.println("Hey3");
					Object[] row2 = {res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)};
					model.addRow(row2);
					System.out.println(row2.toString());
					//System.out.println(res.next());
				}
				

			
			}
			
			table_1.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public JPanel getContentPane() {
		return contentPane;
	}
}
