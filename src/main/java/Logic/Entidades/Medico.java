package Logic.Entidades;

public class Medico extends Usuario{
    private String contasenna;
    public Medico(String id, String apellido, String nombre, String rol , String contasenna) {
        super(id, apellido, nombre, rol);
        this.contasenna = contasenna;
    }

    @Override
    public String getRol() {return rol;}


    //TEMA DE LA CONTRSENNA
    public String getContasenna() {return contasenna;}
    public void CambiarContrasenna(String nuevaContrasenna){
        this.contasenna = nuevaContrasenna;
    }

    //no en el proyecto final
    @Override
    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: " + nombre);
        System.out.println("Rol: " + rol);
        System.out.println("Clave: " + contasenna);
    }
}
