package data;
// Entidades
import Logic.Entidades.*;
// Medicamentos
import Logic.Medicamentos.Receta;
import Logic.Medicamentos.medicamento;
import jdk.dynalink.linker.GuardingDynamicLinkerExporter;

import java.util.LinkedList;
import java.util.List;

public class data {
    // Entidades
    private List<Usuario> ListaUsuarios;
    //private List<Farmaceutico> ListaFarmaceuticos;
    private List<Medico> ListaMedicos;
    //private List<Administradores> ListaAdministradores;
    private List<Paciente> ListaPacientes;

    //Medicamentos
    private List<medicamento> ListaMedicamentos;
    private List<Receta> ListaRecetas;


    // Constructores

    public data(){
        //Entidades
        ListaUsuarios= new LinkedList<>();
        //ListaFarmaceuticos = new LinkedList<>();
        ListaMedicos = new LinkedList<>();
        //ListaAdministradores = new LinkedList<>();
        ListaPacientes = new LinkedList<>();

        //Medicamentos
        ListaMedicamentos = new LinkedList<>();
        ListaRecetas = new LinkedList<>();

    }
    // Getters Entidades
    public List<Usuario> getUsuarios() {return ListaUsuarios;}
    // public List<Farmaceutico> getFarmaceuticos(){return farmaceuticos;}
     public List<Medico> getMedicos(){return ListaMedicos;}
    // public List<Administradores> getAdministradores(){return administradores;}
     public List<Paciente> getPacientes(){return ListaPacientes;}

    //Getters medicamentos
    public List<medicamento> getMedicamentos() {return ListaMedicamentos;}
    public List<Receta> getRecetas(){return ListaRecetas;}
}
