package managmentSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRoom extends JFrame implements ActionListener{
	
	JTextField tfRoom,price;
	JComboBox available,status,type;
	JButton add,cancel;

	public AddRoom() {
		setBounds(330,200,940,470);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Add Room");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		
		JLabel text=new JLabel("Add Rooms");
		text.setFont(new Font("tahoma",Font.BOLD,18));
		text.setBounds(150,20,200,20);
		add(text);
		
		JLabel lblRoomno=new JLabel("Room Number");
		lblRoomno.setFont(new Font("tahoma",Font.PLAIN,16));
		lblRoomno.setBounds(60,80,120,30);
		add(lblRoomno);
		
		tfRoom=new JTextField();
		tfRoom.setBounds(200,80,150,30);
		add(tfRoom);
		
		JLabel lblavailable=new JLabel("Available");
		lblavailable.setFont(new Font("tahoma",Font.PLAIN,16));
		lblavailable.setBounds(60,130,120,30);
		add(lblavailable);
		
		String avl[]= {"Available","Occupied"};
		available =new JComboBox(avl);
		available.setBounds(200,130,150,30);
		available.setBackground(Color.WHITE);
		add(available);
		
		JLabel lblstatus=new JLabel("Cleaned Status");
		lblstatus.setFont(new Font("tahoma",Font.PLAIN,16));
		lblstatus.setBounds(60,180,120,30);
		add(lblstatus);
		
		String sta[]= {"Cleaned","Dirty"};
		status =new JComboBox(sta);
		status.setBounds(200,180,150,30);
		status.setBackground(Color.WHITE);
		add(status);
		
		JLabel lblPrice=new JLabel("Price");
		lblPrice.setFont(new Font("tahoma",Font.PLAIN,16));
		lblPrice.setBounds(60,230,120,30);
		add(lblPrice);
		
		price=new JTextField();
		price.setBounds(200,230,150,30);
		add(price);
		
		JLabel lbltype=new JLabel("Bed Type");
		lbltype.setFont(new Font("tahoma",Font.PLAIN,16));
		lbltype.setBounds(60,280,120,30);
		add(lbltype);
		
		String t[]= {"Single","Couple"};
		type =new JComboBox(t);
		type.setBounds(200,280,150,30);
		type.setBackground(Color.WHITE);
		add(type);
		
		add =new JButton("Add Room");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.addActionListener(this);
		add.setBounds(60,350,130,30);
		add(add);
		
		cancel =new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.addActionListener(this);
		cancel.setBounds(220,350,130,30);
		add(cancel);
		
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\room.png");
		JLabel i2=new JLabel(i1);
		i2.setBounds(450,30,389,366);
		add(i2);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== add) {
			String room=tfRoom.getText();
			String cost=price.getText();
			String avl=(String) available.getSelectedItem();
			String clean=(String)status.getSelectedItem();
			String cap=(String)type.getSelectedItem();
			
			String query="insert into room values('"+room+"','"+avl+"','"+clean+"','"+cost+"','"+cap+"')";
			try {
				Conn c=new Conn();
				c.stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Room Added Success Fully");
				
			} catch (Exception e1) {
				e1.printStackTrace();
				
			}
		}
		else if(e.getSource()==cancel) {
			setVisible(false);
		}
	}
	
	
	public static void main(String[] args) {
		new AddRoom();

	}

	

}
