package presentation.MVC_Pacientes;

import Logic.Entidades.Paciente;
import presentation.Highlighter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private JTextField apellidoPaciente_JtextField1;

    //MVC
    Controller controller;
    Model model;

    public View_Pacientes() {
        Highlighter highlighter = new Highlighter(Color.green);
        id_JTextField.addMouseListener(highlighter);
        nombrePaciente_JtextField.addMouseListener(highlighter);
        apellidoPaciente_JtextField1.addMouseListener(highlighter);
        NombreBusqueda_JtextField.addMouseListener(highlighter);

        //BOTON GUARDAR
        BotonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validate()) {
                    try {
                        Paciente p = take();
                        controller.create(p);
                        JOptionPane.showMessageDialog(Jpanel, "Persona ingresada");
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

        //BOTON BUSCAR
        BotonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validate_buscar()) {
                    controller.search(NombreBusqueda_JtextField.getText());
                }else{
                    controller.restore();
                }
            }
        });
        //BOTON BORRAR
        BotonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validate_ID()){
                    try{
                        controller.delete(id_JTextField.getText());
                        JOptionPane.showMessageDialog(Jpanel, "Paciente eliminada");
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(Jpanel, ex.getMessage());
                    }
                }
            }
        });
        TablaDePaciente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = TablaDePaciente.getSelectedRow();
                if (fila != -1) {
                    TableModel tm = (TableModel) TablaDePaciente.getModel();
                    Paciente paciente = tm.getRowAt(fila);
                    controller.setPaciente(paciente);
                }
            }
        });
    }
    public JPanel getPanel() {
        return Jpanel;
    }

    public void setController (Controller controller){
        this.controller = controller;}

    public void setModel (Model model){
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public Paciente take(){
        Paciente p = new Paciente();
        p.setId(id_JTextField.getText());
        p.setNombre(nombrePaciente_JtextField.getText());
        p.setApellido(apellidoPaciente_JtextField1.getText());
        return p;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()) {
            case Model.PACIENTES:
                int[] cols = {TableModel.ID, TableModel.NOMBRE,
                               TableModel.APELLIDO, TableModel.ROL};
                TablaDePaciente.setModel(new TableModel(cols, model.getPacientes()));
                break;

            case Model.CURRENT:
                id_JTextField.setText(model.getCurrent().getId());
                nombrePaciente_JtextField.setText(model.getCurrent().getNombre());
               // controller.clear();
                id_JTextField.setBackground(null);
                nombrePaciente_JtextField.setBackground(null);
                apellidoPaciente_JtextField1.setBackground(null);
                break;
        }
        this.Jpanel.revalidate();
    }
    //VALIDATE
    private boolean validate (){
       boolean validId = true;
       boolean validNm = true;
       boolean validAp = true;
       if (id_JTextField.getText().isEmpty()){
           validId = false;
           id_JTextField.setBackground(Color.RED);
           JOptionPane.showMessageDialog(Jpanel,"ID necesario");
       }else{
           id_JTextField.setBackground(null);
           validId = true;
       }
       if (nombrePaciente_JtextField.getText().isEmpty()){
              valid = false;
              nombrePaciente_JtextField.setBackground(Color.RED);
              JOptionPane.showMessageDialog(Jpanel,"Nombre necesario");
       }else {
           nombrePaciente_JtextField.setBackground(null);
           validNm = true;
       }
        if (apellidoPaciente_JtextField1.getText().isEmpty()){
            validAp = false;
            apellidoPaciente_JtextField1.setBackground(Color.RED);
            JOptionPane.showMessageDialog(Jpanel,"Apellido necesario");
        }else {
            apellidoPaciente_JtextField1.setBackground(null);
            validAp = true;
        }
       return (validId && validNm && validAp);
    }
    private boolean validate_buscar(){
        boolean valid = true;
        if (NombreBusqueda_JtextField.getText().isEmpty()){
            valid = false;
        }else{
            NombreBusqueda_JtextField.setBackground(null);
            valid = true;
        }
        return valid;
    }

    private boolean validate_ID() {
        boolean valid = true;
        if (id_JTextField.getText().isEmpty()) {
            valid = false;
            id_JTextField.setBackground(Color.RED);
            JOptionPane.showMessageDialog(Jpanel, "ID necesario");
            //controller.clear();
        } else {
            valid = true;
            id_JTextField.setBackground(null);
        }
        return valid;
    }
}




