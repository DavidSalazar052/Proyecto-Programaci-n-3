package presentation.MVC_Medicos;
import presentation.AbstractModel;
import java.beans.PropertyChangeListener;
import Logic.Entidades.Medico;

public class ModelMedic extends AbstractModel {
    Medico current;
    public ModelMedic(){
        current = new Medico();
    }
    public static final String CURRENT = "current";
    //PropertyChanges
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener){
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
    }
    public Medico getCurrent(){
        return current;
    }
    public void setCurrent(Medico current){
        this.current = current;
        firePropertyChange(CURRENT);
    }
}
