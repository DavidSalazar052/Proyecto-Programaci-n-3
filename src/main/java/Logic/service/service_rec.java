package Logic.service;

import Logic.Entidades.Usuario;
import Logic.Medicamentos.Receta;
import data.data;

public class service_rec {
    private static service_rec instance;

    public static service_rec getInstance() {
        if (instance == null) {
            instance = new service_rec();
        }
        return instance;
    }
    private data receta;

    private service_rec() { receta = new data();}

    // ==================Receta================//

}


