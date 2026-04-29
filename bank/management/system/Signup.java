package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.Random;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener {
    JTextField textName,textFather,textEmail,textMartial,textAddress,textCity,textPin,textState;
    JDateChooser dateChooser;
    Random  rand = new Random();
    long   random = (rand.nextLong()%9000l)+1000l;
    String first = " "+ Math.abs(random);
    JRadioButton r1,r2,m1,m2,m3;
    JButton next;

    Signup(){
            super("APPLICATION FORM");
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/sbi.png"));
            Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon i3= new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(50,10,150,100);
            add(image);

            JLabel label1=new JLabel("APPLICATION FORM NO."+first);
            label1.setBounds(230,20,600,40);
            label1.setFont(new Font("Raaleway",Font.BOLD,28));
            add(label1);

            JLabel label2=new JLabel("Page 1");
            label2.setFont(new Font("Ralway",Font.BOLD,22));
            label2.setBounds(330,70,600,30);
            add(label2);

            JLabel label3=new JLabel("Personal Details");
            label3.setFont(new Font("Ralway",Font.BOLD,22));
            label3.setBounds(290,100,600,30);
            add(label3);

            JLabel labelName=new JLabel("Name");
            labelName.setFont(new Font("Ralway",Font.BOLD,20));
            labelName.setBounds(50,150,100,30);
            add(labelName);

            textName =new JTextField();
            textName.setFont(new Font("Ralway",Font.BOLD,14));
            textName.setBounds(280,150,400,30);
            add(textName);

            JLabel labelFather=new JLabel("Father's Name");
            labelFather.setFont(new Font("Ralway",Font.BOLD,20));
            labelFather.setBounds(50,190,150,30);
            add(labelFather);

            textFather=new JTextField();
            textFather.setFont(new Font("Ralway",Font.BOLD,14));
            textFather.setBounds(280,190,400,30);
            add(textFather);

            JLabel dob=new JLabel("Date of birth");
            dob.setFont(new Font("Ralway",Font.BOLD,20));
            dob.setBounds(50,230,200,30);
            add(dob);

            dateChooser = new JDateChooser();
            dateChooser.setBounds(280, 230, 400, 30); // Set bounds for the date chooser
            add(dateChooser);

            JLabel labelGender=new JLabel("Gender");
            labelGender.setFont(new Font("Raleway",Font.BOLD,20));
            labelGender.setBounds(50,270,100,30);
            add(labelGender);

            r1=new JRadioButton("Male");
            r1.setFont(new Font("Raleway",Font.BOLD,14));
            r1.setBounds(300,270,60,30);
            r1.setBackground(new Color(255,255,255));
            add(r1);

            r2=new JRadioButton("Female");
            r2.setFont(new Font("Raleway",Font.BOLD,14));
            r2.setBounds(430,270,80,30);
            r2.setBackground(new Color(255,255,255));
            add(r2);

            ButtonGroup buttonGroup = new ButtonGroup(); //we can select only one button
            buttonGroup.add(r1);
            buttonGroup.add(r2);

            JLabel email=new JLabel("E-Mail");
            email.setFont(new Font("Raleway",Font.BOLD,20));
            email.setBounds(50,310,100,30);
            add(email);

            textEmail=new JTextField();
            textEmail.setFont(new Font("Raleway",Font.BOLD,14));
            textEmail.setBounds(280,310,400,30);
            add(textEmail);

            JLabel martial=new JLabel("Marital Status");
            martial.setFont(new Font("Raleway",Font.BOLD,20));
            martial.setBounds(50,350,200,30);
            add(martial);

            m1=new JRadioButton("Married");
            m1.setFont(new Font("Raleway",Font.BOLD,14));
            m1.setBounds(300,350,80,30);
            m1.setBackground(new Color(255,255,255));
            add(m1);

            m2=new JRadioButton("Unmarried");
            m2.setFont(new Font("Raleway",Font.BOLD,14));
            m2.setBounds(430,350,100,30);
            m2.setBackground(new Color(255,255,255));
            add(m2);

            m3=new JRadioButton("Other");
            m3.setFont(new Font("Raleway",Font.BOLD,14));
            m3.setBounds(560,350,80,30);
            m3.setBackground(new Color(255,255,255));
            add(m3);

            ButtonGroup buttonGroup2= new ButtonGroup();
            buttonGroup2.add(m1);
            buttonGroup2.add(m2);
            buttonGroup2.add(m3);

            JLabel address=new JLabel("Address");
            address.setFont(new Font("Raleway",Font.BOLD,20));
            address.setBounds(50,390,200,30);
            add(address);

            textAddress = new JTextField();
            textAddress.setFont(new Font("Raleway",Font.BOLD,14));
            textAddress.setBounds(280,390,400,30);
            add(textAddress);

            JLabel city= new JLabel("City");
            city.setFont(new Font("Raleway",Font.BOLD,20));
            city.setBounds(50,430,200,30);
            add(city);

            textCity=new JTextField();
            textCity.setFont(new Font("Raleway",Font.BOLD,14));
            textCity.setBounds(280,430,400,30);
            add(textCity);

            JLabel pin = new JLabel("Pin Code");
            pin.setFont(new Font("Raleway",Font.BOLD,20));
            pin.setBounds(50,470,200,30);
            add(pin);

            textPin=new JTextField();
            textPin.setFont(new Font("Raleway",Font.BOLD,14));
            textPin.setBounds(280,470,400,30);
            add(textPin);

            JLabel state = new JLabel("State");
            state.setFont(new Font("Raleway",Font.BOLD,20));
            state.setBounds(50,510,200,30);
            add(state);

            textState=new JTextField();
            textState.setFont(new Font("Raleway",Font.BOLD,14));
            textState.setBounds(280,510,400,30);
            add(textState);

            next= new JButton("Next");
            next.setFont(new Font("Raleway",Font.BOLD,14));
            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.setBounds(620,550,80,30);
            next.addActionListener(this);
            add(next);

        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setSize(750,650);
        setLocation(260,40);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String formno=first;
        String name=textName.getText();
        String f=textFather.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(r1.isSelected()){
            gender="Male";
        }else if(r2.isSelected()){
            gender="Female";
        }
        String email=textEmail.getText();
        String marital=null;
        if(m1.isSelected()){
            marital="Married";
        }else if(m2.isSelected()){
            marital="Unmarried";
        }else if(m3.isSelected()){
            marital="Other";
        }
        String add= textAddress.getText();
        String city=textCity.getText();
        String pin=textPin.getText();
        String state=textState.getText();

        try{
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            }else{
                Connect con1=new Connect();
                String q="insert into SignUp values('"+formno+"','"+name+"','"+f+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+add+"','"+city+"','"+pin+"','"+state+"')";
                con1.statement.executeUpdate(q); //input value in database
                new Signup2(formno);
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}