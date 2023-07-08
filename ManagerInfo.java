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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManagerInfo extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	public ManagerInfo() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Manager Information");
		ImageIcon x=new ImageIcon("C:\\Users\\mr\\Desktop\\images\\icon.png");
		Image y=x.getImage();
		setIconImage(y);
		
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(10,20,970,300);
		add(scrollPane);
		table =new JTable();
		table.setBackground(Color.white);
		scrollPane.setViewportView(table);
		DefaultTableModel model=new DefaultTableModel();
		Object[] column= {"Name","Age","Gender","Job","Salary","Mobile","Email","Aadhar"};
		final Object[] row=new Object[8];
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		try {
			String query2="select * from employee where job='Manager'";
			Conn c=new Conn();
			ResultSet rs=c.stmt.executeQuery(query2);
			for(int i=0;rs.next();i++) {
				row[0]=rs.getString(1);
				row[1]=rs.getString(2);
				row[2]=rs.getString(3);
				row[3]=rs.getString(4);
				row[4]=rs.getString(5);
				row[5]=rs.getString(6);
				row[6]=rs.getString(7);
				row[7]=rs.getString(8);
				
				model.addRow(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.white);
		back.setBounds(420,370,120,30);
		back.addActionListener(this);
		add(back);
		
		
		setBounds(300,200,1000,500);
		setVisible(true);
	
	}
	public static void main(String[] args) {
		new ManagerInfo();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			setVisible(false);
			new Reception();
		}
	}

}
