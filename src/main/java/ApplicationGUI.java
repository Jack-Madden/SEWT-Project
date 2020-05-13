import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationGUI {
    public JFrame getFrame() {
        return frame;
    }

    public JFrame frame;

    addTransaction addTransaction = new addTransaction();
    expenseLog expenseLog = new expenseLog();

    public ApplicationGUI(){
        initialise();
    }   // Calculator()

    public void initialise()
    {
        // Create frame
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Expense Report");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton transactionBttn = new JButton("Add Transaction");
        frame.getContentPane().add(transactionBttn, BorderLayout.NORTH);
        transactionBttn.setSize(50,50);
        transactionBttn.setLocation(80,30);
        transactionBttn.addActionListener(this.addTransaction);

        JButton logBttn = new JButton("Log");
        frame.getContentPane().add(logBttn, BorderLayout.SOUTH);
        logBttn.addActionListener(this.expenseLog);


    } // initialise()

}
