package presentation.MVC_Medicos;
import Logic.Entidades.Medico;
import presentation.AbstractTableModel;

import java.util.List;

public class TableModel extends AbstractTableModel<Medico> implements javax.swing.table.TableModel  {
    //METODOS DE LA CLASE TABLE MODEL
    public TableModel(int[] cols, List<Medico> rows) {
        super(cols, rows);
    }
    public static final int ID = 0;
    public static final int NOMBRE = 1;
    public static final int APELLIDO = 2;
    public static final int ROL = 3;

    @Override
    protected Object getPropetyAt(Medico medico, int col) {
        switch (cols[col]) {
            case ID:
                return medico.getId();
            case NOMBRE:
                return medico.getNombre();
            case APELLIDO:
                return medico.getApellido();
            case ROL:
                return medico.getRol();
            default:
                return "";
        }
    }

    @Override
    protected void initColNames() {
        colNames = new String[4];
        colNames[ID] = "Id";
        colNames[NOMBRE] = "Nombre";
        colNames[APELLIDO] = "Apellido";
        colNames[ROL] = "Rol";
    }
}
