import javax.swing.*;

import presentation.MVC_Pacientes.ModelPac;
import presentation.MVC_Pacientes.ContPac;
import presentation.MVC_Pacientes.View_Pacientes;

import java.awt.*;


public class Application {
        public static void main(String[] args) {
            try {UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
            catch (Exception ex) {};

            View_Pacientes view = new View_Pacientes();
            ModelPac model = new ModelPac();
            ContPac controller = new ContPac(view, model);

            JFrame window = new JFrame();
            window.setSize(800,600);
            window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            window.setTitle("Personas");
            window.setContentPane(view.getPanel());
            window.setVisible(true);
        }

        public static final Color BACKGROUND_ERROR = new Color(255, 102, 102);
}
