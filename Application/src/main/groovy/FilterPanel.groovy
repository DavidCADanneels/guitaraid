import javax.swing.BoxLayout
import javax.swing.ButtonGroup
import javax.swing.JCheckBox
import javax.swing.JPanel
import javax.swing.JRadioButton
import javax.swing.border.BevelBorder
import javax.swing.border.CompoundBorder
import javax.swing.border.LineBorder
import javax.swing.border.TitledBorder
import java.awt.Color
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.function.Predicate

class FilterPanel extends JPanel implements ActionListener{
    GuitarStringsPanel guitarStringsPanel
    JRadioButton all, full, selection
    HashMap<Note, JCheckBox> checkBoxes = new HashMap<>()

    FilterPanel(GuitarStringsPanel guitarStringsPanel) {
        this.guitarStringsPanel = guitarStringsPanel

//        setLayout(new  BoxLayout(this, BoxLayout.Y_AXIS))
        JPanel optionsPanel = new JPanel()
//        optionsPanel.setBorder(new CompoundBorder(new TitledBorder('Selection:'), new LineBorder(Color.BLACK)))
        optionsPanel.setBorder(new TitledBorder('Selection:'))
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS))
        ButtonGroup group = new ButtonGroup()
        all = new JRadioButton('All notes')
        full = new JRadioButton('Full notes only')
        selection = new JRadioButton('Selected notes:')
        group.add all
        group.add full
        group.add selection
        optionsPanel.add all
        optionsPanel.add full
        optionsPanel.add selection
        all.addActionListener this
        full.addActionListener this
        selection.addActionListener this
        all.setSelected true
        add optionsPanel

        JPanel boxes = new JPanel(new GridLayout(2,0))
        boxes.setBorder(new TitledBorder('Displayed Notes:'))
        ['C','D','E','F','G','A','B','C#','D#', null,'F#','G#','A#',null].each { String name ->
            if(name == null){
                boxes.add new JPanel()
            } else {
                Note note = Notes.notes.get(name)
                JCheckBox checkBox = new JCheckBox(name)
                checkBoxes.put(note, checkBox)
                checkBox.selected = true
                checkBox.enabled = false
                checkBox.addActionListener this
                boxes.add checkBox
            }
        }
        add boxes

        setBorder(new TitledBorder('Filter'))
    }

    static Predicate<Note> fullScaledTone = [
            test: {
                !it.name.contains('#') && !it.name.contains('b')
//                !it.name.contains('#') && !it.name.contains('b')
//            },
//            and: {
//                Predicate<ScaledNote> other -> [
//                        test: {
//
//                        }
//                ] as Predicate<ScaledNote>
            }
    ] as Predicate<Note>

    void actionPerformed(ActionEvent e) {
        if (e.source == all) {
            checkBoxes.each { Note note, JCheckBox checkBox ->
                checkBox.enabled = false
                checkBox.selected = true
            }
            guitarStringsPanel.filter = null
        } else if (e.source == full) {
            checkBoxes.each { Note note, JCheckBox checkBox ->
                checkBox.enabled = false
                checkBox.selected = fullScaledTone.test(note as Note)
            }
            guitarStringsPanel.filter = fullScaledTone
        } else if (e.source == selection) {
            checkBoxes.each { Note note, JCheckBox checkBox ->
                checkBox.enabled = true
//                checkBox.selected = true
            }
        } else {
            ArrayList<Note> notes = new ArrayList<>()
            checkBoxes.each { Note note, JCheckBox checkBox ->
                if(checkBox.selected){
                    notes.add note
                }
            }
            def filter = new Predicate<Note>(){
                boolean test(Note note) {
                    notes.contains(note)
                }
            }
            guitarStringsPanel.filter = filter
        }
    }
}
