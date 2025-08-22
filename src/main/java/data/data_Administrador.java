package data;
import java.util.LinkedList;
import java.util.List;
import Logic.Entidades.Administradores;


public class data_Administrador {
    private List<Administradores> administradores;
    public data_Administrador(){administradores = new LinkedList<>();}
    public List<Administradores> getadministradores() {return administradores;}
}
