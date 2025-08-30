package presentation.MVC_Medicos;
import Logic.Entidades.Medico;
import Logic.service.service_Medico;
import Logic.service.service_Paciente;


public class Controller {
    View_Medicos view;
    presentation.MVC_Medicos.Model model;

    public Controller(View_Medicos view, Model model){
        this.view = view;
        this.model  = model;
        view.setModel(model);
        view.setController(this);
    }
    public void read(String id)throws Exception{
        Medico e = new Medico();
        e.setId(id);
        model.setCurrent(service_Medico.instance().read(e));
    }
    public void create(Medico e)throws Exception{
        service_Medico.instance().create(e);
        model.setCurrent(new Medico());
        model.setMedicos(service_Medico.instance().getMedicos());
    }
    //limpiar
    public void clear(){
        model.setCurrent(new Medico());
    }

    public void delete(String id)throws Exception {
        Medico e = new Medico();
        e.setId(id);
        service_Medico.instance().delete(e);
        model.setCurrent(new Medico());
        model.setMedicos(service_Medico.instance().getMedicos());
    }

    public void search(String buscar) {
        model.setMedicos(service_Medico.instance().search(buscar));
    }

    public void restore(){
        model.setMedicos(service_Medico.instance().getMedicos());
    }

    public void setMedico(Medico medico){
        model.setCurrent(medico);
    }
}
