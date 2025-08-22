import View.LogIn.logIn;

import javax.swing.*;


public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch (Exception ex) {};

        logIn logIn = new logIn();


        JFrame window = new JFrame();
        window.setSize(600,300);
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Personas");
        window.setVisible(true);
    }
}
