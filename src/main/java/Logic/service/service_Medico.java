package Logic.service;
import Logic.Entidades.Medico;
import Logic.Entidades.Paciente;
import data.data;

import java.util.LinkedList;
import java.util.List;

public class service_Medico {
    private static service_Medico theInstanceMedic;

    public static service_Medico instance(){
        if(theInstanceMedic==null) theInstanceMedic = new service_Medico();
        return theInstanceMedic;
    }
    private data medico;
    private service_Medico(){medico = new data();}

    // =============== MEDICO ===============
    public void create(Medico e) throws Exception {
        Medico result = (Medico) medico.getUsuarios().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            medico.getMedicos().add(e);
        } else {
            throw new Exception("Medico ya existe");
        }
    }


    public Medico read(Medico e) throws Exception {
        // la clase stream() permite recorrer la lista, con el metodo filter cumple la condicion
        Medico result = medico.getMedicos().stream()
                .filter(i -> i.getId().equals(e.getId())) // funcion lambda de busqueda por ID
                .findFirst() // encuentra el primer elemento que cumpla la condicion
                .orElse(null); // si no encuentra nada, devuelve null
        if (result != null) {
            return result;
        } else {
            throw new Exception("Medico no existe");
        }
    }
    public List<Medico> getMedicos() {
        return medico.getMedicos();   // <- lees de la misma lista
    }

    //Delete
    public void delete(Medico e) throws Exception {
        Medico result = read(e);
        if(result != null){
            medico.getMedicos().remove(result);
        }else{
            throw new Exception("Medico no existe");
        }
    }
    //BUSQUEDA ESPECIFICA
    public List<Medico> search(String buscar) {
        List<Medico> medicos = new LinkedList<>();
        if (buscar != null) {
            for (Medico medico : medico.getMedicos()) {
                if(medico.getNombre().contains(buscar)) {
                    medicos.add(medico);
                }
            }
            return medicos;
        }else{
            return medicos;
        }
    }
}
