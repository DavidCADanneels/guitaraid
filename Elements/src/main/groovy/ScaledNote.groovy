class ScaledNote extends Note{
    Note note
    Integer octave
    String getName(){
        return "${note.name}${octave}"
    }
    String toString(){ name }
}
