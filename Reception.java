package managmentSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Reception extends JFrame implements ActionListener{

	JButton newCust,rooms,department,allEmployees,custinfo,manager,checkout,update,roomStatus,pickup,searchRoom,logout;
	public Reception() {
		setBounds(350, 200, 800, 570);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Reception");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		newCust=new JButton("New Customer Form");
		newCust.setBounds(10,30,200,30);
		newCust.addActionListener(this);
		newCust.setBackground(Color.BLACK);
		newCust.setForeground(Color.WHITE);
		add(newCust);

		rooms=new JButton("Rooms");
		rooms.setBounds(10,75,200,30);

		rooms.addActionListener(this);
		rooms.setBackground(Color.BLACK);
		rooms.setForeground(Color.WHITE);
		add(rooms);

//		department=new JButton("Department");
//		department.setBounds(10,110,200,30);
//		department.setBackground(Color.BLACK);
//		department.setForeground(Color.WHITE);
//		add(department);
		
		allEmployees=new JButton("All Employees");
		allEmployees.setBounds(10,120,200,30);

		allEmployees.addActionListener(this);
		allEmployees.setBackground(Color.BLACK);
		allEmployees.setForeground(Color.WHITE);
		add(allEmployees);
		
		custinfo=new JButton("Customer Info");
		custinfo.setBounds(10,165,200,30);
		custinfo.addActionListener(this);
		custinfo.setBackground(Color.BLACK);
		custinfo.setForeground(Color.WHITE);
		add(custinfo);
		
		manager=new JButton("Manager Info");
		manager.setBounds(10,210,200,30);
		manager.addActionListener(this);
		manager.setBackground(Color.BLACK);
		manager.setForeground(Color.WHITE);
		add(manager);
		
		checkout=new JButton("Checkout");
		checkout.setBounds(10,255,200,30);
		checkout.addActionListener(this);
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		add(checkout);
		
		update=new JButton("Update Status");
		update.setBounds(10,300,200,30);
		update.addActionListener(this);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		add(update);
		
		roomStatus=new JButton("Update Room Status");
		roomStatus.setBounds(10,345,200,30);
		roomStatus.addActionListener(this);
		roomStatus.setBackground(Color.BLACK);
		roomStatus.setForeground(Color.WHITE);
		add(roomStatus);
		
//		pickup=new JButton("Pickup Service");
//		pickup.setBounds(10,390,200,30);
//		pickup.addActionListener(this);
//		pickup.setBackground(Color.BLACK);
//		pickup.setForeground(Color.WHITE);
//		add(pickup);
		
		searchRoom=new JButton("Search Room");
		searchRoom.setBounds(10,390,200,30);
		searchRoom.addActionListener(this);
		searchRoom.setBackground(Color.BLACK);
		searchRoom.setForeground(Color.WHITE);
		add(searchRoom);
		
		logout=new JButton("Logout");
		logout.setBounds(10,435,200,30);
		logout.addActionListener(this);
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.WHITE);
		add(logout);
		
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\receptionist.png");
		Image i2=i1.getImage().getScaledInstance(384, 384, Image.SCALE_DEFAULT);
		JLabel img=new JLabel(new ImageIcon(i2));
		img.setBounds(300,30,384,384);
		add(img);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Reception();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newCust) {
			setVisible(false);
			new AddCustomer();
		}else if(e.getSource()==rooms) {
			setVisible(false);
			new Room();
		}else if(e.getSource()==allEmployees) {
			setVisible(false);
			new EmployeeInfo();
		}else if(e.getSource()==manager) {
			setVisible(false);
			new ManagerInfo();
		}else if(e.getSource()==custinfo) {
			setVisible(false);
			new CustomerInfo();
		}else if(e.getSource()==searchRoom) {
			setVisible(false);
			new SearchRoom();
		}else if(e.getSource()==update) {
			setVisible(false);
			new UpdateCheck();
		}else if(e.getSource()==roomStatus) {
			setVisible(false);
			new UpdateRoom();
		}else if(e.getSource()==checkout) {
			setVisible(false);
			new CheckOut();
		}else if(e.getSource()==logout) {
			setVisible(false);
			new Dashboard();
		}
	}

}
