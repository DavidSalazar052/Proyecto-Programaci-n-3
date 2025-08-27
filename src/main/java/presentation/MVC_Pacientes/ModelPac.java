package presentation.MVC_Pacientes;
import Logic.Entidades.Paciente;
import Logic.Entidades.Usuario;
import presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.List;

public class ModelPac extends AbstractModel {
    Paciente current;
    List<Paciente> pacientes;

    public static final String CURRENT = "current";
    public static final String PACIENTES = "pacientes";

    public ModelPac(){
        current = new Paciente();
        pacientes = new LinkedList<>();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
    }
    public Paciente getCurrent(){return current;}
    public List<Paciente> getPacientes(){return pacientes;}

    public void setCurrent(Paciente current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }
    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
        firePropertyChange(PACIENTES);
    }
};
