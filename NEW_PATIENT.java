package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber,textName,textFieldDisease,textFieldDeposite;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton b1,b2;
    NEW_PATIENT(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);
        JLabel LabelName=new JLabel("New Patient Form");
        LabelName.setBounds(118,11,260,53);
        LabelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(LabelName);
        JLabel LabelID=new JLabel("ID:");
        LabelID.setBounds(35,76,200,14);
        LabelID.setFont(new Font("Tahoma",Font.BOLD,14));
        LabelID.setForeground(Color.WHITE);
        panel.add(LabelID);
        comboBox=new JComboBox(new String[]{"Aadhar Card","Voter ID","Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);
        JLabel LabelNumber=new JLabel("Number:");
        LabelNumber.setBounds(35,111,200,14);
        LabelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        LabelNumber.setForeground(Color.WHITE);
        panel.add(LabelNumber);

        textFieldNumber=new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);
        JLabel labelName=new JLabel("Name:");
        labelName.setBounds(35,151,200,14);
        labelName.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);


        textName=new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);
        JLabel labelGender=new JLabel("Gender:");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(271,191,80,15);
        panel.add(r1);
        r2=new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(350,191,80,15);
        panel.add(r2);


        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        panel.add(textFieldDisease);
        JLabel LabelRoom=new JLabel("Room:");
        LabelRoom.setBounds(35,274,200,14);
        LabelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        LabelRoom.setForeground(Color.WHITE);
        panel.add(LabelRoom);
        //room choice//
        c1=new Choice();
        try {
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select *from Room");
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);


        JLabel LabelDate=new JLabel("Time:");
        LabelDate.setBounds(35,316,200,14);
        LabelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        LabelDate.setForeground(Color.WHITE);
        panel.add(LabelDate);

        Date date1=new Date();
        date=new JLabel(""+date1);
        date.setBounds(271,316,250,14);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        date.setForeground(Color.WHITE);
        panel.add(date);
        JLabel labelDeposite=new JLabel("Deposite:");
        labelDeposite.setBounds(35,359,200,14);
        labelDeposite.setBackground(Color.WHITE);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDeposite.setForeground(Color.WHITE);
        panel.add(labelDeposite);

        textFieldDeposite=new JTextField();
        textFieldDeposite.setBounds(271,359,150,20);
        panel.add(textFieldDeposite);
        b1=new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);
        b2=new JButton("Back");
        b2.setBounds(260,430,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);





        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new NEW_PATIENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            conn c=new conn();
            String radioBTN=null;
            if(r1.isSelected()){
                radioBTN="Male";
            }else if(r2.isSelected()){
                radioBTN="Female";
            }
            String s1=(String)comboBox.getSelectedItem();
            String s2=textFieldNumber.getText();
            String s3=textName.getText();
            String s4=radioBTN;
            String s5=textFieldDisease.getText();
            String s6=c1.getSelectedItem();
            String s7=date.getText();
            String s8=textFieldDeposite.getText();
            try{
                String q="insert into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1="update room set Availability ='Occupied' where room_no="+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Patient Added Successfully");

                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
}
