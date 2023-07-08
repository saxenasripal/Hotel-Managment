package managmentSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener{

	Choice ccust;
	JLabel room,checkin;
	JButton checkoutbtn,back;
	
	public CheckOut() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(300,200,980,500);
		setTitle("Checkout");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		JLabel text=new JLabel("Checkout The Room");
		text.setFont(new Font("tahoma", Font.PLAIN, 25));
		text.setBounds(110,50,250,30);
		text.setForeground(Color.BLACK);
		add(text);
		
		JLabel lblid=new JLabel("Customer ID");
		lblid.setBounds(30,130,100,20);
		add(lblid);
		
		ccust=new Choice();
		ccust.setBounds(200,130,150,25);
		add(ccust);
		
		
		JLabel lblroom=new JLabel("Room Number");
		lblroom.setBounds(30,180,100,20);
		add(lblroom);
		
		room =new JLabel();
		room.setBounds(200,180,150,25);
		add(room);
		
		JLabel lblcheckin=new JLabel("Checkin time");
		lblcheckin.setBounds(30,230,100,20);
		add(lblcheckin);
		
		checkin =new JLabel();
		checkin.setBounds(200,230,150,25);
		add(checkin);
		
		JLabel lblcheckout=new JLabel("Checkout Time");
		lblcheckout.setBounds(30,280,100,20);
		add(lblcheckout);
		
		Date date=new Date();
		JLabel checkout=new JLabel(""+date);
		checkout.setBounds(200,280,150,25);
		add(checkout);
		
		
		
		checkoutbtn=new JButton("check");
		checkoutbtn.setBackground(Color.BLACK);
		checkoutbtn.setForeground(Color.WHITE);
		checkoutbtn.addActionListener(this);
		checkoutbtn.setBounds(50,330,100,30);
		add(checkoutbtn);
		
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(250,330,100,30);
		add(back);
		
		try {
			Conn c=new Conn();
			ResultSet rs= c.stmt.executeQuery("select * from customer");
			while(rs.next()) {
				ccust.add(rs.getString(2));
				room.setText(rs.getString(6));
				checkin.setText(rs.getString(7));
				
			}
			rs.beforeFirst();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\checkout.png");
		Image i2=i1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		JLabel img=new JLabel(new ImageIcon(i2));
		img.setBounds(470,20,400,400);
		add(img);
		
		setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==checkoutbtn) {
			try {
				Conn c=new Conn();
				String query="delete from customer where number='"+ccust.getSelectedItem()+"'";
				String query2="update room set availability='Available',cleaning_status='Dirty' where roomnumber='"+room.getText()+"'";
				
					c.stmt.executeUpdate(query2);
					c.stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Checkout Done");
					setVisible(false);
					new Reception();
				} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else {
			setVisible(false);
			new Reception();
		}
		
	}
	
	public static void main(String[] args) {
		new CheckOut();
	}

}
