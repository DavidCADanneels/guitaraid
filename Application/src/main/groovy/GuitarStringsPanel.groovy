import javax.swing.JScrollPane
import java.awt.Color

import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.border.LineBorder
import java.awt.Dimension

class GuitarStringsPanel extends JPanel {
    JTable table

    GuitarStringsPanel() {
        GuitarStringsDataModel dataModel = new GuitarStringsDataModel()
        table = new JTable(dataModel)
        table.setBorder(new LineBorder(Color.BLACK))
        table.setPreferredScrollableViewportSize(new Dimension(1500, 96));
        JScrollPane scrollPane = new JScrollPane(table)
        add scrollPane
    }
}
