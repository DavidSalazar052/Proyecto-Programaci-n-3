package data;
import Logic.Entidades.Usuario;


import java.util.LinkedList;
import java.util.List;

public class data_Usuario {

    private List<Usuario> usuarios;
    public data_Usuario(){usuarios = new LinkedList<>();}
    public List<Usuario> getPersonas(){return usuarios;}
}
