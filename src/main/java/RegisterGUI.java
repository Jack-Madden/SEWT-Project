import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGUI {
    public JFrame getFrame() {
        return frame;
    }

    public JFrame frame;
    public JTextField addName;
    public JTextField addSurname;
    public JTextField addAddr1;
    public JTextField addAddr2;
    public JTextField addEirCode;
    public JTextField addCity;
    public JTextField addPhone;
    public JTextField addPassword;
    public JButton registerBttn;

    DatabaseHandler databaseHandler = new DatabaseHandler();

    public RegisterGUI(){
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

        addName = new JTextField("Name", 50);
        frame.getContentPane().add(addName, BorderLayout.NORTH);

        addSurname = new JTextField("Surname", 50);
        frame.getContentPane().add(addSurname, BorderLayout.NORTH);

        addAddr1 = new JTextField("Addr1", 50);
        frame.getContentPane().add(addAddr1, BorderLayout.NORTH);

        addAddr2 = new JTextField("Addr2", 50);
        frame.getContentPane().add(addAddr2, BorderLayout.NORTH);

        addEirCode = new JTextField("eirCode", 50);
        frame.getContentPane().add(addEirCode, BorderLayout.NORTH);

        addCity = new JTextField("city", 50);
        frame.getContentPane().add(addCity, BorderLayout.NORTH);

        addPhone = new JTextField("phone", 50);
        frame.getContentPane().add(addPhone, BorderLayout.NORTH);

        addPassword = new JTextField("password", 50);
        frame.getContentPane().add(addPassword, BorderLayout.NORTH);

        registerBttn = new JButton("Log In");
        registerBttn.setSize(50,50);
        frame.getContentPane().add(registerBttn, BorderLayout.NORTH);
        registerBttn.addActionListener(this.databaseHandler.createUser);

    }

}
