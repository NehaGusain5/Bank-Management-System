package bank.management.system;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    FastCash( String pin) {
        this.pin = pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1350,690,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3= new JLabel(i3);
        l3.setBounds(0,0,1350,690);
        add(l3);

        JLabel label=new JLabel("Select Withdrawal Amount");
        label.setBounds(430,140,700,30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,18));
        l3.add(label);

        b1=new JButton("Rs.100");
        b1.setBounds(360,220,160,30);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("Rs.500");
        b2.setBounds(570,220,160,30);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l3.add(b2);

        b3=new JButton("Rs.1000");
        b3.setBounds(360,260,160,30);
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        l3.add(b3);

        b4=new JButton("Rs.2000");
        b4.setBounds(570,260,160,30);
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        l3.add(b4);

        b5=new JButton("Rs.5000");
        b5.setBounds(360,300,160,30);
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        l3.add(b5);

        b6=new JButton("Rs.10000");
        b6.setBounds(570,300,160,30);
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        l3.add(b6);

        b7=new JButton("BACK");
        b7.setBounds(570,340,160,30);
        b7.setForeground(Color.BLACK);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,830);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b7){
            setVisible(false);
            new Main_Class(pin);}
        else{
            String amount=((JButton)e.getSource()).getText().substring(3);
            Connect c= new Connect();
            Date date= new Date();
            try{
                ResultSet resultSet=c.statement.executeQuery("select * from bank where pin ='"+pin+"'");
                int balance =0;
                while(resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(resultSet.getString("amount"));
                    }
                }String num="17";
                if(e.getSource()!=b7 && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debeted Successfully");
            }catch(Exception E)
            {
                E.printStackTrace();
            }
            setVisible(false);
            new Main_Class(pin);
        }
    }
    public static void main(String[] args) {
        new FastCash("");
}
}