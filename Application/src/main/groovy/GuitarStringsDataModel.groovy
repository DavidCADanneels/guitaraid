import javax.swing.table.AbstractTableModel
import java.util.function.Predicate

class GuitarStringsDataModel extends AbstractTableModel {
    Predicate<Note> filter
    boolean showOctave = true

    int getRowCount() {
        return 6
    }

    int getColumnCount() {
        return 23
    }

    String getValueAt(int rowIndex, int columnIndex) {
        GuitarString guitarString = GuitarStrings.ordenedStrings.get(rowIndex)
        ScaledNote scaledNote = guitarString.notes.get(columnIndex)
        Note note = scaledNote.note
        if(filter!=null && !filter.test(note)) null
        else {
            showOctave?scaledNote.name:note.name
        }
    }

    String getColumnName(int col) {
        "${col}"
    }

    Class getColumnClass(int col) {
        String.class
    }

    boolean isCellEditable(int row, int col) { false }

    void setShowOctave(boolean show){
        showOctave = show
        fireTableDataChanged()
    }

    void setFilter(Predicate<Note> filter) {
        this.filter = filter
        fireTableDataChanged()
    }
}
