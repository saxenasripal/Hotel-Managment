package managmentSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HotelManagmentSystem extends JFrame implements ActionListener{

	public HotelManagmentSystem(){
		setSize(912,712);
		setLocation(200,30);
		setLayout(null);
		setTitle("Hotel Management System");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
       
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\Hotel.png");
		Image i2=i1.getImage().getScaledInstance(384, 384, Image.SCALE_SMOOTH);
		JLabel img=new JLabel(new ImageIcon(i2));
		img.setBounds(250, 150, 384, 384);
		add(img);
		setBackground(new Color(247, 247, 241));
		
		JLabel text =new JLabel("HOTEL \n MANAGMENT\n SYSTEM");
		text.setBounds(150, 70, 600, 50);
		text.setOpaque(true);
		text.setBackground(new Color(229,230,29));
		text.setForeground(new Color(36, 22, 37));
		text.setFont(new Font("serif", Font.PLAIN, 40));
		add(text);
		
		JButton next=new JButton("NEXT");
		next.setBounds(370, 600, 150, 40);
		next.setBackground(new Color(15,39,48));
		next.setForeground(new Color(228,220,193));
		next.addActionListener(this);
		next.setFont(new Font("serif",Font.PLAIN,25));
		add(next);
		
		setVisible(true);
		
		
		/*
		 * this is an infinite loop which helps in blinking the text witch we are added
		 */
		
//		while(true) {
//			text.setVisible(false);
//			try {
//				Thread.sleep(500);
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//			text.setVisible(true);
//			try {
//				Thread.sleep(500);
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
	

	public static void main(String[] args) {
		new HotelManagmentSystem();
	}
	
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login();
		
	}

}
