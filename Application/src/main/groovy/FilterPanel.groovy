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
    JRadioButton all, full, selectedNotes, selectedScaledNotes
    HashMap<Note, JCheckBox> notesCheckBoxes = new HashMap<>()
    HashMap<ScaledNote, JCheckBox> scaledNotesCheckBoxes = new HashMap<>()

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
        selectedNotes = new JRadioButton('Selected notes')
        selectedScaledNotes = new JRadioButton('Selected Scaled Notes')

        group.add all
        group.add full
        group.add selectedNotes
        group.add selectedScaledNotes

        optionsPanel.add all
        optionsPanel.add full
        optionsPanel.add selectedNotes
        optionsPanel.add selectedScaledNotes

        all.addActionListener this
        full.addActionListener this
        selectedNotes.addActionListener this
        selectedScaledNotes.addActionListener this

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

        JPanel selectedScaledNotes = new JPanel(new GridLayout(0, 7))
        selectedScaledNotes.setBorder(new TitledBorder('Displayed Scaled Notes:'))
        [
                null, null, 'E2', 'F2','G2', 'A2', 'B2',
                null, null, null, 'F#2', 'G#2', 'A#2', null,
                'C3', 'D3', 'E3', 'F3','G3', 'A3', 'B3',
                'C#3', 'D#3', null, 'F#3', 'G#3', 'A#3', null,
                'C4', 'D4', 'E4', 'F4','G4', 'A4', 'B4',
                'C#4', 'D#4', null, 'F#4', 'G#4', 'A#4', null,
                'C5', 'D5', 'E5', 'F5','G5', 'A5', 'B5',
                'C#5', 'D#5', null, 'F#5', 'G#5', 'A#5', null,
                'C6', 'C#6', 'D6', null, null, null, null
        ].each { String name ->
            if(name == null){
                selectedScaledNotes.add new JPanel()
            } else {
                ScaledNotes.scaledNotes.indexOf()
                ScaledNote scaledNote = ScaledNotes.scaledNotesMap.get(name)
                JCheckBox checkBox = new JCheckBox(name)
                scaledNotesCheckBoxes.put(scaledNote, checkBox)
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
            scaledNotesCheckBoxes.each { ScaledNote scaledNote, JCheckBox checkbox ->
                checkbox.enabled = false
                checkbox.selected = true
            }
            guitarStringsPanel.filter = null
        } else if (e.source == full) {
            notesCheckBoxes.each { Note note, JCheckBox checkBox ->
                checkBox.enabled = false
                checkBox.selected = fullScaledTone.test(note)
            }
            scaledNotesCheckBoxes.each { ScaledNote scaledNote, JCheckBox checkbox ->
                checkbox.enabled = false
                checkbox.selected = fullScaledTone.test(scaledNote.note)
            }
            guitarStringsPanel.filter = fullScaledTone
        } else if (e.source == selectedNotes) {
            notesCheckBoxes.each { Note note, JCheckBox checkBox ->
                checkBox.enabled = true
            }
            scaledNotesCheckBoxes.each { ScaledNote scaledNote, JCheckBox checkBox ->
                checkBox.enabled = false
            }
        } else if (e.source == selectedScaledNotes){
            scaledNotesCheckBoxes.each { ScaledNote scaledNote, JCheckBox checkBox ->
                checkBox.enabled = true
            }
            notesCheckBoxes.each { Note note, JCheckBox checkBox ->
                checkBox.enabled = false
            }
        } else {
            if(selectedNotes.selected) {
                ArrayList<Note> notes = new ArrayList<>()
                notesCheckBoxes.each { Note note, JCheckBox checkBox ->
                    if (checkBox.selected) {
                        notes.add note
                    }
                }
                Predicate<ScaledNote> filter = new Predicate<ScaledNote>() {
                    boolean test(ScaledNote scaledNote) {
                        notes.contains(scaledNote.note)
                    }
                }
                guitarStringsPanel.filter = filter
                scaledNotesCheckBoxes.each { ScaledNote scaledNote, JCheckBox checkBox ->
                    checkBox.removeActionListener this
                    checkBox.selected = filter.test(scaledNote)
                    checkBox.addActionListener this
                }
            } else if (selectedScaledNotes.selected){
                ArrayList<ScaledNote> scaledNotes = new ArrayList<>()
                scaledNotesCheckBoxes.each { ScaledNote scaledNote, JCheckBox checkBox ->
                    if (checkBox.selected) {
                        scaledNotes.add scaledNote
                    }
                }
                Predicate<ScaledNote> filter = new Predicate<ScaledNote>() {
                    boolean test(ScaledNote scaledNote) {
                        scaledNotes.contains(scaledNote)
                    }
                }
                guitarStringsPanel.filter = filter
            }
       }
    }
}
