package presentation.MVC_Pacientes;

import Logic.Entidades.Paciente;
import Logic.service.service_Paciente;

public class Controller {
    View_Pacientes view;
    Model model;

    public Controller(View_Pacientes view, Model model){
        this.view = view;
        this.model  = model;
        view.setModel(model);
        view.setController(this);
    }
    public void read(String id)throws Exception{
        Paciente e = new Paciente();
        e.setId(id);
        model.setCurrent(service_Paciente.instance().read(e));
    }
    public void create(Paciente e)throws Exception{
        service_Paciente.instance().create(e);
        model.setCurrent(new Paciente());
        model.setPacientes(service_Paciente.instance().getpacientes());
    }
    //limpiar
    public void clear(){
        model.setCurrent(new Paciente());
    }

    public void delete(String text) {
       //No implementado todavia
    }
}
