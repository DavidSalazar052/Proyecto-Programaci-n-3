package Logic.Entidades;

public class Paciente extends Usuario {
    public Paciente(String id, String apellido, String nombre, String rol) {
        super(id, apellido, nombre, rol);
    }

    @Override
    public String getRol() {return rol;} // ROL PACIENTE

    @Override
    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: " + nombre);
        System.out.println("Rol: " + rol);
    }
}
