import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class expenseLog implements Runnable {


    public JPanel expenseLog() {
        try {
            // Stores the separate lines in a List then to a 2d List
            Scanner in = new Scanner(new File("Transactions.txt"));
            List<String[]> lines = new ArrayList<>();
            while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                String[] splitted = line.split(", ");
                lines.add(splitted);
            }

            // Convert List<String[]> to String[][]
            String[][] result = new String[lines.size()][];
            for(int i = 0; i<result.length; i++) {
                result[i] = lines.get(i);
            }
            // Call balance
            getBalance(result);
            System.out.println("Transactions \n"+ Arrays.deepToString(result));
            // 2d table model
            DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
                    },          // Column names
                    new Object[] { "Description", "Amount" }
            );
            // Populate table
            for(int i=0;i<result.length;i++){
                String[] row = new String[result[i].length];
                for(int j=0;j<result[i].length;j++){
                    row[j] = result[i][j];
                }

                tableModel.addRow(row);
            }

            // Add model to table
            JTable table = new JTable(tableModel);
            Font font = new Font("Verdana", Font.PLAIN, 12);
            table.setFont(font);
            table.setRowHeight(15);
            JPanel panel = new JPanel();
            panel.setSize(600, 900);
            panel.add(new JScrollPane(table));
            panel.setVisible(true);

            // Get balance
            float balance = getBalance(result);
            // Remove extra decimals and cast to String
            DecimalFormat df = new DecimalFormat("0.00");
            String balString = df.format(balance);
            // Add balance to table
            tableModel.addRow(new Object[]{"", ""});
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    tableModel.addRow(new Object[]{"Balance", balString});
                }
            });

            panel.updateUI();

            // Create frame
            JFrame frame = new JFrame();
            frame.setSize(600, 400);
            frame.add(panel);
            frame.setVisible(true);
            frame.dispose();

            return panel;

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File not found");
        }
        return null;
    } // expenseLog()

    public float getBalance(String [][] result){

                float balance = 0;
                // Check if the amount should be added or subtracted from balance
                for(int i =0;i<result.length;i++){
                    if(result[i][1].contains("+")){
                        String positive = "";
                        positive = result[i][1];
                        String posAmount = positive.substring(1);
                        float f = Float.parseFloat(posAmount);
                        balance += f;
                    }
                    else if(result[i][1].contains("-")){
                        String negative = "";
                        negative = result[i][1];
                        String negAmount = negative.substring(1);
                        float f = Float.parseFloat(negAmount);
                        balance -= f;
                    }
                }
                System.out.printf("Balance is %.2f \n", balance);


        return balance;


    }   // getBalance()

    @Override
    public void run() {
        expenseLog();
    }


}
