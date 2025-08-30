import javax.swing.*;


import presentation.MVC_Pacientes.Model;
import presentation.MVC_Pacientes.Controller;
import presentation.MVC_Pacientes.View_Pacientes;

import java.awt.*;


public class Application {
        public static void main(String[] args) {
            try {UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
            catch (Exception ex) {};

            JFrame window = new JFrame();
            JTabbedPane  tabbedPane = new JTabbedPane();
            window.setContentPane(tabbedPane);

            presentation.MVC_Pacientes.Model model1 = new presentation.MVC_Pacientes.Model();
            presentation.MVC_Pacientes.View_Pacientes view1 = new presentation.MVC_Pacientes.View_Pacientes();
            presentation.MVC_Pacientes.Controller controller1 = new presentation.MVC_Pacientes.Controller(view1 ,model1);

            presentation.MVC_Medicos.Model model2 = new presentation.MVC_Medicos.Model();
            presentation.MVC_Medicos.View_Medicos view2 = new presentation.MVC_Medicos.View_Medicos();
            presentation.MVC_Medicos.Controller controller2 = new presentation.MVC_Medicos.Controller(view2 ,model2);



            tabbedPane.addTab("PACIENTES",null,view1.getPanel());
            tabbedPane.addTab("MEDICOS",null,view2.getPanel());



            window.setSize(820,600);
            window .setResizable(false);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setTitle("CLINICA");
            window.setVisible(true);
        }

        public static final Color BACKGROUND_ERROR = new Color(255, 102, 102);
}
