package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){
         JPanel panel = new JPanel();
         panel.setBounds(5,5,700,500);
         panel.setLayout(null);
         panel.setBackground(new Color(90,156,163));
         add(panel);
         JTable table = new JTable();
         table.setBounds(0,40,700,400);
         table.setBackground(new Color(90,156,163));
         table.setFont(new Font("Tahoma",Font.BOLD,14));
         table.setForeground(Color.BLACK);

         panel.add(table);

         try{
             conn c=new conn();
             String q="select *From Department";
             ResultSet resultSet=c.statement.executeQuery(q);
             table.setModel(DbUtils.resultSetToTableModel(resultSet));
         }catch(Exception e){
             e.printStackTrace();
         }

         JLabel label1 = new JLabel("Department");
         label1.setBounds(10,10,100,30);
         label1.setFont(new Font("Tahoma",Font.BOLD,16));
         panel.add(label1);
        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(350,11,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label2);

        JButton back = new JButton("Back");
        back.setBounds(500,450,120,30);
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
        setSize(700,500);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();
    }
}
