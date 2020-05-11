import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class addTransaction extends ApplicationGUI implements ActionListener {





    public void addTransaction() {
        JFrame incomeF = new JFrame("Add Transaction");
        JButton submit = new JButton("Submit");
        String[] transactionType = {"Add", "Less"};

        // Dropdown box
        JComboBox transactionList = new JComboBox(transactionType);
        JLabel dropLabel = new JLabel();
        transactionList.setSelectedIndex(1);
        transactionList.setBounds(60, 150, 100, 30);
        incomeF.add(transactionList);
        incomeF.add(dropLabel);

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

        // Amount
        amntTextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char input = e.getKeyChar();

                JLabel numError = new JLabel("");
                numError.setForeground(Color.RED);
                numError.setBounds(30,50, 111, 111);

                if((Character.isLetter(input) && !e.isAltDown())){
                    e.consume();
                    System.out.println("Invalid character");
                    numError.setText("Invalid character");  // fix this to print under box
                }
            }
        });

        // Submit button
        submit.setBounds(100,200,140, 40);

        // Add description to frame
        incomeF.add(desTextBoxLabel);
        incomeF.add(desTextfield);
        incomeF.add(nameLabel);
        // Add amount to frame
        incomeF.add(amntTextBoxLabel);
        incomeF.add(amntTextfield);
        incomeF.add(amountLabel);

        incomeF.add(submit);
        incomeF.setSize(300,300);
        incomeF.setLayout(null);
        incomeF.setVisible(true);
        incomeF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Action listener
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String description = "";
                String amount = "";
                String operator = "";


                description = amntTextfield.getText();
                amount = desTextfield.getText();
                operator = (String)transactionList.getSelectedItem();


                System.out.println("Description: " + desTextfield.getText());
                System.out.println("Amount: " + amntTextfield.getText());
                System.out.println("Selected operator is " + operator);

                File f = new File("TransactionLog.txt");



                incomeF.dispose();
            }
        });


    } // addTransaction()


    @Override
    public void actionPerformed(ActionEvent e) {
        addTransaction();
    }
}
