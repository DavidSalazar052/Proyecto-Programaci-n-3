package presentation.MVC_login;
import Logic.Entidades.Usuario;
import presentation.MVC_login.View.logIn;
import Logic.service.service_farma;

public class Controller {
    logIn view;
    Model_Log model;

    public Controller(logIn view, Model_Log model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public void read(String id) throws Exception {


    }

    public void create(Usuario usuario) {

    }
}
