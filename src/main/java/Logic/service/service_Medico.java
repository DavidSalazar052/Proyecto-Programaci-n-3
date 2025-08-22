package Logic.service;
import Logic.Entidades.Medico;
import data.data_Medico;

public class service_Medico {
    private static service_Medico theInstanceMedic;

    public static service_Medico instace(){
        if(theInstanceMedic==null) theInstanceMedic = new service_Medico();
        return theInstanceMedic;
    }
    private data_Medico medico;
    private service_Medico(){medico = new data_Medico();}

    // =============== MEDICO ===============
    public void create(Medico e) throws Exception {
        Medico result = medico.getMedicos().stream()
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



}
