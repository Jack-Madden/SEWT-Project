import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationGUI extends expenseLog{
    // Create Frame
    public JFrame frame;
    public JFrame getFrame() {
        return frame;
    }
    // Classes
    addTransaction addTransaction = new addTransaction();
    expenseLog expenseLog = new expenseLog();

    public ApplicationGUI(){
        initialise();
    }   // ApplicationGUI()

    public void initialise(){
        // Create frame
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Expense Report");
        //frame.setSize(700, 900);
        frame.setSize(expenseLog().getSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Transaction Button
        JButton transactionBttn = new JButton("Add Transaction");
        frame.getContentPane().add(transactionBttn, BorderLayout.SOUTH);
        transactionBttn.setSize(50,50);
        transactionBttn.setLocation(80,30);
        transactionBttn.addActionListener(this.addTransaction);

        displayTrans();
    } // initialise()

    public void displayTrans(){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.add(expenseLog());
            }
        });

       // frame.add(expenseLog());
    }

} // ApplicationGUI class
