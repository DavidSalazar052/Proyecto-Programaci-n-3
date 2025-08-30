package presentation.MVC_Pacientes;
import Logic.Entidades.Paciente;
import presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.List;


public class Model extends AbstractModel {
    Paciente current;
    List<Paciente> pacientes;

    public static final String CURRENT = "current";
    public static final String PACIENTES = "pacientes";

    //CONSTRUCTOR
    public Model(){
        current = new Paciente();
        pacientes = new LinkedList<>(); //hice cambio
    }
    //GETTERS Y SETTERS
    public Paciente getCurrent(){
        return current;}

    public List<Paciente> getPacientes(){
        return pacientes;}

    public void setCurrent(Paciente current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }
    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
        firePropertyChange(PACIENTES);
    }
    //LISTENER
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
        firePropertyChange(PACIENTES);
    }
};
