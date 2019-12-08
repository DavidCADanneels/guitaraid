package be.dafke.GuitarAid.Elements

class Scale {
    Note rootNote
    List<Integer> steps
    List<Note> notes = []

    Scale(Note rootNote, List<Integer> steps) {
        this.rootNote = rootNote
        this.steps = steps
        def maxSize = Notes.noteNames.size()
        notes.add(rootNote)
        int index = Notes.noteNames.indexOf(rootNote.name )
        steps.each { step ->
            index+=step
            if(index>=maxSize){
                index = index-maxSize
            }
            String noteName = Notes.noteNames.get(index)
            Note note = Notes.notes.get(noteName)
            notes.add note
        }
    }
    String toString() {
        "${rootNote}: (${notes.stream().collect().join(", ")})"
    }
}
