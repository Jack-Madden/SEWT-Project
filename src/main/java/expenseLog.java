import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class expenseLog implements ActionListener
{
    public void expenseLog()
    {
        try {

            // Stores the separate lines in a List than to a 2d List
            Scanner in = new Scanner(new File("Transactions.txt"));
            List<String[]> lines = new ArrayList<>();
            while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                String[] splitted = line.split(", ");
                for(int i = 0; i<splitted.length; i++) {
                    // Remove additional " at start and end
                    //splitted[i] = splitted[i].substring(1, splitted[i].length()-1);
                }
                lines.add(splitted);
            }

            // Convert List<String[]> to String[][]
            String[][] result = new String[lines.size()][];
            for(int i = 0; i<result.length; i++) {
                result[i] = lines.get(i);
            }
            System.out.println("Transactions \n"+ Arrays.deepToString(result));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File not found");
        }


    } // lessExpense()

    @Override
    public void actionPerformed(ActionEvent e) {
        expenseLog();
    }
}
