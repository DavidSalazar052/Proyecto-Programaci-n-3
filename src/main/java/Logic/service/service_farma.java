package Logic.service;
import Logic.Entidades.Farmaceutico;
import data.data;

public class service_farma {
    private static service_farma instance;

    public static service_farma instance() {
        if (instance == null) {
            instance = new service_farma();
        }
        return instance;
    }
    private data_Farmaceutico farmaceutico;

    private service_farma() {farmaceutico = new data_Farmaceutico();}

    // ==================Farmaceutico================//
    public void create(Farmaceutico e){
        Farmaceutico result = farmaceutico.getFarmaceuticos().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            farmaceutico.getFarmaceuticos().add(e);
        } else {
            throw new RuntimeException("Farmaceutico ya existe");
        }
    }
    public Farmaceutico read(Farmaceutico e) throws Exception {
        Farmaceutico result = (Farmaceutico) farmaceutico.getUsuarios().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Farmaceutico no existe");
        }
    }
}
