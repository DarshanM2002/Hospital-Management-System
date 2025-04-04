package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame {
    Patient_Discharge(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,590,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);
        JLabel label=new JLabel("Check Out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label2=new JLabel("Customer ID");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3=new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        JLabel RN=new JLabel();
        RN.setBounds(200,130,150,20);
        RN.setFont(new Font("Tahoma",Font.BOLD,14));
        RN.setForeground(Color.WHITE);
        panel.add(RN);
        JLabel label4=new JLabel("In Time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        JLabel INTime=new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.WHITE);
        panel.add(INTime);

        JLabel label5=new JLabel("Out Time");
        label5.setBounds(30,230,250,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        Date date=new Date();

        JLabel OUTTime=new JLabel(""+date);
        OUTTime.setBounds(200,230,250,20);
        OUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTTime.setForeground(Color.WHITE);
        panel.add(OUTTime);

        JButton discharge=new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conn c=new conn();
                try{
                    c.statement.executeUpdate("delete from patient_info where number='"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability='Available' where room_no='"+RN.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JButton check=new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conn c=new conn();
                try{
                    ResultSet resultSet=c.statement.executeQuery("select * from patient_info where number='"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        RN.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        JButton back=new JButton("Back");
        back.setBounds(300,300,120,30);
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
        setSize(800,400);
        setVisible(true);
        setLocation(300,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient_Discharge();
    }
}
