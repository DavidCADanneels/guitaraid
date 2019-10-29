import javax.swing.BoxLayout
import javax.swing.ButtonGroup
import javax.swing.JCheckBox
import javax.swing.JPanel
import javax.swing.JRadioButton
import javax.swing.border.TitledBorder
import java.awt.BorderLayout
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.function.Predicate

class FilterPanel extends JPanel implements ActionListener{
    GuitarStringsPanel guitarStringsPanel
    JRadioButton all, full, selection
    HashMap<Note, JCheckBox> notesCheckBoxes = new HashMap<>()
    HashMap<ScaledNote, JCheckBox> scaledNoteCheckBoxes = new HashMap<>()

    FilterPanel(GuitarStringsPanel guitarStringsPanel) {
        this.guitarStringsPanel = guitarStringsPanel

        setLayout(new BorderLayout())
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
        add optionsPanel, BorderLayout.WEST

        JPanel selectedNotes = new JPanel(new GridLayout(2,0))
        selectedNotes.setBorder(new TitledBorder('Displayed Notes:'))
        ['C','D','E','F','G','A','B','C#','D#', null,'F#','G#','A#',null].each { String name ->
            if(name == null){
                selectedNotes.add new JPanel()
            } else {
                Note note = Notes.notes.get(name)
                JCheckBox checkBox = new JCheckBox(name)
                notesCheckBoxes.put(note, checkBox)
                checkBox.selected = true
                checkBox.enabled = false
                checkBox.addActionListener this
                selectedNotes.add checkBox
            }
        }

        JPanel selectedScaledNotes = new JPanel(new GridLayout(0, 6))
        selectedScaledNotes.setBorder(new TitledBorder('Displayed Scaled Notes'))
        [
                null, null, null, null, 'E2', 'F2', 'F#2', 'G2', 'G#2', 'A2', 'A#2', 'B2',
                'C3', 'C#3', 'D3', 'D#3', 'E3', 'F3', 'F#3', 'G3', 'G#3', 'A3', 'A#3', 'B3',
                'C4', 'C#4', 'D4', 'D#4', 'E4', 'F4', 'F#4', 'G4', 'G#4', 'A4', 'A#4', 'B4',
                'C5', 'C#5', 'D5', 'D#5', 'E5', 'F5', 'F#5', 'G5', 'G#5', 'A5', 'A#5', 'B5',
                'C6', 'C#6', 'D6', null, null, null
        ].each { String name ->
            if(name == null){
                selectedScaledNotes.add new JPanel()
            } else {
                ScaledNotes.scaledNotes.indexOf()
                ScaledNote scaledNote = ScaledNotes.scaledNotesMap.get(name)
                JCheckBox checkBox = new JCheckBox(name)
                scaledNoteCheckBoxes.put(scaledNote, checkBox)
                checkBox.selected = true
                checkBox.enabled = false
                checkBox.addActionListener this
                selectedScaledNotes.add checkBox
            }
        }


        JPanel center = new JPanel(new BorderLayout())
        center.add selectedNotes, BorderLayout.NORTH
        center.add selectedScaledNotes, BorderLayout.CENTER
        add center, BorderLayout.CENTER

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
            notesCheckBoxes.each { Note note, JCheckBox checkBox ->
                checkBox.enabled = false
                checkBox.selected = true
            }
            guitarStringsPanel.filter = null
        } else if (e.source == full) {
            notesCheckBoxes.each { Note note, JCheckBox checkBox ->
                checkBox.enabled = false
                checkBox.selected = fullScaledTone.test(note as Note)
            }
            guitarStringsPanel.filter = fullScaledTone
        } else if (e.source == selection) {
            notesCheckBoxes.each { Note note, JCheckBox checkBox ->
                checkBox.enabled = true
//                checkBox.selected = true
            }
        } else {
            ArrayList<Note> notes = new ArrayList<>()
            notesCheckBoxes.each { Note note, JCheckBox checkBox ->
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
