package managmentSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{
	
	/*
	 * Global Variables used for Accepting the data From the User/Form......
	 */
	
	JTextField tfname,tfage,tfsal,tfphone,tfemail,tfaadhar;
	JRadioButton rbmale,rbfemale;
	JComboBox cbjob;

	
	/*
	 * Constructors which creates the Frame/window when the Object is created
	 */
	public AddEmployee() {
		
		setLayout(null);
		setBounds(350, 200, 850, 540);		
		getContentPane().setBackground(Color.WHITE);
		setTitle("Add Employee");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		JLabel name=new JLabel("NAME");
		name.setBounds(60, 30, 120, 30);
		name.setFont(new Font("tahoma",Font.PLAIN,17));
		add(name);
		
		tfname=new JTextField();
		tfname.setBounds(200, 30, 150, 30);
		add(tfname);
		
		
		JLabel aadhar=new JLabel("AADHAR");
		aadhar.setBounds(60, 380, 120, 30);
		aadhar.setFont(new Font("tahoma",Font.PLAIN,17));
		add(aadhar);
		
		tfaadhar=new JTextField();
		tfaadhar.setBounds(200, 380, 150, 30);
		add(tfaadhar);
		
		
		JLabel age=new JLabel("AGE");
		age.setBounds(60, 80, 120, 30);
		age.setFont(new Font("tahoma",Font.PLAIN,17));
		add(age);
		
		tfage=new JTextField();
		tfage.setBounds(200, 80, 150, 30);
		add(tfage);
		
		JLabel gender=new JLabel("GENDER");
		gender.setBounds(60, 130, 120, 30);
		gender.setFont(new Font("tahoma",Font.PLAIN,17));
		add(gender);
		
		rbmale=new JRadioButton("Male");
		rbmale.setFont(new Font("tahoma",Font.PLAIN,14));
		rbmale.setBackground(Color.WHITE);
		rbmale.setBounds(200,130,70,30);
		add(rbmale);
		
		rbfemale=new JRadioButton("Female");
		rbfemale.setFont(new Font("tahoma",Font.PLAIN,14));
		rbfemale.setBackground(Color.WHITE);
		rbfemale.setBounds(280,130,70,30);
		add(rbfemale);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbfemale);
		bg.add(rbmale);
		
		JLabel Job=new JLabel("JOB");
		Job.setBounds(60, 180, 120, 30);
		Job.setFont(new Font("tahoma",Font.PLAIN,17));
		add(Job);
		
		String str[]= {"Front Desk Clear","Porters","Housekeeping","Kitechen Staff","Room Service","Chef","Waiter","Manager","Accountent"};
		cbjob=new JComboBox(str);
		cbjob.setBackground(Color.WHITE);
		cbjob.setBounds(200, 180, 150, 30);
		add(cbjob);
		
		JLabel sal=new JLabel("SALARY");
		sal.setBounds(60, 230, 120, 30);
		sal.setFont(new Font("tahoma",Font.PLAIN,17));
		add(sal);
		
		tfsal=new JTextField();
		tfsal.setBounds(200, 230, 150, 30);
		add(tfsal);
		
		JLabel phone=new JLabel("PHONE");
		phone.setBounds(60, 280, 120, 30);
		phone.setFont(new Font("tahoma",Font.PLAIN,17));
		add(phone);
		
		tfphone=new JTextField();
		tfphone.setBounds(200, 280, 150, 30);
		add(tfphone);
		
		JLabel email=new JLabel("EMAIL");
		email.setBounds(60, 330, 120, 30);
		email.setFont(new Font("tahoma",Font.PLAIN,17));
		add(email);
		
		tfemail=new JTextField();
		tfemail.setBounds(200, 330, 150, 30);
		add(tfemail);
		
		JButton submit=new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setBounds(150, 430, 100, 30);
		add(submit);
		
		ImageIcon i1=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\employee.jpg");
		Image i2=i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(380,60,450,450);
		add(img);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * Taking the values from the Form
		 */
		String name=tfname.getText();
		String age=tfage.getText();
		String sal=tfsal.getText();
		String phone=tfphone.getText();
		String email=tfemail.getText();
		String aadhar=tfaadhar.getText();
		String gender="";
		if (rbmale.isSelected()) {
			gender="male";
		}
		else if (rbfemale.isSelected()) {
			gender="female";
		}
		String job=(String) cbjob.getSelectedItem();
		
		
		/*
		 * adding the data into the DataBase......
		 */
		
		String query="insert into employee values ('"+name+"','"+age+"','"+gender+"','"+job+"','"+sal+"','"+phone+"','"+email+"','"+aadhar+"')";
		try {
			Conn c=new Conn();
			int a=c.stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Employee Added Successfully");
		}
		catch(Exception er) {
			er.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new AddEmployee();
	}
}
