package bank.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Deposit extends JFrame implements ActionListener{
    String pin;
    TextField textField;
    JButton b1,b2;
    Deposit(String pin){

        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1350,690,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3= new JLabel(i3);
        l3.setBounds(0,0,1350,690);
        add(l3);

        JLabel label1=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,14));
        label1.setBounds(400,150,400,35);
        l3.add(label1);

        textField =new TextField();
        textField.setForeground(Color.BLACK);
        textField.setBounds(400,190,300,30);
        textField.setFont(new Font("Raleway",Font.BOLD,16));
        l3.add(textField);

        b1=new JButton("DEPOSIT");
        b1.setBounds(600,300,130,30);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(600,340,130,30);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        String amount=textField.getText();
        Date date=new Date();
        if(e.getSource()==b1){
            if(textField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER AMOUNT");
            }else{
                Connect c=new Connect();
                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs."+amount+" DEPOSITTED SUCCESSFULL");
                setVisible(false);
                new Main_Class(pin);
            }
        }else if(e.getSource()==b2){
            setVisible(false);
            new Main_Class(pin);
        }
    }catch(Exception E){
        E.printStackTrace();
    }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
   
}
