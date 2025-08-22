package Logic.service;
import Logic.Entidades.Administradores;
import Logic.Entidades.Usuario;
import data.data_Administrador;

public class service_Admi {
    private static service_Admi Theinstance;
    
    
    public static service_Admi getInstance() {
        if (Theinstance == null) {
            Theinstance = new service_Admi();
        }
        return Theinstance;
    }
    private data_Administrador administrador;
    private service_Admi() {administrador = new data_Administrador();}
    
    // ==================Adminstradores================//
    public void create(Administradores e){
        Administradores result = administrador.getadministradores().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            administrador.getadministradores().add(e);
        } else {
            throw new RuntimeException("Administrador ya existe");
        }
    }
    public Administradores read(Administradores e) throws Exception {
        Administradores result = administrador.getadministradores().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Administrador no existe");
        }
    }
}
