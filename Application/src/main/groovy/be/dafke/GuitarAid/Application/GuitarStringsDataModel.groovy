package be.dafke.GuitarAid.Application

import be.dafke.GuitarAid.Elements.GuitarString
import be.dafke.GuitarAid.Elements.GuitarStrings
import be.dafke.GuitarAid.Elements.Note
import be.dafke.GuitarAid.Elements.ScaledNote

import javax.swing.table.AbstractTableModel
import java.util.function.Predicate

class GuitarStringsDataModel extends AbstractTableModel {
    Predicate<ScaledNote> filter
    boolean showOctave = true

    int getRowCount() {
        return 6
    }

    int getColumnCount() {
        return 23
    }

    Note getValueAt(int rowIndex, int columnIndex) {
        GuitarString guitarString = GuitarStrings.ordenedStrings.get(rowIndex)
        ScaledNote scaledNote = guitarString.notes.get(columnIndex)
        if(filter!=null && !filter.test(scaledNote)) null
        else {
            showOctave?scaledNote:scaledNote.note
        }
    }

    String getColumnName(int col) {
        "${col}"
    }

    Class getColumnClass(int col) {
        Note.class
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

//    Node getObject(int row, int col) {
//        if(journal==null) return null;
//        ArrayList<Transaction> transactions = journal.getBusinessObjects();
//        return transactions.get(row);
//    }
}
