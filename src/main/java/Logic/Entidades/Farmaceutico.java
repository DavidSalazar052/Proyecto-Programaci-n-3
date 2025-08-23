package Logic.Entidades;

public class Farmaceutico extends Usuario{
    private String contrasena;
    public Farmaceutico(String id , String nombre, String apellido,String rol , String contrasena) {
        super(id, apellido, nombre, rol);
        this.contrasena = contrasena;
    }
    public Farmaceutico(){super();}

    @Override
    public String getRol() {return rol;}
    @Override
    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: " + nombre);
        System.out.println("Rol: " + rol);
        System.out.println("Clave: " + contrasena);
    }

    public String getcontrasena(){
        return contrasena;
    }
    public void CambiarContrasena(String nuevaContrasena){
        this.contrasena = nuevaContrasena;
    }
}
