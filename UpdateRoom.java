package managmentSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame implements ActionListener{

	Choice ccust;
	JTextField room,avalable,status;
	JButton check,update,back;
	
	public UpdateRoom() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(300,200,980,500);
		setTitle("Update Details");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		JLabel text=new JLabel("Update Room Status");
		text.setFont(new Font("tahoma", Font.PLAIN, 25));
		text.setBounds(100,50,250,30);
		text.setForeground(Color.BLACK);
		add(text);
		
		JLabel lblid=new JLabel("Customer ID");
		lblid.setBounds(30,130,100,20);
		add(lblid);
		
		ccust=new Choice();
		ccust.setBounds(200,130,150,25);
		add(ccust);
		try {
			Conn c=new Conn();
			ResultSet rs= c.stmt.executeQuery("select * from customer");
			while(rs.next()) {
				ccust.add(rs.getString(2));
			}
			rs.beforeFirst();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblroom=new JLabel("Room Number");
		lblroom.setBounds(30,180,100,20);
		add(lblroom);
		
		room =new JTextField();
		room.setBounds(200,180,150,25);
		add(room);
		
		JLabel lblname=new JLabel("Availability");
		lblname.setBounds(30,230,100,20);
		add(lblname);
		
		avalable =new JTextField();
		avalable.setBounds(200,230,150,25);
		add(avalable);
		
		JLabel lblClean=new JLabel("Cleaning Status");
		lblClean.setBounds(30,280,100,20);
		add(lblClean);
		
		status =new JTextField();
		status.setBounds(200,280,150,25);
		add(status);
		
		
		
		check=new JButton("check");
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.addActionListener(this);
		check.setBounds(30,330,100,30);
		add(check);
		
		update=new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		
		update.setBounds(150,330,100,30);
		add(update);
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(270,330,100,30);
		add(back);
		
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\clean.jpg");
		Image i2=i1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		JLabel img=new JLabel(new ImageIcon(i2));
		img.setBounds(470,20,400,400);
		add(img);
		
		setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==check) {
			try {
				Conn c=new Conn();
				ResultSet rs=c.stmt.executeQuery("select room from customer where number='"+ccust.getSelectedItem()+"'");
				while(rs.next()) {
				room.setText(rs.getString(1));
				}
				ResultSet rs1=c.stmt.executeQuery("select availability,cleaning_status from room where roomnumber='"+room.getText()+"'");
				if(rs1.next()) {
				avalable.setText(rs1.getString(1));
				status.setText(rs1.getString(2));
				}
				} catch (Exception e1) {
				e1.printStackTrace();
			}
			update.addActionListener(this);
		}else if(e.getSource()==update) {
			
			String number=ccust.getSelectedItem();
			String roo=room.getText();
			String avl=avalable.getText();
			String sta=status.getText();
			try {
				Conn c=new Conn();
				c.stmt.executeUpdate("update customer set room ='"+roo+"' where number='"+ccust.getSelectedItem()+"'");
				c.stmt.executeUpdate("update room set availability='"+avl+"',cleaning_status='"+sta+"' where roomnumber='"+roo+"'");
				JOptionPane.showMessageDialog(null, "Data Updated successfully");
				setVisible(false);
				new Reception();
					
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Reception();
		}
		
	}
	
	public static void main(String[] args) {
		new UpdateRoom();
	}

}
