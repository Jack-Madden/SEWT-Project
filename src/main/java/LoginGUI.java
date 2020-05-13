import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    public JFrame getFrame() {
        return frame;
    }

    public JFrame frame;
    public JTextField name;
    public JTextField surname;
    public JTextField Addr1;
    public JTextField Addr2;
    public JTextField eirCode;
    public JTextField city;
    public JTextField phone;
    public JTextField password;
    public JButton loginBttn;

    DatabaseHandler databaseHandler = new DatabaseHandler();

    public LoginGUI(){
        initialise();
    }   // Calculator()

    public void initialise()
    {
        // Create frame
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Log In");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        name = new JTextField("Name", 50);
        frame.getContentPane().add(name, BorderLayout.NORTH);

        surname = new JTextField("Surname", 50);
        frame.getContentPane().add(surname, BorderLayout.NORTH);

        Addr1 = new JTextField("Addr1", 50);
        frame.getContentPane().add(Addr1, BorderLayout.NORTH);

        Addr2 = new JTextField("Addr2", 50);
        frame.getContentPane().add(transactionBttn, BorderLayout.NORTH);

        eirCode = new JTextField("eirCode", 50);
        frame.getContentPane().add(Addr2, BorderLayout.NORTH);

        city = new JTextField("city", 50);
        frame.getContentPane().add(city, BorderLayout.NORTH);

        phone = new JTextField("phone", 50);
        frame.getContentPane().add(phone, BorderLayout.NORTH);

        password = new JTextField("password", 50);
        frame.getContentPane().add(password, BorderLayout.NORTH);

        loginBttn = new JButton("Log In");
        loginBttn.setSize(50,50);
        frame.getContentPane().add(loginBttn, BorderLayout.NORTH);
        loginBttn.addActionListener(this.databaseHandler.findUser);

    }

}
