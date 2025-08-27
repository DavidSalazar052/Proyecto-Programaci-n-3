package Logic.service;
import Logic.Medicamentos.medicamento;
import data.data;

public class service_Medicamento {
    private static service_Medicamento Theinstance;

    public static service_Medicamento getInstance() {
        if (Theinstance == null) {
            Theinstance = new service_Medicamento();
        }
        return Theinstance;
    }

    private data_medicamentos medicamentos;
    private service_Medicamento() { medicamentos = new data_medicamentos(); }

    public void create(medicamento e){
        medicamento result = medicamentos.getMedicamento().stream()
                .filter(i -> i.getCodigo().equals(e.getCodigo()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            medicamentos.getMedicamento().add(e);
        } else {
            throw new RuntimeException("El medicamento existente");
        }

    }
    public medicamento read(medicamento e) throws Exception {
        medicamento result = medicamentos.getMedicamento().stream()
                .filter(i -> i.getCodigo().equals(e.getCodigo()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Medicamento no existente");
        }
    }
}
