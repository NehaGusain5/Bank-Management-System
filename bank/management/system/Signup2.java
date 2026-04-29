package bank.management.system;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
//import java.sql.*;
public class Signup2 extends JFrame implements ActionListener{
    String formno;
    JComboBox combobox,combobox2,combobox3,combobox4,combobox5;
    JTextField textPAN,textAadhar;
    JRadioButton s1,s2,e1,e2;
    JButton next;

    Signup2(String formno){
            super("APPLICATION FORM");

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/sbi.png"));
            Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon i3= new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(50,10,100,100);
            add(image);

            this.formno=formno;

            JLabel l1=new JLabel("Page 2");
            l1.setFont(new Font("Raleway",Font.BOLD,22));
            l1.setBounds(200,30,100,30);
            add(l1);

            JLabel l2= new JLabel("Additional Details");
            l2.setFont(new Font("Raleway",Font.BOLD,22));
            l2.setBounds(200,60,200,30);
            add(l2);

            JLabel l3= new JLabel("Religion");
            l3.setFont(new Font("Raleway",Font.BOLD,18));
            l3.setBounds(50,150,100,30);
            add(l3);

            String [] religion = {"Hindu","Muslim","Christian","Sikh","Buddhist","Jain","Other"};
            combobox=new JComboBox(religion);
            combobox.setBackground(new Color(255,255,255)); //rgb value
            combobox.setFont(new Font("Raleway",Font.BOLD,14));
            combobox.setBounds(300,150,350,30);
            add(combobox);

            JLabel l4= new JLabel("Category");
            l4.setFont(new Font("Raleway",Font.BOLD,18));
            l4.setBounds(50,190,100,30);
            add(l4);

            String [] category = {"General","SC","ST","OBC","Other"};
            combobox2=new JComboBox(category);
            combobox2.setBackground(new Color(255,255,255)); //rgb value
            combobox2.setFont(new Font("Raleway",Font.BOLD,14));
            combobox2.setBounds(300,190,350,30);
            add(combobox2);

            JLabel l5= new JLabel("Income");
            l5.setFont(new Font("Raleway",Font.BOLD,18));
            l5.setBounds(50,230,100,30);
            add(l5);

            String [] income = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
            combobox3=new JComboBox(income);
            combobox3.setBackground(new Color(255,255,255)); //rgb value
            combobox3.setFont(new Font("Raleway",Font.BOLD,14));
            combobox3.setBounds(300,230,350,30);
            add(combobox3);

            JLabel l6= new JLabel("Educational");
            l6.setFont(new Font("Raleway",Font.BOLD,18));
            l6.setBounds(50,270,150,30);
            add(l6);

            String [] edu= {"Non-graduate","Graduate","Post-gradutio","Doctrate","Other"};
            combobox4=new JComboBox(edu);
            combobox4.setBackground(new Color(255,255,255)); //rgb value
            combobox4.setFont(new Font("Raleway",Font.BOLD,14));
            combobox4.setBounds(300,270,350,30);
            add(combobox4);

            JLabel l7= new JLabel("Occupation");
            l7.setFont(new Font("Raleway",Font.BOLD,18));
            l7.setBounds(50,310,150,30);
            add(l7);

            String [] occupation= {"Salaried","Self-Employed","Business","Student","Retired","Other"};
            combobox5=new JComboBox(occupation);
            combobox5.setBackground(new Color(255,255,255)); //rgb value
            combobox5.setFont(new Font("Raleway",Font.BOLD,14));
            combobox5.setBounds(300,310,350,30);
            add(combobox5);

            JLabel l8= new JLabel("PAN Number");
            l8.setFont(new Font("Raleway",Font.BOLD,18));
            l8.setBounds(50,350,150,30);
            add(l8);

            textPAN = new JTextField();
            textPAN.setFont(new Font("Raleway",Font.BOLD,14));
            textPAN.setBounds(300,350,350,30);
            add(textPAN);

            JLabel l9= new JLabel("Aadhar Number");
            l9.setFont(new Font("Raleway",Font.BOLD,18));
            l9.setBounds(50,390,150,30);
            add(l9);

            textAadhar = new JTextField();
            textAadhar.setFont(new Font("Raleway",Font.BOLD,14));
            textAadhar.setBounds(300,390,350,30);
            add(textAadhar);

            JLabel l10= new JLabel("Senior Citizen");
            l10.setFont(new Font("Raleway",Font.BOLD,18));
            l10.setBounds(50,430,150,30);
            add(l10);

            s1=new JRadioButton("Yes");
            s1.setFont(new Font("Raleway",Font.BOLD,14));
            s1.setBounds(300,430,50,30);
            s1.setBackground(new Color(255,255,255));
            add(s1);

            s2=new JRadioButton("No");
            s2.setFont(new Font("Raleway",Font.BOLD,14));
            s2.setBackground(new Color(255,255,255));
            s2.setBounds(450,430,50,30);
            add(s2);

            ButtonGroup buttongroup=new ButtonGroup();
            buttongroup.add(s1);
            buttongroup.add(s2);

            JLabel l11= new JLabel("Existing Account");
            l11.setFont(new Font("Raleway",Font.BOLD,18));
            l11.setBounds(50,470,150,30);
            add(l11);

            e1=new JRadioButton("Yes");
            e1.setFont(new Font("Raleway",Font.BOLD,14));
            e1.setBounds(300,470,50,30);
            e1.setBackground(new Color(255,255,255));
            add(e1);

            e2=new JRadioButton("No");
            e2.setFont(new Font("Raleway",Font.BOLD,14));
            e2.setBackground(new Color(255,255,255));
            e2.setBounds(450,470,50,30);
            add(e2);

            ButtonGroup buttongroup2=new ButtonGroup();
            buttongroup2.add(e1);
            buttongroup2.add(e2);

            JLabel l12= new JLabel("Form No.");
            l12.setFont(new Font("Raleway",Font.BOLD,18));
            l12.setBounds(530,10,150,30);
            add(l12);


            JLabel l13= new JLabel(formno);
            l13.setFont(new Font("Raleway",Font.BOLD,18));
            l13.setBounds(620,10,100,30);
            add(l13);

            next = new JButton("Next");
            next.setFont(new Font("Raleway",Font.BOLD,14));
            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.setBounds(550,550,100,30);
            next.addActionListener(this);
            add(next);

        setLayout(null);
        setSize(750,650);
        setLocation(260,40);
        getContentPane().setBackground(new Color(255,255,255));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String rel=(String) combobox.getSelectedItem();
        String cat=(String) combobox2.getSelectedItem();
        String inc=(String) combobox3.getSelectedItem();
        String edu=(String) combobox4.getSelectedItem();
        String occ=(String) combobox5.getSelectedItem();
        String pan= textPAN.getText();
        String aadhar=textAadhar.getText();
        String sCitizen=null;
        if(s1.isSelected()){
            sCitizen="Yes";
        }else if(s2.isSelected()){
            sCitizen="No";
        }
        String eAccount=null;
        if(e1.isSelected()){
            eAccount="Yes";
        }else if(e2.isSelected()){
            eAccount="No";
        }
        try{
            if(textPAN.getText().equals("")||textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please fill all the fields");
            }else{
                Connect c=new Connect();
                String q="insert into Signuptwo values('"+formno+"','"+rel+"','"+cat+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+sCitizen+"','"+eAccount+"')";
                c.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }

    }
    public static void main(String args[]){
        new Signup2("");
    }
}
