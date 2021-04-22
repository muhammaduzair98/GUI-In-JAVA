package pkg;

/*
@author Muhammad Uzair
*/


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtRollNo;
	private JTextField txtName;
	private JTextField txtFName;
	private JTextField txtEmail;
	private JComboBox cmbGender;
	private JTextArea txtAddress;
	private JLabel lblName;
	private JLabel lblFathersName;
	private JLabel lblGender;
	private controller c;


	 
	
	public void setcont(controller c) {
		this.c = c;
	}

	/**
	 * Create the frame.
	 */
	public RegisterFrame() {
		
		setForeground(new Color(0, 0, 0));
		setTitle("Student Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 444);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRollNo.setBounds(55, 52, 46, 14);
		contentPane.add(lblRollNo);
		
		txtRollNo = new JTextField();
		txtRollNo.addFocusListener((FocusListener) new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String rno = txtRollNo.getText();
				String[] rollNo = rno.split("-");
				try {
					String email = rollNo[0]+rollNo[1]+"@nu.edu.pk";
					txtEmail.setText(email);
				} catch (Exception e) {
					
				}
				
				
			}
		});
		txtRollNo.setBounds(156, 49, 135, 20);
		contentPane.add(txtRollNo);
		txtRollNo.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(156, 88, 135, 20);
		contentPane.add(txtName);
		
		txtFName = new JTextField();
		txtFName.setColumns(10);
		txtFName.setBounds(156, 119, 135, 20);
		contentPane.add(txtFName);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(156, 195, 135, 20);
		contentPane.add(txtEmail);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(55, 91, 46, 14);
		contentPane.add(lblName);
		
		lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFathersName.setBounds(55, 122, 91, 14);
		contentPane.add(lblFathersName);
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setBounds(55, 163, 46, 14);
		contentPane.add(lblGender);
		
		cmbGender = new JComboBox();
		cmbGender.setForeground(Color.WHITE);
		cmbGender.setBackground(Color.GRAY);
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cmbGender.setBounds(156, 159, 135, 22);
		contentPane.add(cmbGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(55, 198, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(55, 241, 58, 14);
		contentPane.add(lblAddress);
		
		JLabel lblFillTheRegistration = new JLabel("Fill the Registration Form");
		lblFillTheRegistration.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFillTheRegistration.setForeground(Color.DARK_GRAY);
		lblFillTheRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblFillTheRegistration.setBounds(227, 11, 231, 27);
		contentPane.add(lblFillTheRegistration);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(156, 235, 135, 55);
		contentPane.add(scrollPane);
		
		txtAddress = new JTextArea();
		scrollPane.setColumnHeaderView(txtAddress);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.GREEN);
		btnRegister.addActionListener(new ActionListener() {     //When register button is clicked
			public void actionPerformed(ActionEvent arg0) {
				String RollNo = txtRollNo.getText();
				String Name = txtName.getText();
				String FName = txtFName.getText();
				String Gender = (String) cmbGender.getSelectedItem();
				String Email = txtEmail.getText();
				String Address = txtAddress.getText();
				
				/*JOptionPane.showMessageDialog(contentPane, "RollNo: " + RollNo+ 
						"\nName: " +Name+
						"\nFName: " +FName+
						"\nGender: " +Gender+
						"\nEmail: " +Email+
						"\nAddress: " +Address);*/
				
				c.getInfo(RollNo, Name, FName, Gender, Email, Address);
				
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegister.setBounds(202, 312, 89, 23);
		contentPane.add(btnRegister);
	}
}
