package managmentSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener{

	JMenuItem employee,room,receptionist;
	public Dashboard() {
		setBounds(0,0,1550,1000);
		setTitle("The Sk Groups");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		
		setLayout(null);
		
		
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\dashboard.jpg");
		Image i2=i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(0, 0, 1550, 1000);
		add(img);
		
		JLabel text=new JLabel("THE SK GROUPS WELCOMES YOU");
		text.setBounds(530, 20, 1000, 50);
		text.setFont(new Font("tahoma",Font.PLAIN,30));
		text.setForeground(Color.WHITE);
		img.add(text);
		
		JMenuBar mb=new JMenuBar();
		mb.setBounds(20,100,1500,30);
		img.add(mb);
		
		JMenu hotel=new JMenu("Hotel Managment");
		hotel.setForeground(Color.BLACK);
		mb.add(hotel);
		
		receptionist=new JMenuItem("Reception");
		receptionist.addActionListener(this);
		hotel.add(receptionist);
		
		JMenu admin=new JMenu("Admin");
		admin.setForeground(Color.BLACK);
		mb.add(admin);
		
		employee=new JMenuItem("Add Employee");
		employee.addActionListener(this);
		admin.add(employee);
		
		room= new JMenuItem("Add Room");
		room.addActionListener(this);
		admin.add(room);
		
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Dashboard();

	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==employee) {
			new AddEmployee();
		}else if(e.getSource()==room) {
			new AddRoom();
		}else if(e.getSource()==receptionist) {
			new Reception();
		}
		
	}

}
