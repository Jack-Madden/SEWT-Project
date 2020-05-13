import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (Exception e) {
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //ApplicationGUI application = new ApplicationGUI();
                //application.initialise();
                try {
                    LoginGUI login = new LoginGUI();
                   // login.initialise();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

