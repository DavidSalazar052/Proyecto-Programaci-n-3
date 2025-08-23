package presentation.MVC_login;
import Logic.Entidades.Usuario;
import presentation.AbstractModel;

public class Model_Log extends AbstractModel {
    Usuario current;

    public Model_Log(){
        current = null;
    }
    
    //CAMANO X TIGRE
    @Override
    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
    }

    public static final String CURRENT = "current";
    public Usuario getCurrent(){return current;}
    public void setCurrent(Usuario current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }
};
