package presentation.MVC_Medicos;
import Logic.Entidades.Medico;
import presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.List;

public class Model extends AbstractModel {
    Medico current;
    List<Medico> medicos;

    public static final String CURRENT = "current";
    public static final String MEDICOS = "medicos";

    //CONSTRUCTOR
    public Model(){
        current = new Medico();
        medicos = new LinkedList<>();
    }
    //GETTERS Y SETTERS
    public Medico getCurrent(){
        return current;
    }
    public void setCurrent(Medico current){
        this.current = current;
        firePropertyChange(CURRENT);
    }
    public List<Medico> getMedicos(){
        return medicos;
    }
    public void setMedicos(List<Medico> medicos){
        this.medicos = medicos;
        firePropertyChange(MEDICOS);
    }
    //LISTENER
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
        firePropertyChange(MEDICOS);
    }
}
