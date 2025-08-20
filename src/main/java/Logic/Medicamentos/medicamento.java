package Logic.Medicamentos;

public class medicamento {
    private String nombre;
    private String codigo;

   //DESCRIPCION SERIE EN LA RECET private String descripicion; // dolor de cabeza

    public medicamento(String nombre,String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre(){return nombre;}
    public String getCodigo(){return codigo;}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setCodigo(String codigo){this.codigo = codigo;}

    //No implementado en el proyecto final
    public void mostrarDatos() {
        System.out.println("medicamento: " + nombre);
        System.out.println("Codigo: " + codigo);
    }
}
