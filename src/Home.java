import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton add, view, update, remove;
    Home(){

        setLayout(null);

/*
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg));
		Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);   //We need to re-scale image		(length, width)
		ImageIcon i3 = new ImageIcon(i2);		//convert Image to ImageIcon
		JLabel image = new JLabel(i3);			//You can't add imageicon directly on JFrame, therefore you need to convert it to JLabel
		image.setBounds(50, 100, 1050, 500);		//Setting new bounds(layout)
		add(image);
*/


        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(350, 20, 400, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);



        add = new JButton("Add Employee");
        add.setBounds(350, 200, 150, 40);
        add.addActionListener(this);
        add(add);


        view = new JButton("View Employees");
        view.setBounds(600, 200, 150, 40);
        view.addActionListener(this);
        add(view);

        update = new JButton("Update Employee");
        update.setBounds(350, 300, 150, 40);
        update.addActionListener(this);
        add(update);

        remove = new JButton("Remove Employee");
        remove.setBounds(600, 300, 150, 40);
        remove.addActionListener(this);
        add(remove);



        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);



    }
    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            setVisible(false);
            new addEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new viewEmployees();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new viewEmployees();
        }else {
            setVisible(false);
            new removeEmployee();
        }
    }
}
