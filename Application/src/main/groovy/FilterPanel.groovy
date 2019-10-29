import javax.swing.ButtonGroup
import javax.swing.JPanel
import javax.swing.JRadioButton
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.function.Predicate

class FilterPanel extends JPanel implements ActionListener{
    GuitarStringsPanel guitarStringsPanel
    JRadioButton all, full

    FilterPanel(GuitarStringsPanel guitarStringsPanel) {
        this.guitarStringsPanel = guitarStringsPanel
        ButtonGroup group = new ButtonGroup()
        all = new JRadioButton('All')
        full = new JRadioButton('Full')
        group.add all
        group.add full
        add all
        add full
        all.addActionListener this
        full.addActionListener this
        all.setSelected true
    }

    static Predicate<ScaledNote> fullScaledTone = { !it.name.contains('#') }
    static Predicate<Note> fullTone = { !it.name.contains('#') }

    void actionPerformed(ActionEvent e) {
        def source = e.getSource()
        if (source == all) {
            guitarStringsPanel.filter = null
        } else if (source == full) {
            guitarStringsPanel.filter = fullScaledTone
        }
    }
}
