class GuitarStrings {
    HashMap<String, GuitarString> guitarStrings = new HashMap<>()

    GuitarStrings() {
        HashMap<String, Note> notes = Notes.notes
        def lowE = new GuitarString(name: 'E-low',
                notes: [
                        new ScaledNote(note: notes.get('E'), octave: 2),
                        new ScaledNote(note: notes.get('F'), octave: 2),
                        new ScaledNote(note: notes.get('F#'), octave: 2),
                        new ScaledNote(note: notes.get('G'), octave: 2),
                        new ScaledNote(note: notes.get('G#'), octave: 2),
                        new ScaledNote(note: notes.get('A'), octave: 2),
                        new ScaledNote(note: notes.get('A#'), octave: 2),
                        new ScaledNote(note: notes.get('B'), octave: 2),
                        new ScaledNote(note: notes.get('C'), octave: 3),
                ])
        guitarStrings.put('E-low', lowE)
    }
}
