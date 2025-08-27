package presentation.MVC_Medicos;

import presentation.MVC_Pacientes.ContPac;
import presentation.MVC_Pacientes.ModelPac;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_Medicos implements PropertyChangeListener {
    private JTextField id_JTextField;
    private JTextField EspecidadJTextFiel;
    private JTextField nombreMedico_JtextField;
    private JButton BotonGuardar;
    private JButton BotonLimpiar;
    private JButton BotonBorrar;
    private JTextField NombreBusqueda_JtextField;
    private JButton BotonBuscar;
    private JButton BotonReporte;
    private JTable TabladeMedicos;

    //MVC
    ContPac controller;
    ModelPac model;

    public View_Medicos() {
        BotonGuardar.addActionListener(e -> {
            try {
                controller.create(model.getCurrent());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        BotonBuscar.addActionListener(e -> {
            try {
                controller.read(NombreBusqueda_JtextField.getText());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void setController (ContPac controller){this.controller = controller;}

    public void setModel (ModelPac model){
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()) {
            case ModelPac.CURRENT:{
                id_JTextField.setText(evt.getNewValue().toString());
                EspecidadJTextFiel.setText(evt.getNewValue().toString());
                nombreMedico_JtextField.setText(evt.getNewValue().toString());

            }
            case ModelPac.PACIENTES:{
                
            }
        }
    }
}




