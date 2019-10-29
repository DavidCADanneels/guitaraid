class ScaledNotes {
    static ArrayList<ScaledNote> scaledNotes = new ArrayList<>()
    static HashMap<String, ScaledNote> scaledNotesMap = new HashMap<>()
    static {
        HashMap<String, Note> notes = Notes.notes

        // octave 2 incomplete
        addScaledNote new ScaledNote(note: notes.get('E'), octave: 2)
        addScaledNote new ScaledNote(note: notes.get('F'), octave: 2)
        addScaledNote new ScaledNote(note: notes.get('F#'), octave: 2)
        addScaledNote new ScaledNote(note: notes.get('G'), octave: 2)
        addScaledNote new ScaledNote(note: notes.get('G#'), octave: 2)
        addScaledNote new ScaledNote(note: notes.get('A'), octave: 2)
        addScaledNote new ScaledNote(note: notes.get('A#'), octave: 2)
        addScaledNote new ScaledNote(note: notes.get('B'), octave: 2)

        // octave 3 to 5 complete
        [3,4,5].each { octave ->
            Notes.noteNames.each { note ->
                addScaledNote new ScaledNote(note: notes.get(note), octave: octave)
            }
        }

        // octave 6 incomplete
        addScaledNote new ScaledNote(note: notes.get('C'), octave: 6)
        addScaledNote new ScaledNote(note: notes.get('C#'), octave: 6)
        addScaledNote new ScaledNote(note: notes.get('D'), octave: 6)
    }
    
    static addScaledNote(ScaledNote scaledNote){
        scaledNotes.add(scaledNote)
        scaledNotesMap.put(scaledNote.name, scaledNote)
    }
}
