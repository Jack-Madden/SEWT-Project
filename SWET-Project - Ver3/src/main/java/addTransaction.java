import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class addTransaction implements ActionListener {

    JFrame frame;

    public void addTransaction( ) {
        // Frame created
        JFrame transFrame = new JFrame();

        // Submit button and dropdown menu
        JButton submit = new JButton("Submit");
        String[] transactionType = {"Income", "Expense"};

        // Dropdown box
        JComboBox transactionList = new JComboBox(transactionType);
        JLabel dropLabel = new JLabel();
        transactionList.setSelectedIndex(1);
        transactionList.setBounds(60, 150, 100, 30);
        transFrame.add(transactionList);
        transFrame.add(dropLabel);

        // Description Textbox label
        JLabel nameLabel = new JLabel();
        nameLabel.setText(" Desc :");
        nameLabel.setBounds(5, 10, 100, 100);
        // Description Textbox text field
        JLabel desTextBoxLabel = new JLabel();
        desTextBoxLabel.setBounds(5, 110, 200, 100);
        JTextField desTextfield= new JTextField();
        desTextfield.setBounds(110, 50, 130, 30);

        // Income amount
        JLabel amountLabel = new JLabel();
        amountLabel.setText(" Amount :");
        amountLabel.setBounds(5, 80, 100, 100);
        // Text box text field
        JLabel amntTextBoxLabel = new JLabel();
        amntTextBoxLabel.setBounds(5, 200, 200, 100);
        JTextField amntTextfield= new JTextField();
        amntTextfield.setBounds(110, 120, 130, 30);

        amntTextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char input = e.getKeyChar();
                // UI Error
                JLabel numError = new JLabel("");
                numError.setForeground(Color.RED);
                numError.setBounds(110, 60, 200, 100);
                numError.setVisible(true);
                transFrame.add(numError);
                // Ensures only numbers are typed
                if((Character.isLetter(input) && !e.isAltDown())){
                    e.consume();
                    System.out.println("Invalid character");
                    numError.setText("Numbers only!");
                }
            }
        });

        // Add description to frame
        transFrame.add(desTextBoxLabel);
        transFrame.add(desTextfield);
        transFrame.add(nameLabel);
        // Add amount to frame
        transFrame.add(amntTextBoxLabel);
        transFrame.add(amntTextfield);
        transFrame.add(amountLabel);
        // Add submit to frame
        submit.setBounds(100,200,140, 40);
        transFrame.add(submit);
        // Frame characteristics
        transFrame.setSize(300,300);
        transFrame.setLayout(null);
        transFrame.setVisible(true);
        transFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Action listener
        submit.addActionListener(new ActionListener() {
            @Override   // When submit button is pressed
            public void actionPerformed(ActionEvent arg0) {
                String description = "";
                String amount = "";
                String operator = "";
                // Input converted to String
                description = amntTextfield.getText();
                amount = desTextfield.getText();
                operator = (String)transactionList.getSelectedItem();

                System.out.println("Description: " + desTextfield.getText());
                System.out.println("Amount: " + amntTextfield.getText());
                System.out.println("Selected operator is " + operator);
                // Operator converted to symbol
                String savedOperator = null;
                if (operator == "Income"){
                    savedOperator = "+";
                }
                else if (operator == "Expense"){
                    savedOperator = "-";
                }
                try {   // Write new transaction to Transactions.txt
                    FileWriter writer = new FileWriter("Transactions.txt", true);
                    BufferedWriter bw = new BufferedWriter(writer);
                    PrintWriter out = new PrintWriter(bw);

                    // Checks if string is empty
                    String s = ("\n" +amount  + ", "  +savedOperator  +description);
                    System.out.println("Size of amount string is " +s.length());
                    if(s.length()>4){
                        out.append("\n" +amount  + ", "  +savedOperator  +description);
                        out.close();
                    }
                    else{
                        System.out.println("String is <4");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                transFrame.dispose();  // close frame
            }   // actionPerformed
        }); // ActionListener
    } // addTransaction()

    @Override
    public void actionPerformed(ActionEvent e) {


                addTransaction();


    }   // actionPerformed(ActionEvent e)
}   // addTransaction class
