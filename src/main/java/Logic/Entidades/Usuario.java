package Logic.Entidades;

public abstract class Usuario {
    protected String id;
    protected String apellido;
    protected String nombre;
    protected String rol;

    public Usuario(String id, String apellido, String nombre, String rol) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.rol = rol;
    }
    public Usuario(String id, String apellido, String nombre) {
        this(id, apellido, nombre, "");
    }
    public String getId(){return id;}
    public String getApellido(){return apellido;}
    public String getNombre(){return nombre;}

    //La ID no se deberia cambiar y el rol tampoco
    public void setApellido(String apellido){this.apellido = apellido;}
    public void setNombre(String  nombre){this.nombre = nombre;}

    public abstract String getRol();
    public abstract void mostrarDatos(); // Al parecer en el ejemplo no se usa, pero por para probar en terminal


}
