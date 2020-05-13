

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI extends JFrame implements ActionListener {



    JPanel panel;
    JLabel userLabel;
    JLabel pssLabel;
    JLabel mesg;
    JTextField UsterName;
    JPasswordField pwd;
    JButton submit;
    JButton AddUser;

    LoginGUI() {

        // User Label
        userLabel = new JLabel();
        userLabel.setText("User Name :");
        UsterName = new JTextField();

        // Password

        pssLabel = new JLabel();
        pssLabel.setText("Password :");
        pwd = new JPasswordField();

        // Submit

        submit = new JButton("SUBMIT");
        AddUser = new JButton("Add User");

        panel = new JPanel(new GridLayout(4, 1));
       // panel.setSize(80,80);
        panel.add(userLabel);
        panel.add(UsterName);
        panel.add(pssLabel);
        panel.add(pwd);
        panel.add(AddUser);

        mesg = new JLabel();
        panel.add(mesg);
        panel.add(submit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(this);
        AddUser.addActionListener(this::add);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(400, 250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new LoginGUI();
    }


    public void add(ActionEvent ae) {

        System.out.println("Add user");
        RegisterGUI work = new RegisterGUI();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = UsterName.getText();
        String password = pwd.getText();
        if (userName.trim().equals("admin") && password.trim().equals("admin")) {
            mesg.setText(" Hello " + userName
                    + "");

            ApplicationGUI runner = new ApplicationGUI();
        } else {
            mesg.setText(" Invalid user.. ");
        }

    }

}