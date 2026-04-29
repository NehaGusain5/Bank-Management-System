package bank.management.system;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener {
    TextField textField;
    JButton b1,b2;
    String pin;

     Withdrawl(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1350,690,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3= new JLabel(i3);
        l3.setBounds(0,0,1350,690);
        add(l3);

        JLabel label2=new JLabel("ENTER AMOUNT TO WITHDRAW");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,14));
        label2.setBounds(400,150,400,35);
        l3.add(label2);

        JLabel label1=new JLabel("*MINIMUM AMOUNT TO WITHDRAW IS 25,000*");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,10));
        label1.setBounds(400,180,450,35);
        l3.add(label1);

        textField =new TextField();
        textField.setForeground(Color.BLACK);
        textField.setBounds(400,220,300,30);
        textField.setFont(new Font("Raleway",Font.BOLD,16));
        l3.add(textField);

        b1=new JButton("WITHDRAW");
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
        if(e.getSource()==b1){
        try{
            String amount=textField.getText();
            Date date=new Date();
            if(textField.getText().equals("")){
                JOptionPane.showMessageDialog(this,"PLEASE ENTER AMOUNT");
            }else{
                Connect c= new Connect();
                ResultSet resultSet=c.statement.executeQuery("select* from bank where pin='"+pin+"'");
                int balance=0;
                while(resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if(Integer.parseInt(amount)>balance){
                   JOptionPane.showMessageDialog(null, "insufficent balance");
                   return;
            }
            c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdraw','"+amount+"')");
            JOptionPane.showMessageDialog(null, "Rs. "+amount+" DEBITTED SUCCESSFULLY");
            setVisible(false);
            new Main_Class(pin);
           
    }}catch(Exception E){

    }}
    else if(e.getSource()==b2){
        setVisible(false);
        new Main_Class(pin);
    }
    }
     public static void main(String[] args) {
        new Withdrawl("");
     }
}
