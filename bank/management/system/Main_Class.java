package bank.management.system;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    Main_Class(String pin){
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1350,690,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3= new JLabel(i3);
        l3.setBounds(0,0,1350,690);
        add(l3);

        JLabel label=new JLabel("Please Select Your Transiction");
        label.setBounds(430,140,700,30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,16));
        l3.add(label);

        b1=new JButton("DEPOSIT");
        b1.setBounds(360,220,160,30);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("CASH WITHDRAWAL");
        b2.setBounds(570,220,160,30);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l3.add(b2);

        b3=new JButton("FAST CASH");
        b3.setBounds(360,260,160,30);
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        l3.add(b3);

        b4=new JButton("MINI STATEMENT");
        b4.setBounds(570,260,160,30);
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        l3.add(b4);

        b5=new JButton("PIN CHANGE");
        b5.setBounds(360,300,160,30);
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        l3.add(b5);

        b6=new JButton("BALANCE ENQUIRY");
        b6.setBounds(570,300,160,30);
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        l3.add(b6);

        b7=new JButton("EXIT");
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
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        }else if(e.getSource()==b7){
            System.exit(0); //to close the whole code
        }else if(e.getSource()==b2){
            new Withdrawl(pin);
            setVisible(false);
        }
        else if(e.getSource()==b6){
            new BalanceEnquiry(pin);
            setVisible(false);
        }else if(e.getSource()==b3){
            new FastCash(pin);
            setVisible(false);
        }else if(e.getSource()==b5){
            new Pin(pin);
            setVisible(false);
        }else if(e.getSource()==b4){
            new Mini_Statement(pin);
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Main_Class("");
    }
}
