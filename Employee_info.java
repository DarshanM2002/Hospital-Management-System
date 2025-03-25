package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info(){
     JPanel panel = new JPanel();
     panel.setBounds(5,5,1000,500);
     panel.setLayout(null);
     panel.setBackground(new Color(109,164,170));
     add(panel);
     JTable table = new JTable();
     table.setBounds(10,40,700,400);
     table.setFont(new Font("Tahoma",Font.BOLD,12));
     table.setBackground(new Color(109,164,170));
     panel.add(table);
      try{
          conn c=new conn();
          String q="select *from EMP_INFO";
          ResultSet resultSet=c.statement.executeQuery(q);
          table.setModel(DbUtils.resultSetToTableModel(resultSet));
      }
      catch(Exception e){
          e.printStackTrace();
      }
      JLabel label1 = new JLabel("Name");
      label1.setBounds(10,10,100,20);
      label1.setFont(new Font("Tahoma",Font.BOLD,13));
      panel.add(label1);
        JLabel label2 = new JLabel("Age");
        label2.setBounds(130,10,100,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,13));
        panel.add(label2);

        JLabel label3 = new JLabel("Phone Number");
        label3.setBounds(240,10,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,13));
        panel.add(label3);
        JLabel label4 = new JLabel("Salary");
        label4.setBounds(370,10,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,13));
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(490,10,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,13));
        panel.add(label5);
        JLabel label6 = new JLabel("Aadhar Number");
        label6.setBounds(600,10,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,13));
        panel.add(label6);

        JButton back = new JButton("BACK");
        back.setBounds(350,420,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,500);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee_info();
    }
}
