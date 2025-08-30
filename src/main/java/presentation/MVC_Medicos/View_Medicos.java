package presentation.MVC_Medicos;

import Logic.Entidades.Medico;
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


public class View_Medicos implements PropertyChangeListener {
    private JTextField nombreMedico_JtextField;
    private JButton BotonGuardar;
    private JButton BotonLimpiar;
    private JButton BotonEliminar;
    private JButton BotonBuscar;
    private JButton BotonReporte;
    private JTable TablaMedicos_Table;
    private JPanel Jpanel;
    private JTextField id_TextField;
    private JTextField NombreBusqueda_JtextField;
    private JTextField apellidoMedico_JtextField;

    //MVC
    Model model;
    Controller controller;

    //Constructor y Logica
    public View_Medicos(){
        Highlighter highlighter = new Highlighter(Color.green);
        nombreMedico_JtextField.addMouseListener(highlighter);
        apellidoMedico_JtextField.addMouseListener(highlighter);
        id_TextField.addMouseListener(highlighter);
        NombreBusqueda_JtextField.addMouseListener(highlighter);

        //BOTON GUARDAR
        BotonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (validate()){
                    try {
                        Medico m = take();
                        controller.create(m);
                        JOptionPane.showMessageDialog(Jpanel,"Medico ingresado");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(Jpanel,ex.getMessage());
                    }
                }
            }
        });
        //BOTON LIMPIAR
        BotonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try{
                    controller.clear();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Jpanel,ex.getMessage());
                }
            }
        });
        //BOTON ELIMINAR
        BotonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validate_ID()){
                    try{
                        controller.delete(id_TextField.getText());
                        JOptionPane.showMessageDialog(Jpanel, "Medico eliminado");
                    }catch (Exception ex){
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
                    controller.search(NombreBusqueda_JtextField.getText());
                }else{
                    controller.restore();
                }
            }
        });

        TablaMedicos_Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = TablaMedicos_Table.getSelectedRow();
                if (fila != -1) {
                    TableModel tm = (TableModel) TablaMedicos_Table.getModel();
                    Medico medico = tm.getRowAt(fila);
                    controller.setMedico(medico);
                }
            }
        });
    }



    //Property Change Listener
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()){
            case Model.MEDICOS:
                int [] cols = {TableModel.ID, TableModel.NOMBRE, TableModel.APELLIDO,TableModel.ROL};
                TablaMedicos_Table.setModel(new TableModel(cols,model.getMedicos()));
                break;

            case Model.CURRENT:
                id_TextField.setText(model.getCurrent().getId());
                nombreMedico_JtextField.setText(model.getCurrent().getNombre());
                apellidoMedico_JtextField.setText(model.getCurrent().getApellido());
                break;
        }
        this.Jpanel.revalidate();
    }

    //Getters y Setters
    public JPanel getPanel(){
        return Jpanel;
    }
    public void setController(Controller controller){
        this.controller = controller;
    }
    public void setModel(Model model){
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    //Take
    public Medico take(){
        Medico m = new Medico();
        m.setId(id_TextField.getText());
        m.setNombre(nombreMedico_JtextField.getText());
        m.setApellido(apellidoMedico_JtextField.getText());
        return m;
    }
    //Validate
    //VALIDATE
    private boolean validate (){
        boolean validId = true;
        boolean validNm = true;
        boolean validAp = true;
        if (id_TextField.getText().isEmpty()){
            validId = false;
            id_TextField.setBackground(Color.RED);
            JOptionPane.showMessageDialog(Jpanel,"ID necesario");
        }else{
            id_TextField.setBackground(null);
            validId = true;
        }
        if (nombreMedico_JtextField.getText().isEmpty()){
            validNm = false;
            nombreMedico_JtextField.setBackground(Color.RED);
            JOptionPane.showMessageDialog(Jpanel,"Nombre necesario");
        }else {
            nombreMedico_JtextField.setBackground(null);
            validNm = true;
        }
        if (apellidoMedico_JtextField.getText().isEmpty()){
            validAp = false;
            apellidoMedico_JtextField.setBackground(Color.RED);
            JOptionPane.showMessageDialog(Jpanel,"Apellido necesario");
        }else {
            apellidoMedico_JtextField.setBackground(null);
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
        if (id_TextField.getText().isEmpty()) {
            valid = false;
            id_TextField.setBackground(Color.RED);
            JOptionPane.showMessageDialog(Jpanel, "ID necesario");
            //controller.clear();
        } else {
            valid = true;
            id_TextField.setBackground(null);
        }
        return valid;
    }
}




