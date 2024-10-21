import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateEmployee  extends JFrame implements ActionListener {


    JButton add, back;

    JLabel lblFirstName, lblMiddleName, lblLastName, dcdob, education, designation,salary, address, lblAadhar, phone, email, lblempId;
//    JLabel eID;
    JTextField tfFirstName, tfMiddleName, tfLastName, tfEducation, tfDesignation,tfSalary, tfAddress, tfAadhar, tfPhone, tfEmail;
    String employeeId;
    updateEmployee( String employeeId){
        this.employeeId = employeeId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);


        JLabel firstName = new JLabel("First name");
        firstName.setBounds(50, 150, 150, 30);
        firstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(firstName);

        JLabel lblFirstName = new JLabel();
        lblFirstName.setBounds(220, 150, 250, 30);
        add(lblFirstName);

        JLabel middleName = new JLabel("Middle name");
        middleName.setBounds(50, 200, 150, 30);
        middleName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(middleName);

        JLabel lblMiddleName = new JLabel();
        lblMiddleName.setBounds(220, 200, 250, 30);
        add(lblMiddleName);


        JLabel lastName = new JLabel("Last name");
        lastName.setBounds(50, 250, 150, 30);
        lastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lastName);

        JLabel lblLastName = new JLabel();
        lblLastName.setBounds(220, 250, 250, 30);
        add(lblLastName);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 300, 150, 30);
        dob.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(dob);

         dcdob = new JLabel();
        dcdob.setBounds(220, 300, 150, 30);
        add(dcdob);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(50, 350, 250, 30);
        education.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(education);


        tfEducation = new JTextField();
        tfEducation.setBounds(220, 350, 250, 30);
        add(tfEducation);

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

        lblAadhar = new JLabel();
        lblAadhar.setBounds(610, 350, 250, 30);
        add(lblAadhar);

        JLabel empId = new JLabel("Employee Id");
        empId.setBounds(520, 400, 150, 30);
        empId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(empId);

        lblempId = new JLabel();
        lblempId.setBounds(680, 400, 80, 30);
        lblempId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblempId);


        try{
            Conn conn = new Conn();
            String query = "select * from employee where empId = '"+employeeId+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                lblFirstName.setText(rs.getString("firstName"));
                lblMiddleName.setText(rs.getString("middleName"));
                lblLastName.setText(rs.getString("lastName"));
                dcdob.setText(rs.getString("dob"));
                lblAadhar.setText(rs.getString("aadhar"));
                empId.setText(rs.getString("empId"));
                tfEducation.setText(rs.getString("education"));
                tfDesignation.setText(rs.getString("designation"));
                tfSalary.setText(rs.getString("salary"));
                tfAddress.setText(rs.getString("address"));
                tfPhone.setText(rs.getString("phone"));
                tfEmail.setText(rs.getString("email"));




            }
        }catch (Exception e){
            e.printStackTrace();
        }
        add = new JButton("Update Details");
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

        new updateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == add){
            String salary = tfSalary.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String education = tfEducation.getText();
            String designation = tfDesignation.getText();

            try{
                Conn c = new Conn();
                String query;
                query = "update employee set education = '"+education+"', designation = '"+designation+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"' where empID = '"+employeeId+"' ";


                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated successfully");
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
