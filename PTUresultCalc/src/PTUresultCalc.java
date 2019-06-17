/*WAP to calculate CGPA and Percentage*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PTUresultCalc implements ActionListener
{
JFrame f1;
JTabbedPane tab1;
JPanel p1,p2;
JComboBox cb;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;//l17 for p2 %,l18 for grade help label
JTextField t1,t2,t3,t4,t5,t6;
JButton b1,b2,b3,b5,b6;//b5 and b6 for reset
Font n1;
//Background
JLabel l100,l200;
Icon c1,c2,c3[];//c3 for tab icons

public PTUresultCalc()
{
    f1=new JFrame("PTU Result Calculator");
    //Frame setting
    f1.setSize(620,650);
    f1.setResizable(false);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.setVisible(true);
    //----------
    
    tab1=new JTabbedPane();
    f1.add(tab1);
        
    p1=new JPanel();
    p1.setLayout(null);
    p2=new JPanel();
    p2.setLayout(null);
    //percentage
    l1=new JLabel("Obtained Marks:");
    t1=new JTextField(10);
    l2=new JLabel("Total Marks:");
    t2=new JTextField(10);
    l3=new JLabel("Result:");
    t3=new JTextField(10);
    l4=new JLabel("%");
    b1=new JButton("Percentage");
    b5=new JButton("Reset");
//----------
    //CGPA
    l5=new JLabel("Total SGPA:");
    t4=new JTextField(10);//Grand Total credit
    l6=new JLabel("No. of semesters:");
    t5=new JTextField(10);//Total credit
    l7=new JLabel("Result:");
    l17=new JLabel("%");
    l17.setVisible(false);
    t6=new JTextField(4);//CGPA,Percentage result
    l18=new JLabel("Grade credit value:");
    n1=new Font("Arial",Font.BOLD,20);
    l18.setFont(n1);
    l8=new JLabel("O=10");
    l9=new JLabel("A+=9");
    l10=new JLabel("A=8");
    l11=new JLabel("B+=7");
    l12=new JLabel("B=6");
    l13=new JLabel("C=5");
    l14=new JLabel("P=4");
    l15=new JLabel("F=0");
    l16=new JLabel("Others=0");
    b2=new JButton("Percentage");
    b3=new JButton("CGPA");
    b6=new JButton("Reset");
    
//Add items and set bounds in Panel 1
    p1.add(l1);
    l1.setBounds(100,150,100,30);
    p1.add(t1);
    t1.setBounds(220,150,100,30);
    p1.add(l2);
    l2.setBounds(100,220,100,30);
    p1.add(t2);
    t2.setBounds(220,220,100,30);
    p1.add(l3);
    l3.setBounds(100,290,100,30);
    p1.add(t3);
    t3.setBounds(220,290,100,30);
    p1.add(l4);
    l4.setBounds(325,290,100,30);
    p1.add(b1);
    b1.setBounds(220,360,100,30);
    p1.add(b5);
    b5.setBounds(100,360,100,30);
    
    //Add items and set bounds in Panel 2
    p2.add(l5);
    l5.setBounds(60,100,110,30);
    p2.add(t4);
    t4.setBounds(190,100,150,30);
    p2.add(l6);
    l6.setBounds(60,150,120,30);
    p2.add(t5);
    t5.setBounds(190,150,150,30);
    p2.add(l7);
    l7.setBounds(60,200,100,30);
    p2.add(t6);
    t6.setBounds(190,200,150,30);
    p2.add(l17);
    l17.setBounds(345,200,50,30);
    p2.add(b6);
    b6.setBounds(60,270,100,30);
    p2.add(b2);
    b2.setToolTipText("CGPA multiplied by 9.5 as per PTU norms");
    b2.setBounds(190,270,100,30);
    p2.add(b3);
    b3.setBounds(340,270,100,30);
    //------------    
    //helper
    p2.add(l18);
    l18.setBounds(150,360,200,30);
    p2.add(l8);
    l8.setBounds(200,390,100,20);
    p2.add(l9);
    l9.setBounds(200,410,100,20);
    p2.add(l10);
    l10.setBounds(200,430,100,20);
    p2.add(l11);
    l11.setBounds(200,450,100,20);
    p2.add(l12);
    l12.setBounds(200,470,100,20);
    p2.add(l13);
    l13.setBounds(200,490,100,20);
    p2.add(l14);
    l14.setBounds(200,510,100,20);
    p2.add(l15);
    l15.setBounds(200,530,100,20);
    p2.add(l16);
    l16.setBounds(200,550,100,20);
    //------------------
    //Panels Background
    /*p1.setBackground(Color.orange);
    p2.setBackground(Color.orange);*/
    
//Background
    c1=new ImageIcon("D:\\Net Beans Projects\\PTUresultCalc\\images\\backgcalc1.jpg");
    l100=new JLabel(c1);
    l100.setBounds(0,0,620,650);//Background
    p1.add(l100);
    c1=new ImageIcon("D:\\Net Beans Projects\\PTUresultCalc\\images\\backgcalc2.jpg");
    l200=new JLabel(c1);
    l200.setBounds(0,0,620,650);//Background
    p2.add(l200);
    //---------    
//Tabs
    c3=new Icon[2];
    c3[0]=new ImageIcon("D:\\Net Beans Projects\\PTUresultCalc\\images\\process1.png");
    c3[1]=new ImageIcon("D:\\Net Beans Projects\\PTUresultCalc\\images\\process2.png");
    tab1.addTab("Percentage",c3[0],p1,"Calculate Percentage");
    tab1.addTab("CGPA",c3[1],p2,"CGPA to percentage as per PTU norms");
    //------------------------
    //Listeners
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    //-------------------------
}
//Logical calculations
public void actionPerformed(ActionEvent e)
    {
        // Percentage Panel 1
        if(e.getSource()==b1)
        {
            float z=Float.parseFloat(t1.getText()) / Float.parseFloat(t2.getText()) * 100;
            t3.setText(String.valueOf(z)); //Converting pure integer result z into string
        }
        if(e.getSource()==b5)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
        //-------------
        // Percentage Panel 2
        if(e.getSource()==b2)
        {
            float z=Float.parseFloat(t4.getText())/Float.parseFloat(t5.getText());
            double m = z*9.5; //multiplier
            t6.setText(String.valueOf(m)); //Converting pure integer result z into string
            l17.setVisible(true);
        }
        //-------------
        //CGPA Panel 2
        if(e.getSource()==b3)
        {
            float z=Float.parseFloat(t4.getText()) / Float.parseFloat(t5.getText());
            t6.setText(String.valueOf(z)); //Converting pure integer result z into string
            l17.setVisible(false);
        }
        if(e.getSource()==b6)
        {
            t4.setText("");
            t5.setText("");
            t6.setText("");
        }
        //--------------------
    }
public static void main(String args[])
{
new PTUresultCalc();
}
}