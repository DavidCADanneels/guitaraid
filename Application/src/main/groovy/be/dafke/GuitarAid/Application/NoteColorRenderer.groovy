package be.dafke.GuitarAid.Application

import be.dafke.GuitarAid.Elements.Note

import javax.swing.JTable
import javax.swing.table.DefaultTableCellRenderer
import java.awt.Color
import java.awt.Component

class NoteColorRenderer extends DefaultTableCellRenderer {

    Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column)
        if (column == 0) {
            cell.setForeground(Color.RED)
        } else {
            cell.setForeground(Color.BLACK)
        }
        if(value!=null && value instanceof Note) {
            Note note = value as Note
            if (note.name.contains('#') || note.name.contains('b')) {
                cell.setBackground(Color.GRAY)
            } else if (note.name.contains('C')) {
                cell.setBackground(Color.RED)
            } else if (note.name.contains('D')) {
                cell.setBackground(Color.ORANGE)
            } else if (note.name.contains('E')) {
                cell.setBackground(Color.YELLOW)
            } else if (note.name.contains('F')) {
                cell.setBackground(Color.LIGHT_GRAY)
            } else if (note.name.contains('G')) {
                cell.setBackground(Color.GREEN)
            } else if (note.name.contains('A')) {
                cell.setBackground(Color.BLUE)
            } else if (note.name.contains('B')) {
                cell.setBackground(Color.MAGENTA)
            } else {
                cell.setBackground(Color.WHITE)
            }
        } else {
            cell.setBackground(Color.GRAY)
        }
        cell
    }
}
