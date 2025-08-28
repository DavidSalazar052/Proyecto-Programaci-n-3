package Logic.Medicamentos;
import java.util.*;

import Logic.Entidades.Medico;
import Logic.Entidades.Paciente;


//Relacionada con paciente y medico, View de Recetas
// En el model de la pantalla deberia de haber una receta
// El paciente puede ligarse a las recetas, el sistemas sale logiado (Colocar el ID del metico arriba), en
// un objeto seccion se guarda el medico que esta logiado

public class Receta {
    String id;
    Paciente paciente;
    Medico medico;
    String descripcion;
    String fechaActual; // esta es para el dia actual
    String fecharetiro;
    List<medicamento> medicinas = new ArrayList<>();
    Boolean entragado;

    public Receta (String id , Paciente paciente1, Medico medico1, String descripcion , String fechaA, String fecharetiro,Boolean entregado){
        this.id = id;
        this.paciente = paciente1;
        this.medico = medico1;
        this.descripcion = descripcion;
        this.fechaActual = fechaA;
        this.fecharetiro = fecharetiro;
        this.entragado = entregado; // preguntar a sanchez es mejor inicializar la lista directo
    }

    public void agregarmedicamento(medicamento med){ // Preguntar metodo a sanchez manana
        if(med!= null){
            medicinas.add(med);
        }
    }
    public String getId() {return id;}



    };




