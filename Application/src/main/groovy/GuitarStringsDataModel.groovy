import javax.swing.table.AbstractTableModel

class GuitarStringsDataModel extends AbstractTableModel {

    GuitarStrings guitarStrings;

    GuitarStringsDataModel(GuitarStrings guitarStrings) {
        this.guitarStrings = guitarStrings
    }

    int getRowCount() {
        return 6
    }

    int getColumnCount() {
        return 23
    }

    ScaledNote getValueAt(int rowIndex, int columnIndex) {
        GuitarString guitarString = guitarStrings.ordenedStrings.get(rowIndex)
        ScaledNote scaledNote = guitarString.notes.get(columnIndex)
        return scaledNote
    }

    String getColumnName(int col) {
        col.toString()
    }

    Class getColumnClass(int col) {
        ScaledNote.class
    }

    boolean isCellEditable(int row, int col) { false }

}
