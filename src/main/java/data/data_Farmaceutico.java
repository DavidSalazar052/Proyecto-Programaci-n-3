package data;
import Logic.Entidades.Farmaceutico;
import java.util.LinkedList;
import java.util.List;

public class data_Farmaceutico {

    private List<Farmaceutico> farmaceutico;
    public data_Farmaceutico(){farmaceutico = new LinkedList<>();}
    public List<Farmaceutico> getFarmaceuticos() {return farmaceutico;}

}