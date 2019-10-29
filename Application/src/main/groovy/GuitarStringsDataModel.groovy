import javax.swing.table.AbstractTableModel
import java.util.function.Predicate

class GuitarStringsDataModel extends AbstractTableModel {
    Predicate<ScaledNote> filter

    int getRowCount() {
        return 6
    }

    int getColumnCount() {
        return 23
    }

    ScaledNote getValueAt(int rowIndex, int columnIndex) {
        GuitarString guitarString = GuitarStrings.ordenedStrings.get(rowIndex)
        ScaledNote scaledNote = guitarString.notes.get(columnIndex)
        filter==null?scaledNote:filter.test(scaledNote)?scaledNote:null
    }

    String getColumnName(int col) {
        "${col}"
    }

    Class getColumnClass(int col) {
        ScaledNote.class
    }

    boolean isCellEditable(int row, int col) { false }

    void setFilter(Predicate<ScaledNote> filter) {
        this.filter = filter
        fireTableDataChanged()
    }
}
