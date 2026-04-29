package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JLabel label1,label2,label3;
    JTextField textField;
    JPasswordField password;
    JButton button1,button2,button3;

    Login(){
        super("BANK MANAGEMENT SYSTEM");//nothing above super
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/sbi.png"));//store in i1
        Image i2=i1.getImage().getScaledInstance(150,100,Image.SCALE_DEFAULT);//scaled image
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,150,100);//location
        add(image);

        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2=ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);

        label1=new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(280,125,450,40);//frame or bouder is consider to shift
        add(label1);

        label2=new JLabel("Card Number:");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.BLACK);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField = new JTextField(15);
        textField.setBounds(360,190,230,30);
        textField.setFont(new Font("Arial",Font.BOLD,14));
        add(textField);

        label3=new JLabel("Pin:");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.BLACK);
        label3.setBounds(150,230,375,30);
        add(label3);

        password=new JPasswordField(15);
        password.setBounds(360,250,230,30);
        password.setFont(new Font("Arial",Font.BOLD,14));
        add(password);

        button1=new JButton("Sign In");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.BLACK);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2=new JButton("Clear");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.BLACK);
        button2.setBounds(450,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3=new JButton("Sign up");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.BLACK);
        button3.setBounds(300,350,250,30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/sbibg.png"));
        Image iii2=iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);
        setLayout(null);
        setSize(850,480);
        setLocation(280,150);
        //setUndecorated(true); //removes the title bar
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) //e gets command of which button choose
    {
        try{
            if(e.getSource()==button1){
                Connect con=new Connect();
                String cardno=textField.getText();
                String pin=new String(password.getPassword());
                String q="select * from login where card_number='"+cardno+"' and pin='"+pin+"'";//String.valueOf(pin)+"'";
                ResultSet resultSet=con.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_Class(pin);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid card number or pin");
                }
            }else if(e.getSource()==button2){
                textField.setText("");
                password.setText("");
            }else if(e.getSource()==button3){
                new Signup();
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new Login();
    }
}
