package Logic.Entidades;
//El se encarga de añadir los usuarios en el sistemas
public class Administradores extends Usuario {
    private String contrasenaADMIN;

    public Administradores(String id, String apellido, String nombre, String rol) {
        super(id, apellido, nombre, rol);
    }
    public Administradores(){super();}

    @Override
    public String getRol() {return rol;}

    public String getContrasenaADMIN() {return contrasenaADMIN;}
    public void setContrasenaADMIN(String contrasenaADMIN) {
        this.contrasenaADMIN = contrasenaADMIN;
    }

    //esto no es para el final
    @Override
    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: " + nombre);
        System.out.println("Rol: " + rol);
        System.out.println("Clave: " + contrasenaADMIN);
    }
}
