class Notes {
    static HashMap<String, Note> notes = new HashMap<>()
    static {
        notes.put('A', new Note(name: 'A'))
        notes.put('A#', new Note(name: 'A#'))
        notes.put('B', new Note(name: 'B'))
        notes.put('C', new Note(name: 'C'))
        notes.put('C#', new Note(name: 'C#'))
        notes.put('D', new Note(name: 'D'))
        notes.put('D#', new Note(name: 'D#'))
        notes.put('E', new Note(name: 'E'))
        notes.put('F', new Note(name: 'F'))
        notes.put('F#', new Note(name: 'F#'))
        notes.put('G', new Note(name: 'G'))
        notes.put('G#', new Note(name: 'G#'))
    }
}
