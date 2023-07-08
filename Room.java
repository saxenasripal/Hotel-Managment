package managmentSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

public class Room extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	public Room() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Rooms");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\room2.jpg");
		Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
		JLabel img=new JLabel(new ImageIcon(i2));
		img.setBounds(500,0,600,600);
		add(img);
		
		JLabel c1=new JLabel("Room Number");
		c1.setBounds(10,10,100,20);
		add(c1);
		
		
		JLabel c2=new JLabel("Availability");
		c2.setBounds(120,10,100,20);
		add(c2);
		

		JLabel c3=new JLabel("Status");
		c3.setBounds(230,10,100,20);
		add(c3);
		

		JLabel c4=new JLabel("Price");
		c4.setBounds(330,10,100,20);
		add(c4);
		

		JLabel c5=new JLabel("Bed Type");
		c5.setBounds(410,10,100,20);
		add(c5);
		int count=0;
		try {
			Conn c=new Conn();
			String query="select count(*) from room";
			ResultSet rs=c.stmt.executeQuery(query);
			rs.next();
			count=rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		String[][] data=new String[count][5];
		try {
			String query2="select * from room";
			Conn c=new Conn();
			ResultSet rs=c.stmt.executeQuery(query2);
			for(int i=0;rs.next();i++) {
				data[i][0]=rs.getString(1);
				data[i][1]=rs.getString(2);
				data[i][2]=rs.getString(3);
				data[i][3]=rs.getString(4);
				data[i][4]=rs.getString(5);				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		Integer[] col={10,20,30,10,10};
		table =new JTable(data,col);
		table.setBounds(00,30,500,400);
		table.setGridColor(Color.BLACK);
		table.setBorder(null);
		add(table);

		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.white);
		back.setBounds(180,500,120,30);
		back.addActionListener(this);
		add(back);
		
		
		setBounds(300,200,1050,600);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Room();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			setVisible(false);
			new Reception();
		}
	}

}
