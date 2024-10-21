import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

	Splash() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		heading.setBounds(80, 30, 1200, 60);
		heading.setFont(new Font("serif", Font.PLAIN, 60));
		heading.setForeground(Color.RED);
		add(heading);


		JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
		clickhere.setBounds(400, 400, 300, 70);
		clickhere.setBackground(Color.BLACK);
		clickhere.setForeground(Color.WHITE);
		clickhere.addActionListener(this);
		add(clickhere);


		setSize(1170, 650);
		setLocation(200, 50);
		setVisible(true);

		while(true) {
			heading.setVisible(false);
			try {
				Thread.sleep(500);
			} catch (Exception e){

			}

			heading.setVisible(true);
			try {
				Thread.sleep(500);
			} catch (Exception e){

			}
		}
	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Login();
	}

	public static void main(String args[]) {
		new Splash();
	}
}