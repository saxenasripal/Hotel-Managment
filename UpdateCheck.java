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

public class UpdateCheck extends JFrame implements ActionListener{

	Choice ccust;
	JTextField room,name,checkin,paid,pending;
	JButton check,update,back;
	
	
	public UpdateCheck() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(300,200,980,500);
		setTitle("Update Details");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		JLabel text=new JLabel("Update Status");
		text.setFont(new Font("tahoma", Font.PLAIN, 20));
		text.setBounds(90,20,200,30);
		text.setForeground(Color.BLUE);
		add(text);
		
		JLabel lblid=new JLabel("Customer ID");
		lblid.setBounds(30,80,100,20);
		add(lblid);
		
		ccust=new Choice();
		ccust.setBounds(200,80,150,25);
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
		lblroom.setBounds(30,120,100,20);
		add(lblroom);
		
		room =new JTextField();
		room.setBounds(200,120,150,25);
		add(room);
		
		JLabel lblname=new JLabel("Name");
		lblname.setBounds(30,160,100,20);
		add(lblname);
		
		name =new JTextField();
		name.setBounds(200,160,150,25);
		add(name);
		
		JLabel lblCheckin=new JLabel("Checkin Time");
		lblCheckin.setBounds(30,200,100,20);
		add(lblCheckin);
		
		checkin =new JTextField();
		checkin.setBounds(200,200,150,25);
		add(checkin);
		
		JLabel lblpaid=new JLabel("Amount Paid");
		lblpaid.setBounds(30,240,100,20);
		add(lblpaid);
		
		paid =new JTextField();
		paid.setBounds(200,240,150,25);
		add(paid);
		
		JLabel lblpending=new JLabel("Pending Amount");
		lblpending.setBounds(30,280,100,20);
		add(lblpending);
		
		pending =new JTextField();
		pending.setBounds(200,280,150,25);
		add(pending);
		
		check=new JButton("check");
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.addActionListener(this);
		check.setBounds(30,340,100,30);
		add(check);
		
		update=new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		//update.addActionListener(this);
		update.setBounds(150,340,100,30);
		add(update);
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(270,340,100,30);
		add(back);
		
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\customer.png");
		JLabel img=new JLabel(i1);
		img.setBounds(550,20,300,400);
		add(img);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new UpdateCheck();
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==check) {
			try {
				Conn c=new Conn();
				ResultSet rs=c.stmt.executeQuery("select * from customer where number='"+ccust.getSelectedItem()+"'");
				rs.next();
					room.setText(rs.getString(6));
					name.setText(rs.getString(3));
					checkin.setText(rs.getString(7));
					paid.setText(rs.getString(8));	
					ResultSet rs1=c.stmt.executeQuery("select price from room where roomnumber='"+room.getText()+"'");
					rs1.next();
					int remain=Integer.valueOf(rs1.getString(1))-Integer.valueOf(paid.getText());
					pending.setText(""+remain);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			update.addActionListener(this);
		}else if(e.getSource()==update) {
			String number=ccust.getSelectedItem();
			String roo=room.getText();
			String na=name.getText();
			String time=checkin.getText();
			String amt=paid.getText();
			try {
				Conn c=new Conn();
				
					c.stmt.executeUpdate("update customer set room ='"+roo+"',name='"+na+"',checkinTime='"+time+"',deposite='"+amt+"' where number='"+ccust.getSelectedItem()+"'");
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

}
