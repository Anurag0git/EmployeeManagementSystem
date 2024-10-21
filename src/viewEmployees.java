import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewEmployees extends JFrame implements ActionListener {


    JTable table;
    Choice chEmployeeID;

    JButton searchButton, printButton, updateButton, backButton;

    viewEmployees(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel search = new JLabel("Search by Employee id");
        search.setBounds(20, 20, 150, 20);
        add(search);

        chEmployeeID = new Choice();
        chEmployeeID.setBounds(190, 20, 150, 20);
        add(chEmployeeID);

        table = new JTable();

        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");

            while(rs.next()){
                chEmployeeID.add(rs.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(5, 100, 875, 600);
        add(jsp);


        searchButton = new JButton("Search");
        searchButton.setBounds(20, 60, 80, 20);
        searchButton.addActionListener(this);
        add(searchButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(120, 60, 80, 20);
        updateButton.addActionListener(this);
        add(updateButton);

        printButton = new JButton("Print");
        printButton.setBounds(220, 60, 80, 20);
        printButton.addActionListener(this);
        add(printButton);

        backButton = new JButton("Back");
        backButton.setBounds(320, 60, 80, 20);
        backButton.addActionListener(this);
        add(backButton);




        setSize(900, 700);
        setLocation(300,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new viewEmployees();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == searchButton){

        String query = "select * from employee where empId = '"+chEmployeeID.getSelectedItem()+"'";
        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        }else if(ae.getSource() == printButton){

            try{
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==updateButton) {
            setVisible(false);
            new updateEmployee(chEmployeeID.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
        }
    }
}
