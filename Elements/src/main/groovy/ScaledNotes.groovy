class ScaledNotes {
    static ArrayList<ScaledNote> scaledNotes = new ArrayList<>()
    static {
        HashMap<String, Note> notes = Notes.notes

        // octave 2 incomplete
        scaledNotes.add(new ScaledNote(note: notes.get('E'), octave: 2))
        scaledNotes.add(new ScaledNote(note: notes.get('F'), octave: 2))
        scaledNotes.add(new ScaledNote(note: notes.get('F#'), octave: 2))
        scaledNotes.add(new ScaledNote(note: notes.get('G'), octave: 2))
        scaledNotes.add(new ScaledNote(note: notes.get('G#'), octave: 2))
        scaledNotes.add(new ScaledNote(note: notes.get('A'), octave: 2))
        scaledNotes.add(new ScaledNote(note: notes.get('A#'), octave: 2))
        scaledNotes.add(new ScaledNote(note: notes.get('B'), octave: 2))

        // octave 3 to 5 complete
        [3,4,5].each { octave ->
            Notes.noteNames.each { note ->
                scaledNotes.add(new ScaledNote(note: notes.get(note), octave: octave))
            }
        }

        // octave 6 incomplete
        scaledNotes.add(new ScaledNote(note: notes.get('C'), octave: 6))
        scaledNotes.add(new ScaledNote(note: notes.get('C#'), octave: 6))
        scaledNotes.add(new ScaledNote(note: notes.get('D'), octave: 6))
    }
}
