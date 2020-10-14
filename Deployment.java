
package mainpack;

import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Deployment {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deployment window = new Deployment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Deployment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 597, 320);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("CREATE SCHEMA");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						Class.forName("com.mysql.jdbc.Driver");
						JOptionPane.showMessageDialog(null,"Driver Loaded");
					    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
					    Statement st=con.createStatement();
					    st.executeUpdate("create database LIBRARY_MANAGEMENT");
					    st.executeUpdate("use LIBRARY_MANAGEMENT");
					    JOptionPane.showMessageDialog(null, "Database created and ready to use");
					   
					    String s1="create table admin(username varchar(10),password varchar(10),name varchar(20),position varchar(20),salary double,doj date)";
					    st.executeUpdate(s1);
					    JOptionPane.showMessageDialog(null, "Admin Table created");
					    
					    String s2="create table User(user_id varchar(20) primary key,Uname varchar(20),Area varchar(20),phone_number int,password varchar(20),dob date)";
					    st.executeUpdate(s2);
					    JOptionPane.showMessageDialog(null, "User Table created");
					    
					    String s3="create table Librarian(Librarian_id varchar(20) primary key,Lname varchar(20),Area varchar(20),phone_number int,password varchar(20))";
					    st.executeUpdate(s3);
					    JOptionPane.showMessageDialog(null, "Librarian Table created");
					    
					    String s4="create table Books(Book_id varchar(20) primary key,Bname varchar(20),Author varchar(20),Book_type varchar(20))";
					    st.executeUpdate(s4);
					    JOptionPane.showMessageDialog(null, "Book Table created");
					    
					    String s5="create table Borrow(Book_id varchar(20),User_id varchar(20), primary key(Book_id,User_id),foreign key(Book_id) references Books(Book_id) on delete cascade,foreign key(User_id) references User(user_id) on delete cascade,user_name varchar(20),Due_Date date)";
					    st.executeUpdate(s5);
					    JOptionPane.showMessageDialog(null, "Borrow Table created");
					    
					    //String s6="create table temp(lid varchar(20), uname varchar(20)
				}
				catch(Exception e1) {

					JOptionPane.showMessageDialog(null,e1);
		
			}
			}
		});
		btnNewButton.setBounds(59, 111, 189, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DROP SCHEMA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Class.forName("com.mysql.jdbc.Driver");
						JOptionPane.showMessageDialog(null,"Driver Loaded");
						Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
					    Statement st=con.createStatement();
					    
					    st.executeUpdate("drop database LIBRARY_MANAGEMENT");
					    
					 
					 JOptionPane.showMessageDialog(null, "Database Dropped");
					    
					    
					    
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
				
				
			}
			
		});
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(321, 111, 189, 23);
		panel.add(btnNewButton_1);
		
		JButton btnInitiate = new JButton("INITIATE DATABASE");
		btnInitiate.setBackground(Color.CYAN);
		btnInitiate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Class.forName("com.mysql.jdbc.Driver");
						JOptionPane.showMessageDialog(null,"Driver Loaded");
					    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
					    Statement st=con.createStatement();
					   
					    st.executeUpdate("use bank3");
					    JOptionPane.showMessageDialog(null,"Database initiated");
					    
				}
					catch(Exception c) {
						JOptionPane.showMessageDialog(null,c);
					}
			}
		});
		btnInitiate.setBounds(59, 218, 189, 23);
		panel.add(btnInitiate);
		
		JButton btnAddAdmin = new JButton("ADD ADMIN");
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Add_Admin();
			}
		});
		btnAddAdmin.setBackground(Color.CYAN);
		btnAddAdmin.setBounds(321, 218, 189, 23);
		panel.add(btnAddAdmin);
		
		JLabel lblDeploymentlibrarymanagement = new JLabel("DEPLOYMENT_LIBRARY_MANAGEMENT");
		lblDeploymentlibrarymanagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeploymentlibrarymanagement.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblDeploymentlibrarymanagement.setBounds(59, 46, 451, 14);
		panel.add(lblDeploymentlibrarymanagement);
		
		JLabel lblNewLabel = new JLabel("LIBRARY_MANGEMENT");
		lblNewLabel.setBounds(465, 328, 142, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
