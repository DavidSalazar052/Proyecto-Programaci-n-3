package presentation.MVC_Pacientes;

import Logic.Entidades.Paciente;
import presentation.AbstractTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_Pacientes implements PropertyChangeListener {
    private JTextField id_JTextField;
    private JTextField nombrePaciente_JtextField;
    private JButton BotonGuardar;
    private JButton BotonLimpiar;
    private JButton BotonBorrar;
    private JTextField NombreBusqueda_JtextField;
    private JButton BotonBuscar;
    private JButton BotonReporte;
    private JTable TablaDePaciente;
    private JPanel Jpanel;

    //MVC
    ContPac controller;
    ModelPac model;

    public View_Pacientes() {
        BotonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Paciente p = take();
                    controller.create(p);
                    JOptionPane.showMessageDialog(Jpanel,"Persona ingresada");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Jpanel,ex.getMessage());
                }
            }
        });
    }
    public JPanel getPanel() {
        return Jpanel;
    }

    public void setController (ContPac controller){this.controller = controller;}

    public void setModel (ModelPac model){
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public Paciente take(){
        Paciente p = new Paciente();
        p.setId(id_JTextField.getText());
        p.setNombre(nombrePaciente_JtextField.getText());
        return p;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()) {
            case ModelPac.CURRENT:{
                id_JTextField.setText(model.getCurrent().getId());
                nombrePaciente_JtextField.setText(model.getCurrent().getNombre());
                break;
            }
            case ModelPac.PACIENTES:{
                int [] cols = {TableModel_Paciente.ID,TableModel_Paciente.NOMBRE,TableModel_Paciente.APELLIDO,TableModel_Paciente.ROL};
                TablaDePaciente.setModel(new TableModel_Paciente(cols, model.getPacientes()));
                break;
            }
        }
    }


}




