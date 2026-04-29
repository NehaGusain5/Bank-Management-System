package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin(String pin){

        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1350,690,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3= new JLabel(i3);
        l3.setBounds(0,0,1350,690);
        add(l3);

        JLabel label1=new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,14));
        label1.setBounds(400,150,400,35);
        l3.add(label1);

        JLabel label2=new JLabel("NEW PIN");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,14));
        label2.setBounds(400,180,400,35);
        l3.add(label2);

        p1=new JPasswordField();
        p1.setForeground(Color.BLACK);
        p1.setBounds(500,180,150,30);
        p1.setFont(new Font("Raleway",Font.BOLD,16));
        l3.add(p1);

        JLabel label3= new JLabel("CONFIRM PIN");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System",Font.BOLD,14));
        label3.setBounds(400,220,400,35);
        l3.add(label3);

        p2=new JPasswordField();
        p2.setForeground(Color.BLACK);
        p2.setBounds(500,220,150,30);
        p2.setFont(new Font("Raleway",Font.BOLD,16));
        l3.add(p2);

        setSize(1550,830);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);

        b1=new JButton("CHANGE");
        b1.setBounds(600,300,130,30);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(600,340,130,30);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l3.add(b2);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            char[] pin1=p1.getPassword();
            char[] pin2=p2.getPassword();
            if(!Arrays.equals(pin1,pin2)){
                JOptionPane.showMessageDialog(null,"PINs do not match");
                return;
            }
            if(e.getSource()==b1){
                if(pin1.length==0){
                    JOptionPane.showMessageDialog(null,"Please enter a PIN");
                    return;
                }
                if(pin2.length==0){
                    JOptionPane.showMessageDialog(null,"Please enter a PIN");
                    return;
                }
                String newPin=new String(pin1);
                Connect c = new Connect();
                String q1="update bank set pin = '"+newPin+"' where pin = '"+pin+"'";
                String q2="update login set pin = '"+newPin+"' where pin = '"+pin+"'";
                String q3="update signupthree set pin = '"+newPin+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "Pin Changed Successfully!");
                setVisible(false);
                new Main_Class(pin);
            }else if(e.getSource()==b2){
                new Main_Class(pin);
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Pin("");
    }
}
