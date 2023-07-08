package managmentSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
	
	JComboBox comboid;
	JTextField num,name,country,deposite;
	JRadioButton rbmale,rbfemale;
	Choice croom;
	JLabel checkinTime;
	JButton add,cancel;

	public AddCustomer() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(350,200,800,550);
		setLayout(null);
		setTitle("Add Customer");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		
		JLabel text=new JLabel("NEW CUSTOMER FORM");
		text.setBounds(100,20,300,30);
		text.setFont(new Font("Ralway", Font.PLAIN, 20));
		add(text);
		
		JLabel id=new JLabel("ID");
		id.setBounds(35,80,100,20);
		id.setFont(new Font("Ralway", Font.PLAIN, 20));
		add(id);
		
		String options[]= {"Aadhar Card","Passport","Driving Licence","voter-id Card","Ration Card"};
		comboid=new JComboBox(options);
		comboid.setBackground(Color.WHITE);
		comboid.setBounds(200,80,150,25);
		add(comboid);
		
		JLabel idnum=new JLabel("Number");
		idnum.setBounds(35,120,100,20);
		idnum.setFont(new Font("Ralway", Font.PLAIN, 20));
		add(idnum);
		
		num=new JTextField();
		num.setBounds(200,120,150,25);
		add(num);
		
		JLabel lblname=new JLabel("Name");
		lblname.setBounds(35,160,100,20);
		lblname.setFont(new Font("Ralway", Font.PLAIN, 20));
		add(lblname);
		
		name=new JTextField();
		name.setBounds(200,160,150,25);
		add(name);
		
		JLabel lblgen=new JLabel("Gender");
		lblgen.setBounds(35,200,100,20);
		lblgen.setFont(new Font("Ralway", Font.PLAIN, 20));
		add(lblgen);
		
		rbmale=new JRadioButton("Male");
		rbmale.setFont(new Font("tahoma",Font.PLAIN,14));
		rbmale.setBackground(Color.WHITE);
		rbmale.setBounds(200,200,60,25);
		add(rbmale);
		
		rbfemale=new JRadioButton("Female");
		rbfemale.setFont(new Font("tahoma",Font.PLAIN,14));
		rbfemale.setBackground(Color.WHITE);
		rbfemale.setBounds(270,200,100,25);
		add(rbfemale);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbfemale);
		bg.add(rbmale);
		
		JLabel lblVountry=new JLabel("Country");
		lblVountry.setBounds(35,240,100,20);
		lblVountry.setFont(new Font("Ralway", Font.PLAIN, 20));
		add(lblVountry);
		
		country=new JTextField();
		country.setBounds(200,240,150,25);
		add(country);
		
		JLabel lblRoom=new JLabel("Room Number");
		lblRoom.setBounds(35,280,150,20);
		lblRoom.setFont(new Font("Ralway", Font.PLAIN, 20));
		add(lblRoom);
		
		croom=new Choice();
		try {
			Conn c=new Conn();
			String query="select roomnumber from room where availability='available'";
			ResultSet rs=c.stmt.executeQuery(query);
			while (rs.next()) {
				croom.add(rs.getString(1));				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		croom.setBounds(200,280,150,25);
		add(croom);
		
		JLabel lblTime=new JLabel("Checkin Time");
		lblTime.setBounds(35,320,150,20);
		lblTime.setFont(new Font("Ralway", Font.PLAIN, 20));
		add(lblTime);
		
		
		Date date=new Date();
		checkinTime=new JLabel(""+date);
		checkinTime.setBounds(200,320,150,20);
		checkinTime.setFont(new Font("Ralway", Font.PLAIN, 15));
		add(checkinTime);
		
		JLabel lblDdeposite=new JLabel("Deposite");
		lblDdeposite.setBounds(35,360,100,20);
		lblDdeposite.setFont(new Font("Ralway", Font.PLAIN, 20));
		add(lblDdeposite);
		
		deposite=new JTextField();
		deposite.setBounds(200,360,150,25);
		add(deposite);
		
		add =new JButton("Add");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.addActionListener(this);
		add.setBounds(50,410,120,30);
		add(add);
		
		cancel =new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.addActionListener(this);
		cancel.setBounds(200,410,120,30);
		add(cancel);
		
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\customer.png");
		JLabel img=new JLabel(i1);
		img.setBounds(400,50,300,400);
		add(img);
		
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==add) {
			String id=(String) comboid.getSelectedItem();
			String idnum=num.getText();
			String custName=name.getText();
			String coun=country.getText();
			String amt=deposite.getText();
			String gen="";
			if (rbmale.isSelected()) {
				gen="Male";
			}
			else if(rbfemale.isSelected()) {
				gen="Female";
			}
			String room=croom.getSelectedItem();
			String time=checkinTime.getText();
			
			try {
				String query1= "insert into customer values('"+id+"','"+idnum+"','"+custName+"','"+gen+"','"+coun+"','"+room+"','"+time+"','"+amt+"')";
				String query2="update room set availability='Occupaid' where roomnumber='"+room+"'";
				Conn c=new Conn();
				c.stmt.executeUpdate(query1);
				c.stmt.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "one Customer added");
				setVisible(false);
				new Reception();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==cancel) {
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		new AddCustomer();
	}

}
