class Notes {
    static HashMap<String, Note> notes = new HashMap<>()
    static noteNames = ['C','C#','D','D#','E','F','F#','G','G#','A','A#','B']
    static {
        noteNames.each {
            notes.put(it, new Note(name: it))
        }
    }
}
