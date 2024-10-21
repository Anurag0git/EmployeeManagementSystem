import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class removeEmployee extends JFrame implements ActionListener {

    Choice cEmpid;
    JButton delete, back;
    removeEmployee(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lablempid = new JLabel("Employee id");
        lablempid.setBounds(50, 50, 100, 30);
        add(lablempid);

        cEmpid = new Choice();
        cEmpid.setBounds(200, 50, 150, 30);
        add(cEmpid);

        try{
            Conn c = new Conn();
            String query = "select * from employee";

            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cEmpid.add(rs.getString("empId"));
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lablname = new JLabel("Name");
        lablname.setBounds(50, 100, 100, 30);
        add(lablname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 400, 30);
        add(lblname);

        JLabel lablphone = new JLabel("Phone");
        lablphone.setBounds(50, 150, 100, 30);
        add(lablphone);

        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);
/*

        JLabel lablemail = new JLabel("Email");
        lablemail.setBounds(50, 200, 100, 30);
        add(lablemail);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 800, 30);
        add(lblemail);
*/


        try{
            Conn c = new Conn();
            String query = "select employee.firstName, employee.middleName, employee.lastName, employee.phone, employee.email from employee where empId = '"+cEmpid.getSelectedItem()+"'";

            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("firstName")+rs.getString("middleName")+" "+rs.getString("lastName"));
                lblphone.setText(rs.getString("phone"));
//                lblemail.setText(rs.getString("email"));
            }





        }catch(Exception e){
            e.printStackTrace();
        }


        cEmpid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Conn c = new Conn();
                    String query = "select employee.firstName, employee.middleName, employee.lastName, employee.phone, employee.email from employee where empId = '"+cEmpid.getSelectedItem()+"'";

                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        lblname.setText(rs.getString("firstName")+rs.getString("middleName")+rs.getString("lastName"));
                        lblphone.setText(rs.getString("phone"));
//                        lablemail.setText(rs.getString("email"));
                    }





                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });





        delete= new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);


        back= new JButton("Back");
        back.setBounds(280, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);






        setSize(500, 400);
        setLocation(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new removeEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {


        if(ae.getSource() == delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empId = '"+cEmpid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee data deleted successfully");
                setVisible(false);
                new Home();

            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }

    }
}
