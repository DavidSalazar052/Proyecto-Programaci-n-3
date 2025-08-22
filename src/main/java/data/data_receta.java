package data;
import Logic.Medicamentos.Receta;
import java.util.LinkedList;
import java.util.List;

public class data_receta {
    private List<Receta> recetas;
    public data_receta() {recetas = new LinkedList<>();}
    public List<Receta> getRecetas() {return recetas;}
}
