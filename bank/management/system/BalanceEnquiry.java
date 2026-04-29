package bank.management.system;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JLabel label1;
    JButton b2;
    String pin;
    BalanceEnquiry(String pin){
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1350,690,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3= new JLabel(i3);
        l3.setBounds(0,0,1350,690);
        add(l3);

        JLabel label2=new JLabel("YOUR CURRET BALANCE IS Rs.");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,14));
        label2.setBounds(400,150,400,35);
        l3.add(label2);

        label1=new JLabel();
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,14));
        label1.setBounds(400,180,450,35);
        l3.add(label1);

        b2=new JButton("BACK");
        b2.setBounds(600,340,130,30);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l3.add(b2);

        int balance=0;
        try{
            Connect c= new Connect();
            ResultSet resultSet=c.statement.executeQuery("Select* from bank where pin='"+pin+"'");
            while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance-=Integer.parseInt(resultSet.getString("amount"));
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        label1.setText(""+balance); //we took a empty string to avoid any error as balance is integer
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Main_Class(pin);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
