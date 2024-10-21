import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class addEmployee  extends JFrame implements ActionListener {


    JButton add, back;

//    JLabel firstName, middleName, lastName, dob, education, designation,salary, address, aadhar, phone, email, eID;
    JLabel eID;
    JTextField tfFirstName, tfMiddleName, tfLastName, tfEducation, tfDesignation,tfSalary, tfAddress, tfAadhar, tfPhone, tfEmail;
    JDateChooser dcdob;
    JComboBox cbEducation;
    Random rnd = new Random();
    int number = rnd.nextInt(999999);
    addEmployee(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);


        JLabel firstName = new JLabel("First name");
        firstName.setBounds(50, 150, 150, 30);
        firstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(firstName);

        tfFirstName = new JTextField();
        tfFirstName.setBounds(220, 150, 250, 30);
        add(tfFirstName);

        JLabel middleName = new JLabel("Middle name");
        middleName.setBounds(50, 200, 150, 30);
        middleName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(middleName);

        tfMiddleName = new JTextField();
        tfMiddleName.setBounds(220, 200, 250, 30);
        add(tfMiddleName);


        JLabel lastName = new JLabel("Last name");
        lastName.setBounds(50, 250, 150, 30);
        lastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lastName);

        tfLastName = new JTextField();
        tfLastName.setBounds(220, 250, 250, 30);
        add(tfLastName);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 300, 150, 30);
        dob.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(dob);

        dcdob = new JDateChooser();
        dcdob.setBounds(220, 300, 150, 30);
        add(dcdob);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(50, 350, 250, 30);
        education.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(education);


        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbEducation = new JComboBox(courses);
        cbEducation.setBackground(Color.WHITE);
        cbEducation.setBounds(220, 350, 250, 30);
        add(cbEducation);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 400, 250, 30);
        designation.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(designation);

         tfDesignation = new JTextField();
        tfDesignation.setBounds(220, 400, 250, 30);
        add(tfDesignation);


        JLabel salary = new JLabel("Salary");
        salary.setBounds(520, 150, 80, 30);
        salary.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(salary);

        tfSalary = new JTextField();
        tfSalary.setBounds(610, 150, 150, 30);
        add(tfSalary);


        JLabel address = new JLabel("Address");
        address.setBounds(520, 200, 80, 30);
        address.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(address);

        tfAddress = new JTextField();
        tfAddress.setBounds(610, 200, 250, 30);
        add(tfAddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(520, 250, 80, 30);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(phone);

        tfPhone = new JTextField();
        tfPhone.setBounds(610, 250, 250, 30);
        add(tfPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(520, 300, 80, 30);
        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(email);

        tfEmail = new JTextField();
        tfEmail.setBounds(610, 300, 250, 30);
        add(tfEmail);

        JLabel Aadhar = new JLabel("Aadhar");
        Aadhar.setBounds(520, 350, 80, 30);
        Aadhar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(Aadhar);

        tfAadhar = new JTextField();
        tfAadhar.setBounds(610, 350, 250, 30);
        add(tfAadhar);

        JLabel empId = new JLabel("Employee Id");
        empId.setBounds(520, 400, 150, 30);
        empId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(empId);

        eID = new JLabel(""+ number);
        eID.setBounds(680, 400, 80, 30);
        eID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(eID);


        add = new JButton("Add Employee");
        add.setBounds(250, 600, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 600, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);


        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);

    }

    public static void main(String[] args) {

        new addEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == add){
            String name = tfFirstName.getText();
            String mName = tfMiddleName.getText();
            String lName = tfLastName.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfSalary.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String education = (String) cbEducation.getSelectedItem();
            String designation = tfDesignation.getText();
            String aadhar = tfAadhar.getText();
            String empId = (String) eID.getText();

            try{
                Conn conn = new Conn();
                String query;
                query = "insert into employee values('"+name+"', '"+mName+"', '"+lName+"', '"+education+"', '"+designation+"', '"+salary+"', '"+address+"', '"+aadhar+"', '"+phone+"', '"+email+"', '"+empId+"', '"+dob+"')";


                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new Home();
            }catch (Exception e ){

                e.printStackTrace();
            }







        } else {

            setVisible(false);
            new Home();

        }
    }
}
