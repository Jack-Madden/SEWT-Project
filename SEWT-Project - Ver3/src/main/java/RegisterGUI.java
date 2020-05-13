
// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RegisterGUI extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel lableFirst;
    private JTextPane tbFirstName;
    private JLabel lableLast;
    private JTextPane tbLastName;
    private JLabel lableAddr1;
    private JTextPane tbAddr1;
    private JLabel lableAddr2;
    private JTextPane tbAddr2;
    private JButton sButten;
    private JTextPane tbEIRCODE;
    private JLabel lableNumber;
    private JLabel lableEircode;
    private JLabel lableCity;
    private JTextPane tbCity;
    private JLabel labelpassword;
    private JTextPane tbpasword;
    private JTextPane number;
    private JButton vButten;
    private JLabel res;
    private JTextPane feedBack;
    private JTextPane tbDataFirstname;
    private JTextPane tbDataLastNAme;
    private JTextPane tbDataAddr1;
    private JTextPane tbDataAddr2;
    private JTextPane tbDataEircode;
    private JTextPane tbDataNumber;
    private JTextPane tbDataCity;

    // strings to hold the data in the select boxes
    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };


    public RegisterGUI()
    {
        JFrame frame = new JFrame();
        frame.setTitle("ExamGui");
        frame.setLocationRelativeTo(null);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8,3,5,10));
        lableFirst = new JLabel();
        lableFirst.setText("First Name");
        tbFirstName = new JTextPane();
        //tbFirstName.setText("");
        tbDataFirstname = new JTextPane();
        lableLast = new JLabel();
        lableLast.setText("Last Name");
        tbLastName = new JTextPane();
        //tbLastName.setText("");
        tbDataLastNAme = new JTextPane();
        lableAddr1 = new JLabel();
        lableAddr1.setText("Address 1");
        tbAddr1 = new JTextPane();
        tbAddr1.setText("");
        tbDataAddr1 = new JTextPane();
        lableAddr2 = new JLabel();
        lableAddr2.setText("Address 2");
        tbAddr2 = new JTextPane();
        tbAddr2.setText("");
        tbDataAddr2 = new JTextPane();
        tbDataAddr2 = new JTextPane();
        lableEircode = new JLabel();
        lableEircode.setText("EIRCODE");
        tbEIRCODE = new JTextPane();
        tbEIRCODE.setText("");
        tbDataEircode = new JTextPane();
        lableNumber = new JLabel();
        lableNumber.setText("Number");
        number = new JTextPane();
        number.setText("");
        tbDataNumber = new JTextPane();

        labelpassword = new JLabel();
        labelpassword.setText("Password");
        tbpasword = new JTextPane();
        tbpasword.setText("");
        tbpasword = new JTextPane();


        lableCity = new JLabel();
        lableCity.setText("City");
        tbCity = new JTextPane();
        tbCity.setText("");
        tbDataCity = new JTextPane();


        sButten = new JButton();
        sButten.setText("Submit");
        vButten = new JButton();
        vButten.setText("Verify");
        vButten.setVisible(false);
        feedBack = new JTextPane();
        feedBack.setEditable(false);
        panel.add(lableFirst);
        panel.add(tbFirstName);
        panel.add(tbDataFirstname);
        panel.add(lableLast);
        panel.add(tbLastName);
        panel.add(tbDataLastNAme);
        panel.add(lableAddr1);
        panel.add(tbAddr1);
        panel.add(tbDataAddr1);
        panel.add(lableAddr2);
        panel.add(tbAddr2);
        panel.add(tbDataAddr2);
        panel.add(lableCity);
        panel.add(tbCity);
        panel.add(tbDataCity);
        panel.add(lableEircode);
        panel.add(tbEIRCODE);
        panel.add(tbDataEircode);
        panel.add(lableNumber);
        panel.add(number);
        panel.add(tbDataNumber);
        //panel.add(labelpassword);
        //panel.add(tbpasword);
        panel.add(sButten);
        panel.add(vButten);
        panel.add(feedBack);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setVisible(true);


        sButten.addActionListener(this);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sButten) {

            System.out.println("Getting here");

            String data  = "Name  = "  + tbFirstName.getText();
            String data1 = "Last Name = " + tbLastName.getText();
            String data2 = "Address 1 = " + tbAddr1.getText();
            String data3 = "Address 2 = " + tbAddr2.getText();
            String data4 = "City = " + tbCity.getText();
            String data5 = "Eirecode = " + tbEIRCODE.getText();
            String data6 = "Number = " + number.getText();
            String data7 = "Password = " + tbpasword.getText();


            tbDataFirstname.setText(data );
            tbDataFirstname.setEditable(false);
            tbDataLastNAme.setText(data1 );
            tbDataLastNAme.setEditable(false);
            tbDataAddr1.setText(data2 );
            tbDataAddr1.setEditable(false);
            tbDataAddr2.setText(data3 );
            tbDataAddr2.setEditable(false);
            tbDataCity.setText(data4 );
            tbDataCity.setEditable(false);
            tbDataEircode.setText(data5 );
            tbDataEircode.setEditable(false);
            tbDataNumber.setText(data6 );
            tbDataNumber.setEditable(false);
            tbpasword.setText(data7 );
            tbpasword.setEditable(false);
            feedBack.setText("Registration Successfully..");

            }
        }


    }



