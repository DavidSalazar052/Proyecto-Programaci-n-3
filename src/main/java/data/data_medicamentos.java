package data;
import Logic.Medicamentos.medicamento;

import java.util.LinkedList;
import java.util.List;

public class data_medicamentos {
    private List<medicamento> medicamento;
    public data_medicamentos(){medicamento = new LinkedList<>();}
    public List<medicamento> getMedicamento(){return medicamento;}
}
