import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    public JFrame getFrame() {
        return frame;
    }

    public JFrame frame;

    LoginGUI loginGUI = new LoginGUI();
    RegisterGUI registerGUI = new RegisterGUI();

    public MainGUI(){
        initialise();
    }

    public void initialise()
    {
        // Create frame
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Expense Calculator");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton loginBttn = new JButton("Log In");
        frame.getContentPane().add(loginBttn, BorderLayout.WEST);
        loginBttn.setSize(50,50);
        loginBttn.setLocation(80,30);
        loginBttn.addActionListener(this.loginGUI);

        JButton registerBttn = new JButton("Register");
        frame.getContentPane().add(registerBttn, BorderLayout.EAST);
        registerBttn.addActionListener(this.registerGUI);


    }

}
