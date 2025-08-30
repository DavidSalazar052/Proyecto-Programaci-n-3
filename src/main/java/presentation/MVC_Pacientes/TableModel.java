package presentation.MVC_Pacientes;
import Logic.Entidades.Paciente;
import presentation.AbstractTableModel;

import java.util.List;

public class TableModel extends AbstractTableModel<Paciente> implements javax.swing.table.TableModel {
    public TableModel(int[] cols, List<Paciente> rows) {
        super(cols, rows);
    }

    public static final int ID = 0;
    public static final int NOMBRE = 1;
    public static final int APELLIDO = 2;
    public static final int ROL = 3;

    @Override
    protected void initColNames() {
        colNames = new String[4];
        colNames[ID] = "Id";
        colNames[NOMBRE] = "Nombre";
        colNames[APELLIDO] = "Apellido";
        colNames[ROL] = "Rol";
    }

    @Override
    protected Object getPropetyAt(Paciente paciente, int col) {
        switch (cols[col]) {
            case ID:
                return paciente.getId();
            case NOMBRE:
                return paciente.getNombre();
            case APELLIDO:
                return paciente.getApellido();
            case ROL:
                return paciente.getRol();
            default:
                return "";
        }
    }
}
