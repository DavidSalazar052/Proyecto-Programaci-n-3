package Logic.service;

import Logic.Entidades.Usuario;
import data.data;

public class service_Usuario {
    private static service_Usuario theInstanceUsuario;
    public static service_Usuario instance(){
        if(theInstanceUsuario == null) theInstanceUsuario = new service_Usuario();
        return theInstanceUsuario;
    }
    private data usuarios;
    private service_Usuario(){usuarios = new data();}

    // ===============USUARIOS===============
    public void create(Usuario e) throws Exception {
        Usuario result = usuarios.getUsuarios().stream()
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
        Usuario result = usuarios.getUsuarios().stream()
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
