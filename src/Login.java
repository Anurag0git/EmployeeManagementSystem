import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener{
	
	
	JTextField tfuname;
	JTextField tfpsswd;
	
	Login(){
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);	
		
		JLabel uname = new JLabel("Username");
		uname.setBounds(40, 20, 100, 30);
		add(uname);
		
		 tfuname = new JTextField();
		tfuname.setBounds(150, 20, 150, 30);
		add(tfuname);
		
		JLabel pssd = new JLabel("Password");		
		pssd.setBounds(40, 70, 100, 30);
		add(pssd);
		
		tfpsswd = new JTextField();
		tfpsswd.setBounds(150, 70, 150, 30);
		add(tfpsswd);
		
		
		JButton Login = new JButton("Login");
		Login.setBounds(150, 140, 150, 30);
		Login.setBackground(Color.BLACK);
		Login.setForeground(Color.WHITE);
		Login.setFont(new Font("serif", Font.PLAIN, 24));
//		image.add(click_here);
		Login.addActionListener((ActionListener) this);
		add(Login);
		
		setSize(600, 300);		//length, width
		setLocation(450, 200); 	//x, y
		
		
		
		setVisible(true);		//To make window visible
			
	}
	

	public static void main(String[] args) {
		new Login();
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {

		try {
			String username = tfuname.getText();
			String password = tfpsswd.getText();


			String query = "select * from login where username =  '"+username+"' and password = '"+password+"'";

			Conn c = new Conn();

			ResultSet rs = c.s.executeQuery(query);

			if(rs.next()){
				setVisible(false);

				new Home();
			}else{
				JOptionPane.showMessageDialog(null,"Invalid username or password");
				setVisible(false);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
