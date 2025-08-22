package View.LogIn;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class logIn implements PropertyChangeListener {

    private JTextField UsuarioIDtf;
    private JPasswordField ContrasenaF;
    private JButton INGRESARButton;
    private JButton REGISTRARButton;
    private JPanel logInPanel;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
    public logIn(){
        INGRESARButton.addActionListener(e -> {
            String usuarioID = UsuarioIDtf.getText();
            String contrasena = new String(ContrasenaF.getPassword());

            // Aquí puedes agregar la lógica para verificar las credenciales del usuario
            if (verificarCredenciales(usuarioID, contrasena)) {
                JOptionPane.showMessageDialog(logInPanel, "Inicio de sesión exitoso");
                // Lógica para iniciar la sesión del usuario
            } else {
                JOptionPane.showMessageDialog(logInPanel, "ID o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        REGISTRARButton.addActionListener(e -> {
            // Lógica para registrar un nuevo usuario
            JOptionPane.showMessageDialog(logInPanel, "Funcionalidad de registro no implementada aún");
        });

    }

    private boolean verificarCredenciales(String usuarioID, String contrasena) {
        return true;
    }
}
