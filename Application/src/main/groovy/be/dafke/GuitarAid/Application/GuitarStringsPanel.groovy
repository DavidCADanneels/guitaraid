package be.dafke.GuitarAid.Application

import be.dafke.GuitarAid.Elements.Note

import javax.swing.JScrollPane
import java.awt.Color

import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.border.LineBorder
import java.awt.Dimension
import java.util.function.Predicate

class GuitarStringsPanel extends JPanel {
    JTable table
    GuitarStringsDataModel dataModel

    GuitarStringsPanel() {
        dataModel = new GuitarStringsDataModel()
        table = new JTable(dataModel)
        table.setBorder(new LineBorder(Color.BLACK))
        table.setPreferredScrollableViewportSize(new Dimension(1200, 96));
        table.setDefaultRenderer(Note.class, new NoteColorRenderer())
        JScrollPane scrollPane = new JScrollPane(table)
        add scrollPane
    }

    void setFilter(Predicate<Note> filter){
        dataModel.setFilter filter
    }

    void setShowOctave(boolean show){
        dataModel.showOctave = show
    }
}
