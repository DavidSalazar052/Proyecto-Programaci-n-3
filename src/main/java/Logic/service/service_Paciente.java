package Logic.service;
import Logic.Entidades.Paciente;
import data.data;

import java.util.LinkedList;
import java.util.List;

public class service_Paciente {
    private static service_Paciente theInstancePaciente;
    public static service_Paciente instance(){
        if(theInstancePaciente == null) theInstancePaciente = new service_Paciente();
        return theInstancePaciente;
    }
    private data paciente;
    private service_Paciente(){paciente = new data();}

    // =============== PACIENTES ===============
    public void create(Paciente e) throws Exception {
        Paciente result = paciente.getPacientes().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);

        if (result == null) {
            paciente.getPacientes().add(e);   // <- ahora guardas en ListaPacientes
        } else {
            throw new Exception("Persona ya existe");
        }
    }

    public Paciente read(Paciente e) throws Exception {
        Paciente result = paciente.getPacientes().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Paciente no existe");
        }
    }

    public List<Paciente> getpacientes() {
        return paciente.getPacientes();
    }

    //DELETE
    public void delete(Paciente e) throws Exception {
        Paciente result = read(e);
        if(result != null){
            paciente.getPacientes().remove(result);
        }else{
            throw new Exception("Paciente no existe");
        }
    }
    //BUSQUEDA ESPECIFICA
    public List<Paciente> search(String buscar) {
        List<Paciente> pacientes = new LinkedList<>();
        if (buscar != null) {
            for (Paciente paciente : paciente.getPacientes()) {
                if(paciente.getNombre().contains(buscar)) {
                    pacientes.add(paciente);
                }
            }
            return pacientes;
        }else{
            return pacientes;
        }
    }
}
