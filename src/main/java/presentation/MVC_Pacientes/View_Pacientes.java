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
        //BOTON GUARDAR
        BotonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validate()) {
                    try {
                        Paciente p = take();
                        controller.create(p);
                        JOptionPane.showMessageDialog(Jpanel, "Persona ingresada");
                        controller.clear();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(Jpanel, ex.getMessage());
                    }
                }
            }
        });
        //BOTON LIMPIAR
        BotonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.clear();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Jpanel,ex.getMessage());
                }
            }
        });
        //BOTON BORRAR (NO IMPLEMENTADO TODAVIA)
        BotonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validate()){
                    try {
                        controller.delete(id_JTextField.getText());
                        JOptionPane.showMessageDialog(Jpanel, "Persona eliminada");
                        controller.clear();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(Jpanel, ex.getMessage());
                    }
                }
            }
        });

        //BOTON BUSCAR
        BotonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validate_buscar()) {
                    try {
                        controller.read(NombreBusqueda_JtextField.getText());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(Jpanel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
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

            case ModelPac.PACIENTES:
                int[] cols = {TableModel_Paciente.ID,TableModel_Paciente.NOMBRE,
                               TableModel_Paciente.APELLIDO,TableModel_Paciente.ROL};
                TablaDePaciente.setModel(new TableModel_Paciente(cols, model.getPacientes()));
                break;

            case ModelPac.CURRENT:
                id_JTextField.setText(model.getCurrent().getId());
                nombrePaciente_JtextField.setText(model.getCurrent().getNombre());
                id_JTextField.setBackground(null);
                nombrePaciente_JtextField.setBackground(null);

        }
        this.Jpanel.revalidate();
    }
    //VALIDATE
    private boolean validate (){
       boolean valid = true;
       if (id_JTextField.getText().isEmpty()){
           valid = false;
           id_JTextField.setBackground(Color.RED);
           JOptionPane.showMessageDialog(Jpanel,"ID necesario");
           id_JTextField.setBackground(null);
           id_JTextField.setToolTipText("ID necesario");
       }
       if (nombrePaciente_JtextField.getText().isEmpty()){
              valid = false;
              nombrePaciente_JtextField.setBackground(Color.RED);
              JOptionPane.showMessageDialog(Jpanel,"Nombre necesario");
              nombrePaciente_JtextField.setBackground(null);
              nombrePaciente_JtextField.setToolTipText("Nombre necesario");
       }else {
              nombrePaciente_JtextField.setBackground(null);
              id_JTextField.setBackground(null);
       }
       return valid;

    }
    private boolean validate_buscar(){
        boolean valid = true;

        if (NombreBusqueda_JtextField.getText().isEmpty()){
            valid = false;
            NombreBusqueda_JtextField.setBackground(Color.RED);
            JOptionPane.showMessageDialog(Jpanel,"ID necesario");
            NombreBusqueda_JtextField.setBackground(null);
            NombreBusqueda_JtextField.setToolTipText("ID necesario");
        }
        else {
        nombrePaciente_JtextField.setBackground(null);
        id_JTextField.setBackground(null);
    }
        return valid;
    }


}




