package managmentSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchRoom extends JFrame implements ActionListener{
	JTable table;
	JButton back,submit;
	JComboBox bed;
	JCheckBox avl;
	static DefaultTableModel model;
	final Object[] row=new Object[5];
	
	
	public SearchRoom() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Search Room");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		JLabel text=new JLabel("SEARCH FOR ROOM");
		text.setFont(new Font("tahoma",Font.PLAIN,20));
		text.setBounds(400,30,200,30);
		add(text);
		
		JLabel lblRType=new JLabel("Bed Type");
		lblRType.setBounds(50,100,100,20);
		add(lblRType);
		
		bed=new JComboBox(new String[] {"Single","Couple"});
		bed.setBounds(150,100,150,20);
		bed.setBackground(Color.WHITE);
		add(bed);
		
		avl=new JCheckBox("Only Available");
		avl.setBounds(650,100,150,20);
		avl.setBackground(Color.WHITE);
		add(avl);
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(0,200,1000,300);
		add(scrollPane);
		table =new JTable();
		table.setBackground(Color.white);
		scrollPane.setViewportView(table);
		model=new DefaultTableModel();
		Object[] column= {"Room Number","Availability","Status","Price","Bed Type"};
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		try {
			String query2="select * from room";
			Conn c=new Conn();
			ResultSet rs=c.stmt.executeQuery(query2);
			for(int i=0;rs.next();i++) {
				row[0]=rs.getString(1);
				row[1]=rs.getString(2);
				row[2]=rs.getString(3);
				row[3]=rs.getString(4);
				row[4]=rs.getString(5);
				model.addRow(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//add(table);
		

		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.white);
		back.setBounds(500,500,150,30);
		back.addActionListener(this);
		add(back);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.white);
		submit.setBounds(300,500,150,30);
		submit.addActionListener(this);
		add(submit);
		
		
		setBounds(300,200,1000,600);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new SearchRoom();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			setVisible(false);
			new Reception();
		}else if (e.getSource()==submit) {
			int a=model.getRowCount();
			for(int i=a-1;i>=0;i--) {
				model.removeRow(i);
			}
			String query1="select * from room where bed_type='"+bed.getSelectedItem()+"'";
			String query2="select * from room where bed_type='"+bed.getSelectedItem()+"'and availability='Available'";
			try {
				Conn c=new Conn();
				ResultSet rs;
				if (avl.isSelected()) {
					rs=c.stmt.executeQuery(query2);
				}
				else {
					rs=c.stmt.executeQuery(query1);
				}
				int i=0;
				while(rs.next()) {
					row[0]=rs.getString(1);
					row[1]=rs.getString(2);
					row[2]=rs.getString(3);
					row[3]=rs.getString(4);
					row[4]=rs.getString(5);
					model.addRow(row);
				i++;
				}
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
		}
	}
}


