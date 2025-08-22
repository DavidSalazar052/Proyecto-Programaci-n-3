package Logic.service;

import Logic.Entidades.Paciente;
import Logic.Entidades.Usuario;
import data.data_Usuario;

public class service_Usuario {
    private static service_Usuario theInstanceUsuario;
    public static service_Usuario instance(){
        if(theInstanceUsuario == null) theInstanceUsuario = new service_Usuario();
        return theInstanceUsuario;
    }
    private data_Usuario usuarios;
    private service_Usuario(){usuarios = new data_Usuario();}

    // ===============USUARIOS===============
    public void create(Usuario e) throws Exception {
        Usuario result = usuarios.getPersonas().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            usuarios.getPersonas().add(e);
        } else {
            throw new Exception("Persona ya existe");
        }
    }

    public Usuario read(Usuario e) throws Exception {
        // la clase stream() permite recorrer la lista, con el metodo filter cumple la condicion
        Usuario result = usuarios.getPersonas().stream()
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
