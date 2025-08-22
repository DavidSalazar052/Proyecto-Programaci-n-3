package Logic.service;
import Logic.Entidades.Paciente;
import data.data_Pacientes;

public class service_Paciente {
    private static service_Paciente theInstancePaciente;
    public static service_Paciente instace(){
        if(theInstancePaciente == null) theInstancePaciente = new service_Paciente();
        return theInstancePaciente;
    }
    private data_Pacientes paciente;
    private service_Paciente(){paciente = new data_Pacientes();}

    // =============== PACIENTES ===============
    public void create(Paciente e) throws Exception {
        Paciente result = paciente.getPersonas().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            paciente.getPersonas().add(e);
        } else {
            throw new Exception("Persona ya existe");
        }
    }

    public Paciente read(Paciente e) throws Exception {
        // la clase stream() permite recorrer la lista, con el metodo filter cumple la condicion
        Paciente result = paciente.getPersonas().stream()
                .filter(i -> i.getId().equals(e.getId())) // funcion lambda de busqueda por ID
                .findFirst() // encuentra el primer elemento que cumpla la condicion
                .orElse(null); // si no encuentra nada, devuelve null
        if (result != null) {
            return result;
        } else {
            throw new Exception("Paciente no existe");
        }
    }


}
