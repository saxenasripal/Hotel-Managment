package managmentSystem;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	
	JTextField username;
	JPasswordField password;
	JButton login,cancel;

	public Login() {
		getContentPane().setBackground(Color.WHITE);  //to change the background of the Frame
		
		setLayout(null);
		setTitle("Login");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		JLabel user=new JLabel("Username");
		user.setBounds(40, 20, 100, 30);
		add(user);
		
		username= new JTextField();
		username.setBounds(150, 20, 150, 25);
		add(username);
		
		JLabel pass=new JLabel("Password");
		pass.setBounds(40, 70, 100, 30);
		add(pass);
		
		password= new JPasswordField();
		password.setBounds(150, 70, 150, 25);
		add(password);
		
		login=new JButton("Login");
		login.setBounds(40, 150, 120, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		
		add(login);
		
		
		
		cancel=new JButton("Cancel");
		cancel.setBounds(180, 150, 120, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\login.png");
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(350, 10, 200, 200);
		add(img);
		setBounds(500,200,600,300);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Login();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==login) {
			
			/*
			 * Accepting the Data From the user......
			 */
			String user=username.getText();
			String pass=password.getText();
			
			try {
				
				/*
				 * Validating the data from the Database........
				 */
				Conn c=new Conn();
				String query="select * from login where username = '"+user+"'and password='"+pass+"'";
				ResultSet res=c.stmt.executeQuery(query);
				if(res.next()) {
					new Dashboard();
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Inavalid Credentials");
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==cancel) {
			setVisible(false);
		}
		
	}
}
