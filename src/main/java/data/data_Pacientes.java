package data;
import Logic.Entidades.Paciente;

import java.util.LinkedList;
import java.util.List;


public class data_Pacientes {

    private List<Paciente> pacientes;
    public data_Pacientes(){pacientes = new LinkedList<>();}
    public List<Paciente> getPersonas(){return pacientes;}



}


